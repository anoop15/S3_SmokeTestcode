package com.s3.businessLogic;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.dub.framework11.model.Dictionary;
import com.dub.framework11.model.JsonModel;
import com.dub.framework11.model.Notifications;
import com.dub.framework11.parser.PlistParser;
import com.dub.framework11.util.U;

public class NotificationParser {

	private static final String USER_AGENT = "Mozilla/5.0";
	public static NotificationParser instance = null;
	private static Dictionary dictionary = null;

	public static NotificationParser getInstance() {
		if (null == instance) {
			instance = new NotificationParser();
		}

		return instance;
	}

	// HTTP GET request
	public static void sendGet(String url) throws Exception {

		// String url = AddModuleAdmissions_Action.url;
		// String url =
		// "https://cloud-test.dublabs.com/s3ws/api/config/live/72011/10thClientpktest11";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print result
		JsonModel mModal = new JsonModel(response.toString());
		Notifications data = new Notifications(mModal);
		Notifications.Item[] items = data.getChildren();
		for (Notifications.Item item : items) {
			System.out.println(item.getString("Description") + " - ");
			System.out.println(item.getString("DescriptionDetails") + " - ");
			System.out.println(item.getString("Hyperlink") + " - ");
			System.out.println(item.getString("LinkLabel") + " - ");
			System.out.println(item.getString("TimeZoneId") + " - ");
			System.out.println(item.getString("NotificationKey" + " - "));

		}
		// getDictionary(response.toString());

	}

	public static void getDictionary(String plist) {
		if (!U.isEmpty(plist)) {
			// if config file is not empty
			ByteArrayInputStream bais = null;
			try {
				bais = new ByteArrayInputStream(plist.getBytes());
				PlistParser plp = new PlistParser();
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
