
package com.digitalriver.report;

import java.util.Scanner;

public class CieloReportConvertor {

	public static void main(String[] args) {

		int choice = 0;
		String inputFilename = null, outputFilename = null;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter your choice. \n 1. To convert byte file to CSV. \n 2. To convert CSV to byte file");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					processByteFileToCsv(inputFilename, outputFilename);
					break;
				case 2:
					processCsvToByteFile(inputFilename, outputFilename);
					break;
				case 3:
					break;
				default:
					System.out.println("Enter valid choice");
					break;
			}
		} while (choice != 3);
		sc.close();
	}

	public static void processByteFileToCsv(String inputFilename, String outputFilename) {

		ProcessByteFileConvertor convertor = new ProcessByteFileConvertor("C:\\Accolite\\DR docs\\VNOFF-430\\Testing\\New Scenario Files\\abc.txt",
		                                                                  "C:\\Accolite\\DR docs\\test.csv");
		/*ProcessByteFileConvertor convertor = new ProcessByteFileConvertor(inputFilename, outputFilename);*/
		convertor.processRawFileToCsv();
	}

	public static void processCsvToByteFile(String inputFilename, String outputFilename) {

		ByteFileConvertor convertor = new ByteFileConvertor("C:\\Accolite\\DR docs\\test.csv",
		                                                    "C:\\Accolite\\DR docs\\VNOFF-430\\Testing\\New Scenario Files\\abc1.txt");
		convertor.processCsvToRawFile();
	}
}