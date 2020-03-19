package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private static Properties properties = new Properties();
	static ConfigFileReader config = new ConfigFileReader();

	String currentDirectory = System.getProperty("user.dir");
	private final String propertyFilePath = currentDirectory + "/configs/Configuartion.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			/*
			 * properties = new Properties();
			 */ try {
				ConfigFileReader.properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getURL() {
		String url = properties.getProperty("app.url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url is  not specified in the Configuration.properties file.");
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public String getfilePath() {
		String Path = properties.getProperty("propertyFilePath");
		if (Path != null)
			return Path;
		else
			throw new RuntimeException("Path  not specified in the Configuration.properties file.");
	}

	public String getvalidUsername() {
		String Username = properties.getProperty("validUsername");

		if (Username != null)
			return Username;
		else
			throw new RuntimeException("Username is  not specified in the Configuration.properties file.");
	}

	public String getvalidPassword() {
		String Password = properties.getProperty("validPassword");
		if (Password != null)
			return Password;
		else
			throw new RuntimeException("Password is  not specified in the Configuration.properties file.");
	}

	public String getTime() {
		String time = properties.getProperty("wait.explicit.seconds");
		if (time != null)
			return time;
		else
			throw new RuntimeException("Password is  not specified in the Configuration.properties file.");
	}

	public String expectedTextTerms() {
		String terms = properties.getProperty("TermOfUse");
		if (terms != null)
			return terms;
		else
			throw new RuntimeException("terms  is  not specified in the Configuration.properties file.");
	}

	public String expectedTextPrivacy() {
		String PrivacyPolicy = properties.getProperty("PrivacyPolicy");
		if (PrivacyPolicy != null)
			return PrivacyPolicy;
		else
			throw new RuntimeException("PrivacyPolicy is  not specified in the Configuration.properties file.");
	}

	public String expectedTextDashBoard() {
		String DashBoard = properties.getProperty("DashBoard");
		if (DashBoard != null)
			return DashBoard;
		else
			throw new RuntimeException("DashBoard is  not specified in the Configuration.properties file.");
	}

	public String getQrCodeName() {
		String QrCodeName = properties.getProperty("QrCodeName");
		if (QrCodeName != null)
			return QrCodeName;
		else
			throw new RuntimeException("QrCodeName is  not specified in the Configuration.properties file.");
	}

	public String getUniqueName() {
		String UniqueName = properties.getProperty("UniqueName");
		if (UniqueName != null)
			return UniqueName;
		else
			throw new RuntimeException("UniqueName is  not specified in the Configuration.properties file.");
	}

}