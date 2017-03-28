/**
 * 
 */
package com.santosh.wsutils.pincodes;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.santosh.wsutils.pincodes.load.PincodesLoader;

/**
 * @author Santosh
 *
 */
@Controller
public class PincodeController {
	private @Autowired PincodesLoader pincodesLoader;

	@GetMapping("pincodes")
	public String home() {
		return "home";
	}

	@ResponseBody
	@RequestMapping("/pincodes/states")
	public ResponseEntity<Set<String>> getStates(@RequestParam(value = "state", required = false) String state) {
		Set<String> response = new HashSet<>();
		if (StringUtils.isEmpty(state)) {
			response = pincodesLoader.getStates();
		} else {
			for (String s : pincodesLoader.getStates()) {
				if (s.startsWith(state.toUpperCase())) {
					response.add(s);
				}
			}
		}
		return new ResponseEntity<Set<String>>(response, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping("/pincodes/districts")
	public ResponseEntity<Set<String>> getDistrict(
			@RequestParam(value = "district", required = false) String district) {
		Set<String> response = new HashSet<>();
		if (StringUtils.isEmpty(district)) {
			response = pincodesLoader.getDistricts();
		} else {
			for (String s : pincodesLoader.getDistricts()) {
				if (s.startsWith(district.toUpperCase())) {
					response.add(s);
				}
			}
		}
		return new ResponseEntity<Set<String>>(response, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping("/pincodes/subdistricts/{state}/{district}/{subdistrict}")
	public ResponseEntity<Set<String>> getTown(@PathVariable("state") String state,
			@PathVariable("district") String district, @PathVariable("subdistrict") String subdistrict) {
		Set<String> districts = new HashSet<>();
		Set<Pincode> pincodes = pincodesLoader.getPincodes();
		pincodes.forEach(pincode -> {
			if (pincode.getState().equals(state) && pincode.getDistrict().equals(district)
					&& pincode.getSubDistrict().startsWith(subdistrict)) {
				districts.add(pincode.getSubDistrict());
			}
		});
		return new ResponseEntity<Set<String>>(districts, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping("/pincodes/villages")
	public ResponseEntity<Set<String>> getVillage(@RequestParam("state") String state,
			@RequestParam("district") String district, @RequestParam("subdistrict") String subdistrict,
			@RequestParam("village") String village) {
		Set<String> districts = new HashSet<>();
		Set<Pincode> pincodes = pincodesLoader.getPincodes();
		pincodes.forEach(pincode -> {
			if (pincode.getState().equals(state) && pincode.getDistrict().equals(district)
					&& pincode.getSubDistrict().equals(subdistrict) && pincode.getVillage().startsWith(village)) {
				districts.add(pincode.getVillage());
			}
		});
		return new ResponseEntity<Set<String>>(districts, HttpStatus.OK);
	}
}
