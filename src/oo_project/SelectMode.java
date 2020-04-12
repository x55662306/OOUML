package oo_project;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class SelectMode extends BaseMode 
{
	BaseShape moveObj;
	boolean moveMode, multiSelectMode;
	
	public SelectMode(DisplayGraphics canvas)
	{
		super(canvas);
	}
	
	@Override
	public void clickEvent(MouseEvent e)
	{
		for(int i=0; i<canvas.shapeList.size(); i++)
		{
			if(canvas.shapeList.get(i).isInBound(e.getX(), e.getY()))
				canvas.shapeList.get(i).select();
			else if(canvas.shapeList.get(i).selected == true)
				canvas.shapeList.get(i).select();
		}
		canvas.repaint();
	}
	
	@Override
	public void pressEvent(MouseEvent e)
	{
		multiSelectMode = true;
		pressX = e.getX();
		pressY = e.getY();
		for(int i=0; i<canvas.shapeList.size(); i++)
		{
			if(canvas.shapeList.get(i).isInBound(e.getX(), e.getY()))
			{
				moveObj = canvas.shapeList.get(i);
				moveMode = true;
				multiSelectMode = false;
			}
		}
	}
	
	@Override
	public void releaseEvent(MouseEvent e)
	{
		if(moveMode == true)
		{
			moveObj.x += e.getX() - pressX;
			moveObj.y += e.getY() - pressY;
			moveMode = false;
		}
		else if(multiSelectMode)
		{
			for(int i=0; i<canvas.shapeList.size(); i++)
			{
				if(canvas.shapeList.get(i).isInRange(pressX, pressY, e.getX(), e.getY()) && canvas.shapeList.get(i).selected == false)
					canvas.shapeList.get(i).select();
				else if(canvas.shapeList.get(i).selected == true)
					canvas.shapeList.get(i).select();
			}
			multiSelectMode = false;
		}
		
		canvas.repaint();
	}
}
