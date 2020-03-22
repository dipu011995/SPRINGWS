package com.pk.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileUploadComand {
	
	private MultipartFile file1;
	private MultipartFile file2;

}
