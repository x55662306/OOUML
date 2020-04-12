package oo_project;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;


public class BaseShape
{
	int x, y, height, width, id;
	DisplayGraphics canvas;
	boolean selected;
	boolean ports[] = new boolean[4];
	
	
	BaseShape(DisplayGraphics canvas, int id) 
	{
		this.canvas = canvas;
		this.id = id;
		height = 60;
		width = 80;
		selected = false;
	}	
	
	public void paintOnCanvas()
	{
		
	}
	
	public void select()
	{
		if(selected == true)
		{
			selected = false;
		}
		else
		{
			selected = true;
		}
	}
	
	public void showPorts(int port)
	{
		int radius = 8;
		double angle = port*Math.PI*0.5f;
		Graphics2D g2d = (Graphics2D)canvas.getGraphics();
		g2d.fillArc( (int)(x+0.5f*width+width*Math.cos(angle)*0.5f-0.5f*radius) , (int)(y+0.5f*height+height*Math.sin(angle)*0.5f-0.5f*radius), radius, radius, 0, 360);
	}
	
	public boolean isInBound(int x, int y)
	{
		if(this.x < x && x < (this.x + width) && this.y < y && y < (this.y + height))
			return true;
		else 
			return false;
	}

	public boolean isInRange(int x1, int y1, int x2, int y2)
	{
		if(x1<x && y1<y && x2>(x+width) && y2 >(y+height))
			return true;
		else
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
	
	
}
