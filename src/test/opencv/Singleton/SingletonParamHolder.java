package opencv.Singleton;

import opencv.Params.VariableParams;
import org.bytedeco.javacpp.opencv_core.Rect;

public class SingletonParamHolder {

    private SingletonParamHolder(){};

    public static Rect getRectorInstance(){
        return new Rect();
    }


    /*
     * resize picture
     */
    public static VariableParams variableParams = new VariableParams();

    public static VariableParams getVariableParams(){
        return  variableParams;
    }

}
