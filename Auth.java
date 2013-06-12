package com.morningstar.util;

import com.morningstar.dataObj.User;

public class Auth {

	private final String user; // e-mail
	private final String userId; // user UUId
	private final String productId;
	private final String cookie;
	private final String token;
 

	public Auth(String user) {
		this.user = user;
		this.userId = "";
		this.productId = "";
		this.cookie = "";
		this.token = "";
	 
	}

	public Auth(User user, double excelVersion) {
		super();
		this.user = user.getUserName();
		this.userId = user.getUserId();
		this.productId = user.getProductId();
		this.cookie = user.getCookie();
		this.token = user.getToken();
		 
	}

	public String getUser() {
		return user;
	}

	public String getCookie() {
		return cookie;
	}

	public String getToken() {
		return token;
	}

	 

	public String getUserId() {
		return userId;
	}

	public String getProductId() {
		return productId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Auth [user=");
		builder.append(user);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", productId=");
		builder.append(productId);
		 
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cookie == null) ? 0 : cookie.hashCode());
	 
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auth other = (Auth) obj;
		if (cookie == null) {
			if (other.cookie != null)
				return false;
		} else if (!cookie.equals(other.cookie))
			return false;
		 
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
