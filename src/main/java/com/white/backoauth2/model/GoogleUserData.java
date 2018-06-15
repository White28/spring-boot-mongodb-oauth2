package com.white.backoauth2.model;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The class that represents a collection of data that retrieve from user's google account
 */
public class GoogleUserData {

	private String email;
	@Field(value = "first_name")
	private String firstName;
	@Field(value = "last_name")
	private String lastName;
	private String gender;
	private String locale;

	public GoogleUserData() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Override
	public String toString() {
		return "GoogleUserData [email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", locale=" + locale + "]";
	}
}
