package com.pk.mapper;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewMapper {
	
private static ResourceBundle bundle;
	
	static {
		try {
			bundle = ResourceBundle.getBundle("com/pk/props/appConfig");
		}
		catch (Exception e) {
			e.printStackTrace();
		}//catch
	}//static
	
	public static void showViewComp(String uri,HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String viewCompName =  null;
		RequestDispatcher rd = null;
		//get targetCiew comp name
		viewCompName =  bundle.getString(uri);
		//get Request Dispatcher
		rd = req.getRequestDispatcher(viewCompName);
		
		//forward request and responce
		rd.forward(req, res);
		
		
	}
	
	

}
