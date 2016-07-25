package com.softright.tbcards;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.handwin.web.Base16;



public class PassportOld {

	static{
		Security.addProvider(new BouncyCastleProvider());
	}
	private byte version;
	private String id;
	
	public PassportOld(byte version, String id) {
		super();
		this.version = version;
		this.id = id;
	}
	public PassportOld(String id)
	{
		this.version=0;
		this.id=id;
	}
	public byte getVersion() {
		return version;
	}

	public void setVersion(byte version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		byte[] data=(this.id+";"+System.currentTimeMillis()).getBytes();
		try {
			data=encode(data);
			byte[] rlt=new byte[data.length+1];
			rlt[0]=(byte)version;
			System.arraycopy(data, 0, rlt, 1, data.length);
			return Base16.encode(rlt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static PassportOld fromString(String ppt) {
		if(ppt==null) return null;
		byte[] data=Base16.decode(ppt);
		byte[] content=new byte[data.length-1];
		System.arraycopy(data, 1,content,0,content.length);
		int version=(int)data[0];
		switch(version)
		{
			case 0:
				return readPassport0(content);
				
		}
		return null;
	}
	private static PassportOld readPassport0(byte[] data)
	{
		String str=decodeString(data);
		
		if(str.indexOf(';')>0)
		{
			return new PassportOld(str.substring(0, str.indexOf(';')));
		}
		return null;
	}
	public static final byte[] key=new byte[]{0x3f,0x7a,0x45,(byte)0xf8,(byte)0xd9,(byte)0xa8,(byte)0x19,0x63};
	private static String decodeString(byte[] data)
	{
		try {
			return new String(des(key,data,false));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	private static byte[] encode(byte[] data)
	{
		try {
			if(data.length%8!=0)
			{
				byte[] rlt=new byte[data.length/8*8+8];
				System.arraycopy(data, 0, rlt, 0, data.length);
				return des(key,rlt,true);
			}
			return des(key,data,true);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public static byte[] des(byte[] key, byte[] src, boolean encrypt)
			throws Exception {
		Cipher cipher = Cipher.getInstance("DES/ECB/NOPadding");
		DESKeySpec desKey = new DESKeySpec(key);
		SecretKeyFactory KeyFactory = SecretKeyFactory.getInstance("DES");
		
		cipher.init(encrypt ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE,
				(Key) KeyFactory.generateSecret(desKey));
		return cipher.doFinal(src);
	}
}
