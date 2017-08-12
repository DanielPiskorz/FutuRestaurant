package pl.danielpiskorz.futurestaurant.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageSystem implements StorageService{

	@Value("${filestorage.absolutepath}")
	private String ABSOLUTE_PATH;
		
	@Override
	public void store(MultipartFile file, String filename) 
			throws IllegalStateException, IOException {
		
		File filePath = new File(ABSOLUTE_PATH);
		File destFile = new File(ABSOLUTE_PATH + filename);
		
		if(!filePath.exists())
			filePath.mkdirs();
			
		if(!destFile.exists())
			destFile.createNewFile();
		
		file.transferTo(destFile);
	}
}