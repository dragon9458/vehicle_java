package opencv.Utils;


import java.io.IOException;

public class ParamsInput implements Runnable {
    public void run() {
            try {
                System.out.print("Enter a char :");
                while(true){
                    char val = (char)System.in.read();
                    if(val == 1){
                        //SingletonParamHolder.getVariableParams().

                    } else{
                        System.out.println("Your char is :" + val + "\r");
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }


    }
}
