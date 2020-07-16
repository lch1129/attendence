package com.wzy.attendence.socket;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SocketServiceLoader implements ServletContextListener{
	private SocketThread socketThread;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
			
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			if(socketThread == null) {
				socketThread = new SocketThread(null);
				socketThread.start();
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
