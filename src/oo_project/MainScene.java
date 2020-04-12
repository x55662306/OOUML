package oo_project;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainScene
{
	
	public static void main(String[] args){
        // �إߤ@�ӵ����A�ñN���D�]�w���u�����{���v
        // ���D�i��jframe.setTitle("�����{��");�N��
        JFrame jframe = new JFrame("�����{��");

        // �]�w�ϥ�
        //jframe.setIconImage(jframe.getToolkit().getImage("\test.png"));
        
        
        DisplayGraphics canvas = new DisplayGraphics();
        canvas.setSize(1000, 700);
        //canvas.setBackground(Color.WHITE);
        canvas.setVisible(true);
        //canvas.setFocusable(false);
        jframe.add(canvas, BorderLayout.CENTER);
        
        //jframe.setLayout(new FlowLayout());
        //BaseButton bt = new BaseButton(canvas);
        ButtonCreate btCreate = new ButtonCreate(canvas);
        btCreate.setSize(50, 30);
        btCreate.setText("Creat");
        //jframe.add(btCreate, BorderLayout.WEST);
		
        //BaseButton bt = new BaseButton(canvas);
        ButtonSelect btSelect = new ButtonSelect(canvas);
        btSelect.setSize(50, 30);
        btSelect.setText("Select");
        //jframe.add(btSelect, BorderLayout.WEST);
        
        //BaseButton bt = new BaseButton(canvas);
        ButtonAssociation btAssociation = new ButtonAssociation(canvas);
        btAssociation.setSize(50, 30);
        btAssociation.setText("Association");
        //jframe.add(btSelect, BorderLayout.WEST);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //������
        panel.add(btCreate);
        panel.add(btSelect);
        panel.add(btAssociation);
        jframe.add(panel, BorderLayout.WEST);
        
        
        // �]�w�����j�p(��,�e)
        jframe.setSize(1200, 800);

        // �]�w�����}�Үɪ���m�A���H�U��ر`�γ]�w��k
        jframe.setLocation(0,0); // --> �]�w�����}�Үɥ��W�����y�СA�]�i�a�JPoint����
        jframe.setLocationRelativeTo(null); // --> �]�w�}�Ҫ���m�M�Y�Ӫ���ۦP�A�a�Jnull�h�|�b�e�������}��

        // �����ﶵ(�k�W�����e�e�ϥ�)���U�᪺�ʧ@
        // EXIT_ON_CLOSE�G�I�������ɡA�����{��
        // DISPOSE_ON_CLOSE�G�I�������ɡA������ܪ������H�ΨϥΪ��귽�A�{�����b�I������
        // HIDE_ON_CLOSE�G�I�������ɡA��������ܪ������A�{�����b�I������
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // �]�w������ܡA�Y���]�w�����u�|�b�I������
        jframe.setVisible(true);
    }
}
