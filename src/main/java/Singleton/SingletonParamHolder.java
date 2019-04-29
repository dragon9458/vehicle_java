package Singleton;

import org.bytedeco.javacpp.opencv_core.Rect;

public class SingletonParamHolder {

    private SingletonParamHolder(){};

    public static Rect getRectorInstance(){
        return new Rect();
    }

}
