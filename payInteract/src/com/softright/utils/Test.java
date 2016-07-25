package com.softright.utils;

import com.softright.utils.codeImage.CodeImageCompatibility;

public class Test {
	  public static void main(String[] args){
		  String out="D:/lcwork/out2.jpg";
		  CodeImageCompatibility.encodeQRCodeImage("http://www.baidu.com", out, null, 0, 0, out, 0, 0);

	  }
	
}
