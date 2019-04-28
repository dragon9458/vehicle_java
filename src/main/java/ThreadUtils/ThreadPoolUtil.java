package ThreadUtils;

import Constant.Constants;
import cameraBasic.CameraBinocular;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolUtil {

    public void ThreadPoolStart(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new CameraBinocular(Constants.TWO, Constants.CAMERA_RIGHT_E));
        executorService.execute(new CameraBinocular(Constants.THREE, Constants.CAMERA_LEFT_E));

    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //executorService.execute(new CameraBinocular(Constants.TWO, Constants.CAMERA_RIGHT_E));
        //executorService.execute(new CameraBinocular(Constants.THREE, Constants.CAMERA_LEFT_E));
        //executorService.execute(new CameraBinocular(0, Constants.CAMERA_RIGHT_A));
        executorService.execute(new CameraBinocular(Constants.ONE, Constants.CAMERA_LEFT_A));

    }
}
