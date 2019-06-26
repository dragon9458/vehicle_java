package Camera;


import imageProcess.ApillarImageProcess;
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

public class CaptureB extends JPanel {
    private static final long serialVersionUID = 1L;
    /**
     * BufferedImage是Image的一个子类，Image和BufferedImage的主要作用就是将一副图片加载到内存中。
     * BufferedImage生成的图片在内存里有一个图像缓冲区，利用这个缓冲区我们可以很方便的操作这个图片，通常用来做图片修改操作如大小变换、图片变灰、设置图片透明或不透明等。
     * Java将一副图片加载到内存中的方法是：BufferedImage bufferedImage = ImageIO.read(new FileInputStream(filePath));
     */

    public static void main(String[] args) {
        cameraBasic(1);
    }

    public static void cameraBasic(int num){

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat frame = new Mat();
        Mat rotFrame = new Mat();
        Mat perspectiveMat = new Mat();
        Mat rotFrameShow = new Mat();

        VideoCapture capture = new VideoCapture(num);
        MyJframe myJframe = new MyJframe();
        CaptureB panel = new CaptureB();

        myJframe.setContentPane(panel);
        try{
            while(myJframe.isShowing()) {

                capture.read(frame);

                //图像处理
                //rotFrameShow = ApillarImageProcess.imageProcess(frame,rotFrame,perspectiveMat);

                rotFrameShow = frame;
                rotFrameShow = FaceProcess.detectFace(rotFrameShow);
                rotFrameShow = EyeProcess.detectEye(rotFrameShow);

                myJframe.setSize(rotFrameShow.rows(),rotFrameShow.rows());
                //处理摄像头获取mat
                panel.mImg = panel.mat2BI(rotFrameShow);

                panel.repaint();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }



    private BufferedImage mImg;

    public static void cameraBasicOld(){
        try {
            /**
             * 加载由LabNAMEARGUDEN指定的本机库。
             * LabNAMEARGUDEN参数必须不包含任何特定于平台的前缀、文件扩展名或路径。
             * 如果称为libname的本地库与VM静态链接，则调用库导出的JNI_OnLoad_libname函数。
             * 有关详细信息，请参阅JNI规范。依赖依赖的方式。
             */
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            Mat frame = new Mat();
            Mat rotFrame = new Mat();
            Mat perspectiveMat = new Mat();
            Mat rotFrameShow = new Mat();

            //Mat capImg = new Mat();
            //开启第一个摄像头
            VideoCapture capture = new VideoCapture(0);
            //视频比例
            int height = (int) capture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
            int width = (int) capture.get(Videoio.CAP_PROP_FRAME_WIDTH);
            //异常判定
            /*
            if (height == 0 || width == 0) {
                throw new Exception("camera not found!");
            }
*/
            //MyJframe jframe = MyJframe.getInstance();
            MyJframe myJframe = new MyJframe();
			/*
			myJframe.setSize(width + myJframe.getInsets().left + myJframe.getInsets().right,
					height + myJframe.getInsets().top + myJframe.getInsets().bottom);
			*/

            CaptureB panel = new CaptureB();
            /**
             * 设置CurrtPANE属性。此方法由构造函数调用。
             * Swing的绘画体系结构需要一个不透明的JCultEnin包容层次结构。这通常由内容窗格提供。
             * 如果替换内容窗格，建议使用不透明的JCube替换内容窗格。
             */
            myJframe.setContentPane(panel);
            //动态显示设置内容后显示，字面翻译

            while (myJframe.isShowing()) {

                //摄像头读取内容
                capture.read(frame);

                //图像处理
                rotFrameShow= ApillarImageProcess.imageProcess(frame,rotFrame,perspectiveMat);

                myJframe.setSize(rotFrameShow.rows(),rotFrameShow.rows());
                //处理摄像头获取mat
                panel.mImg = panel.mat2BI(rotFrameShow);
                /**
                 * 重新绘制此组件。
                 * 如果此组件是轻量级组件，则该方法将尽快调用该组件的PruttMead方法。
                 * 否则，该方法会导致对该组件的更新方法的调用成为可能。
                 */
                panel.repaint();
            }
            capture.release();
            myJframe.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("--done--");
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
        /**
         * TYPE_3BYTE_BGR：
         * 表示一个具有 8 位 rgb 颜色分量的图像，对应于 windows 风格的 bgr 颜色模型，具有用 3 字节存储的 blue、green 和 red 三种颜色。
         * 不存在 alpha。该图像具有一个 componentcolormodel。
         * 当具有透明 alpha 的数据存储在此类型的图像中时，必须将颜色数据调整为非预乘形式并丢弃 alpha，如 alphacomposite 文档中的描述。
         */
        /**
         * TYPE_BYTE_GRAY：
         * 表示无索引的灰度级图像，无索引。这个图像有一个带有CSHGRY的<代码>组件颜色模型< /代码>{@链接颜色空间}。
         * 当存储有非不透明α的数据时在这种类型的图像中，颜色数据必须调整为非预乘形式。
         * 阿尔法被抛弃，正如在{@链接java. AWT.AlpAccoPosiTe}文档。
         */
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

}
