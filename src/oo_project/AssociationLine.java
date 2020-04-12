package oo_project;

import java.awt.Graphics2D;
import java.awt.Point;

public class AssociationLine extends BaseLine
{
	AssociationLine(DisplayGraphics canvas, int startId, int endId, int startPort, int endPort)
	{
		super(canvas, startId, endId, startPort, endPort);
	}
	
	@Override
	void paintOnCanvas()
	{
		Graphics2D g2d = (Graphics2D)canvas.getGraphics();
		BaseShape startShape = canvas.shapeList.get(startId);
		BaseShape endShape = canvas.shapeList.get(endId);
		Point startPoint = startShape.getPortPos(startPort);
		Point endPoint = endShape.getPortPos(endPort);
        drawAL(startPoint.x, startPoint.y, endPoint.x, endPoint.y, g2d);
	}
	
	private static void drawAL(int sx, int sy, int ex, int ey, Graphics2D g2) {
        double H = 10; // 箭头高度
        double L = 5; // 底边的一半
        int x3 = 0;
        int y3 = 0;
        int x4 = 0;
        int y4 = 0;
        double awrad = Math.atan(L / H); // 箭头角度
        double arraow_len = Math.sqrt(L * L + H * H); // 箭头的长度
        double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
        double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
        double x_3 = ex - arrXY_1[0]; // (x3,y3)是第一端点
        double y_3 = ey - arrXY_1[1];
        double x_4 = ex - arrXY_2[0]; // (x4,y4)是第二端点
        double y_4 = ey - arrXY_2[1];

        Double X3 = new Double(x_3);
        x3 = X3.intValue();
        Double Y3 = new Double(y_3);
        y3 = Y3.intValue();
        Double X4 = new Double(x_4);
        x4 = X4.intValue();
        Double Y4 = new Double(y_4);
        y4 = Y4.intValue();
        //起始线
        g2.drawLine(sx, sy, ex, ey);
        //箭头
        g2.drawLine(ex, ey, x3, y3);
        g2.drawLine(ex, ey, x4, y4);
        //三角形箭头
        //GeneralPath triangle = new GeneralPath();
        //triangle.moveTo(ex, ey);
        //triangle.lineTo(x3, y3);
        //triangle.lineTo();
        //triangle.closePath();
        //实心箭头
        //g2.fill(triangle);
        //非实心箭头
        //g2.draw(triangle);

    }
	
	private static double[] rotateVec(int px, int py, double ang, boolean isChLen, double newLen) 
	{
		double mathstr[] = new double[2];
		double vx = px * Math.cos(ang) - py * Math.sin(ang);
		double vy = px * Math.sin(ang) + py * Math.cos(ang);
		if (isChLen) 
		{
		double d = Math.sqrt(vx * vx + vy * vy);
		vx = vx / d * newLen;
		vy = vy / d * newLen;
		mathstr[0] = vx;
		mathstr[1] = vy;
		}
		return mathstr;
	}

}
