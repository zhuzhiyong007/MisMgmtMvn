package net.zx.lims.core.net;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

import net.zx.lims.core.util.Log;

/**
 * Application Lifecycle Listener implementation class SessionIdListener
 *
 */
//@WebListener
public class SessionIdListener implements HttpSessionIdListener {

    /**
     * Default constructor. 
     */
    public SessionIdListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionIdListener#sessionIdChanged(HttpSessionEvent, String)
     */
    public void sessionIdChanged(HttpSessionEvent event, String oldSessionId)  { 
         // TODO Auto-generated method stub
    	Log.info("sessionIdChanged3333333333333");
    }
	
}
