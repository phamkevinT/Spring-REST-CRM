package com.kevinpham.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			// create Object mapper 
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO:
			// the file location: data/sample-full.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first and last name
			System.out.println("First Name = " + theStudent.getFirstName());
			System.out.println("Last Name = " + theStudent.getLastName());
			
			// print out address from nested JSON: street and city
			Address tempAddress = theStudent.getAddress();
			
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());

			// print out languages from array
			
			for(String tempLang: theStudent.getLanguages()) {
				System.out.println(tempLang);
			}
			
		} 
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
