package imageProcess;

import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;
import org.opencv.utils.Converters;

import beans.Parameters;

/*
 * srcPoint[0] = Point2f( 0,0 );			//左上
	srcPoint[1] = Point2f( 1279, 0 );		//右上
	srcPoint[2] = Point2f( 0, 719);			//左下
	srcPoint[3] = Point2f( 1279, 719);		//右下

	warpPoint[0] = Point2f( p1x, p1y );
	warpPoint[1] = Point2f( p2x, p2y);
	warpPoint[2] = Point2f( p3x, p3y);
	warpPoint[3] = Point2f( p4x, p4y);
 */
public class MatrixPerspectiveGet {
	public static Mat getPerspectiveMatrix(Mat perspectiveMat) {
		Parameters param = Parameters.getInstance();
		Mat src = new Mat();
		Mat dst = new Mat();
		try{
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			
			// get  perspective matrix 
			List<Point> listSrcs=java.util.Arrays.asList(new Point(1,1),new Point(959,1),new Point(1,1279),new Point(959,1279));
			src = Converters.vector_Point_to_Mat(listSrcs,CvType.CV_32F);
			
			List<Point> listDsts=java.util.Arrays.asList(new Point(param.getP1x(),param.getP1y()),new Point(param.getP2x(),param.getP2y()),new Point(param.getP3x(),param.getP3y()),new Point(param.getP4x(),param.getP4y()));
			dst = Converters.vector_Point_to_Mat(listDsts,CvType.CV_32F);
			
			perspectiveMat = Imgproc.getPerspectiveTransform(src, dst);
			
		}catch(Exception e){ 
			System.out.println("异常：" + e);
		}
		
		return perspectiveMat;
		
	}
}
