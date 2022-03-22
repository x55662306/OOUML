package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import oo_project.DisplayGraphics;

public class ShapeClass extends BaseShape
{
	private int yInterval;
	public ShapeClass(DisplayGraphics canvas, int x, int y, int id,BaseShape parent)
	{
		super(canvas, id, parent);
		this.x = x;
		this.y = y;
		width = 100;
		height = 120;
		this.yInterval = (int)(height/3.0f);
		root = this;
		floatUp();
	}
	

	@Override
	public void paintOnCanvas(Graphics2D g2d)
	{
		g2d.setPaint(new Color(180, 180, 180));
		g2d.fillRect(x, y, width, height);
		g2d.setPaint(new Color(50, 50, 50));
		g2d.drawRect(x, y, width, height);
		g2d.drawLine(x, y+yInterval, x+width, y+yInterval);
		g2d.drawLine(x, y+2*yInterval, x+width, y+2*yInterval);
		g2d.drawString(name, x+20, y+20);
				
		if(root.getSelected() || getSelected())
		{
			for(int i=0; i<4; i++)
				showPorts(i, g2d);
		}
		
		for(int i=0; i<4; i++)
		{
			if(ports[i])
				showPorts(i, g2d);
		}
		
	}
	
	@Override
	public void setName(String str)
	{
		name = String.valueOf(str);
	}
	
	@Override
	public boolean isInShape(int x, int y) //for one point
	{
		if(this.x < x && x < (this.x + width) && this.y < y && y < (this.y + height))
			return true;
		else 
			return false;
	}
	
	@Override
	public boolean isInRange(int x1, int y1, int x2, int y2) //for two points
	{
		int rangeWidth = Math.abs(x1-x2);
		int rangeHeight = Math.abs(y1-y2);
		
		if( (Math.abs(x-x1) + Math.abs(x-x2) == rangeWidth) && (Math.abs(y-y1) + Math.abs(y-y2) == rangeHeight) 
		&& (Math.abs(x+width-x1) + Math.abs(x+width-x2) == rangeWidth) && (Math.abs(y+height-y1) + Math.abs(y+height-y2) == rangeHeight) )
			return true;
		else
			return false;
	}
	
	@Override
	public int mouseOnWitchId(int x, int y) //for one point
	{
		if(this.x < x && x < (this.x + width) && this.y < y && y < (this.y + height))
			return id;
		else 
			return -1;
	}
	
	@Override
	public void move(int deltaX, int deltaY)
	{
		x += deltaX;
		y += deltaY;
	}
	
	@Override
	public void select()
	{
		selected = true;
	}
	
	@Override
	public void unselect()
	{
		selected = false;
	}
	
	@Override
	public BaseShape findShape(int id)
	{
		if(id == this.id)
			return this;
		else
			return null;
	}
	
	@Override
	public void floatUp()
	{
		depth = 99;
		
		for(int i=0; i<canvas.itemList.size(); i++)
		{
			if(canvas.itemList.get(i).overlap(this) && canvas.itemList.get(i).getDepth()<=depth)
				depth = canvas.itemList.get(i).getDepth()-1;
		}
		
		for(int i=0; i<canvas.lineList.size(); i++)
		{
			BaseLine line = canvas.lineList.get(i);
			if(line.getStartId() == id || line.getEndId() == id)
				line.floatUp();
		}
	}
	
	@Override
	public boolean overlap(BaseShape shape)
	{
		if(shape.isInShape(x, y) || shape.isInShape(x+width, y) || shape.isInShape(x, y+height) || shape.isInShape(x+width, y+height))
			return true;
		else
			return false;
	}
	
	public boolean overlap(BaseLine line)
	{
		line.caculatePoints();
		Point sp1 = new Point(x, y);
		Point sp2 = new Point(x + width, y);
		Point sp3 = new Point(x, y + height);
		Point sp4 = new Point(x + width, y + height);
		if(doIntersect(line.getStartPoint(), line.getEndPoint(), sp1, sp2)) return true;
		if(doIntersect(line.getStartPoint(), line.getEndPoint(), sp2, sp3)) return true;
		if(doIntersect(line.getStartPoint(), line.getEndPoint(), sp3, sp4)) return true;
		if(doIntersect(line.getStartPoint(), line.getEndPoint(), sp4, sp1)) return true;
		return false;
	}
	
	@Override
	public int adjustDepth()
	{
		return depth;
	}
}
