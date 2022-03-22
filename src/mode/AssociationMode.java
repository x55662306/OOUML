package mode;

import java.awt.event.MouseEvent;

import oo_project.DisplayGraphics;
import shape.AssociationLine;
import shape.BaseShape;
import shape.CompositionLine;

public class AssociationMode extends BaseMode
{
	private int startId, startPort, endId, endPort;
	
	public AssociationMode(DisplayGraphics canvas)
	{
		super(canvas);
		startId = -1;
		endId = -1;
	}
	
	@Override
	public void pressEvent(MouseEvent e)
	{
		for(int i=0; i<canvas.shapeList.size(); i++)
		{
			if(canvas.shapeList.get(i).isInShape(e.getX(), e.getY()) && canvas.shapeList.get(i).getId()!=-1)
			{
				startId = canvas.shapeList.get(i).getId();
				BaseShape startshape = canvas.findShapeInList(startId);
				startPort = startshape.whichSide(e.getX(), e.getY());
			}
		}
	}
	
	@Override
	public void releaseEvent(MouseEvent e)
	{
		for(int i=0; i<canvas.shapeList.size(); i++)
		{
			if(canvas.shapeList.get(i).isInShape(e.getX(), e.getY()) && canvas.shapeList.get(i).getId()!=-1 && startId!=-1 && canvas.shapeList.get(i).getId() != startId)
			{
				endId = canvas.shapeList.get(i).getId();
				BaseShape startshape = canvas.findShapeInList(startId);
				BaseShape endshape = canvas.findShapeInList(endId);
				endPort = endshape.whichSide(e.getX(), e.getY());
				AssociationLine line = new AssociationLine(canvas, startId, endId, startPort, endPort);
				canvas.lineList.add(line);
				canvas.itemList.add(line);
				startshape.setPort(startPort, true);
				endshape.setPort(endPort, true);
			}
		}
		startId = -1;
		endId = -1;
		canvas.repaint();
	}	
}
