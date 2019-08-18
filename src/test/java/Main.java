// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] days = new int[n*3];

        for(int i=0;i<n*3;i++) {
            days[i] = in.nextInt();
        }

        String str[] = new String[n];

        int temp = 0 ;

        for(int i = 0; i< n; i++){
            str[i] = days[temp++]+"-"+days[temp++]+ "-" + days[temp++];
        }
        System.out.println(n-1);


        try {
            for(int i = 1; i<n; i++){
                solution(str[0], str[i]);
            }
        }catch (Exception e){

        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public static void solution(String str1, String str2) throws ParseException {

        Date earlydate = new Date();
        Date latedate = new Date();
        DateFormat df = DateFormat.getDateInstance();
        try {
            earlydate = df.parse(str1);
            latedate = df.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int days = daysBetween(earlydate,latedate);
        System.out.println(days);
    }

    public static final int daysBetween(Date early, Date late) {

        java.util.Calendar calst = java.util.Calendar.getInstance();
        java.util.Calendar caled = java.util.Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calst.set(java.util.Calendar.MINUTE, 0);
        calst.set(java.util.Calendar.SECOND, 0);
        caled.set(java.util.Calendar.HOUR_OF_DAY, 0);
        caled.set(java.util.Calendar.MINUTE, 0);
        caled.set(java.util.Calendar.SECOND, 0);
        //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
                .getTime().getTime() / 1000)) / 3600 / 24;

        return days+1;
    }
}
