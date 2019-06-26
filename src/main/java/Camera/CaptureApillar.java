package Camera;


import Params.Constants;
import imageProcess.ApillarImageProcess;
import imageProcess.BodyProcess;
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

public class CaptureApillar extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    int cameraNum;
    String cameraName;
    CaptureApillar panel;

    public CaptureApillar(){}

    public CaptureApillar(int cameraNum, String cameraName){
        this.cameraNum = cameraNum;
        this.cameraName = cameraName;
        panel = this;
    }

    public static void main(String[] args) {
        new CaptureApillar(1,Constants.CAMERA_L_A).cameraBasic();

    }

    public void cameraBasic(){

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat frame = new Mat();
        Mat rotFrame = new Mat();
        Mat perspectiveMat = new Mat();
        Mat rotFrameShow = new Mat();

        VideoCapture capture = new VideoCapture(cameraNum);
        MyJframe myJframe = new MyJframe();
        myJframe.setContentPane(panel);


        try{
            while(myJframe.isShowing()) {
                capture.read(frame);

                rotFrameShow = ApillarImageProcess.apillarImageProcess(BodyProcess.detectPeople(frame),rotFrame,perspectiveMat);

                myJframe.setSize(rotFrameShow.width(),rotFrameShow.height());
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
    private BufferedImage mImg;
    public void paintComponent(Graphics g) {
        if (mImg != null) {
            g.drawImage(mImg, 0, 0, mImg.getWidth(), mImg.getHeight(), this);
        }
    }

    public void run() {

    }
}
