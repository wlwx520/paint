package com.track.paint.core;

import java.util.HashMap;
import java.util.Map;

import io.vertx.ext.web.FileUpload;

public class Invocation {
	private Map<String, Object> attachments = new HashMap<String, Object>();
	public static final String MAPPING = "constants_mapping";
	public static final String REQUEST = "constants_request";
	public static final String UPLOAD_FILES = "constants_upload_files";

	@SuppressWarnings("unchecked")
	public <T> T getAttachment(String key) {
		return (T) attachments.get(key);
	}

	public <T> void setAttachment(String key, T value) {
		attachments.put(key, value);
	}

	public static Invocation encode(Map<String, String> data, Map<String, FileUpload> fileUploads) {
		Invocation invocation = new Invocation();
		invocation.setAttachment(REQUEST, data);
		invocation.setAttachment(UPLOAD_FILES, fileUploads);
		return invocation;
	}

}
