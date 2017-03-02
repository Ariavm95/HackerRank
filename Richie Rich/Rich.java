/**
 * Created by Aria on 3/1/17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Rich {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        boolean isOdd=false;
        String number = in.next();
        int temp=k;
        boolean pal=true;
        char [] numArray= number.toCharArray();
        int [] numk=new int[n];
        if(n%2 != 0){
            isOdd=true;
        }

        for(int i=0; i< n/2; i++){
            if(numArray[i] != numArray[n-1-i]){
                if(temp>0) {
                    if(numArray[i]<numArray[n - 1 - i]) {
                        numArray[i] = numArray[n - 1 - i];
                    }
                    else{
                        numArray[n - 1 - i]=numArray[i];
                    }
                    numk[i]=1;
                    temp--;
                }
                else {
                    pal=false;
                    break;
                }
            }
            else{
                numk[i]=0;
            }


        }
        if(pal){
            if(n==1 && k>=1){
                numArray[0]='9';
            }
            for(int i=0; i< n/2; i++) {
                if(numk[i] == 1 && temp>0 && numArray[i]!='9'){
                    numArray[i]=numArray[n - 1 - i]='9';
                    temp--;
                }
                else if(numk[i] == 0 && temp>1 && numArray[i]!='9'){
                    numArray[i]=numArray[n - 1 - i]='9';
                    temp=temp-2;
                }
                if(temp>=1 && isOdd && i==Math.floor(number.length()/2)-1){
                    int middle=(int)Math.ceil(n/2);
                    numArray[middle]='9';
                    temp--;
                }

            }
            System.out.print(String.valueOf(numArray));
        }
        else {
            System.out.print(-1);
        }


    }
}
