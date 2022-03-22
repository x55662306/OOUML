package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import oo_project.DisplayGraphics;

public class ShapeComposite extends BaseShape
{	
	public ShapeComposite(DisplayGraphics canvas, int id,BaseShape parent)
	{
		super(canvas, id, parent);
		childs = new ArrayList<BaseShape>();
		selected = true;
		root = this;
	}
	
	public void addChild(BaseShape shape) 
    {
        childs.add(shape);
    }
	
	@Override
	public void setName(String str)
	{
		for(int i=0; i<childs.size(); i++)
		{
			childs.get(i).setName(str);
		}
	}
	
	@Override
	public void move(int deltaX, int deltaY)
	{
		x += deltaX;
		y += deltaY;
		for(int i=0; i<childs.size(); i++)
			childs.get(i).move(deltaX, deltaY);
		
	}
	
	@Override
	public void select()
	{
		selected = true;
		for(int i=0; i<childs.size(); i++)
		{
			childs.get(i).select();
		}
	}
	
	@Override
	public void unselect()
	{
		selected = false;
		for(int i=0; i<childs.size(); i++)
			childs.get(i).unselect();
	}
	
	@Override
	public boolean isInShape(int x, int y) //for one point
	{
		for(int i=0; i<childs.size(); i++)
		{
			if(childs.get(i).isInShape(x, y))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean isInRange(int x1, int y1, int x2, int y2) //for two points
	{
		for(int i=0; i<childs.size(); i++)
		{
			if(childs.get(i).isInRange(x1, y1, x2, y2))
				return true;
		}
		return false;
	}
	
	@Override
	public int mouseOnWitchId(int x, int y) //for one point
	{
		for(int i=0; i<childs.size(); i++)
		{
			if(childs.get(i).mouseOnWitchId(x, y) != -1)
				return childs.get(i).getId();
		}
		return -1;
	}
	
	@Override
	public void paintOnCanvas(Graphics2D g2d)
	{
		for(int i=0; i<childs.size(); i++)
		{
			childs.get(i).paintOnCanvas(g2d);
		}
	}
	
	@Override
	public BaseShape findShape(int id)
	{
		for(int i=0; i<childs.size(); i++)
		{
			if(childs.get(i).findShape(id) != null)
				return childs.get(i).findShape(id);
		}
		return null;
	}
	
	@Override
	public void floatUp()
	{
		for(int i=0; i<childs.size(); i++)
		{
			childs.get(i).floatUp();
		}
		adjustDepth();
	}
	
	@Override
	public boolean overlap(BaseShape shape)
	{
			return false;
	}
	
	public boolean overlap(BaseLine line)
	{
		return false;
	}
	
	@Override
	public int adjustDepth()
	{
		int d = Integer.MAX_VALUE;

		for(int i=0; i<childs.size(); i++)
		{
			if(d>childs.get(i).adjustDepth())
				d = childs.get(i).adjustDepth();
		}
		depth = d;
		
		return d;
	}
	
}
