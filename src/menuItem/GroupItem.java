package menuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import oo_project.DisplayGraphics;
import shape.BaseShape;
import shape.ShapeComposite;

public class GroupItem extends JMenuItem
{
	DisplayGraphics canvas;
	
	public GroupItem(DisplayGraphics canvas)
	{
		this.canvas = canvas;
		this.setText("Group");
		this.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent actionEvent) 
            {
            	ShapeComposite newRoot = new ShapeComposite(canvas, -1, null);
            	
            	for(int i=0; i<canvas.shapeList.size(); i++)
            	{
            		if(canvas.shapeList.get(i).getSelected())
            		{
            			newRoot.addChild(canvas.shapeList.get(i));
        				canvas.shapeList.get(i).setRoot(newRoot);
            		}
            	}
            	for(int i=0; i<newRoot.getChilds().size(); i++)
            	{
            		canvas.shapeList.remove(newRoot.getChilds().get(i));
            	}
            	newRoot.adjustDepth();
            	canvas.shapeList.add(newRoot);
            }
        });
	}
	
	public void setActiveState()
	{
		int cnt = 0;
		for(BaseShape shape : canvas.shapeList)
		{
			if(shape.getSelected())
				cnt++;
		}
		if(cnt>1)
			this.setEnabled(true);
		else
			this.setEnabled(false);
	}
}
