package oo_project;

public class ButtonAssociation extends BaseButton
{
	ButtonAssociation(DisplayGraphics canvas)
	{
		super(canvas);
	}
	
	@Override
	protected void Onclick()
	{
		canvas.mode = new AssociationMode(canvas);
	}
}
