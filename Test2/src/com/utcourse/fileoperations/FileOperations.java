package com.utcourse.fileoperations;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class FileOperations {
	boolean flag;
	public synchronized void writeObjectTolog(String textToAdd) {
		File log = new File("log.txt");
		  	 
				try{
				    if(!log.exists()){
				    	System.out.println("We had to make a new file.");
				        log.createNewFile();
				    }

				    FileWriter fileWriter = new FileWriter(log, true);

				    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				    bufferedWriter.write(textToAdd);
				    bufferedWriter.close();
	                
				} catch(IOException e) {
					System.out.println("COULD NOT LOG!!");
				}	
	}
	public void reWritelog(String text) {
		File log = new File("log.txt");

				try{
				    if(!log.exists()){
				    	System.out.println("We had to make a new file.");
				        log.createNewFile();
				    }

				    FileWriter fileWriter = new FileWriter(log, false);

				    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				    bufferedWriter.write(text);
				    bufferedWriter.close();
                 
				} catch(IOException e) {
					System.out.println("COULD NOT LOG!!");
				}	
}
	public static List<NewSession> getAllSessions(){
		List<NewSession> list = new ArrayList<>();
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader("log.txt");
			bufferedReader = new BufferedReader(fileReader);
			String tempText;
			
			while ((tempText = bufferedReader.readLine()) != null ) {
				String[] words = tempText.split(" ");
				
				if(words[0].equals("")) {
					break;
				}	
				for(int i = 0;i<words.length;i++) {
				NewSession newSession = new NewSession();	
				newSession.setId(words[i]);

				list.add(newSession);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
 }
	public void checkBlackList(List<NewSession>list) {
		for (int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).getId());
		}
	}
	public void checkAccess(List<NewSession> list) throws IOException {
		
		System.out.println("Enter ip adres to check access");
		//Scanner scanner = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String checkIp;
		checkIp = reader.readLine();
		//scanner.close();
		for(int i = 0;i<list.size();i++) {
			if (checkIp.equals(list.get(i).getId())) { 
				flag = false;	
				break;
		}else flag = true;
		}
			if(flag == true) {
				System.out.println("Acces allowed");
			}else System.out.println("Access denided");
			
	
	}
	
}
