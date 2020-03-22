package com.pk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pk.handler.SystemDateHandler;
import com.pk.handler.SystemHandler;
import com.pk.handler.SystemPropsHandler;

public class NitControllerServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		SystemHandler sysHandler = null; 
		String lvn = null;
		String target = null;
		RequestDispatcher rd = null;
		
		if (req.getServletPath().equalsIgnoreCase("/date.do")) {
			System.out.println(1);
			sysHandler = new SystemDateHandler();
		}
		else if(req.getServletPath().equalsIgnoreCase("/props.do"))	
			sysHandler = new SystemPropsHandler();
		else
			throw new IllegalArgumentException("Invalid request url Type");
		
		//use handler and get logical view name
		lvn = sysHandler.execute(req, res);
		
		if(lvn.equalsIgnoreCase("show_date"))
			target =  "/show_date.jsp";
		else if(lvn.equalsIgnoreCase("show_props"))
			target = "/show_props.jsp";
		else
			target = "/error.jsp";
		
		//get request dispatcher
		rd = req.getRequestDispatcher(target);
		//ser value to request dispatcher
		rd.forward(req, res);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
