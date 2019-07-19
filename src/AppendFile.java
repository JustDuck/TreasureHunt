package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class AppendFile {
	
/**
 * I will also try to use the scanner and get user input
 */


	    /**
	     * This class shows how to append text to existing file
	     * @param args
	     */
	    public static void main(String[] args) {
	    	
	    	//System.out.println(" Read the Instructions");
	    	
	    	Scanner input = new Scanner(System.in);
	    	System.out.println("Please Enter username");
	    	
	    	String userName =input.nextLine();  // Read user input
	    	
	    	System.out.println("\n");
	    	
	        String filePath = "X:\\text\\" + "SampleOutput.txt";
	        System.out.println("\n");
	        
	        System.out.println("X:\\text\\" + "SampleOutput.txt"+userName);
	        System.out.println("\n");
	        
	        String appendText = " "+userName;
	        
	        System.out.println("Username is: " + userName);  // Output user input 
	        
	        System.out.println("X:\\text\\" + "SampleOutput.txt"+filePath);
	        
	        appendUsingFileWriter(filePath, appendText);
	        
	       // appendUsingBufferedWriter(filePath, appendText, 100);
	        
	       // appendUsingOutputStream(filePath, appendText);
	    }

	    
	    private static void appendUsingOutputStream(String fileName, String data) {
	        OutputStream os = null;
	        try {
	            //below true flag tells OutputStream to append
	            os = new FileOutputStream(new File(fileName), true);
	            os.write(data.getBytes(), 0, data.length());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                os.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	   
	    private static void appendUsingBufferedWriter(String filePath, String text, int noOfLines) {
	        File file = new File(filePath);
	        FileWriter fr = null;
	        BufferedWriter br = null;
	        try {
	            //to append to file, you need to initialize FileWriter using below constructor
	            fr = new FileWriter(file,true);
	            br = new BufferedWriter(fr);
	            for(int i = 0; i<noOfLines;i++){
	                br.newLine();
	                //you can use write or append method
	                br.write(text);
	            }
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                br.close();
	                fr.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	   /**
	    * This is the only one that works
	    * @param filePath
	    * @param text
	    */
	    private static void appendUsingFileWriter(String filePath, String text) {
	        File file = new File(filePath);
	        FileWriter fr = null;
	        try {
	            //Below constructor argument decides whether to append or override
	            fr = new FileWriter(file,true);
	            fr.write(text);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }finally{
	            try {
	                fr.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	}


