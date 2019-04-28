package cameraBasic;

import Constant.Constants;
import VedioUtils.ApillarVedioUtils;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.swing.*;

public class CameraA implements Runnable{

    int cameraNum;
    String cameraName;
    public CameraA(int cameraNum, String cameraName) {
        this.cameraNum = cameraNum;
        this.cameraName = cameraName;
        System.out.println("loading camera" + cameraNum + "named" + cameraName);
    }

    public  void vedioShow() {
        try{
            OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(cameraNum);
            grabber.start();   //开始获取摄像头数据
            CanvasFrame canvas = new CanvasFrame(cameraName);//新建一个窗口
            canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvas.setAlwaysOnTop(true);

            Frame frame;

            while(true)
            {
                if(!canvas.isDisplayable())
                {//窗口是否关闭
                    grabber.stop();//停止抓取
                    System.exit(2);//退出
                }
                frame = grabber.grab();

                //图像处理过程
                frame = ApillarVedioUtils.apillarVedioUtils(frame);

                canvas.showImage(frame);//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像

                Thread.sleep(50);//50毫秒刷新一次图像
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.vedioShow();
        System.out.println("loading camera" + cameraNum + "named" + cameraName + "!!is running");
    }

}
