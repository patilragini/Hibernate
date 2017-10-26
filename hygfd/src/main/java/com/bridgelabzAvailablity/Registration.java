/****************************************************************************** 
 *  @author  Ragini Patil
 *  @version 1.0
 *  @since   5-10-2017
 *	@purpose getter setter for registration 
 *  Get name email phonenumber password and set values
 ******************************************************************************/
package com.bridgelabzAvailablity;

public class Registration {
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static long getPhoneNumber() {
		return phoneNumber;
	}

	public static void setPhoneNumber(long phoneNumber) {
		Registration.phoneNumber = phoneNumber;
	}

	private static String name;
	private static String email;
	private static long phoneNumber;
	private static String password;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Registration.name = name;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		Registration.email = email;
	}

	public long getphoneNumber() {
		return phoneNumber;
	}

	public static void setphoneNumber(long phoneNumber) {
		Registration.phoneNumber = phoneNumber;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Registration.password = password;
	}

}
