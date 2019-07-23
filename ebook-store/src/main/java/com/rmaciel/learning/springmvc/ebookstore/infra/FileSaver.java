package com.rmaciel.learning.springmvc.ebookstore.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	@Autowired
	private HttpServletRequest request;
	
	public String write(String base, MultipartFile file) {
		try {
			String realpath = request.getServletContext().getRealPath("/" + base);
			String path = realpath + File.separator + file.getOriginalFilename();
			file.transferTo(new File(path));
			
			return base + File.separator + file.getOriginalFilename();
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
		
	}

}
