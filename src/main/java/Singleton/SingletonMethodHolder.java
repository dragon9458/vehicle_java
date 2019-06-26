package Singleton;


import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter;

public class SingletonMethodHolder {

    public static OpenCVFrameConverter openCVFrameConverter = new OpenCVFrameConverter() {
        public Frame convert(Object o) {
            return null;
        }

        public Object convert(Frame frame) {
            return null;
        }
    };

    private SingletonMethodHolder(){};

    public static OpenCVFrameConverter getOpenCVFrameConverter(){
        return openCVFrameConverter;
    }


}
