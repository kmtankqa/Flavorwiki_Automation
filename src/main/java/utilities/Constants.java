package utilities;

import utilities.ConfigFileReader;

public class Constants {

	static ConfigFileReader config = new ConfigFileReader();

	public static final int WAIT_EXPLICIT_SEC = Integer.parseInt(config.getTime());

}