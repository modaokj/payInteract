package com.softright.tbcards;

import java.io.IOException;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.handwin.web.Base16;



public class PassportNew {

	static{
		Security.addProvider(new BouncyCastleProvider());
	}
	private byte version;
	private String id;
	private String subId;
	private String partitionId;
	private String cardId;
	private boolean shopOwner;
	public PassportNew(byte version, String id,String subId,String partitionId,String cardId) {
		super();
		this.version = version;
		this.id = id;
		this.subId=subId==null?"":subId;
		this.partitionId=partitionId==null?"":partitionId;
		this.cardId=cardId==null?"":cardId;
		shopOwner= StringUtils.isNotBlank(id) && id.equals(subId);
	}
	public PassportNew(String id,String subId,String partitionId,String cardId)
	{
		this((byte)1,id,subId,partitionId,cardId);
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
	public String getSubId() {
		return subId;
	}
	public String getPartitionId() {
		return partitionId;
	}

	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	public String toString() {
		byte[] data=(this.id+"|"+this.subId+"|"+partitionId+"|"+cardId+";"+System.currentTimeMillis()).getBytes();
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

	public static PassportNew fromString(String ppt) {
		if(ppt==null) return null;
		byte[] data=Base16.decode(ppt);
		byte[] content=new byte[data.length-1];
		System.arraycopy(data, 1,content,0,content.length);
		int version=(int)data[0];
		switch(version)
		{
			case 1:
				return readPassport1(content);
				
		}
		return null;
	}
//	private static PassportNew readPassport0(byte[] data)
//	{
//		String str=decodeString(data);
//		
//		if(str.indexOf(';')>0)
//		{
//			return new PassportNew(str.substring(0, str.indexOf(';')));
//		}
//		return null;
//	}
	private static PassportNew readPassport1(byte[] data)
	{
		String str=decodeString(data);
		
		if(str.indexOf(';')>0)
		{
			String content=str.substring(0, str.indexOf(';'));
			String[] result=StringUtils.splitPreserveAllTokens(content, '|');
			if(result.length==4){
				return new PassportNew(result[0],result[1],result[2],result[3]);
			}
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
	/*********
	 * 64位加密 
	 * @param strEncode
	 * @return
	 */
	public static String BASE64Encode(String strEncode){
		String ret = new BASE64Encoder().encode(strEncode.getBytes());
		System.out.println("加密前:"+strEncode+" 加密后:"+ret);
		return ret;
	}
	/*********
	 * 64位解密 
	 * @param strEncode
	 * @return
	 */
	public static String BASE64Decode(String strDncode){
		String ret =null;
		try {
    		ret = new String(new BASE64Decoder().decodeBuffer(strDncode));
    		System.out.println("解密前:"+strDncode+" 解密后:"+ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	//public static void main(String[] args) {
//		    PassportNew passport=new PassportNew("11","222", "ssss", "ddddd","杭州佑软科技有限公司","1天3小时22分33秒");
//           System.out.println(BASE64Decode(passport.getUserName()));
//           System.out.println(BASE64Decode(passport.getValidityDate()));
//	}

	public void setPartitionId(String partitionId) {
		this.partitionId = partitionId;
	}
	public boolean isShopOwner() {
		return shopOwner;
	}
	public void setShopOwner(boolean shopOwner) {
		this.shopOwner = shopOwner;
	}
}
