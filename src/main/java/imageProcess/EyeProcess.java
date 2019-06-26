package imageProcess;

import Params.Constants;
import org.opencv.core.*;
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



        Rect[] rects = faceDetections.toArray();
        /*
        System.out.println(String.format("Detected %s eyes", faceDetections.toArray().length));
        if(rects != null && rects.length <2){
            //throw new RuntimeException("不是一双眼睛");
            return img;
        }
        */
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
            /*
            Constants.setInteger("EYE_X",(eyea.x + eyeb.x)/2);
            Constants.setInteger("EYE_Y",(eyea.y + eyeb.y)/2);
            Constants.setInteger("RIGHT_EYE_X", eyea.x);
            Constants.setInteger("RIGHT_EYE_Y", eyea.y);
            Constants.setInteger("LEFT_EYE_X", eyeb.x);
            Constants.setInteger("LEFT_EYE_Y", eyeb.y);
            */
        }else if(rects.length == 1){
            Rect eyea = rects[0];
            if((eyea.x > Integer.valueOf(Constants.paramsHash.get("EYE_X")))){
                /*
                System.out.println("单独右眼-中心坐标 " + eyea.x + " and " + eyea.y);
                */
                Constants.paramsHash.put("EYE_X", String.valueOf(Integer.valueOf(Constants.paramsHash.get("EYE_X")) + Integer.valueOf(Constants.paramsHash.get("RIGHT_EYE_X")) - eyea.x));
                Constants.paramsHash.put("EYE_Y", String.valueOf(Integer.valueOf(Constants.paramsHash.get("EYE_Y")) + Integer.valueOf(Constants.paramsHash.get("RIGHT_EYE_Y")) - eyea.y));
                /*
                Constants.setInteger("EYE_X", Constants.EYE_X + (Constants.RIGHT_EYE_X - eyea.x));
                Constants.setInteger("EYE_Y", Constants.EYE_Y + (Constants.RIGHT_EYE_Y - eyea.y));
                */
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
                /*
                Constants.setInteger("EYE_X", Constants.EYE_X + (Constants.LEFT_EYE_X - eyea.x));
                Constants.setInteger("EYE_Y", Constants.EYE_Y + (Constants.LEFT_EYE_Y - eyea.y));
                */
            }

        }

        /*
        //获取两个人眼的角度
        double dy=(eyeb.y-eyea.y);
        double dx=(eyeb.x-eyea.x);
        double len=Math.sqrt(dx*dx+dy*dy);
        System.out.println("dx is "+dx);
        System.out.println("dy is "+dy);
        System.out.println("len is "+len);
        double angle=Math.atan2(Math.abs(dy),Math.abs(dx))*180.0/Math.PI;
        System.out.println("angle is "+angle);
        */
        for(Rect rect:faceDetections.toArray()) {
            Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
        System.out.println("The center of the eyes is" + Constants.paramsHash.get("EYE_X") + Constants.paramsHash.get("EYE_Y"));
        return img;
    }
}
