package button;

import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.JFrame;

import oo_project.DisplayGraphics;

public class ButtonRenameCancel extends BaseButton
{
	TextField tf;
	JFrame frame;
	
	public ButtonRenameCancel(DisplayGraphics canvas, ArrayList<BaseButton> buttonList, JFrame frame)
	{
		super(canvas, buttonList);
		this.frame = frame;
	}
	
	@Override
	protected void Onclick()
	{
		frame.dispose();
	}
}
