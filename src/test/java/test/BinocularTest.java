package test;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.swing.*;

public class BinocularTest {

    private int cameraNum;
    private String cameraName;

    public BinocularTest(){

    }


    public void binocularShow(){
        try{
            OpenCVFrameGrabber grabberLeft = new OpenCVFrameGrabber(1);
            grabberLeft.start();   //开始获取摄像头数据
            OpenCVFrameGrabber grabberRight = new OpenCVFrameGrabber(0);
            grabberRight.start();


            CanvasFrame canvasLeft = new CanvasFrame("2");//新建一个窗口
            CanvasFrame canvasRight = new CanvasFrame("3");


            canvasLeft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvasLeft.setAlwaysOnTop(true);

            canvasRight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvasRight.setAlwaysOnTop(true);

            Frame frameLeft;
            Frame frameRight;

            while(true)
            {

                frameLeft = grabberLeft.grab();//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
                frameRight = grabberRight.grab();


                canvasLeft.showImage(frameLeft);
                canvasRight.showImage(frameRight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void binocularShowOne(){
        try{
            OpenCVFrameGrabber grabberLeft = new OpenCVFrameGrabber(2);
            grabberLeft.start();   //开始获取摄像头数据

            CanvasFrame canvasLeft = new CanvasFrame("3");


            canvasLeft.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            canvasLeft.setAlwaysOnTop(true);
            Frame frameLeft;

            while(true)
            {
                frameLeft = grabberLeft.grab();//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像

                canvasLeft.showImage(frameLeft);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args){
        new BinocularTest().binocularShow();
    }

}
