package menuItem;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import button.ButtonRename;
import button.ButtonRenameCancel;
import oo_project.DisplayGraphics;
import shape.BaseShape;
import shape.ShapeComposite;

public class RenameItem extends JMenuItem
{
	DisplayGraphics canvas;
	
	public RenameItem(DisplayGraphics canvas)
	{
		this.canvas = canvas;
		this.setText("Rename");
		this.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent actionEvent) 
            {
            	System.out.println("123154654645");
            	JFrame frame = new JFrame ("Rename");
                
                TextField tf = new TextField();
                frame.add(tf);
                
                JPanel panel2 = new JPanel();
                panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
                
                ButtonRename btRename = new ButtonRename(canvas, null, tf, frame);
                btRename.setText("Rename");
                btRename.setSize(50, 30);
                panel2.add(btRename);
                
                ButtonRenameCancel btRenameCancel = new ButtonRenameCancel(canvas, null, frame);
                btRenameCancel.setText("Cancel");
                btRenameCancel.setSize(50, 30);
                panel2.add(btRenameCancel);
                
                frame.add(panel2, BorderLayout.SOUTH);
                frame.setSize(500, 300);
                frame.setLocation(0,0);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible (true);
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
		if(cnt>0)
			this.setEnabled(true);
		else
			this.setEnabled(false);
	}
}
