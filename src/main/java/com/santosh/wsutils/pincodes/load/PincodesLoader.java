/**
 * 
 */
package com.santosh.wsutils.pincodes.load;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.santosh.wsutils.pincodes.Pincode;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author Santosh
 *
 */
@Component
public class PincodesLoader {
	private Set<Pincode> pincodes = new HashSet<>();
	private Set<String> states = new HashSet<>();
	private Set<String> districts = new HashSet<>();

	public PincodesLoader() {
		try {
			CSVReader csvReader = new CSVReader(new BufferedReader(new FileReader("locdetails_15feb16_4.csv")));
			String[] input;
			csvReader.readNext();
			int index = 0;
			int districtIndex = 0;
			int lesser = 0;
			int totalIndex = 0;
			int previousIndex = 0;
			while ((input = csvReader.readNext()) != null) {
				/*
				 * Integer x = Integer.parseInt(input[9]); if (x !=
				 * (previousIndex + 1)) { System.out.println(x); previousIndex =
				 * x; }
				 */
				try {
					Pincode pincode = new Pincode(input[0].toUpperCase(), input[1].toUpperCase(),
							input[2].toUpperCase(), input[3].toUpperCase(), input[4].toUpperCase(),
							input[5].toUpperCase(), input[6].toUpperCase(), input[7].toUpperCase(),
							input[8].toUpperCase());
					System.out.println(input[9]);
					getPincodes().add(pincode);
					if (getStates().add(input[0].toUpperCase())) {
						index = 1;
					} else {
						index++;
					}
					if (getDistricts().add(input[1].toUpperCase())) {
						districtIndex = 1;
					} else {
						districtIndex++;
					}
					totalIndex++;
				} catch (Exception e) {
					System.out.println(input[0]);
					e.printStackTrace();
				}
			}
			// System.out.println(input);
			System.out.println(totalIndex);
			csvReader.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public Set<Pincode> getPincodes() {
		return pincodes;
	}

	public void setPincodes(Set<Pincode> pincodes) {
		this.pincodes = pincodes;
	}

	public Set<String> getStates() {
		return states;
	}

	public void setStates(Set<String> states) {
		this.states = states;
	}

	public Set<String> getDistricts() {
		return districts;
	}

	public void setDistricts(Set<String> districts) {
		this.districts = districts;
	}
}
