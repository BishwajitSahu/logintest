package com.bi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



public class LoginSubmit extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request entered into credential check part");
		String  uname=null;
		String pwd=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
		
		ses=request.getSession();
		
		
		uname=request.getParameter("uname");
		pwd=request.getParameter("pwd");
		
		System.out.println(uname+"    "+pwd);
		//check credential
		if(uname.equals("biswa") && pwd.equals("biswa")) {
			ses.setAttribute("user_status", true);
			rd=request.getRequestDispatcher("/home");
			rd.forward(request, response);
		}
		else {
			ses.setAttribute("user_status",false);
			rd=request.getRequestDispatcher("/loginerror");
			rd.forward(request, response);
		}
	}
		
	
	 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	 
	}
}
