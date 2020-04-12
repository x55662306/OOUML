package oo_project;

import java.awt.event.MouseEvent;

public class ClassMode extends BaseMode
{
	public ClassMode(DisplayGraphics canvas)
	{
		super(canvas);
	}
	
	@Override
	public void clickEvent(MouseEvent e)
	{
		canvas.shapeList.add(new Square(canvas, e.getX(), e.getY(), canvas.shapeList.size()));
		canvas.repaint();
	}
}
