package oo_project;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import button.ButtonAssociation;
import button.ButtonClass;
import button.ButtonComposition;
import button.ButtonGeneralization;
import button.ButtonSelect;
import button.ButtonUseClass;
import button.BaseButton;
import menuItem.MyMenuBar;

public class MainFrame extends JFrame
{
	ArrayList<BaseButton> buttonList;
	
	public MainFrame()
	{
		buttonList = new ArrayList<BaseButton>();
		DisplayGraphics canvas = new DisplayGraphics();
        canvas.setSize(1000, 700);
        //canvas.setBackground(Color.WHITE);
        canvas.setVisible(true);
        //canvas.setFocusable(false);
        this.add(canvas, BorderLayout.CENTER);
        
        MyMenuBar menuBar = new MyMenuBar(canvas);
        this.setJMenuBar(menuBar);
        
        ButtonClass btClass = new ButtonClass(canvas, buttonList);
        
        ButtonUseClass btUseClass = new ButtonUseClass(canvas, buttonList);
		
        ButtonSelect btSelect = new ButtonSelect(canvas, buttonList);
        
        ButtonAssociation btAssociation = new ButtonAssociation(canvas, buttonList);
        
        ButtonGeneralization btGeneralization = new ButtonGeneralization(canvas, buttonList);
        
        ButtonComposition btComposition = new ButtonComposition(canvas, buttonList);
        
        
        JPanel panel = new JPanel();
        
        buttonList.add(btSelect);
        buttonList.add(btAssociation);
        buttonList.add(btGeneralization);
        buttonList.add(btComposition);
        buttonList.add(btClass);
        buttonList.add(btUseClass);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //������
        panel.add(btSelect);
        panel.add(btAssociation);
        panel.add(btGeneralization);
        panel.add(btComposition);
        panel.add(btClass);
        panel.add(btUseClass);
        this.add(panel, BorderLayout.WEST);
        
        
        // �]�w�����j�p(��,�e)
        this.setSize(1200, 800);

        // �]�w�����}�Үɪ���m�A���H�U��ر`�γ]�w��k
        this.setLocation(0,0); // --> �]�w�����}�Үɥ��W�����y�СA�]�i�a�JPoint����
        this.setLocationRelativeTo(null); // --> �]�w�}�Ҫ���m�M�Y�Ӫ���ۦP�A�a�Jnull�h�|�b�e�������}��

        // �����ﶵ(�k�W�����e�e�ϥ�)���U�᪺�ʧ@
        // EXIT_ON_CLOSE�G�I�������ɡA�����{��
        // DISPOSE_ON_CLOSE�G�I�������ɡA������ܪ������H�ΨϥΪ��귽�A�{�����b�I������
        // HIDE_ON_CLOSE�G�I�������ɡA��������ܪ������A�{�����b�I������
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // �]�w������ܡA�Y���]�w�����u�|�b�I������
        this.setVisible(true);
	}
}
