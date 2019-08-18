package imageProcess;

import org.opencv.core.Mat;

import java.util.Date;
import java.util.HashMap;

public class BinocularImageProcess {

    public static Mat binocularImageProcess(Mat mat, HashMap hashMap) throws Exception{
        long start = new Date().getTime();
        //mat = FaceProcess.detectFace(EyeProcess.detectEye(mat, hashMap));

        mat = FaceProcess.detectFace(mat);

        //mat = EyeProcess.detectEye(mat, hashMap);

        long end = new Date().getTime();
        System.out.println(hashMap.getClass().getName() + String.valueOf(end-start));
        return mat;
    }


}
