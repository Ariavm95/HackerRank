/**
 * Created by Aria on 2/25/17.
 */
import java.util.Scanner;
public class Pii {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long min = in.nextLong();
        long max = in.nextLong();
        long numerator=0;
        long denominator=0;
        double minThreshold=0;
        // your code goes here
        for(long i=min; i<=max; i++ ){
            int round=0;
            long threshold= (long) (i*Math.PI);
            double threFraction= (double) (i*Math.PI);
            long fraction= (long) ((threFraction-threshold)*100000);
            String fractioninString =Long.toString(fraction);
            long th= (long) Math.pow(10,fractioninString.length());
            if(fraction > th/2){
                round=1;
            }
            long out= threshold+round;
            double b= (double) out/i;
            double distance= Math.abs((b-Math.PI));
            if(i==min){
                minThreshold=distance;
            }
            else {
                if(minThreshold> distance){
                    minThreshold= distance;
                    numerator=out;
                    denominator=i;
                }
            }
        }
        System.out.println(numerator+"/"+ denominator);
    }
}
