package utils;

import java.io.File;
import java.util.UUID;

public class MyFunctions
{
	public static String getUuid() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		System.out.println("생성된 UUID: "+ uuid); // 확인용
		return uuid;
	}
//	파일명 변경
	public static String renameFile(String sDirectory, String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String now = getUuid();
		String newFileName = now + ext;
		
//		 기존 파일과 새로운 파일의 객체를 만든 후 이름을 변경함
		File oldFile = new File(sDirectory + File.separator + fileName);
		File newFile = new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
//		변경된 파일명을 반환함
		return newFileName;
	}
}
