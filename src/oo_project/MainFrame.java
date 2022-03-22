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
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //垂直排
        panel.add(btSelect);
        panel.add(btAssociation);
        panel.add(btGeneralization);
        panel.add(btComposition);
        panel.add(btClass);
        panel.add(btUseClass);
        this.add(panel, BorderLayout.WEST);
        
        
        // 設定視窗大小(長,寬)
        this.setSize(1200, 800);

        // 設定視窗開啟時的位置，有以下兩種常用設定方法
        this.setLocation(0,0); // --> 設定視窗開啟時左上角的座標，也可帶入Point物件
        this.setLocationRelativeTo(null); // --> 設定開啟的位置和某個物件相同，帶入null則會在畫面中間開啟

        // 關閉選項(右上角的叉叉圖示)按下後的動作
        // EXIT_ON_CLOSE：點選關閉時，關閉程式
        // DISPOSE_ON_CLOSE：點選關閉時，關閉顯示的視窗以及使用的資源，程式仍在背景執行
        // HIDE_ON_CLOSE：點選關閉時，僅隱藏顯示的視窗，程式仍在背景執行
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 設定視窗顯示，若未設定視窗只會在背景執行
        this.setVisible(true);
	}
}
