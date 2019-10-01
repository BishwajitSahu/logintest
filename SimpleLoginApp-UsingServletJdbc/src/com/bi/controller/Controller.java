package com.bi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Controller extends HttpServlet {
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller.doGet()");
		System.out.println(request.getRequestURI());
		HttpSession ses=null;
		ses=request.getSession();
		if(request.getRequestURI()=="/SimpleLoginApp-UsingServletJdbc/login_submit") {
			System.out.println("request entered into credential check part");
			String  uname=null;
			String pwd=null;
			RequestDispatcher rd=null;
			
			
			uname=request.getParameter("uname");
			pwd=request.getParameter("pwd");
			//check credential
			if(uname=="biswa" && pwd=="biswa") {
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
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
