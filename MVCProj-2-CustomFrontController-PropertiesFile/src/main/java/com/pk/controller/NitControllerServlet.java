package com.pk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pk.handler.SystemHandler;
import com.pk.mapper.HandlerMapper;
import com.pk.mapper.ViewMapper;

public class NitControllerServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		SystemHandler sysHandler = null; 
		String uri = null;
		String lvn = null;
		
		try{
			//get url
			uri = req.getServletPath();
			//get handler class
			sysHandler = HandlerMapper.getHandler(uri);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//use handler and get logical view name
		lvn = sysHandler.execute(req, res); 
		
		try {
			//send to view obj
			ViewMapper.showViewComp(lvn, req, res);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
