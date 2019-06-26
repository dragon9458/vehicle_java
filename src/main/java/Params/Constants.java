package Params;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

public class Constants {
	private static PropertiesLoader pl = new PropertiesLoader();

	public static HashMap<String, String> paramsHash = getParamsHash();

	public static HashMap<String, String> getParamsHash(){
		return PropertiesLoader.paramsHash;
	}

	//加载配置文件 为hash注入值
	/*
	public static HashMap<String, String> getParams() {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		Properties props = new Properties();
		try {
			InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("conf/vehicle.properties"))); //方法1
			props.load(new InputStreamReader(inputStream, "UTF-8")); //加载格式化后的流
			Iterator<String> it = props.stringPropertyNames().iterator();
			while(it.hasNext()){
				String key=it.next();
				hashMap.put(key,props.getProperty(key));
				System.out.println(key+":" + props.getProperty(key));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取配置文件失败！");
		}
		return hashMap;
	}
	*/

	public static void setInteger(String key, Integer value){
		String str = String.valueOf(value);
		pl.setString(key,str);
	}

	public static boolean CameraFlag = true;
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

	//图像长宽
	public static int BINOCULAR_H = pl.getInteger("BINOCULAR_H");
	public static int BINOCULAR_W = pl.getInteger("BINOCULAR_W");

	public static int CAMERA_RIGHT_A = pl.getInteger("CAMERA_RIGHT_A");
	public static int CAMERA_LEFT_A = pl.getInteger("CAMERA_LEFT_A");
	public static int CAMERA_RIGHT_E = pl.getInteger("CAMERA_RIGHT_E");
	public static int CAMERA_LEFT_E = pl.getInteger("CAMERA_LEFT_E");

	public static String CAMERA_L_A = "CAMERA_L_A";
	public static String CAMERA_R_A = "CAMERA_R_A";
	public static String CAMERA_L_E = "CAMERA_L_E";
	public static String CAMERA_R_E = "CAMERA_R_E";

	//人眼坐标
	public static int LEFT_EYE_X = pl.getInteger("LEFT_EYE_X");
	public static int LEFT_EYE_Y = pl.getInteger("LEFT_EYE_Y");
	public static int RIGHT_EYE_X = pl.getInteger("RIGHT_EYE_X");
	public static int RIGHT_EYE_Y = pl.getInteger("RIGHT_EYE_Y");

	public static int EYE_X = pl.getInteger("EYE_X");
	public static int EYE_Y = pl.getInteger("EYE_Y");

	int APILLAR_WIDTH = 720;
	int APILLAR_HIGHT = 1280;

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
