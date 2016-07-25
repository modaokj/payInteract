package com.softright.tbcards.bo;

import java.util.Date;

import org.apache.log4j.Logger;

import com.handwin.db.DataService;
import com.softright.tbcards.po.ApiOperation;

public class ApiRecord {
	private static Logger logger = Logger.getLogger(ApiRecord.class);
	/******
	 * 添加api记录
	 * @author liucheng
	 * @param 
	 * @return 
	 * @exception/throws
	 */
    public static void add(ApiOperation apiOperation){
    	DataService dao=new DataService();
    	try {
        	apiOperation.setId(String.valueOf(new Date().getTime()));
        	apiOperation.setTime(new Date());
        	dao.insert(apiOperation);
        	dao.commit();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("apiOperation插入失败！",e);
		}finally {
			if(null!=dao){
				dao.close();
			}
			dao=new DataService();
		}
    }
}
