package imageProcess;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

public class BodyProcess {
    /**
     * opencv实现人型识别，hog默认的分类器。所以效果不好。
     * @param img
     */
    public static HOGDescriptor hog = new HOGDescriptor();
    public static MatOfRect regions = new MatOfRect();
    public static MatOfDouble foundWeights = new MatOfDouble();

    public static Mat detectPeople(Mat img) {
        if (img.empty()) {
            System.out.println("image is exist");
        }

        hog.setSVMDetector(HOGDescriptor.getDefaultPeopleDetector());

        //System.out.println(HOGDescriptor.getDefaultPeopleDetector());
        //hog.setSVMDetector(HOGDescriptor.getDaimlerPeopleDetector());
        //System.out.println(foundWeights.toString());

        hog.detectMultiScale(img, regions, foundWeights);
        for (Rect rect : regions.toArray()) {
            Imgproc.rectangle(img, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),new Scalar(0, 0, 255), 2);
        }
        return img;
    }
}
