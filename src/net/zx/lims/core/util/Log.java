package net.zx.lims.core.util;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class Log {
	 private static Logger logger = Logger.getLogger(Log.class);
	 
	 public static void log(String message){
		 logger.info("[系统日志] "+message);
	 }
	 
	 public static void info(String message){
		 logger.info("[系统信息] "+message);
	 }
	 
	 public static void error(String message){
		 logger.info("[系统一般错误] "+message);
	 }
	 
	 public static void fatalError(String message){
		 logger.info("[系统严重错误] "+message);
	 }
}
