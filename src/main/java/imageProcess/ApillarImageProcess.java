package imageProcess;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class ApillarImageProcess {
	
	/**
	 * perspective change and image cut
	 */
	public static Mat apillarImageProcess(Mat frame,Mat rotFrame,Mat perspectiveMat) {
		//获取 透视变换矩阵				
		perspectiveMat = MatrixPerspectiveGet.getPerspectiveMatrix(perspectiveMat);
		
		//size 实际对应高*宽
		Imgproc.resize(frame, rotFrame, new Size(1280,960));
		
		//透视仿射变换 定义透视仿射点S
		Imgproc.warpPerspective(rotFrame, frame, perspectiveMat, rotFrame.size(),Imgproc.INTER_LINEAR);
		
		//图片裁剪	宽*高
		/*
		Rect rect = new Rect(1, 1, 128, 684);
		Mat temp = new Mat(frame, rect);
		temp.copyTo(rotFrame);

		//图片缩放
		Imgproc.resize(rotFrame, frame, new Size(256,1366));
		*/
		return frame;
	}
	
}
