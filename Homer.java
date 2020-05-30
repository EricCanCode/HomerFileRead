/*
 * File: Homer.java
 * Author: Eric Haynes
 * Date: March 8, 2020,
 * Purpose: This program reads input from text file and displays it.
 * After completing, it gives a summary of how many characters make up the file.
 */

// Import Utilities

import java.io.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;

public class Homer {
    private static final int INSTRUCTIONLIST = 1;
    private static final String FILE_PATH = "Homer.txt";

    public static void main(String[] args) throws IOException {

        // Variables
        String yourChoice;
        int fileChar;

        //Welcome message
        System.out.println("Welcome to the File Read Demo application");
        System.out.println("This app will output the information found on the Homer.txt file");
        System.out.println("Artist credit could not be given due to anonymity\n");

        //Prompt user to display information
        String[] Instruction = new String[INSTRUCTIONLIST];
        Instruction[0]=
                "1. Enter the word 'Doh' if you are ready to see Homer.\n"+
                        "2. Enter ‘Q’ to quit the program : \n";
        System.out.println(Instruction[0]);

        //initialize utilities
        // Use the Scanner class to read user input
        Scanner scanner = new Scanner(System.in);

        //Prompt user for selected question.
        yourChoice =scanner.next();

        if(yourChoice.equalsIgnoreCase("Doh"))

        {
            try {
                //Use DataInputStream to input text file
                DataInputStream targetStream =
                        new DataInputStream(new FileInputStream("Homer.txt"));

                System.out.println("Homer File Contents\n");
                System.out.println("Grab your donut and get ready to yell Doh :-)\n");
                // Read one char at a time
                while ((fileChar = targetStream.read()) != -1) {
                    // convert int to char
                    System.out.print((char) fileChar);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if (yourChoice.equalsIgnoreCase("Q")) { System.out.println("Thank you for using the File Read Demo Application");
            System.exit(0);
        }

        FileUtil fileUtil = new FileUtil(FILE_PATH);
        System.out.println("\n");
        System.out.println("No. of characters in file: " + fileUtil.getCharCount() + "\n");
        System.out.println("Thank you for using the File Read Demo Application");
        System.exit(0);
    }
}

        class FileUtil {
            BufferedReader reader;

            public FileUtil(String filePath) throws FileNotFoundException {
                File file = new File(filePath);
                FileInputStream fileStream = new FileInputStream(file);
                InputStreamReader input = new InputStreamReader(fileStream);
                reader = new BufferedReader(input);
            }

            public int getCharCount() throws IOException {
                int charCount = 0;
                String data;
                while ((data = reader.readLine()) != null) {
                    charCount += data.length();
                }
                return charCount;
            }

        }