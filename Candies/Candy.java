import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
           Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] array=new int[n];
        int[] out= new int [n];
        int sum=0;
        for(int i=0;i<n;i++){
            array[i]=s.nextInt();
            out[i]=1;
        }
        for( int i=1; i<array.length;i++) {
            if(array[i] > array[i - 1]) {
                out[i]=out[i-1]+1;
            }
        }
        sum=out[n-1];
        for( int i=(n-2); i>=0 ;i--) {
            if(array[i] > array[i+1]) {
                out[i]=Math.max(out[i],out[i+1]+1);
               
            }
            sum+=out[i];
              
        }
        
       System.out.println(sum);
    }
}
