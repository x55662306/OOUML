package menuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import oo_project.DisplayGraphics;
import shape.BaseShape;

public class UnGroupItem extends JMenuItem
{
	DisplayGraphics canvas;
	
	public UnGroupItem(DisplayGraphics canvas)
	{
		this.canvas = canvas;
		this.setText("UnGroup");
		this.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent actionEvent) 
            {
            	BaseShape node = whichComposite();
            	if(node!=null)
            	{
            		for(int i=0; i<node.getChilds().size(); i++)
            		{
            			node.getChilds().get(i).setRoot(node.getChilds().get(i));
            			canvas.shapeList.add(node.getChilds().get(i));
            		}
            		canvas.shapeList.remove(node);
            	}
            	node = null;
            }
        });
	}
	
	BaseShape whichComposite()
	{
		BaseShape root = null;
		for(int i=0; i<canvas.shapeList.size(); i++)
    	{
    		if(canvas.shapeList.get(i).getSelected())
    		{
    			if(root == null)
    				root = canvas.shapeList.get(i);
    			else if(root != canvas.shapeList.get(i))
    				return null;
    		}
    	}
		return root;
	}
	
	public void setActiveState()
	{
		int compositeCnt = 0, cnt = 0;
		for(BaseShape shape : canvas.shapeList)
		{
			if(shape.getSelected())
			{
				if(shape.getId() == -1)
					compositeCnt++;
				cnt++;
			}
		}
		if(cnt==1 && compositeCnt == 1)
			this.setEnabled(true);
		else
			this.setEnabled(false);
	}
}
