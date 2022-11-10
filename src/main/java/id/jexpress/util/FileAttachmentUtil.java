package id.jexpress.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileAttachmentUtil {
	
	public static String uploadFileMessage(MultipartFile file, 
			String UPLOADED_FOLDER, String UPLOADED_SEPARATOR){
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dnow = new Date();
        String strDate = sdfDate.format(dnow);
        
        SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyyMM");
        Date dnow2 = new Date();
        String strMonth = sdfMonth.format(dnow2);
        
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        Date dnow3 = new Date();
        String strYear = sdfYear.format(dnow3);
        
        String filelocation = UPLOADED_FOLDER;
		File fileFolder = new File(filelocation);
		if (!fileFolder.exists()) {
            if (fileFolder.mkdir()) {
                System.out.println("Parent directory is created!");
            } else {
                System.out.println("Failed to create parent directory!");
            }
        }
		
		filelocation += strYear + UPLOADED_SEPARATOR;
		fileFolder = new File(filelocation);
		if (!fileFolder.exists()) {
            if (fileFolder.mkdir()) {
                System.out.println("Year directory is created!");
            } else {
                System.out.println("Failed to create year directory!");
            }
        }
		
		filelocation += strMonth + UPLOADED_SEPARATOR;
		fileFolder = new File(filelocation);
		if (!fileFolder.exists()) {
            if (fileFolder.mkdir()) {
                System.out.println("Month directory is created!");
            } else {
                System.out.println("Failed to create month directory!");
            }
        }
		
		filelocation += strDate + UPLOADED_SEPARATOR;
		fileFolder = new File(filelocation);
		if (!fileFolder.exists()) {
            if (fileFolder.mkdir()) {
                System.out.println("File directory is created!");
            } else {
                System.out.println("Failed to create file directory!");
            }
        }
		
		if (file.isEmpty()) {
            System.out.println("File Empty");
        }
		
		String filePathRes = "";

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(filelocation + file.getOriginalFilename());
            Files.write(path, bytes);

            System.out.println("You successfully uploaded '" + file.getOriginalFilename() + "'");
            
            filePathRes = filelocation + file.getOriginalFilename();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return filePathRes;
	}

}
