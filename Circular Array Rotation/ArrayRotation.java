import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        for(int a0 = 0; a0 < q; a0++){
            //m times the array should rotate
            int m = in.nextInt();
            int temp=0;  
            temp=m-k;
            if(temp<0){
                m=n+temp;
            }
            else{
                m=temp;
            }
            
            System.out.println(a[m]);
        }
    }
}
