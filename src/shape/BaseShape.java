package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import oo_project.DisplayGraphics;


public class BaseShape extends BaseItem
{
	public int x, y, height, width;
	protected int  id;
	DisplayGraphics canvas;
	protected boolean selected;
	boolean ports[] = new boolean[4];
	String name;
	BaseShape root;
	ArrayList<BaseShape> childs;
	private BaseShape parent;
	
	public BaseShape(DisplayGraphics canvas, int id, BaseShape parent) 
	{
		this.canvas = canvas;
		this.id = id;
		selected = false;
		name = "";
		this.parent = parent; 
	}	
	
	public boolean getSelected()
	{
		return selected;
	}
	
	public int getId()
	{
		return id;
	}
	
	public BaseShape getRoot()
	{
		return root;
	}
	
	public ArrayList<BaseShape> getChilds()
	{
		return childs;
	}
	

	
	public void setRoot(BaseShape newRoot)
	{
		if(childs!=null)
		{
			for(int i=0; i<childs.size(); i++)
			{
				childs.get(i).setRoot(newRoot);
			}
		}
		root = newRoot;
	}
	
	public void setPort(int n, boolean b)
	{
		ports[n] = b;
	}
	
	public void setName(String str)
	{
		
	}
	
	
	public void select()
	{
		
	}
	
	public void unselect()
	{
		
	}
	
	public boolean overlap(int x, int y, int width, int height)
	{
		return false;
	}
	
	public void showPorts(int port, Graphics2D g2d)
	{
		int radius = 8;
		double angle = port*Math.PI*0.5f;
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillArc( (int)(x+0.5f*width+width*Math.cos(angle)*0.5f-0.5f*radius) , (int)(y+0.5f*height+height*Math.sin(angle)*0.5f-0.5f*radius), radius, radius, 0, 360);
	}
	
	public boolean isInShape(int x, int y) //for one point
	{
		return false;
	}
	
	public int mouseOnWitchId(int x, int y) //for one point
	{
			return -1;
	}

	public boolean isInRange(int x1, int y1, int x2, int y2) //for two points
	{
		return false;
	}
	
	public double dist(int x1, int y1, int x2, int y2)
	{
		return Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2);
	}
	
	public int whichSide(int a, int b)
	{
		int side = 0;
		double min = Double.MAX_VALUE;
		
		for(int i=0; i<4; i++)
		{
			double angle = i*Math.PI*0.5f;
			double distance = dist(a, b, (int)(x+0.5f*width+0.5f*width*Math.cos(angle)) , (int)(y+0.5f*height+0.5f*height*Math.sin(angle)));
			if( distance < min)
			{
				min = distance;
				side = i;
			}			
		}
		
		return side;
	}
	
	public Point getPortPos(int port)
	{
		double angle = port*Math.PI*0.5f;
		int a = (int)(x+0.5f*width+width*Math.cos(angle)*0.5f); 
		int b = (int)(y+0.5f*height+height*Math.sin(angle)*0.5f); 
		return new Point(a, b);
	}
	
	public void move(int deltax, int deltay)
	{
		
	}	
	
	public BaseShape findShape(int id)
	{
		return null;
	}
	
	public void floatUp()
	{
		
	}
	
	public int adjustDepth()
	{
		return 0;
	}
	
	public int lineOverlap(BaseLine line)
	{
		return -1;
	}
	
	
	
}
