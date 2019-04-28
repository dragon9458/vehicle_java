package VedioUtils;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.Rect;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacv.Frame;

public class ApillarVedioUtils {

    public static Frame apillarVedioUtil (Frame frame) {

        //获取透视变换矩阵

        //frame 转换为 mat
        //opencv_core.cvarrToMat(frame);


        //透视变换,参数依次为源图像,目标图像,旋转矩阵,目标图像尺寸
        //opencv_imgproc.warpPerspective();

        //缩放图像 依次源图像, 目标图像, 尺寸, CV_INTER_LINE
        //opencv_imgproc.resize();

        //图像裁剪
        Mat result11 = new Mat();
        Rect rect = new Rect(1 ,1, 128, 684 );
        Mat result = new Mat(result11, rect);
        return frame;
    }
}
