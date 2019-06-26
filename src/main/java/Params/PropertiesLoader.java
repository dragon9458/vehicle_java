package Params;

import java.io.*;
import java.util.*;

public class PropertiesLoader implements Serializable {

	private static final long serialVersionUID = 1L;

	private Properties props = new Properties();

	public static HashMap<String, String> paramsHash = new HashMap<String, String>();

	public static void main(String args[]) {
		new PropertiesLoader();
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
*/
			InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("conf/vehicle.properties"))); //方法1
			props.load(new InputStreamReader(inputStream, "UTF-8")); //加载格式化后的流

			Iterator<String> it = props.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				String value = props.getProperty(key);
				paramsHash.put(key, value);
				System.out.println(key + ":" + props.getProperty(key));
			}
/*
			///保存属性到b.properties文件
			FileOutputStream oFile = new FileOutputStream("conf/vehicle.properties", true);//true表示追加打开
			props.setProperty("phone", "10086333");
			props.store(oFile, "The New properties file");
			oFile.close();
*/
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取配置文件失败！");
		}
	}
}
