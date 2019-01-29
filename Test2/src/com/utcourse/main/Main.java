package com.utcourse.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.utcourse.fileoperations.FileOperations;
import com.utcourse.fileoperations.NewSession;
import com.utcourse.ipgenerator.IpGenerator;

public class Main {

	public static void main(String[] args) throws IOException {
				List <NewSession> list = new ArrayList<NewSession>();
				FileOperations operation = new FileOperations();
				NewSession session = new NewSession();
				Scanner scanner = new Scanner(System.in);
				while(true) {
				System.out.println("Please do your choise");
				System.out.println("Press 1 to add 10 random ip to blacklist");
				System.out.println("Press 2 to show black list");
				System.out.println("Press 3 to check your access");
				System.out.println("Press 4 to exit");
				int count = scanner.nextInt();
				switch(count) {
				case 1:{
					for (int i = 0;i < 10; i ++ ) {
						session.setId(IpGenerator.idCreation());
						operation.writeObjectTolog(session.getId());
					}
					break;
				}
				case 2:{
					list = FileOperations.getAllSessions();
					System.out.println(list.size());
					operation.checkBlackList(list);
					break;
				}
				case 3:{
					operation.checkAccess(list);
					break;
				}
				case 4:{
					System.exit(0);
				}
			
				default :{
					System.out.println("Some error");
					break;
				}
				}
				
				}
			
			
			}

		


	}


