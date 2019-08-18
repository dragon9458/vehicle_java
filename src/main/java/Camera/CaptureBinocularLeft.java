package Camera;


import Params.Constants;
import imageProcess.BinocularImageProcess;
import imageProcess.EyeProcess;
import imageProcess.FaceProcess;
import jFrameBeans.MyJframe;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CaptureBinocularLeft extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    int cameraNum;
    String cameraName;

    public CaptureBinocularLeft(){
    }
    public CaptureBinocularLeft(int cameraNum, String cameraName){
        this.cameraNum = cameraNum;
        this.cameraName = cameraName;
    }

    public static void main(String[] args) {
        new CaptureBinocularLeft(1,"localTest").cameraBasic();
    }

    public void cameraBasic(){

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat frame = new Mat();
        Mat rotFrameShow;

        VideoCapture capture = new VideoCapture(cameraNum);
        MyJframe myJframe = new MyJframe(cameraName);
        CaptureBinocularLeft panel = new CaptureBinocularLeft();
        myJframe.setContentPane(panel);
        //视频比例
        int height = (int) capture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
        int width = (int) capture.get(Videoio.CAP_PROP_FRAME_WIDTH);

        try{
            while(myJframe.isShowing()) {
                capture.read(frame);

                rotFrameShow = BinocularImageProcess.binocularImageProcess(frame, Constants.paramsHashLeft);

                myJframe.setSize(rotFrameShow.width(),rotFrameShow.rows());
                //处理摄像头获取mat
                panel.mImg = panel.mat2BI(rotFrameShow);
                panel.repaint();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /**
     *
     * @param mat
     * @return
     */
    private BufferedImage mImg;
    private BufferedImage mat2BI(Mat mat) {
        int dataSize = mat.cols() * mat.rows() * (int) mat.elemSize();
        byte[] data = new byte[dataSize];
        mat.get(0, 0, data);
        int type = mat.channels() == 1 ? BufferedImage.TYPE_BYTE_GRAY : BufferedImage.TYPE_3BYTE_BGR;
        if (type == BufferedImage.TYPE_3BYTE_BGR) {
            for (int i = 0; i < dataSize; i += 3) {
                byte blue = data[i + 0];
                data[i + 0] = data[i + 2];
                data[i + 2] = blue;
            }
        }
        BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
        image.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), data);
        return image;
    }


    /**
     * 真正处理图像显示的地方
     */
    public void paintComponent(Graphics g) {
        if (mImg != null) {
            g.drawImage(mImg, 0, 0, mImg.getWidth(), mImg.getHeight(), this);
        }

    }

    public void run() {
       this.cameraBasic();
    }
}
