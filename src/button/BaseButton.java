package button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import oo_project.DisplayGraphics;

public class BaseButton extends  JButton
{
	DisplayGraphics canvas;
	ImageIcon image;
	String fileLocation;
	ArrayList<BaseButton> buttonList;
	
	BaseButton(DisplayGraphics canvas, ArrayList<BaseButton> buttonList)
	{
		this.canvas = canvas;
		this.buttonList = buttonList;
		this.setBackground(Color.white);
		this.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	Onclick();
		    }
		});
	}
	
	protected void Onclick()
	{
		
	}
	
	public void clickEffects()
	{
		this.setBackground(Color.LIGHT_GRAY);
	}
	
	public void unclickEffects()
	{
		this.setBackground(Color.white);
	}
}
