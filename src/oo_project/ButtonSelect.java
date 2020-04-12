package oo_project;

public class ButtonSelect extends BaseButton
{
	ButtonSelect(DisplayGraphics canvas)
	{
		super(canvas);
	}
	
	@Override
	protected void Onclick()
	{
		canvas.mode = new SelectMode(canvas);
	}
}
