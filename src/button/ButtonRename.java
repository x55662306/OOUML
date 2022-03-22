package button;

import java.awt.Graphics2D;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.JFrame;

import oo_project.DisplayGraphics;

public class ButtonRename extends BaseButton
{
	TextField tf;
	JFrame frame;
	
	public ButtonRename(DisplayGraphics canvas, ArrayList<BaseButton> buttonList, TextField tf, JFrame frame)
	{
		super(canvas, buttonList);
		this.tf = tf; 
		this.frame = frame;
	}
	
	@Override
	protected void Onclick()
	{
		
		for(int i=0; i<canvas.shapeList.size(); i++)
		{
			if(canvas.shapeList.get(i).getSelected())
				canvas.shapeList.get(i).setName(tf.getText());
		}
		canvas.repaint();
		frame.dispose();
	}
}
