package cameraBasic;

import java.util.List;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class Camera {


    public static Mat norm_0_255(Mat src) {
        Mat dst = new Mat();
        switch (src.channels()) {
            case 1:
                Core.normalize(src, dst, 0, 255, Core.NORM_MINMAX, CvType.CV_8UC1);
                break;
            case 3:
                Core.normalize(src, dst, 0, 255, Core.NORM_MINMAX, CvType.CV_8UC3);
                break;
            default:
                src.copyTo(dst);
                break;
        }
        return dst;
    }
/*
    public static void read_csv(final String filename, List<Mat> images, List<Integer> labels, char separator) throws Exception {
        if (filename.isEmpty()) {
            throw new Exception("没有提供有效的输入文件, 请检查给定的文件名");
        }
        String line, path, classLabel;
        //while()
    }
*/
    public static void detectHumenFrontFace(Mat rgb, Mat gray) {
        CascadeClassifier cascade = new CascadeClassifier("conf/haarcascade_frontalface_default.xml");
        if (cascade.empty()) {
            System.out.println("文件读取失败");
            return;
        }
        MatOfRect rect = new MatOfRect();
        cascade.detectMultiScale(gray, rect);
        for (Rect re : rect.toArray()) {
            Imgproc.rectangle(rgb, new Point(re.x, re.y), new Point(re.x
                    + re.width, re.y + re.height), new Scalar(0, 255, 0));
        }
        HighGui.imshow("ImageShow", rgb);
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture videoCapture = new VideoCapture();
        if (!videoCapture.open(1)) {
            System.out.println("相机打开失败");
            return;
        }
        while (true) {
            Mat img = new Mat();
            if (!videoCapture.read(img)) {
                return;
            }
            Mat rgb = new Mat();
            Imgproc.cvtColor(img, rgb, Imgproc.COLOR_BGR2RGB);
            Mat gray = new Mat();
            Imgproc.cvtColor(rgb, gray, Imgproc.COLOR_RGB2GRAY);
            detectHumenFrontFace(img, gray);
            HighGui.waitKey(1);
        }
    }
}
