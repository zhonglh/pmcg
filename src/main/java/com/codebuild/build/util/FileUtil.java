package com.codebuild.build.util;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class FileUtil {

	public static boolean deleteFile(String filename)  {
		return deleteFile(new File(filename));
	}
	public static boolean deleteFile(File file)  {
		try{
			if(file == null) return true;
			else if(file.isDirectory()){
				return false;
			}
			else if(file.isFile() && file.exists()){
				file.delete();
				return true;
			}else {
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean copyFile(File file, String filePath)  {
		try{
			if(!file.exists()) return true;
			FileInputStream  is = new FileInputStream(file);
			return copyFile(is,filePath);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public static boolean copyFile(InputStream is, String filePath) {

		boolean retCode = false;
		byte[] buffer = new byte[1024];
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(new File(filePath));
			
			int n = -1;
			while ((n = is.read(buffer, 0, buffer.length)) != -1) {
				fos.write(buffer, 0, n);
			}

			retCode = true;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		return retCode;
	}
	
	

	public static String getFileContent(String fileName) {
		
		BufferedReader reader = null;
		StringBuilder fileContent = new StringBuilder();
		try {
			File f = new File(fileName);

			reader = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line = reader.readLine()) != null) {
				fileContent.append(line);
				fileContent.append("\n"); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
					reader = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileContent.toString();
	}

	public static String getFileContent(InputStream is) {

		BufferedReader reader = null;
		StringBuilder fileContent = new StringBuilder();
		try {
			reader = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while ((line = reader.readLine()) != null) {
				fileContent.append(line);
				fileContent.append("\n"); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
					reader = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileContent.toString();

	}
	
	

	public static boolean setFileContent(String folder,String file, String content) {
		File f = new File(folder,file);
		return setFileContent(f,content);
	}
	
	public static boolean setFileContent(String path, String content) {

			File f = new File(path);
			return setFileContent(f,content);
	}
	
	

	public static boolean setFileContent(File file, String content) {
		boolean flag = false;
		DataOutputStream dos = null;

		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}

		try {
			if (content != null && content.length() >= 0) {
				byte abyte[] = content.getBytes();
				dos = new DataOutputStream(new FileOutputStream(file));
				dos.write(abyte, 0, abyte.length);
				dos.flush();

				flag = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				dos = null;
			}
		}
		return flag;
	}
	

}
