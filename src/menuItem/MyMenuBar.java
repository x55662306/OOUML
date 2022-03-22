package menuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import oo_project.DisplayGraphics;

public class MyMenuBar extends JMenuBar 
{
	public MyMenuBar(DisplayGraphics canvas)
	{
		JMenu menuEdit = new JMenu("Edit");
		
		RenameItem rename = new RenameItem(canvas);
        GroupItem group = new GroupItem(canvas);
        UnGroupItem unGroup = new UnGroupItem(canvas);
        
        menuEdit.add(rename);
        menuEdit.add(group);
        menuEdit.add(unGroup);
        
		menuEdit.addMenuListener(new MenuListener() 
		{
			@Override
			public void menuSelected(MenuEvent arg0) 
			{
				rename.setActiveState();
				group.setActiveState();
				unGroup.setActiveState();
			}

			@Override
			public void menuCanceled(MenuEvent e) 
			{
			}

			@Override
			public void menuDeselected(MenuEvent e) 
			{
			}
		});  
		
		this.add(menuEdit);
	}
}
