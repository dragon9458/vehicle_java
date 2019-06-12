import Params.Constants;
import Params.ThreadConstants;
import ThreadPool.ThreadPoolUtil;
import cameraBasic.CameraBinocular;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){
        ExecutorService executorSingleton = Executors.newSingleThreadExecutor ();
        executorSingleton.execute(new CameraBinocular(Constants.ZERO, Constants.CAMERA_RIGHT_E));


        ExecutorService executorSingleton1 = Executors.newSingleThreadExecutor ();
        executorSingleton1.execute(new CameraBinocular(Constants.ONE, Constants.CAMERA_LEFT_E));

System.out.println("succeed");
    }

}
