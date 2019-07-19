package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in); // used to get input
		int option1 = 0;

		// Main Menu options
		System.out.println("1.Option 1");
		System.out.println("2.Option 2");
		System.out.println("3.Option 3");
		System.out.println("4.Option 4");
		System.out.println("5.Option 5");

		System.out.println("6.Exit main menu");
		// addUserInput
		while (true) {

			System.out.print("Please enter your choice : ");
			option1 = input.nextInt();
			String s = "";
			switch (option1) {

			case 1:
				System.out.println(" Read the Instructions");
				System.out.println("\n");
				readInstructions(s);
				break;
			case 2:
				System.out.println(" Read the Sample Input");
				System.out.println("\n");
				readSampleInput(s);
				break;
			case 3:
				System.out.println(" Read the Sample Output");
				System.out.println("\n");
				readSampleOutput(s);
				break;
			case 4:
				System.out.println(" Try the Treasure Hunt Program ");
				System.out.println("\n");
				runTreasureHunt();
				break;

			case 5:
				System.out.println("Add to The file ");
				System.out.println("\n");
				addToFile(s);
				break;
			case 6:
				System.out.println("You are about to exit the program ");
				System.out.println("\n");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option");
			}
		}

	}

	public static void readInstructions(String hello) {
		try {

			File file = new File("X:\\text\\TreasureHunt.txt");

			Scanner sc = new Scanner(file);
			sc.useDelimiter(",|\r\n");
			System.out.println(sc.next());
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}

			sc.close();

		} catch (FileNotFoundException e) {

			System.out.println("Enter existing file name");

			e.printStackTrace();
		}
	}

	public static void readSampleInput(String hello) {
		try {

			File file = new File("X:\\text\\SampleInput.txt");

			Scanner sc = new Scanner(file);
			sc.useDelimiter(",|\r\n");
			System.out.println(sc.next());
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}

			sc.close();
		} catch (FileNotFoundException e) {

			System.out.println("Enter existing file name");

			e.printStackTrace();
		}
	}

	public static void readSampleOutput(String hello) {
		try {

			File file = new File("X:\\text\\SampleOutput.txt");

			Scanner sc = new Scanner(file);
			sc.useDelimiter(",|\r\n");
			System.out.println(sc.next());
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}

			sc.close();
		} catch (FileNotFoundException e) {

			System.out.println("Enter existing file name");

			e.printStackTrace();
		}
	}

	public static void runTreasureHunt() {

		System.out.println("Notes: use this to run the TreasureHunt program jar file from a dos prompt as:");
		System.out.println(" java -jar TreasureHunt.jar");

	}

	public static void addToFile(String hello) throws IOException {

		String fileName = "X:\\text\\" + "SampleOutput.txt";
		FileWriter fw;
		// FileWriter fw1;

		// add this: 3069.2 miles to the south, 16039.25 miles to the west
		try {
			fw = new FileWriter(fileName, true);
			fw.write(" 3069.2 miles to the south, 16039.25 miles to the west");
			fw.close();
			FileWriter fw1 = new FileWriter(fileName, true);
			fw1.write(" 10.2 miles to the east, 18039.1 miles to the north");
			fw1.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void addUserInput(String hello) throws IOException {
		// String file = "userStrings.txt";
		String file = "X:\\text\\" + "SampleOutput.txt";
		Scanner scan = new Scanner(System.in);
		System.out.println("Your input is required ");
		FileWriter fw = new FileWriter(file);
		while (true) {
			String input = scan.nextLine();
			// System.out.println("your input was "+input);
			if ("DONE".equalsIgnoreCase(input.trim())) {
				break;
			}
			fw.write(input);
		}
		scan.close();
		fw.close();
	}

}