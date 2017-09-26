package com.s3.businessLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class VCardParser {

	public static final String BEGIN_VCARD = "BEGIN:VCARD";
	public static final String END_VCARD = "END:VCARD";
	private ArrayList<Values> arr = new ArrayList<>();

	private static VCardParser instance = null;

	// private VCardParser() {
	// sendGet();
	// }

	public static VCardParser getInstance() {
		if (null == instance) {
			instance = new VCardParser();
		}

		return instance;
	}

	public void sendGet(String file) {

		BufferedReader bf;
		int count = 0;
		try {
			//
			// URL url = new URL(
			// "https://crane.it.utsa.edu:8443/resources/maps.vcf");
			// bf = new BufferedReader(new InputStreamReader(url.openStream()));
			//
			File obj = new File(file);
			FileReader fis = new FileReader(obj);
			bf = new BufferedReader(fis);
			// convert in buffer reader as stream
			String line = null;
			Values v = null;
			while ((line = bf.readLine()) != null) {
				// read here data from stream
				if (line.contains(BEGIN_VCARD)) {
					v = new Values();
					v.index = count++;
				} else if (line.contains(END_VCARD)) {
					arr.add(v);
				} else {
					if (line.contains(":")) {
						String[] str = line.split(":");
						if (str != null && line.contains(";")) {
							String[] str1 = line.split(";");
							int len = str1.length;
							if (null != str1 && len == 3) {
								v.values.put(str1[0], str1[1]);
							}

						}
						if (null != str && str.length == 2) {
							v.values.put(str[0], str[1]);
						}

					}

					// String[] str3 = line.split(":");
					// if(null != str3 && str3.length== 2){
					// v.values.put(str3[0], str3[1]);
				}
			}

			bf.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public class Values {
		public int index;
		public HashMap<String, String> values = new HashMap<>();

	}

	public ArrayList<Values> getCampuses() {
		return arr;
	}

	public String getCampusData(int campus, String key) {
		return arr.get(campus).values.get(key);
	}

}
