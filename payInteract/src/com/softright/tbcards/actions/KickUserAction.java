package com.softright.tbcards.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.handwin.web.json.FormField;
import com.handwin.web.json.TransactionAction;
/**
 * 踢出用户
 * @author conan
 *
 */
public class KickUserAction extends TransactionAction {
	public static String path="/data/kickuser.txt";
	public static Set<String> kuser = new HashSet<String>();
	static{
		try{
			File file = new File(path);
			if(file.exists()){
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String tempString = null;
				//一次读一行，读入null时文件结束
				while ((tempString = reader.readLine()) != null) {
				//把当前行号显示出来
					if(StringUtils.isNotBlank(tempString.trim())){
						kuser.add(tempString.trim());
					}
				}
				reader.close();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@FormField(name="ID",required=true)
	private String userId;
	@FormField(name="remove",required=false)
	private String remove;
	
	@Override
	public Object exec() throws Exception {
		if(StringUtils.isNotBlank(remove) && remove.equals("true")){
			kuser.remove(userId);
		}else{
			kuser.add(userId);
		}
		File file = new File(path);
		if(file.exists()){
			file.delete(); 
		}
		FileWriter out = new FileWriter(file);
		for (Object user : kuser.toArray()) {
			out.write((String)user);
			out.write("\n");
		}
		out.flush();
		out.close();
		return "kick:"+userId;
	}

	@Override
	public Object onTransactionException(Exception arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
