package common;

import java.awt.geom.Point2D;

import javax.swing.text.PlainDocument;

import org.opencv.core.Mat;

public class Constants {
	private static PropertiesLoader pl = new PropertiesLoader();
	//目标顶点 x坐标
	public static int p1x = pl.getInteger("p1x");
	public static int p2x = pl.getInteger("p2x");
	public static int p3x = pl.getInteger("p3x");
	public static int p4x = pl.getInteger("p4x");
	
	//目标顶点 y坐标
	public static int p1y = pl.getInteger("p1y");
	public static int p2y = pl.getInteger("p2y");
	public static int p3y = pl.getInteger("p3y");
	public static int p4y = pl.getInteger("p4y");
	
	//
	public static int base = pl.getInteger("base");
	public static int flag = pl.getInteger("flag");
	public static int release = pl.getInteger("release");	
	
	
	//窗口名称
	public static String JFRAME_NAME = pl.getString("JFRAME_NAME");
	


	
	
	
}
