package com.track.paint.core.exception;

public class ContextXmlError extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6626512822324455461L;

	public ContextXmlError(String msg) {
		super(msg);
	}

	public ContextXmlError(Throwable throwable) {
		super(throwable);
	}

	public ContextXmlError(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
