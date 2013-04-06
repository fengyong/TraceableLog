package com.MrFengYong.util;

import org.apache.commons.logging.Log;

public class TraceLog implements Log {

	private final Log log;
	private final Auth auth;
	private Env env;

	// public static Log attach(Log sharedLog, Auth auth, Env env) {
	// Log log = new TraceLog(sharedLog, auth, env);
	// return log;
	// }
	//
	// public static Log attach(Log sharedLog, Auth auth) {
	// Env env = new Env();
	// Log log = new TraceLog(sharedLog, auth, env);
	// return log;
	// }

	private String addTraceInfo(Object message) {
		if (env.isDebugging() && !env.isLogUser())
			return String.format("%s - %s", message, env.getUuid());

		if (env.isDebugging() && env.isLogUser())
			return String.format("%s - %s - %s", auth.getUser(), message,
					env.getUuid());

		if (!env.isLogUser())
			return message.toString();

		return String.format("%s - %s", auth.getUser(), message);
	}

	public Env getEnv() {
		return env;
	}

	public void setEnv(Env env) {
		this.env = env;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TraceLog [env=");
		builder.append(env);
		builder.append(", user=");
		builder.append(auth.getUser());
		builder.append("]");
		return builder.toString();
	}

	public TraceLog(Log log, Auth auth, Env env) {
		super();
		this.log = log;
		this.auth = auth;
		this.env = env;
	}

	public TraceLog(Log log, Auth auth) {
		super();
		this.log = log;
		this.auth = auth;
		this.env = new Env();
	}

	public boolean isDebugEnabled() {
		if (env != null)
			return env.isDebugging();
		return log.isDebugEnabled();
	}

	public boolean isErrorEnabled() {
		return log.isErrorEnabled();
	}

	public boolean isFatalEnabled() {
		return log.isFatalEnabled();
	}

	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	public boolean isWarnEnabled() {
		return log.isWarnEnabled();
	}

	public void trace(Object message) {
		// mandatory log as info level
		if (env.isDebugging()) {
			this.info(message);
			return;
		}

		if (log.isTraceEnabled())
			message = addTraceInfo(message);
		log.trace(message);
	}

	public void trace(Object message, Throwable t) {

		// mandatory log as info level
		if (env.isDebugging()) {
			this.info(message);
			return;
		}

		if (log.isTraceEnabled())
			message = addTraceInfo(message);
		log.trace(message);
	}

	public void debug(Object message) {

		// mandatory setting log to info level
		if (env.isDebugging()) {
			this.info(message);
			return;
		}

		if (log.isDebugEnabled())
			message = addTraceInfo(message);

		log.debug(message);
	}

	public void debug(Object message, Throwable t) {

		// mandatory setting log to info level
		if (env.isDebugging()) {
			this.info(message);
			return;
		}

		if (log.isDebugEnabled())
			message = addTraceInfo(message);
		log.debug(message);
	}

	public void info(Object message) {
		message = addTraceInfo(message);
		log.info(message);
	}

	public void info(Object message, Throwable t) {
		message = addTraceInfo(message);
		log.info(message);
	}

	public void warn(Object message) {
		message = addTraceInfo(message);
		log.warn(message);
	}

	public void warn(Object message, Throwable t) {
		message = addTraceInfo(message);
		log.warn(message);
	}

	public void error(Object message) {
		message = addTraceInfo(message);
		log.error(message);
	}

	public void error(Object message, Throwable t) {
		message = addTraceInfo(message);
		log.error(message);
	}

	public void fatal(Object message) {
		message = addTraceInfo(message);
		log.fatal(message);
	}

	public void fatal(Object message, Throwable t) {
		message = addTraceInfo(message);
		log.fatal(message);
	}

}
