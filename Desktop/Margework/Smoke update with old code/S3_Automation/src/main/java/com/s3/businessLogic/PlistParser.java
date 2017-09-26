package com.s3.businessLogic;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.dub.framework11.model.Dictionary;
import com.dub.framework11.util.U;

public class PlistParser {

	private static final String USER_AGENT = "Mozilla/5.0";
	public static PlistParser instance = null;
	private static Dictionary dictionary = null;

	public static PlistParser getInstance()  {
		if (null == instance) {
			instance = new PlistParser();
		}
		try {
			sendGet();
		} 
		/*catch (MalformedURLException e) {
			System.out.println("Unable to parse Plist");
			throw new Exception(e);
		}*/
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return instance;
	}

	// HTTP GET request
	@SuppressWarnings("unused")
	public static void sendGet() throws Exception {

		URL obj = new URL(GetLivePlist.url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result

		getDictionary(response.toString());

	}

	public static void getDictionary(String plist) {
		if (!U.isEmpty(plist)) {
			// if config file is not empty
			ByteArrayInputStream bais = null;
			try {
				bais = new ByteArrayInputStream(plist.getBytes());
				com.dub.framework11.parser.PlistParser plp = new com.dub.framework11.parser.PlistParser();
				dictionary = plp.parse(bais);

			} finally {
				U.closeIn(bais);
			}
		}
	}

	public Dictionary getDictionary(String key, Dictionary d) {
		return d.getChild(key);
	}

	public Dictionary getModule(String key) {
		return dictionary.getChild(key);
	}

	public String getValue(String moduleName, String key) {
		return dictionary.getChild(moduleName).getValue(key);
	}

	public String[] getValueArray(String moduleName, String key) {
		return dictionary.getChild(moduleName).getValueArray(key);
	}

}
