package oo_project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BaseButton extends  JButton
{
	DisplayGraphics canvas;
	
	BaseButton(DisplayGraphics canvas)
	{
		this.canvas = canvas;
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
}
