package com.pk.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pk.service.FileDownloadMgmtService;

@Controller
public class FileDownloadController {
	
	@Autowired
	private FileDownloadMgmtService service;
	
	@GetMapping("/home.htm")
	public String ShowFileDownloadForm(HashMap<String, Object> map,HttpServletRequest req) {
		
		ServletContext sc = null;
		String upoadStorePath = null;
		List<String> listOfFiles = null;
		
		sc = req.getServletContext();
		upoadStorePath = sc.getInitParameter("UPLOAD_STORE");
		//use Service
		listOfFiles = service.getAllFile(upoadStorePath);
		map.put("filesList", listOfFiles);		
		return "download_files_form";
	}
	
	@GetMapping("/download.htm")
	public void downloadFile(@RequestParam("fileName")String fileName,Map<String,Object> map,
													HttpServletRequest req,HttpServletResponse res) throws Exception {
		ServletContext sc = null;
		String uploadStorePath  = null;
		File file = null;
		InputStream is = null;
		OutputStream os = null;
		
		
		//get file path
		sc = req.getServletContext();
		uploadStorePath = sc.getInitParameter("UPLOAD_STORE");
		//create file object with file path and file name locating file to be downloaded 
		file = new File(uploadStorePath+"/"+fileName);
		//get length of  the file and make its length as responce length
		res.setContentLengthLong(file.length());
		//get MIME Type and make it as Responce MIME Type
		res.setContentType(sc.getMimeType(uploadStorePath+"/"+fileName));
		//create inputStream to read the file data
		is = new FileInputStream(file);
		//create Output Stream  pointing to responce object
		os = res.getOutputStream();
		//give instruction to browser to make the received output as downloadable file
		res.setHeader("Content-Disposition", "attachment;fileName="+fileName);
		
		//copy content from file to response Object
		IOUtils.copy(is, os);
		
		//close/flush stream
		os.close(); //first  flush and then close the stream
		is.close();
		
	}

}
