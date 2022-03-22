package mode;

import java.awt.event.MouseEvent;

import oo_project.DisplayGraphics;
import shape.BaseShape;
import shape.ShapeUseClass;

public class UseClassMode extends BaseMode
{
	int maxDepth;
	
	public UseClassMode(DisplayGraphics canvas)
	{
		super(canvas);
		maxDepth = 99;
	}
	
	@Override
	public void clickEvent(MouseEvent e)
	{
		int id = canvas.addId();
		ShapeUseClass shape = new ShapeUseClass(canvas, e.getX(), e.getY(), id, null);
		canvas.shapeList.add(shape);
		canvas.itemList.add(shape);
		canvas.repaint();
	}
}
