package imageProcess;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class EyeProcess {

    /**
     * opencv实现人眼识别
     * @param img
     * @throws Exception
     */
    public static  CascadeClassifier eyeDetector = new CascadeClassifier("conf/haarcascade_eye.xml");
    // 在图片中检测人脸
    public static MatOfRect faceDetections = new MatOfRect();

    public static Mat detectEye(Mat img) throws Exception {




        eyeDetector.detectMultiScale(img, faceDetections, 2.0,1,1,new Size(20,20),new Size(20,20));

        System.out.println(String.format("Detected %s eyes", faceDetections.toArray().length));

        Rect[] rects = faceDetections.toArray();
        if(rects != null && rects.length <2){
            //throw new RuntimeException("不是一双眼睛");
            return img;
        }
        Rect eyea = rects[0];
        Rect eyeb = rects[1];
        System.out.println("a-中心坐标 " + eyea.x + " and " + eyea.y);
        System.out.println("b-中心坐标 " + eyeb.x + " and " + eyeb.y);
        //获取两个人眼的角度
        double dy=(eyeb.y-eyea.y);
        double dx=(eyeb.x-eyea.x);
        double len=Math.sqrt(dx*dx+dy*dy);
        System.out.println("dx is "+dx);
        System.out.println("dy is "+dy);
        System.out.println("len is "+len);
        double angle=Math.atan2(Math.abs(dy),Math.abs(dx))*180.0/Math.PI;
        System.out.println("angle is "+angle);
        for(Rect rect:faceDetections.toArray()) {
            Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
        return img;
    }
}
