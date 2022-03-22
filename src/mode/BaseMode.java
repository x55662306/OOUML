package mode;

import java.awt.event.MouseEvent;

import oo_project.DisplayGraphics;

public class BaseMode 
{
	DisplayGraphics canvas;
	int pressX, pressY;
	
	public BaseMode(DisplayGraphics canvas)
	{
		this.canvas = canvas;
	}
	
	public void clickEvent(MouseEvent e) 
	{
		
	}
	
	public void pressEvent(MouseEvent e) 
	{
		
	}
	
	public void releaseEvent(MouseEvent e) 
	{
		
	}
}
