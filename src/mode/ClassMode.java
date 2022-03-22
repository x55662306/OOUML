package mode;

import java.awt.event.MouseEvent;

import oo_project.DisplayGraphics;
import shape.BaseShape;
import shape.ShapeClass;

public class ClassMode extends BaseMode
{
	int maxDepth;
	
	public ClassMode(DisplayGraphics canvas)
	{
		super(canvas);
		maxDepth = 99;
	}
	
	@Override
	public void clickEvent(MouseEvent e)
	{
		int id = canvas.addId();
		ShapeClass shape = new ShapeClass(canvas, e.getX(), e.getY(), id, null);
		canvas.shapeList.add(shape);
		canvas.itemList.add(shape);
		canvas.repaint();
	}
}
