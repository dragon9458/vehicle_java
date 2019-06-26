package Utils;

import Singleton.SingletonMethodHolder;
import org.bytedeco.javacpp.opencv_core.Size;
import org.bytedeco.javacpp.opencv_core.*;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacv.Frame;

import java.util.List;


/**
 * @author dragon
 * the static method for apillar camera
 */
public class ApillarVedioUtils {

    public Frame apillarVedioUtil (Mat oldMat) {

        //图像裁剪 缩放
        Rect rect = new Rect(220 ,160, 200,320 );
        Mat resultFrom = new Mat(oldMat,rect);
        Mat resultTo = new Mat();
        opencv_imgproc.resize(resultFrom,resultTo,new Size(720,1366));

        //透视仿射变换
        //opencv_imgproc.warpPerspective(resultTo, resultFrom, ApillarVedioUtils.getPerspectiveMatrix(),resultTo.size());

        return SingletonMethodHolder.getOpenCVFrameConverter().convert(resultTo);
    }


    static Mat src;
    static Mat dst;
    static Mat perspectiveMat;
    public static Mat getPerspectiveMatrix(){
        try{
            // get  perspective matrix
            List<Point> listSrcs = java.util.Arrays.asList(new Point(1,1),new Point(959,1),new Point(1,1279),new Point(959,1279));
            //src = Converters.vector_Point_to_Mat(listSrcs, 5);

            List<Point> listDsts = java.util.Arrays.asList(new Point(1,1),new Point(959,1),new Point(1,1279),new Point(959,1279));
            //dst = Converters.vector_Point_to_Mat(listDsts, opencv_core.CvType.CV_32F);

            Point2f srcTri[] = new Point2f[4];
            Point2f dstTri[] = new Point2f[4];

            srcTri[0] = new Point2f( 1,1 );
            srcTri[1] = new Point2f( 959,1 );
            srcTri[2] = new Point2f( 1,1279);
            srcTri[3] = new Point2f(959,1279);

            dstTri[0] = new Point2f( 1,1 );
            dstTri[1] = new Point2f( 959,1 );
            dstTri[2] = new Point2f( 1,1279);
            dstTri[3] = new Point2f(959,1279);

            Mat src = new Mat();

            perspectiveMat = opencv_imgproc.getPerspectiveTransform(src, dst);

        }catch(Exception e){
            System.out.println("异常：" + e);
        }
        return perspectiveMat;
    }

    public static void main(String[] args){
        getPerspectiveMatrix();
    }
}
