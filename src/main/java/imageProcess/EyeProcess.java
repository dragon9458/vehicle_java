package imageProcess;

import Params.Constants;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.util.HashMap;

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
        Rect[] rects = faceDetections.toArray();
        if(rects.length == 2){
            Rect eyea = rects[0];
            Rect eyeb = rects[1];
            /*
            System.out.println("右眼-中心坐标 " + eyea.x + " and " + eyea.y);
            System.out.println("左眼-中心坐标 " + eyeb.x + " and " + eyeb.y);
            */
            Constants.paramsHash.put("EYE_X",String.valueOf((eyea.x + eyeb.x)/2));
            Constants.paramsHash.put("EYE_Y",String.valueOf((eyea.y + eyeb.y)/2));
            Constants.paramsHash.put("RIGHT_EYE_X", String.valueOf(eyea.x));
            Constants.paramsHash.put("RIGHT_EYE_Y", String.valueOf(eyea.y));
            Constants.paramsHash.put("LEFT_EYE_X", String.valueOf(eyeb.x));
            Constants.paramsHash.put("LEFT_EYE_Y", String.valueOf(eyeb.y));
        }else if(rects.length == 1){
            Rect eyea = rects[0];
            if((eyea.x > Integer.valueOf(Constants.paramsHash.get("EYE_X")))){
                /*
                System.out.println("单独右眼-中心坐标 " + eyea.x + " and " + eyea.y);
                */
                Constants.paramsHash.put("EYE_X", String.valueOf(Integer.valueOf(Constants.paramsHash.get("EYE_X")) + Integer.valueOf(Constants.paramsHash.get("RIGHT_EYE_X")) - eyea.x));
                Constants.paramsHash.put("EYE_Y", String.valueOf(Integer.valueOf(Constants.paramsHash.get("EYE_Y")) + Integer.valueOf(Constants.paramsHash.get("RIGHT_EYE_Y")) - eyea.y));
            }else if (eyea.x < Integer.valueOf(Constants.paramsHash.get("EYE_X"))){
                /*
                System.out.println("单独左眼-中心坐标 " + eyea.x + " and " + eyea.y);
                */
                int a = Integer.valueOf(Constants.paramsHash.get("EYE_X"));
                int b = Integer.valueOf(Constants.paramsHash.get("RIGHT_EYE_X")) - eyea.x;
                Integer X = a + b;
                Constants.paramsHash.put("EYE_X", String.valueOf(X));
                Integer Y = Integer.valueOf(Constants.paramsHash.get("EYE_Y")) + Integer.valueOf(Constants.paramsHash.get("RIGHT_EYE_Y")) - eyea.y;
                Constants.paramsHash.put("EYE_Y", String.valueOf(Y));
            }
        }
        for(Rect rect:faceDetections.toArray()) {
            Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
        //System.out.println("The center of the eyes is" + Constants.paramsHash.get("EYE_X") + Constants.paramsHash.get("EYE_Y"));
        return img;
    }

    public static Mat detectEye(Mat img, HashMap<String, String> hash) throws Exception {
        eyeDetector.detectMultiScale(img, faceDetections, 2.0,1,1,new Size(20,20),new Size(20,20));
        Rect[] rects = faceDetections.toArray();
        if(rects.length == 2){
            Rect eyea = rects[0];
            Rect eyeb = rects[1];
            /*
            System.out.println("右眼-中心坐标 " + eyea.x + " and " + eyea.y);
            System.out.println("左眼-中心坐标 " + eyeb.x + " and " + eyeb.y);
            */
            hash.put("EYE_X",String.valueOf((eyea.x + eyeb.x)/2));
            hash.put("EYE_Y",String.valueOf((eyea.y + eyeb.y)/2));
            hash.put("RIGHT_EYE_X", String.valueOf(eyea.x));
            hash.put("RIGHT_EYE_Y", String.valueOf(eyea.y));
            hash.put("LEFT_EYE_X", String.valueOf(eyeb.x));
            hash.put("LEFT_EYE_Y", String.valueOf(eyeb.y));

        }else if(rects.length == 1){
            Rect eyea = rects[0];
            if((eyea.x > Integer.valueOf(hash.get("EYE_X")))){
                /*
                System.out.println("单独右眼-中心坐标 " + eyea.x + " and " + eyea.y);
                */
                hash.put("EYE_X", String.valueOf(Integer.valueOf(hash.get("EYE_X")) + Integer.valueOf(hash.get("RIGHT_EYE_X")) - eyea.x));
                hash.put("EYE_Y", String.valueOf(Integer.valueOf(hash.get("EYE_Y")) + Integer.valueOf(hash.get("RIGHT_EYE_Y")) - eyea.y));
            }else if (eyea.x < Integer.valueOf(hash.get("EYE_X"))){
                /*
                System.out.println("单独左眼-中心坐标 " + eyea.x + " and " + eyea.y);
                */
                int a = Integer.valueOf(hash.get("EYE_X"));
                int b = Integer.valueOf(hash.get("RIGHT_EYE_X")) - eyea.x;
                Integer X = a + b;
                hash.put("EYE_X", String.valueOf(X));

                Integer Y = Integer.valueOf(hash.get("EYE_Y")) + Integer.valueOf(hash.get("RIGHT_EYE_Y")) - eyea.y;
                hash.put("EYE_Y", String.valueOf(Y));
            }
        }
        for(Rect rect:faceDetections.toArray()) {
            Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
        //System.out.println("The center of the eyes is" + Constants.paramsHash.get("EYE_X") + Constants.paramsHash.get("EYE_Y"));
        return img;
    }
}
