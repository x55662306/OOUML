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
        // 建立一個視窗，並將標題設定為「視窗程式」
        // 標題可用jframe.setTitle("視窗程式");代替
        JFrame jframe = new JFrame("視窗程式");

        // 設定圖示
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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //垂直排
        panel.add(btCreate);
        panel.add(btSelect);
        panel.add(btAssociation);
        jframe.add(panel, BorderLayout.WEST);
        
        
        // 設定視窗大小(長,寬)
        jframe.setSize(1200, 800);

        // 設定視窗開啟時的位置，有以下兩種常用設定方法
        jframe.setLocation(0,0); // --> 設定視窗開啟時左上角的座標，也可帶入Point物件
        jframe.setLocationRelativeTo(null); // --> 設定開啟的位置和某個物件相同，帶入null則會在畫面中間開啟

        // 關閉選項(右上角的叉叉圖示)按下後的動作
        // EXIT_ON_CLOSE：點選關閉時，關閉程式
        // DISPOSE_ON_CLOSE：點選關閉時，關閉顯示的視窗以及使用的資源，程式仍在背景執行
        // HIDE_ON_CLOSE：點選關閉時，僅隱藏顯示的視窗，程式仍在背景執行
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 設定視窗顯示，若未設定視窗只會在背景執行
        jframe.setVisible(true);
    }
}
