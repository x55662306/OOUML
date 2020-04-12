package oo_project;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DisplayGraphics extends JPanel
{
	public ArrayList<BaseShape> shapeList = new ArrayList();
	public ArrayList<BaseLine> lineList = new ArrayList();
	
	BaseMode mode;
	
	DisplayGraphics()
	{
		mode = new ClassMode(this);		
		addMouseListener( new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
		        System.out.println("mouseClicked");
		        mode.clickEvent(e);
		    }
			
			@Override
			public void mousePressed(MouseEvent e) 
			{
		        System.out.println("mousePress");
		        mode.pressEvent(e);
		    }
			
			@Override
			public void mouseReleased(MouseEvent e) 
			{
		        System.out.println("mouseReleased");
		        mode.releaseEvent(e);
		    }
		});
	}
	
	@Override
    protected void paintComponent (Graphics g) 
	{
		super.paintComponent(g);
		//Graphics2D g2d = (Graphics2D)g;
		//g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
		for(int i=0; i<shapeList.size(); i++)
			shapeList.get(i).paintOnCanvas();
		for(int i=0; i<lineList.size(); i++)
			lineList.get(i).paintOnCanvas();
    }
	
	/*
	@Override
	public void paint(Graphics g) 
	{
		
		System.out.println(shapeList.size());
		for(int i=0; i<shapeList.size(); i++)
		{
			shapeList.get(i).paintOnCanvas();
		}
		
			
	}
	*/
	
	public void myRepaint()
	{
		
	}
}
