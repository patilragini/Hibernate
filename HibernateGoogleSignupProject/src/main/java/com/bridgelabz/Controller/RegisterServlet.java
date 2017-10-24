/********************************************************************************** 
 *  @author  Ragini Patil
 *  @version 1.0
 *  @since   5-10-2017
 *	@purpose RegisterServlet extends http servlet.
 *			 			 
 ***********************************************************************************/
package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.DAO.RegisterDao;
import com.bridgelabz.Model.Registration;
import com.bridgelabz.Validator.Checker;

/**
 * Servlet implementation class RegisterServlet
 */
// @WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
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
	 *      <p>
	 *      accepts name email phonenumber password from user from request if
	 *      registration successful then redirect to olgin page if account
	 *      exists i.e email id exit give error message and redirect to register
	 *      page again.
	 * 
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Boolean status = false;
		Registration registration = new Registration();
		HttpSession session = request.getSession();
		session.removeAttribute("errorLogin");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phoneNumber");
		String email = request.getParameter("email");

		if (phone != null) {
			long phoneNumber = Long.parseLong((request.getParameter("phoneNumber")));
			registration.setName(name);
			registration.setPassword(password);
			registration.setphoneNumber(phoneNumber);
			registration.setEmail(email);

			String error1 = Checker.checkName(name);
			String error2 = Checker.checkemail(email);
			String error3 = Checker.checkphoneNumber(phoneNumber);
			String error4 = Checker.checkpassword(password);

			if (error1 == "valid" && error2 == "valid" && error3 == "valid" && error4 == "valid") {

				try {
					status = RegisterDao.register(registration);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (status == true) {
					// Regestration sucessfull if true
					RequestDispatcher requestDipatcher = request.getRequestDispatcher("index.jsp");
					requestDipatcher.forward(request, response);
				} else {

					String errorMsg = "error ";
					session.setAttribute("errorEmail", errorMsg);
					response.setContentType("text/html");
					// existing email id
					PrintWriter out = response.getWriter();
					session.setAttribute("existingEmail", "Account exists enter	 different EmailId");
					out.print("<p style=\"color:red\">Account exists enter	 different EmailId</p>");
					RequestDispatcher requestDipatcher = request.getRequestDispatcher("RegistrationPage.jsp");
					requestDipatcher.forward(request, response);
				}
			} else {
				if (error1 != "valid")
					session.setAttribute("error1", "Invalid name");
				if (error2 != "valid")
					session.setAttribute("error2", "Invalid email");
				if (error3 != "valid")
					session.setAttribute("error3", "Invalid phone number");
				if (error4 != "valid")
					session.setAttribute("error4", "Invalid password");

				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<p style=\"color:red\">Invalid values!!!</p>");
				RequestDispatcher requestDipatcher = request.getRequestDispatcher("RegistrationPage.jsp");
				requestDipatcher.forward(request, response);
			}
		}
	}
}
