package com.utcourse.ipgenerator;

public class IpGenerator {
	
	 public static String idCreation() {
	    	int min = 100;
			int max = 255;
			String iD ="";
			for(int i = 0; i < 3; i++) {
				int idGenerate =  min + (int)(Math.random()*((max-min)+1));
				iD += Integer.toString(idGenerate) + ".";
				if(i == 2) {
					iD+= Integer.toString(idGenerate/10) + " ";
				}
			}
			return iD;
	 }
}
