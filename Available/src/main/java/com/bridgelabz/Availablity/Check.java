package com.bridgelabz.Availablity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Availablity
 */
@WebServlet("/Availablity")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String email = request.getParameter("email");
		System.out.println("in post " + email);
		PrintWriter outPrintWriter = response.getWriter();
		boolean exist=EmailAvailablity.validate(email);
		System.out.println(exist);
		if(exist=true){
		response.getWriter().print("{success: true}");
		System.out.println("return true found");
		}
		else{
			response.getWriter().print("{success: false}");
		System.out.println("return false ");
		}

	}

}