package oo_project;

import java.awt.Color;
import java.awt.Graphics2D;

public class Square extends BaseShape
{
	public Square(DisplayGraphics canvas, int x, int y, int id)
	{
		super(canvas, id);
		this.x = x;
		this.y = y;
	}
	

	@Override
	public void paintOnCanvas()
	{
		Graphics2D g2d = (Graphics2D)canvas.getGraphics();
		g2d.setPaint(new Color(150, 150, 150));
		g2d.fillRect(x, y, width, height);
		if(selected)
		{
			for(int i=0; i<4; i++)
				showPorts(i);
		}
		else
		{
			for(int i=0; i<4; i++)
			{
				if(ports[i])
					showPorts(i);
			}
		}
	}
	
}
