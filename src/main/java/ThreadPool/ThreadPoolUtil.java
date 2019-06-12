package ThreadPool;

import Params.Constants;
import Params.ThreadConstants;
import cameraBasic.CameraApillar;
import cameraBasic.CameraBinocular;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolUtil {

    public void ThreadPoolStart(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);


        executorService.execute(new CameraApillar(Constants.ONE, Constants.CAMERA_RIGHT_A));
        executorService.execute(new CameraApillar(Constants.TWO, Constants.CAMERA_LEFT_A));


        executorService.execute(new CameraBinocular(Constants.THREE, Constants.CAMERA_RIGHT_E));
        sleep();
        executorService.execute(new CameraBinocular(Constants.ZERO, Constants.CAMERA_LEFT_E));
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
