package com.demo.project;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class crud {
	private String Name;
	private String Email;
	private String Password;
	private String PhoneNumber;
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getPassword() {
		return passwordEncoder(Password);
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String PhoneNumber) {
		this.PhoneNumber = PhoneNumber;
	}

	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String passwordEncoder(String Password) {
		String encrypted = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(Password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder s = new StringBuilder();
			for(int i=0;i<bytes.length;i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
			}
			encrypted = s.toString();
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encrypted;
	}

}
