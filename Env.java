package com.morningstar.util;

import java.util.UUID;

public class Env {
	private boolean debugging = true;
	private boolean mockServer = true;
	private boolean logUser = true; // need to log user name
	private String uuid = ""; // indicate single call

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Env [debugging=");
		builder.append(debugging);
		builder.append(", mockServer=");
		builder.append(mockServer);
		builder.append(", logUser=");
		builder.append(logUser);
		// builder.append(", uuid=");
		// builder.append(uuid);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (debugging ? 1231 : 1237);
		result = prime * result + (logUser ? 1231 : 1237);
		result = prime * result + (mockServer ? 1231 : 1237);
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
		Env other = (Env) obj;
		if (debugging != other.debugging)
			return false;
		if (logUser != other.logUser)
			return false;
		if (mockServer != other.mockServer)
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

	public Env() {
	}

	public Env(boolean debugging, boolean mockServer) {
		this.debugging = debugging;
		this.mockServer = mockServer;

		this.setDebugging(debugging);
	}

	public boolean isDebugging() {
		return debugging;
	}

	public void setDebugging(boolean debugging) {
		if (debugging)
			uuid = "UUID" + UUID.randomUUID().toString().replaceAll("-", "");
		else
			uuid = ""; // if not debugging, reset uuid to empty

		this.debugging = debugging;
	}

	public boolean isMockServer() {
		return mockServer;
	}

	public void setMockServer(boolean mockServer) {
		this.mockServer = mockServer;
	}

	public boolean isLogUser() {
		return logUser;
	}

	public void setLogUser(boolean logUser) {
		this.logUser = logUser;
	}

	public String getUuid() {
		return uuid;
	}

}
