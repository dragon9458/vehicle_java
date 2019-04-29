package ThreadPool;

import Params.Constants;
import cameraBasic.CameraApillar;
import cameraBasic.CameraBinocular;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolUtil {

    public void ThreadPoolStart(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new CameraBinocular(Constants.ZERO, Constants.CAMERA_RIGHT_E));
        executorService.execute(new CameraBinocular(Constants.TWO, Constants.CAMERA_LEFT_E));
        executorService.execute(new CameraApillar(Constants.ONE, Constants.CAMERA_RIGHT_A));
        //executorService.execute(new CameraApillar(Constants.ONE, Constants.CAMERA_LEFT_A));

    }

    public static void main(String[] args){
        new ThreadPoolUtil().ThreadPoolStart();

    }
}
