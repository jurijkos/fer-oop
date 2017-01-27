package my_game;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Window {
	private GraphicsDevice gDevice;
	
	
	public Window() {
		GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gDevice = gEnvironment.getDefaultScreenDevice();
		
	}
	public void setFullScreen(DisplayMode dMode, JFrame window) {
		window.setUndecorated(true);
		window.setResizable(false);
		gDevice.setFullScreenWindow(window);
		if (dMode != null && gDevice.isDisplayChangeSupported()) {
			try {
				gDevice.setDisplayMode(dMode);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public java.awt.Window getFullScreen() {
		return gDevice.getFullScreenWindow();
	}
	
	public void restoreWindow() {
		java.awt.Window w = gDevice.getFullScreenWindow();
		if (w != null) {
			w.dispose();
		}
		gDevice.setFullScreenWindow(null);
	}
	
	

}
