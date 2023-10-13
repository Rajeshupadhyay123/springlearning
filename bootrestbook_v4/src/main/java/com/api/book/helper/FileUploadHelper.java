package com.api.book.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public final String UPLOAD_DIR =
		"G:\\Springlearning\\Working_Dir_YouTube\\bootrestbook\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile multipartFile) {
		
		boolean flag = false;
		
		try {
			
//			InputStream inputStream = multipartFile.getInputStream();
//			
//			byte data[] = new byte[inputStream.available()];
//			
//			inputStream.read(data);
//			
//			
//			//write
//			FileOutputStream fileOutputStream = new FileOutputStream(
//					UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()
//					);
//			fileOutputStream.write(data);
//			
//			fileOutputStream.flush();
//			fileOutputStream.close();
			
			Files.copy(multipartFile.getInputStream(), 
					Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
