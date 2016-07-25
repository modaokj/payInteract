package com.softright.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class Base64 {
	/****
	 * 加密
	 * @param str
	 * @return
	 */
    public static String encoder(String str) {
    	return new BASE64Encoder().encode(str.getBytes());
	}
    /****
     * 解密
     * @param str
     * @return
     */
    public static String decoder(String str) {
		try {
			byte[]  b = new BASE64Decoder().decodeBuffer(str);
			return new String(b, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
    
    /*****
     * 根据文件内容生成文件到指定目录
     * @param filePath
     * @param fileContent
     * @return
     * @throws IOException
     */
    public static void decodeToFile (String filePath,String fileContent) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] by=decoder.decodeBuffer(fileContent);
		File docFile = new File(filePath);
		try {
			docFile.createNewFile();
			FileOutputStream txtfile = new FileOutputStream(docFile);
			txtfile.write(by);
			txtfile.flush();
			txtfile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    /*****
     * 将文件编码成string
     * @param file
     * @return
     * @throws IOException
     */
	public static String encodeFileToString (File file) throws IOException {
		BASE64Encoder decoder = new BASE64Encoder();
		String infoname="";
		try {
			if(null!=file){
				FileInputStream txtfile = new FileInputStream(file);
				int leg=txtfile.available();
				byte[] buf = new byte[leg];
				txtfile.read(buf);
				infoname=decoder.encode(buf);
				txtfile.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return infoname;
	}
	public static byte[] encodeFileToByte (File file) throws IOException {
		BASE64Encoder decoder = new BASE64Encoder();
		String infoname="";
		byte[] buf=new byte[0];
		try {
			if(null!=file){
				FileInputStream txtfile = new FileInputStream(file);
				int leg=txtfile.available();
				buf = new byte[leg];
				txtfile.read(buf);
				txtfile.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf;
	}
	
	public static void main(String[] args) {
		File file=new File("d://lcwork/out.jpg");
		try {
			String fileContent=encodeFileToString(file);
			System.out.println(fileContent);
			decodeToFile("d://lcwork/outcs.jpg", fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
