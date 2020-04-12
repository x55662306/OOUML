package oo_project;

import java.awt.event.MouseEvent;

public class AssociationMode extends BaseMode
{
	private int startId, startPort, endId, endPort;
	
	public AssociationMode(DisplayGraphics canvas)
	{
		super(canvas);
	}
	
	@Override
	public void pressEvent(MouseEvent e)
	{
		for(int i=0; i<canvas.shapeList.size(); i++)
		{
			if(canvas.shapeList.get(i).isInBound(e.getX(), e.getY()))
			{
				startId = i;
				startPort = canvas.shapeList.get(i).whichSide(e.getX(), e.getY());
			}
		}
	}
	
	@Override
	public void releaseEvent(MouseEvent e)
	{
		for(int i=0; i<canvas.shapeList.size(); i++)
		{
			if(canvas.shapeList.get(i).isInBound(e.getX(), e.getY()) && canvas.shapeList.get(i).id != startId)
			{
				endId = i;
				endPort = canvas.shapeList.get(i).whichSide(e.getX(), e.getY());
				canvas.lineList.add(new AssociationLine(canvas, startId, endId, startPort, endPort));
				canvas.shapeList.get(startId).ports[startPort] = true;
				canvas.shapeList.get(endId).ports[endPort] = true;
			}
		}
		
		canvas.repaint();
	}
	
	
}
