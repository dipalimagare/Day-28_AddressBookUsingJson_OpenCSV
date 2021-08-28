package com.bl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;


public class AddressBookCSV 
{
	public static void readInCSV() {
		Path path = Paths.get("src\newcsvFile.csv");
		try {
			Reader r = Files.newBufferedReader(path);
			BufferedReader br = new BufferedReader(r);
			CSVReader csv = new CSVReader(br);
			String[] records;
			while ((records = csv.readNext()) != null) {
				System.out.println("First Name: " + records[0]);
				System.out.println("Last Name: " + records[1]);
				System.out.println("Address: " + records[2]);
				System.out.println("City: " + records[3]);
				System.out.println("State: " + records[4]);
				System.out.println("Email : " + records[5]);
				System.out.println("Phone : " + records[6]);
				System.out.println("ZIP : " + records[7]);
				System.out.println("-------------------------");
			}
			csv.close();
		} catch (Exception e) {

		}
	}

	public static void writeInCSV(Contact c) {
		try {
			FileWriter fw = new FileWriter("src\\csvFile.csv", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.print(c.getFirstName() + "," + c.getLastName() + "," + c.getAddress() + "," + c.getCityName() + ","
					+ c.getStateName() + "," + c.getEmailId() + "," + c.getPhoneNumber() + "," + c.getZipCode() + "\n");
			pw.flush();
			pw.close();

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
