package ThreadPool;

import Camera.CaptureBinocularLeft;
import Camera.CaptureBinocularRight;
import Params.Constants;
import Params.PropertiesLoader;
import cameraBasic.CameraAp;
import cameraBasic.CameraBin;


import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolUtil {

    public void JavaCV_ThreadPoolStart(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new CameraAp(Constants.CAMERA_RIGHT_A, Constants.CAMERA_R_A));
        sleep();
        executorService.execute(new CameraAp(Constants.CAMERA_LEFT_A, Constants.CAMERA_L_A));
        sleep();
        executorService.execute(new CameraBin(Constants.CAMERA_RIGHT_E, Constants.CAMERA_R_E));
        sleep();
        executorService.execute(new CameraBin(Constants.CAMERA_LEFT_E, Constants.CAMERA_L_E));
        sleep();
    }


    public void OpenCV_ThreadPoolStart(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(new CaptureBinocularRight(Constants.CAMERA_RIGHT_E, Constants.CAMERA_R_E));
        sleep();
        executorService.execute(new CaptureBinocularLeft(Constants.CAMERA_LEFT_E, Constants.CAMERA_L_E));
        sleep();
/*
        executorService.execute(new CameraAp(Constants.CAMERA_RIGHT_A, Constants.CAMERA_R_A));
        sleep();
        executorService.execute(new CameraAp(Constants.CAMERA_LEFT_A, Constants.CAMERA_L_A));
        sleep();
*/
    }

    public void sleep(){
        try {
            Thread.sleep(5000);
            System.out.println("Waiting!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        //new ThreadPoolUtil().JavaCV_ThreadPoolStart()
        new PropertiesLoader();
        new ThreadPoolUtil().OpenCV_ThreadPoolStart();

    }
}
