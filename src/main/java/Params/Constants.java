package common;

import parameterUtils.PropertiesLoader;

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



	int ZERO = 0;
	int ONE = 1;
	int TWO = 2;
	int THREE = 3;
	int FOUR = 4;
	String CAMERA_LEFT_A = "CAMERA_LEFT_A";
	String CAMERA_RIGHT_A = "CAMERA_RIGHT_A";
	String CAMERA_LEFT_E = "CAMERA_LEFT_E";
	String CAMERA_RIGHT_E = "CAMERA_RIGHT_E";

	int APILLAR_WIDTH = 720;
	int APILLAR_HIGHT = 1280;

	int BINOCULAR_W = 640;
	int BINOCULAR_H = 240;


	long LONG_ONE = 120;
	long LONG_TWO = 160;
	long WIDTH = 70;
	long HEIGHT = 50;
	long TILT = 80;

	int POINT1_X = 1000;
	int POINT1_Y = -280;

	int POINT2_X = 1033;
	int POINT2_Y = 1090;

	int POINT3_X = 280;
	int POINT3_Y = -280;

	int POINT4_X = 202;
	int POINT4_Y = 928;
	
	
	
}
