package generator.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {
	
	public static void zip(String path,List<String> srcFiles) {
//		 List<String> srcFiles = Arrays.asList("test1.txt", "test2.txt");
		 try {
	        FileOutputStream fos = new FileOutputStream(path);
	        ZipOutputStream zipOut = new ZipOutputStream(fos);
	        for (String srcFile : srcFiles) {
	            File fileToZip = new File(srcFile);
	            FileInputStream fis = new FileInputStream(fileToZip);
	            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
	            zipOut.putNextEntry(zipEntry);

	            byte[] bytes = new byte[1024];
	            int length;
	            while((length = fis.read(bytes)) >= 0) {
	                zipOut.write(bytes, 0, length);
	            }
	            fis.close();
	        } 
	            zipOut.close();
		        fos.close();
	        
		 }catch(IOException e) {
			 System.out.println(e);
		 }
	       
	    
		
	}

}
