package button;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import mode.SelectMode;
import oo_project.DisplayGraphics;

public class ButtonSelect extends BaseButton
{
	public ButtonSelect(DisplayGraphics canvas, ArrayList<BaseButton> buttonList)
	{
		super(canvas, buttonList);
		fileLocation = "C:\\Users\\User\\eclipse-workspace\\oo_project\\src\\oo_project\\select.png";
		image = new ImageIcon(new ImageIcon(fileLocation).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        setIcon(image);
        setSize(50, 50);
	}
	
	@Override
	protected void Onclick()
	{
		canvas.mode = new SelectMode(canvas);
		clickEffects();
		for(int i=0; i<buttonList.size(); i++)
		{
			if(buttonList.get(i)!=this)
				buttonList.get(i).unclickEffects();
		}
	}
}