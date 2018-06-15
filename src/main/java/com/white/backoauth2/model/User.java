package com.white.backoauth2.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * The class that represents a collection of user's data
 */
@Document(collection = "user")
public class User {
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	private String email;
	private String password;
	@Field(value = "google_user_data")
	private GoogleUserData googleUserData;

	public User() {}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public GoogleUserData getGoogleUserData() {
		return googleUserData;
	}

	public void setGoogleUserData(GoogleUserData googleUserData) {
		this.googleUserData = googleUserData;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", googleUserData="
				+ googleUserData + "]";
	}
}
