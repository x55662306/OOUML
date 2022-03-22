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
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import mode.BaseMode;
import mode.ClassMode;
import shape.BaseItem;
import shape.BaseLine;
import shape.BaseShape;

public class DisplayGraphics extends JPanel
{
	public ArrayList<BaseItem> itemList;
	public ArrayList<BaseShape> shapeList;
	public ArrayList<BaseLine> lineList;
	private BaseShapeComparator shapeCmp;
	private BaseLineComparator lineCmp;
	private BaseItemComparator itemCmp;
	private int idCnt;
	
	public BaseMode mode;
	
	DisplayGraphics()
	{
		 
		mode = new BaseMode(this);	
		itemList = new ArrayList<BaseItem>();
		shapeList = new ArrayList<BaseShape>();
		lineList = new ArrayList<BaseLine>();
		itemCmp = new BaseItemComparator();
		shapeCmp = new BaseShapeComparator();
		lineCmp = new BaseLineComparator();
		idCnt = -1;
		
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
	
	public void sortDepth()
	{
		
	}
	
	@Override
    protected void paintComponent (Graphics g) 
	{
		super.paintComponent(g);
		
		itemList.sort(itemCmp);
		
		for(int i=0; i<itemList.size(); i++)
			itemList.get(i).paintOnCanvas((Graphics2D)g);
		
		/*
		shapeList.sort(shapeCmp);
		lineList.sort(lineCmp);
		
		for(int i=0; i<shapeList.size(); i++) 
			shapeList.get(i).paintOnCanvas((Graphics2D)g);
		
		for(int i=0; i<lineList.size(); i++)
			lineList.get(i).paintOnCanvas((Graphics2D)g);
		*/
		/*
		for(int i=0; i<depthList.size(); i++) 
			shapeList.get(depthList.get(i)).paintOnCanvas((Graphics2D)g);
		*/	
    }
	
	public int addId()
	{
		idCnt++;
		return idCnt;
	}
	
	public BaseShape findShapeInList(int id)
	{
		for(int i=0; i<shapeList.size(); i++)
		{
			BaseShape shape = shapeList.get(i).findShape(id);
			if(shape != null)
				return shape;
		}
		return null;
	}
	
	
	class BaseShapeComparator implements Comparator<BaseShape> 
	{
		@Override
		public int compare(BaseShape arg0, BaseShape arg1) 
		{
			return -(arg0.getDepth()-arg1.getDepth());
		}
	}
	
	class BaseLineComparator implements Comparator<BaseLine> 
	{
		@Override
		public int compare(BaseLine arg0, BaseLine arg1) 
		{
			return -(arg0.getDepth()-arg1.getDepth());
		}
	}
	
	class BaseItemComparator implements Comparator<BaseItem> 
	{
		@Override
		public int compare(BaseItem arg0, BaseItem arg1) 
		{
			return -(arg0.getDepth()-arg1.getDepth());
		}
	}
	
	
}
