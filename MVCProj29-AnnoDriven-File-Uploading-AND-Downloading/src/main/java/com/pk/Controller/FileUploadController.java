package com.pk.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pk.command.FileUploadComand;

@Controller
public class FileUploadController {

	@GetMapping("/upload.htm")
	public String showForm(@ModelAttribute("upldCmd")FileUploadComand cmd) {

		return "file_upload_form";
	}
	
	@PostMapping("/save.htm")
	public String uploadFile(Map<String, Object> map,@ModelAttribute("upldCmd")FileUploadComand cmd,
												HttpServletRequest req) throws Exception {
		ServletContext sc = null;
		String UPLOAD_PATH = null;
		File file = null;
		String fileName1 = "",fileName2 = "";
		InputStream is1 = null,is2=null;
		OutputStream os1 = null,os2 = null;
		
		//Read Context Param Value for location to store the File
		sc = req.getServletContext();
		UPLOAD_PATH = sc.getInitParameter("UPLOAD_STORE");
		file = new File(UPLOAD_PATH);
		
		//create file if existing file are not there
		if(!file.exists())
			file.mkdir();
	
		//get Upload File Name
		fileName1 = cmd.getFile1().getOriginalFilename();
		fileName2 = cmd.getFile2().getOriginalFilename();
		
		//create InputStreamObject to read content inside file
		is1 = cmd.getFile1().getInputStream();
		is2 = cmd.getFile2().getInputStream();
		
		//create outputStream pointing t destination file
		os1 = new FileOutputStream(UPLOAD_PATH+"/"+fileName1);
		os2 = new FileOutputStream(UPLOAD_PATH+"/"+fileName2);
		
		//copy InputStream file  content to outputStream File Content
		IOUtils.copy(is1, os1);
		IOUtils.copy(is2, os2);
		
		//close streams
		is1.close();is2.close();
		os1.close();os2.close();
		
		//keep FileName in Model Attribute
		map.put("fileName1", fileName1);
		map.put("fileName2", fileName2);

	//	return "sucess_view";
		return "redirect:/home.htm";
	}
}
