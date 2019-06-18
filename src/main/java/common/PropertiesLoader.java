package common;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesLoader implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Properties props = new Properties();

	public static void main(String args[]) {
		String aa = new PropertiesLoader().getString("OP_NAME");
		System.out.println(aa);
	}
	
	public String getLocalPath() {
		String localPath = System.getProperty("user.dir") + "\\";
		return localPath;
	}
	
	public String getString(String str) {
		String string = props.getProperty(str);
		return string;
	}	
	public String getString(String str, String defaultValue) {
		String string = props.getProperty(str);
		if(string == null) {
			return defaultValue;
		}
		return string;
	}
	
	public Integer getInteger(String str) {
		String string = props.getProperty(str);
		return Integer.valueOf(string);
	}	
	public void setString(String key, String value) {
		props.setProperty(key, value);
	}
	
	public Map<String, String> getMapByPrefix(String prefix) {
		Map<String, String> map = new HashMap<String, String>();
		Set<Object> set = props.keySet();
		for (Object object : set) {
			String key = (String) object;
			if(key.startsWith(prefix)) {
				map.put(key, props.getProperty(key));
			}
		}
		return map;
	}
	
	
	// 加载配置的配置文件
	public PropertiesLoader() {
		try {
/*
			InputStream is = PropertiesLoader.class.getClassLoader().getResourceAsStream("/conf/vehicle.properties");
			props.load(is);
/**/
			InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("conf/vehicle.properties"))); //方法1
			//InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"); //方法2

			props.load(new InputStreamReader(inputStream, "UTF-8")); //加载格式化后的流

	} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取配置文件失败！");
		}
	}	
	
		

}
