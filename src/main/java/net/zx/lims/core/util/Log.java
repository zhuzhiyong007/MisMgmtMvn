package net.zx.lims.core.util;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class Log {
	 private static Logger logger = Logger.getLogger(Log.class);
	 
	 public static void log(Exception e){
		 logger.info("[系统日志] "+getStackTrace(e));
	 }
	 
	 public static void log(String e){
		 logger.info("[系统日志] "+e);
	 }
	 
	 public static void info(String message){
		 logger.info("[系统信息] "+message);
	 }
	 
	 public static void error(String message){
		 logger.error("[系统一般错误] "+message);
	 }
	 public static void error(Exception e){
		 logger.error("[系统一般错误] "+e);
	 }
	 
	 public static void fatalError(String message){
		 logger.info("[系统严重错误] "+message);
	 }
	 
	 public static String getStackTrace(Exception e){
		 StringBuffer exceptionMessage = new StringBuffer();
		 StackTraceElement[] traces = e.getStackTrace();
		 for(int i=0;i<traces.length;i++){
			 if(traces[i].getMethodName().indexOf("net.zx")!=-1){
				 exceptionMessage.append("net.zx->:\n");
			 }
			 exceptionMessage.append(traces[i].getMethodName());
		 }
		 return exceptionMessage.toString();
	 }
}
