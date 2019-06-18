package opencv.ThreadPool;

import opencv.Params.Constants;
import opencv.Params.ThreadConstants;
import opencv.cameraBasic.CameraApillar;
import opencv.cameraBasic.CameraBinocular;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolUtil {

    public void ThreadPoolStart(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);


        executorService.execute(new CameraApillar(Constants.ZERO, Constants.CAMERA_RIGHT_A));
        sleep();
        executorService.execute(new CameraApillar(Constants.TWO, Constants.CAMERA_LEFT_A));
        sleep();
        executorService.execute(new CameraBinocular(Constants.ONE, Constants.CAMERA_RIGHT_E));
        sleep();
        executorService.execute(new CameraBinocular(Constants.THREE, Constants.CAMERA_LEFT_E));
        sleep();



    }

    public void sleep(){
        if(ThreadConstants.binocularStatus){
            try {
                System.out.println(Thread.activeCount() + "    succeed");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new ThreadPoolUtil().ThreadPoolStart();

    }
}
