package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.DAO.EmailAvailablity;

/**
 * Servlet implementation class Availablity
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		PrintWriter outPrintWriter = response.getWriter();
		System.out.println(email);
		if (EmailAvailablity.checkemail(email)) {
			boolean exist = EmailAvailablity.validate(email);
			if (exist) {
				response.getWriter().print("{success: true}");
			} else {
				response.getWriter().print("{success: false}");
			}
		} else {
			response.getWriter().print("{success: invalid}");
		}

	}

}
