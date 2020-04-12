package oo_project;

public class ButtonCreate extends BaseButton
{	
	ButtonCreate(DisplayGraphics canvas)
	{
		super(canvas);
	}
	
	@Override
	protected void Onclick()
	{
		canvas.mode = new ClassMode(canvas);
	}
}
