package com.pk.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("downloadService")
public class FileDownloadMgmtServiceImpl implements FileDownloadMgmtService {

	@Override
	public List<String> getAllFile(String upoadStorePath) {
		File fileStore = null;
		File files[] = null;
		List<String> listOfFiles = null;
		//Locate Upload store where All files are there using Java.io.File class object
		fileStore = new File(upoadStorePath);
		listOfFiles = new ArrayList();
		
		//retrive or get All file from the uploadStore and kept all file in list
		if(fileStore.exists()) {
			files =  fileStore.listFiles();
			for(File f:files) {
				if( ! f.isDirectory()) {
					listOfFiles.add(f.getName());
				}
			}
		}
		return listOfFiles;
	}

}
