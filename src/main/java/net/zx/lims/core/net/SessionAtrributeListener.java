package net.zx.lims.core.net;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import net.zx.lims.core.util.Log;

/**
 * Application Lifecycle Listener implementation class SessionAtrributeListener
 *
 */
//@WebListener
public class SessionAtrributeListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionAtrributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	Log.info("atrribiteAdd111111");
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	Log.info("atrribiteReplaced111111");
    }
	
}
