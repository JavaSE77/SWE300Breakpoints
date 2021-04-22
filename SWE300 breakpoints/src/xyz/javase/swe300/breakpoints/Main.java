package xyz.javase.swe300.breakpoints;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class Main {

public static void main(String[] args) throws FileNotFoundException, NoMoreData {
	String fileName = "baby-names-by-state.csv";
	Scanner scanner = new Scanner(new File(fileName));
	scanner.useDelimiter(",");
	
    while (scanner.hasNext()) 
    {
        System.out.print(scanner.next() + "|");
    }
    
	
	scanner.close();
	
    FileParser f = new FileParser("baby-names-by-state.csv");
    NameRecord rec = f.getNext();
	
	
	
}

@Test
public void firstRecord() throws FileNotFoundException, NoMoreData
{
    FileParser f = new FileParser("baby-names-by-state.csv");
    NameRecord rec = f.getNext();
    assertEquals("AK", rec.getState());
    assertEquals(1960, rec.getYear());
    assertEquals("David", rec.getName());
    assertEquals(151, rec.getCount());
}

@Test
public void readLast() throws FileNotFoundException
{
    FileParser f = new FileParser("baby-names-by-state.csv");
    NameRecord rec = null;
    boolean stillReading = true;
    while (stillReading)
    {
        try
        {
            rec = f.getNext();
        }
        catch(NoMoreData e)
        {
            stillReading = false;
        }
    }
    assertEquals("WY", rec.getState());
    assertEquals(2008, rec.getYear());
    assertEquals("MYA", rec.getName());
    assertEquals(6, rec.getCount());
}
}
