package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("D:\\json\\Data.json"));

			JSONObject jsonObject = (JSONObject) obj;
			// System.out.println(jsonObject);

			Long name = (Long) jsonObject.get("Username");
			System.out.println("Username : " + name);

			String pass = (String) jsonObject.get("Password");
			System.out.println("Password : " + pass);

			// loop array

			Object objArray = jsonObject.get("messages");
			JSONArray msg = (JSONArray) objArray;
			// Iterator<String> iterator = msg.iterator();

			for (Object object : msg) {
				String val = (String) object;
				System.out.println("Array " + val);
			}

			/*
			 * while (iterator.hasNext()) { System.out.println(iterator.next());
			 * }
			 */

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
