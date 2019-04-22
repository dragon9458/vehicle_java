import params.PropertiesLoader;

public class PropertiesLoaderTest {
    public static void main(String[] args){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        System.out.println(propertiesLoader.getString("JFRAME_NAME"));
    }
}
