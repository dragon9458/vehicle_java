package test;

import javax.swing.JFrame;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameGrabber;

/**
 * 调用本地摄像头窗口视频
 * @author BrainWang
 * @version 2017年3月6日
 */

public class DivideBinocularTest
{
    public static void main(String[] args) throws Exception, InterruptedException
    {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(1);
        int captureWidth = 390;
        int captureHeight = 1280;
        grabber.setImageWidth(captureWidth);
        grabber.setImageHeight(captureHeight);

        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);

        while(true)
        {
            if(!canvas.isDisplayable())
            {//窗口是否关闭
                grabber.stop();//停止抓取
                System.exit(2);//退出
            }


            canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
            System.out.println(grabber.grab().imageHeight + "22" +grabber.grab().imageWidth);
            Thread.sleep(2000);//50毫秒刷新一次图像```````````````
        }
    }
}

