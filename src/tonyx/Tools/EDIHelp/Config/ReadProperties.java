package tonyx.Tools.EDIHelp.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadProperties {
	private static SafeProperties mainProp;

	static {
		FileInputStream input = null;
		try {
			input = new FileInputStream("config/main.properties");
			mainProp = new SafeProperties();
			mainProp.load(input);
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input = null;
			}
		}
	}

	public static String getProperty(String key) {
		return key == null ? "" : mainProp.getProperty(key);
	}

	public static void setProperty(String key, String value) {
		if (key != null && value != null) {
			mainProp.setProperty(key, value);
			writeback();
		}
	}

	public static void writeback() {
		FileOutputStream output;
		try {
			output = new FileOutputStream("config/main.properties");
			mainProp.store(output, null);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
