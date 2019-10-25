package com.widebidders.models.entities;

public class LoginEntity {
	
		private String emailId;
		private String password;

		public LoginEntity()
		{
			
		}
		public LoginEntity(String emailId, String password) {

			this.emailId = emailId;
			this.password = password;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	}



