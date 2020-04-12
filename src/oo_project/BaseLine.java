package oo_project;

public class BaseLine 
{
	int startId, endId, startPort, endPort;
	DisplayGraphics canvas;

	BaseLine(DisplayGraphics canvas, int startId, int endId, int startPort, int endPort)
	{
		this.canvas = canvas;
		this.startId = startId;
		this.endId = endId;
		this.startPort = startPort;
		this.endPort = endPort;
	}
	
	void paintOnCanvas()
	{
		
	}
	
}
