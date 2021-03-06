/****************************************************************************** 
 *  @author  Ragini Patil
 *  @version 1.0
 *  @since   5-10-2017
 *	@purpose  Checker class has different methods to check 
 *			 
 ******************************************************************************/
package com.bridgelabz.Validator;

import java.util.regex.Pattern;

public class Checker {
	
	public static String checkName(String name) {
		String regexName = "[a-zA-Z\\s]{4,}";
		if (Pattern.matches(regexName, name) == false || name == null) {			
			return "name error";
		}
		return "valid";
	}

	public static String checkemail(String email) {
		String regexEmail = "[a-z0-9]{1,}[@]{1}[a-z]{1,}[.]{1}[a-z]{1,}";
		if (Pattern.matches(regexEmail, email) == false || email == "") {
			return "email error";
		}
		return "valid";
	}

	public static String checkphoneNumber(long phoneNumber) {

		if ((int) Math.log10(phoneNumber) + 1 != 10) {
			return "phoneNumber error";
		}
		return "valid";
	}

	public static String checkpassword(String password) {

		if (password.length() < 6) {
			return "password error";
		}
		return "valid";
	}

}
