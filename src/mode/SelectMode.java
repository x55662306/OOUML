package mode;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import oo_project.DisplayGraphics;
import shape.BaseShape;

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
		BaseShape root = null;
		int depth = Integer.MAX_VALUE;
		for(int i=0; i<canvas.shapeList.size(); i++)
		{
			if(canvas.shapeList.get(i).isInShape(e.getX(), e.getY())) //&& canvas.shapeList.get(i).getDepth() < depth)
			{
				root = canvas.shapeList.get(i);
			}
		}

		for(int i=0; i<canvas.shapeList.size(); i++)
		{
			if(canvas.shapeList.get(i) != root)
				canvas.shapeList.get(i).unselect();
		}
		if(root != null)
		{
			
			root.select();
			root.floatUp();
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
			if(canvas.shapeList.get(i).isInShape(e.getX(), e.getY()))
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
			moveObj.move(e.getX() - pressX, e.getY() - pressY);
			moveObj.floatUp();
			moveMode = false;
		}
		else if(multiSelectMode)
		{
			for(int i=0; i<canvas.shapeList.size(); i++)
			{
				if(canvas.shapeList.get(i).isInRange(pressX, pressY, e.getX(), e.getY()))
				{
					canvas.shapeList.get(i).select();
				}
			}
			multiSelectMode = false;
		}
		
		canvas.repaint();
	}
}
