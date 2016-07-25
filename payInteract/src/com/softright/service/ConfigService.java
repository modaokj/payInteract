package com.softright.service;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.handwin.web.Service;
import com.softright.utils.properties.ReadProperties;

public class ConfigService implements Service, Runnable {
	private static Log logger = LogFactory.getLog(ConfigService.class);
	private boolean running = false;

	public String getName() {
		return "ConfigService";
	}
	public void startService() {
		running = true;
		new Thread(this).start();
	}

	public void stopService() {
		// TODO Auto-generated method stub
		running = false;
	}
	public void run() {
		this.logger.info("开始读取属性文件...");
		while (running) {
			ReadProperties property=ReadProperties.getInit();
			property.read("/config.properties");
			Iterator<String> it=property.stringPropertyNames().iterator();
         	while(it.hasNext()){
                 String key=it.next();
                 String val=property.getProperty(key);
                 this.logger.info(key+" 开始，开始于："+val);
                 property.read("/"+val); 
            }
         	running = false;
		}
	}
}
