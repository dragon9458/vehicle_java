package cameraBasic;

import Params.Constants;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameGrabber;


public class CameraBin implements Runnable{

    private int cameraNum;
    private String cameraName;

    public CameraBin(int cameraNum, String cameraName){
        this.cameraNum = cameraNum;
        this.cameraName = cameraName;
        System.out.println("loading camera   " + cameraNum + "    named    " + cameraName);
    }

    public void binocularShow(){
        try {
            OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(cameraNum);
            grabber.setImageWidth(Constants.BINOCULAR_W);
            grabber.setImageHeight(Constants.BINOCULAR_H);
            grabber.start();   //开始获取摄像头数据
            CanvasFrame canvas = new CanvasFrame(cameraName);//新建一个窗口
            canvas.setAlwaysOnTop(true);
            Frame frame;

            while(true)
            {
                frame = grabber.grab();//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
                canvas.showImage(frame);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        System.out.println("loading camera    " + cameraNum + "    named    " + cameraName + "!!is running");
        this.binocularShow();

    }

}
