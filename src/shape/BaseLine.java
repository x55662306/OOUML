package shape;

import java.awt.Graphics2D;
import java.awt.Point;

import oo_project.DisplayGraphics;

public class BaseLine extends BaseItem
{
	int startId, endId, startPort, endPort;
	protected Point startPoint, endPoint;
	DisplayGraphics canvas;

	BaseLine(DisplayGraphics canvas, int startId, int endId, int startPort, int endPort)
	{
		this.canvas = canvas;
		this.startId = startId;
		this.endId = endId;
		this.startPort = startPort;
		this.endPort = endPort;
	}
	
	public Point getStartPoint()
	{
		return startPoint;
	}
	
	public Point getEndPoint()
	{
		return endPoint;
	}
	
	public int getStartId()
	{
		return startId;
	}
	
	public int getEndId()
	{
		return endId;
	}
	
	public void caculatePoints()
	{
		BaseShape startShape = canvas.findShapeInList(startId);
		BaseShape endShape = canvas.findShapeInList(endId);
		startPoint = startShape.getPortPos(startPort);
		endPoint = endShape.getPortPos(endPort);
	}
	
	@Override
	public boolean overlap(BaseShape shape)
	{
		caculatePoints();
		Point sp1 = new Point(shape.x, shape.y);
		Point sp2 = new Point(shape.x + shape.width, shape.y);
		Point sp3 = new Point(shape.x, shape.y + shape.height);
		Point sp4 = new Point(shape.x + shape.width, shape.y + shape.height);
		if(doIntersect(startPoint, endPoint, sp1, sp2)) return true;
		if(doIntersect(startPoint, endPoint, sp2, sp3)) return true;
		if(doIntersect(startPoint, endPoint, sp3, sp4)) return true;
		if(doIntersect(startPoint, endPoint, sp4, sp1)) return true;
		return false;
	}
	
	public boolean overlap(BaseLine line)
	{
		caculatePoints();
		line.caculatePoints();
		Point lp1 = line.getStartPoint();
		Point lp2 = line.getEndPoint();
		if(doIntersect(startPoint, endPoint, lp1, lp2)) return true;
		return false;
	}
	
	public void floatUp()
	{
		depth = 99;
		caculatePoints();
		for(int i=0; i<canvas.itemList.size(); i++)
		{
			if(canvas.itemList.get(i).overlap(this) && canvas.itemList.get(i).getDepth()<=depth)
				depth = canvas.itemList.get(i).getDepth()-1;
		}
	}
}
