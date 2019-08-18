package imageProcess;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceProcess {
    /**
     * opencv实现人脸识别
     * @param img
     */
    private static CascadeClassifier faceDetector = new CascadeClassifier("conf/haarcascade_frontalface_default.xml");
    private static MatOfRect faceDetections = new MatOfRect();
    private static Rect[] rects;

    public static Mat detectFace(Mat img) throws Exception {

        faceDetector.detectMultiScale(img, faceDetections);

        rects = faceDetections.toArray();

        if(rects != null && rects.length >= 1){
            for (Rect rect : rects) {
                Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                        new Scalar(0, 0, 255), 2);
            }
        }
        return img;
    }

    public static Mat detectFaceByCID(Mat img) throws Exception {

        faceDetector.detectMultiScale(img, faceDetections);

        rects = faceDetections.toArray();

        if(rects != null && rects.length >= 1){
            for (Rect rect : rects) {
                Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                        new Scalar(0, 0, 255), 2);
            }
        }
        return img;
    }
}
