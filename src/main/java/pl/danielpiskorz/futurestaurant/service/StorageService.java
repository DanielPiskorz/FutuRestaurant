package pl.danielpiskorz.futurestaurant.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	void store(MultipartFile file, String filename)
			throws IllegalStateException, IOException;
}
