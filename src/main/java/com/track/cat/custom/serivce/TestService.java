package com.track.cat.custom.serivce;

import java.util.Map;
import java.util.Set;

import com.track.cat.core.Invocation;
import com.track.cat.core.Result;
import com.track.cat.core.handler.HttpMethod;
import com.track.cat.core.handler.annotation.Handler;
import com.track.cat.core.handler.annotation.Service;
import com.track.cat.core.handler.interfaces.IService;
import com.track.cat.core.http.ResultBuilder;

import io.vertx.ext.web.FileUpload;

@Service("/test")
public class TestService implements IService {
	@Handler(value = "/text", method = { HttpMethod.POST, HttpMethod.GET })
	public Result test(Invocation invocation) {
		Map<String, String> data = invocation.getAttachment(Invocation.REQUEST);
		System.out.println("in -----> " + data.toString());
		return ResultBuilder.buildResult(0);
	}

	@Handler(value = "/file", method = { HttpMethod.FILE })
	public Result test2(Invocation invocation) {
		Set<FileUpload> fileUploads = invocation.getAttachment(Invocation.UPLOAD_FILES);
		fileUploads.forEach(fileUpload->{
			String contentType = fileUpload.contentType();
			String fileName = fileUpload.fileName();
			long size = fileUpload.size();
			String uploadedFileName = fileUpload.uploadedFileName();
			System.out.println(contentType);
			System.out.println(fileName);
			System.out.println(size);
			System.out.println(uploadedFileName);
		});

		return null;
	}
}
