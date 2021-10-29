package tests;

import org.apache.logging.log4j.LogManager;


public class Logs {

	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(Logs.class.getName());
	public static void main(String[]args)
	{
		
		log.info("This is info");
		log.trace("This is trace");
		log.error("this is error");
		log.debug("this is debug");
		log.fatal("This is fatal");
	}
}
