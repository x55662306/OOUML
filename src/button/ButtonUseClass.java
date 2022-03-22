package button;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import mode.UseClassMode;
import oo_project.DisplayGraphics;

public class ButtonUseClass extends BaseButton
{
	public ButtonUseClass(DisplayGraphics canvas, ArrayList<BaseButton> buttonList)
	{
		super(canvas, buttonList);
		fileLocation = "C:\\Users\\User\\eclipse-workspace\\oo_project\\src\\oo_project\\useclass.png";
		image = new ImageIcon(new ImageIcon(fileLocation).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        setIcon(image);
        setSize(50, 50);
	}
	
	@Override
	protected void Onclick()
	{
		canvas.mode = new UseClassMode(canvas);
		clickEffects();
		for(int i=0; i<buttonList.size(); i++)
		{
			if(buttonList.get(i)!=this)
				buttonList.get(i).unclickEffects();
		}
	}
}
