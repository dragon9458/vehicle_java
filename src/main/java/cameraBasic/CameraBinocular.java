package cameraBasic;

import Constant.Constants;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.swing.*;

public class CameraBinocular implements Runnable{

    private int cameraNum;
    private String cameraName;

    public CameraBinocular(int cameraNum, String cameraName){
        this.cameraNum = cameraNum;
        this.cameraName = cameraName;
        System.out.println("loading camera" + cameraNum + "named" + cameraName);
    }

    public void binocularShow(){
        try {
            OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(cameraNum);
            grabber.start();   //开始获取摄像头数据
            CanvasFrame canvas = new CanvasFrame(cameraName);//新建一个窗口
            canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvas.setAlwaysOnTop(true);
            Frame frameLeft;

            while(true)
            {
                if(!canvas.isDisplayable())
                {//窗口是否关闭
                    grabber.stop();//停止抓取
                    System.exit(2);//退出
                }
                frameLeft = grabber.grab();//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
                canvas.showImage(frameLeft);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loading camera" + cameraNum + "named" + cameraName + "!!is wrong");
        }
    }

    public void run(){
        System.out.println("loading camera" + cameraNum + "named" + cameraName + "!!is running");
        this.binocularShow();
    }

}
