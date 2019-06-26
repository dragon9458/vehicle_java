package Camera;

import org.opencv.core.Mat;
import org.opencv.core.Size;


public class DoubleCameraCalib {
    int imageWidth = 640;                             //摄像头的分辨率
    int imageHeight = 480;
    int boardWidth = 9;                               //横向的角点数目
    int boardHeight = 6;                              //纵向的角点数据
    int boardCorner = boardWidth * boardHeight;       //总的角点数据
    int frameNumber = 28;                             //相机标定时需要采用的图像帧数
    int squareSize = 41;                              //标定板黑白格子的大小 单位mm
    Size boardSize = new Size(boardWidth, boardHeight);
    Size imageSize = new Size(imageWidth, imageHeight);
    Mat R, T, E, F;                                     //R 旋转矢量 T平移矢量 E本征矩阵 F基础矩阵

}


