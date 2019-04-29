package Utils;

import Singleton.SingletonMethodHolder;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Point;
import org.bytedeco.javacpp.opencv_core.Size;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacv.Frame;

import java.util.List;


/**
 * @author dragon
 * the static method for apillar camera
 */
public class ApillarVedioUtils {

    public static Frame apillarVedioUtil (Mat oldMat) {



        //获取透视变换矩阵




        //透视变换,参数依次为源图像,目标图像,旋转矩阵,目标图像尺寸
        //opencv_imgproc.warpPerspective();

        //缩放图像 依次源图像, 目标图像, 尺寸, CV_INTER_LINE
        //opencv_imgproc.resize();

        //图像裁剪
        Rect rect = new Rect(220 ,160, 200,320 );
        Mat resultFrom = new Mat(oldMat,rect);
        Mat resultTo = new Mat();
        opencv_imgproc.resize(resultFrom,resultTo,new Size(720,1280));

        return SingletonMethodHolder.getOpenCVFrameConverter().convert(resultTo);
    }


    static Mat src;
    static Mat dst;
    static Mat perspectiveMat;
    public static Mat getPerspectiveMatrix(){
        try{
            // get  perspective matrix
            List<Point> listSrcs = java.util.Arrays.asList(new Point(1,1),new Point(959,1),new Point(1,1279),new Point(959,1279));
            //src = Converters.vector_Point_to_Mat(listDsts, opencv_core.CvType.CV_32F);

            List<Point> listDsts = java.util.Arrays.asList(new Point(1,1),new Point(959,1),new Point(1,1279),new Point(959,1279));
            //dst = Converters.vector_Point_to_Mat(listDsts, opencv_core.CvType.CV_32F);

            perspectiveMat = opencv_imgproc.getPerspectiveTransform(src, dst);
//          perspectiveMat = opencv_imgproc.getPerspectiveTransform();

        }catch(Exception e){
            System.out.println("异常：" + e);
        }
        return perspectiveMat;
    }
}
