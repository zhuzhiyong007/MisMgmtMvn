package net.zx.lims.core.util;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class Log {
	 private static Logger logger = Logger.getLogger(Log.class);
	 public static void log(){
		 logger.log(Priority.DEBUG, "≤‚ ‘");
	 }
	 
	 public static void log(String message){
		 logger.info(message);;
	 }
}
