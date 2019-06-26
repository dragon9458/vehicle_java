package cameraBasic;


import Params.Constants;
import Singleton.SingletonMethodHolder;
import Utils.ApillarVedioUtils;
import org.bytedeco.javacpp.opencv_core.*;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import java.util.Date;

public class CameraAp implements Runnable{

    int cameraNum;
    String cameraName;
    public CameraAp(int cameraNum, String cameraName) {
        this.cameraNum = cameraNum;
        this.cameraName = cameraName;
        System.out.println("loading camera    " + cameraNum + "    named    " + cameraName);
    }

    public  void vedioShow() {
        try{
            //开始获取摄像头数据
            OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(cameraNum);
            /*
            grabber.setImageHeight(480);
            grabber.setImageWidth(640);
            */

            grabber.start();

            CanvasFrame canvas = new CanvasFrame(cameraName);//新建一个窗口
            canvas.setAlwaysOnTop(true);
            //canvas.setBounds(0,0,1920,1080);
            Frame frame;

            CanvasFrame canvasAll = new CanvasFrame(cameraName);//新建一个窗口
            canvasAll.setAlwaysOnTop(true);
            Frame frameAll;

            ApillarVedioUtils apillarVedioUtils = new ApillarVedioUtils();

            while(true) {
                long start = new Date().getTime();

                frameAll = grabber.grab();

                //整图显示
                canvasAll.showImage(frameAll);

                //图像处理过程
                frame = apillarVedioUtils.apillarVedioUtil(SingletonMethodHolder.getOpenCVFrameConverter().convertToMat(frameAll));


                Mat mat = SingletonMethodHolder.getOpenCVFrameConverter().convertToMat(frame);
                canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像

                //Thread.sleep(50);//50毫秒刷新一次图像

                long end = new Date().getTime();
                //System.out.println(end - start);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("loading camera    " + cameraNum + "    named    " + cameraName + "!!is running");
        this.vedioShow();

    }

}
