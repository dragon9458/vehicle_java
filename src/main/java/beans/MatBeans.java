package beans;


import org.opencv.core.Mat;

public class MatBeans {
	
	public static MatBeans getMatBeans() {
		return matBeans;
	}

	public static void setMatBeans(MatBeans matBeans) {
		MatBeans.matBeans = matBeans;
	}

	public Mat getFrame() {
		return frame; 
	}

	public void setFrame(Mat frame) {
		this.frame = frame;
	}

	public Mat getImageRot() {
		return imageRot;
	}

	public void setImageRot(Mat imageRot) {
		this.imageRot = imageRot;
	}

	public Mat getImageCut() {
		return imageCut;
	}

	public void setImageCut(Mat imageCut) {
		this.imageCut = imageCut;
	}

	public Mat getDstImage() {
		return dstImage;
	}

	public void setDstImage(Mat dstImage) {
		this.dstImage = dstImage;
	}



	public static MatBeans matBeans = null;
	
	public static MatBeans getInstance() {
		if(matBeans == null) {
			matBeans = new MatBeans();			
		}
		return matBeans;
	}
	
	private MatBeans() {
	}
	
	

	public Mat getSrcPoints() {
		return srcPoints;
	}

	public void setSrcPoints(Mat srcPoints) {
		this.srcPoints = srcPoints;
	}



	public Mat getDstPoints() {
		return dstPoints;
	}

	public void setDstPoints(Mat dstPoints) {
		this.dstPoints = dstPoints;
	}



	public Mat getPerspectiveMat() {
		return perspectiveMat;
	}

	public void setPerspectiveMat(Mat perspectiveMat) {
		this.perspectiveMat = perspectiveMat;
	}



	/**
	 * 摄像机读取Mat
	 */
	Mat frame;
	/**
	 * 透视变换处理结果
	 */
	Mat imageRot;
	/**
	 * 裁剪处理结果
	 */
	Mat imageCut;
	/**
	 * 缩放处理结果
	 */
	Mat dstImage;
	/**
	 * 源图像顶点
	 */
	Mat srcPoints;
	/**
	 * 目标图像顶点
	 */
	Mat dstPoints;
	/**
	 * matrix perspective
	 */
	Mat perspectiveMat;
}
