package com.pk.mapper;

import java.util.ResourceBundle;

import com.pk.handler.SystemHandler;

public class HandlerMapper {
	
	private static ResourceBundle bundle;
	
	static {
		try {
			bundle = ResourceBundle.getBundle("com/pk/props/appConfig");
		}
		catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//static
	
	public static SystemHandler getHandler(String uri) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String handlerName = null;
		SystemHandler handler = null;
		
		//get handler uri name
		handlerName = bundle.getString(uri);
		//get Handler obj using uri
		handler = (SystemHandler) Class.forName(handlerName).newInstance();
		
		return handler;
		
		
	}

}
