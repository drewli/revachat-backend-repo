package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGasdet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter pw = resp.getWriter();
		pw.write("Testing changing back end servlet 2");
	}

}
