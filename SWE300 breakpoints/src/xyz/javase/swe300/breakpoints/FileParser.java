package xyz.javase.swe300.breakpoints;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Year;
import java.util.Date;
import java.util.Scanner;

public class FileParser {

	String fileName = null;
	int count = 1;
	Scanner scanner;
	int totalLines = 1;
	
	/**
	 * @param String fileName
	 * */
	public FileParser (String fileName) {
		this.fileName = fileName;
		

		try {
			scanner = new Scanner(new File(fileName));
			scanner.useDelimiter(",|\\n");
			//this is going to move us into the readable section of the file
			int currentRow = 0;
		    while (scanner.hasNext()) 
		    {
		    	scanner.next();
		        if(currentRow >= 4) {
		        	break;
		        }
		        currentRow++;
		    }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public NameRecord getNext() throws NoMoreData {
		String state = null;
		int year = 0;
		String name = null; 
		int number = 0;
		String gender = null;

			if(scanner.hasNext()) {
				state = scanner.next().replaceAll("\"", "");
			}
			if(scanner.hasNext()) {
				year = Integer.parseInt(scanner.next());
			}
			if(scanner.hasNext()) {
				name = scanner.next().replaceAll("\"", "");
			}
			if(scanner.hasNext()) {
				try {
				number = Integer.parseInt(scanner.next());
				} catch(NumberFormatException e) {
					
				}
			}
			if(scanner.hasNext()) {
				gender = scanner.next().replaceAll("\"", "");
			}
		
			if(state  != null || name != null || gender != null || year != 0) {
				totalLines++;
				System.out.println(totalLines + "\n");
			return new NameRecord(state, year, name, number, gender);
			}
			
		//return null if no record is found
			throw new NoMoreData();
	}
	
	public void closeParser() {
		scanner.close();
	}
	
}
