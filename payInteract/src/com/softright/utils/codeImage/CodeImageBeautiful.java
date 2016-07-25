package com.softright.utils.codeImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
public class CodeImageBeautiful {
	 // 图片宽度的一般  
    private static final int IMAGE_WIDTH = 80;  
    private static final int IMAGE_HEIGHT = 80;  
    private static final int IMAGE_HALF_WIDTH = IMAGE_WIDTH / 2;  
    private static final int FRAME_WIDTH = 2;  
    private static final int IMG_WIDTH = 300; 
    private static final int IMG_HEIGHT = 300; 
  
    // 二维码写码器  
    private static MultiFormatWriter mutiWriter = new MultiFormatWriter(); 
//    //二维码内容
//    private static final String content1= "http://blog.sina.com.cn/u/2502486485";
//    private static final String content2= "http://user.qzone.qq.com/1289643364?ptlang=2052";
//    
//    
//    
//    public static void main(String[] args) {
//    	 String logourl="C:/IMG_0559.png";
//    	 String outurl="C:/out1.jpg";
//    	 String content=content1;
//    	 int width=300;
//    	 int height=300;
//    	 int logoWidth=100;
//    	 int logoHeight=100;
//         encode(content,null,width, height, logourl,outurl,logoWidth,logoHeight);  
//	     System.out.println(decodeQRCodeImage(outurl, null)); 
//	}
    
    /***
     * 生成二维码  方法已整合
     * 缺点 ：logo图片太大的时候直接死掉，无法生成二维码 
     * 优点：这种方式会将logo图片嵌入在二维码图片中 比较美观
     * @param content 二维码内容
     * @param charset 二维码编码
     * @param width  生成的维码图片高度
     * @param height 生成的维码图片宽度
     * @param srcImagePath logo图片路径
     * @param destImagePath 生成的二维码输出路径
     * @param logoWidth logo图片宽度
     * @param logoHeight logo图片高度
     */
    public static void encode(String content,String charset, int width, int height,String srcImagePath, String destImagePath,int logoWidth,int logoHeight,boolean fag) {  
    	if(width==0){
    		width=IMG_WIDTH;
    	}
    	if(height==0){
    		height=IMG_HEIGHT;
    	}
        try {  
            ImageIO.write(genBarcode(content,charset, width, height, srcImagePath,logoWidth,logoHeight),"jpg", new File(destImagePath));  
        } catch (Exception e){  
        	if(fag){
        		System.out.println("第一种方式生成失败了,开始使用兼容模式生成"+e);
                try {
                	if(CodeImageCompatibility.encodeQRCodeImage(content, charset, srcImagePath, width, height, destImagePath, logoWidth, logoHeight)){
                		System.out.println("二维码使用兼容模式生成成功，路径为"+srcImagePath);
                	}else{
                		if(CodeImageCompatibility.fag){
                    		System.out.println("二维码使用兼容模式,抛弃logo图片"+srcImagePath+"后生成成功，路径为"+destImagePath);
                    	}else{
                    		System.out.println("使用兼容模式生成失败，没救了");
                    	}
                	}
    			} catch (Exception e2) {
    				// TODO: handle exception
    				if(CodeImageCompatibility.fag){
                		System.out.println("二维码使用兼容模式,抛弃logo图片"+srcImagePath+"后生成成功，路径为"+destImagePath);
                	}else{
                		System.out.println("使用兼容模式生成失败，没救了"+e2);
                	}
    			}
        	}
        }  
    }  
  /************
   * 
   * @param content 二维码内容
   * @param charset 二维码编码
   * @param width  生成的维码图片高度
   * @param height 生成的维码图片宽度
   * @param srcImagePath logo图片路径
   * @return
   * @throws WriterException
   * @throws IOException
   */
    private static BufferedImage genBarcode(String content,String charset, int width,int height, String srcImagePath,int logoWidth,int logoHeight) throws WriterException,IOException {  
        // 读取源图像  
    	if(logoWidth==0){
    		logoWidth=IMAGE_WIDTH;
    	}
    	if(logoHeight==0){
    		logoHeight=IMAGE_HEIGHT;
    	}
    	int image_half_width=logoWidth/2;
        BufferedImage scaleImage = scale(srcImagePath, logoWidth,  
        		logoHeight, true);  
        int[][] srcPixels = new int[logoWidth][logoHeight];  
        for (int i = 0; i < scaleImage.getWidth(); i++) {  
            for (int j = 0; j < scaleImage.getHeight(); j++) {  
                srcPixels[i][j] = scaleImage.getRGB(i, j);  
            }  
        }  
  
        Map<EncodeHintType, Object> hint = new HashMap<EncodeHintType, Object>();  
        hint.put(EncodeHintType.CHARACTER_SET, "utf-8");  
        hint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
        // 生成二维码  
       // BitMatrix matrix = mutiWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hint);  
         BitMatrix matrix = mutiWriter.encode(new String(content.getBytes(charset==null?"UTF-8":charset), "ISO-8859-1"), BarcodeFormat.QR_CODE, width, height, hint);  
  
        // 二维矩阵转为一维像素数组  
        int halfW = matrix.getWidth() / 2;  
        int halfH = matrix.getHeight() / 2;  
        int[] pixels = new int[width * height];  
  
        for (int y = 0; y < matrix.getHeight(); y++) {  
            for (int x = 0; x < matrix.getWidth(); x++) {  
                // 读取图片  
                if (x > halfW - image_half_width  
                        && x < halfW + image_half_width  
                        && y > halfH - image_half_width  
                        && y < halfH + image_half_width) {  
                    pixels[y * width + x] = srcPixels[x - halfW  
                            + image_half_width][y - halfH + image_half_width];  
                }   
                // 在图片四周形成边框  
                else if ((x > halfW - image_half_width - FRAME_WIDTH  
                        && x < halfW - image_half_width + FRAME_WIDTH  
                        && y > halfH - image_half_width - FRAME_WIDTH && y < halfH  
                        + image_half_width + FRAME_WIDTH)  
                        || (x > halfW + image_half_width - FRAME_WIDTH  
                                && x < halfW + image_half_width + FRAME_WIDTH  
                                && y > halfH - image_half_width - FRAME_WIDTH && y < halfH  
                                + image_half_width + FRAME_WIDTH)  
                        || (x > halfW - image_half_width - FRAME_WIDTH  
                                && x < halfW + image_half_width + FRAME_WIDTH  
                                && y > halfH - image_half_width - FRAME_WIDTH && y < halfH  
                                - image_half_width + FRAME_WIDTH)  
                        || (x > halfW - image_half_width - FRAME_WIDTH  
                                && x < halfW + image_half_width + FRAME_WIDTH  
                                && y > halfH + image_half_width - FRAME_WIDTH && y < halfH  
                                + image_half_width + FRAME_WIDTH)) {  
                    pixels[y * width + x] = 0xfffffff;  
                } else {  
                    // 此处可以修改二维码的颜色，可以分别制定二维码和背景的颜色；  
                    pixels[y * width + x] = matrix.get(x, y) ? 0xff000000 : 0xfffffff;  
                }  
            }  
        }  
  
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        image.getRaster().setDataElements(0, 0, width, height, pixels);  
  
        return image;  
    }  
  
    /** 
     * 把传入的原始图像按高度和宽度进行缩放，生成符合要求的图标 
     *  
     * @param srcImageFile 源文件地址 
     * @param height 目标高度 
     * @param width 目标宽度 
     * @param hasFiller 比例不对时是否需要补白：true为补白; false为不补白; 
     * @throws IOException 
     */  
    private static BufferedImage scale(String srcImageFile, int height,int width, boolean hasFiller) throws IOException {  
        double ratio = 0.0; // 缩放比例  
        File file = new File(srcImageFile);  
        BufferedImage srcImage = ImageIO.read(file);  
        Image destImage = srcImage.getScaledInstance(width, height,  
                BufferedImage.SCALE_SMOOTH);  
        // 计算比例  
        if ((srcImage.getHeight() > height) || (srcImage.getWidth() > width)) {  
            if (srcImage.getHeight() > srcImage.getWidth()) {  
                ratio = (new Integer(height)).doubleValue()  
                        / srcImage.getHeight();  
            } else {  
                ratio = (new Integer(width)).doubleValue()  
                        / srcImage.getWidth();  
            }  
            AffineTransformOp op = new AffineTransformOp(  
                    AffineTransform.getScaleInstance(ratio, ratio), null);  
            destImage = op.filter(srcImage, null);  
        }  
        if (hasFiller) {// 补白  
            BufferedImage image = new BufferedImage(width, height,  
                    BufferedImage.TYPE_INT_RGB);  
            Graphics2D graphic = image.createGraphics();  
            graphic.setColor(Color.white);  
            graphic.fillRect(0, 0, width, height);  
            if (width == destImage.getWidth(null))  
                graphic.drawImage(destImage, 0,  
                        (height - destImage.getHeight(null)) / 2,  
                        destImage.getWidth(null), destImage.getHeight(null),  
                        Color.white, null);  
            else  
                graphic.drawImage(destImage,  
                        (width - destImage.getWidth(null)) / 2, 0,  
                        destImage.getWidth(null), destImage.getHeight(null),  
                        Color.white, null);  
            graphic.dispose();  
            destImage = image;  
        }  
        return (BufferedImage) destImage;  
    }  
    
    /**
     * 解析二维码
     * @param imagePath 二维码图片存放路径(含文件名)
     * @param charset   解码二维码内容时采用的字符集(传null时默认采用UTF-8编码)
     * @return 解析成功后返回二维码文本,否则返回空字符串
     */ 
    public static String decodeQRCodeImage(String imagePath, String charset) { 
        BufferedImage image = null; 
        try { 
            image = ImageIO.read(new File(imagePath)); 
        } catch (IOException e) { 
            e.printStackTrace(); 
            return ""; 
        } 
        if(null == image){ 
            System.out.println("Could not decode QRCodeImage"); 
            return ""; 
        } 
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image))); 
        Map<DecodeHintType, String> hints = new HashMap<DecodeHintType, String>(); 
        hints.put(DecodeHintType.CHARACTER_SET, charset==null ? "UTF-8" : charset); 
        Result result = null; 
        try { 
            result = new MultiFormatReader().decode(bitmap, hints); 
            return result.getText(); 
        } catch (NotFoundException e) { 
            System.out.println("二维码图片[" + imagePath + "]解析失败,堆栈轨迹如下"+e.getMessage()); 
            e.printStackTrace(); 
            return ""; 
        } 
    } 
}