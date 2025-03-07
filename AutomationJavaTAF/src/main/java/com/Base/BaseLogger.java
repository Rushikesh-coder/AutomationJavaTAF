package com.Base;

//import java.util.logging.LogManager;
//
//import org.slf4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class BaseLogger {

	 protected static final Logger log = LogManager.getLogger(BaseLogger.class);

	    public static void main(String[] args) {
	        log.info("Logging setup is working!");
	    }
	    
	 // 🔥 Generic Log Reporter Method with Assertion
		public void logReporter(String message, boolean condition) {
			log.info(message);
			Assert.assertTrue(condition, "Assertion Failed: " + message);
		}
}