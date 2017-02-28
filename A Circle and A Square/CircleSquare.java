/**
 * Created by Aria on 2/22/17.
 */
import java.util.*;
public class CircleSquare {
    static boolean[][] sboard;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        int circleX = in.nextInt();
        int circleY = in.nextInt();
        int r = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();

        // your code goes here

        boolean [][]board = new boolean [h][w];
        //The square calculation starts below
        double [][] points=  new double [4][2];

        if(Math.abs(x1-x3) == Math.abs(y1-y3)){
            for (int j= Math.min(y1,y3); j< (y1+y3-Math.min(y1,y3));j++){
                for (int i= Math.min(x1,x3); i< (x1+x3-Math.min(x1,x3));i++){
                    board[j][i]=true;
                }
            }
        }
        else {

            double xc = (x1 + x3) / 2;
            double yc = (y1 + y3) / 2;
            double xd = (x1 - x3) / 2;
            double yd = (y1 - y3) / 2;

            double x2 = xc - yd;
            double y2 = yc + xd;
            double x4 = xc + yd;
            double y4 = yc - xd;
            
            points[0][0] = x1;
            points[0][1] = y1;
            points[1][0] = x2;
            points[1][1] = y2;
            points[2][0] = x3;
            points[2][1] = y3;
            points[3][0] = x4;
            points[3][1] = y4;
            double maxX = 0;
            double minX = x1;
            double maxY = 0;
            double minY = y1;
            int imaxX = 0;
            int iminX = 0;
            int imaxY = 0;
            int iminY = 0;
            for (int i = 0; i < 4; i++) {
                if (points[i][0] > maxX) {
                    maxX = points[i][0];
                    imaxX = i;
                }
                if (points[i][0] < minX) {
                    minX = points[i][0];
                    iminX = i;
                }
                if (points[i][1] > maxY) {
                    maxY = points[i][1];
                    imaxY = i;
                }
                if (points[i][1] < minY) {
                    minY = points[i][1];
                    iminY = i;
                }
            }
            for (int i = (int) points[iminX][0]; i<w && i <= points[imaxX][0]; i++) {

                for (int j = (int) points[iminY][1]; j<h && j <= points[imaxY][1]; j++) {
                    board[j][i] = true;

                }
            }
      
            double a1 = (points[iminX][1] - points[iminY][1]) / (points[iminX][0] - points[iminY][0]);
            //f1= a1*(x)-a*(sq[iminX][0]+sq[iminX][1])

            for (int j = (int) points[iminY][1]; j <= (int) points[iminX][1]; j++) {
                if(j<0){
                    continue;
                }
                for (int i = (int) points[iminX][0]; i <= (int) points[iminY][0]; i++) {
                    if(i<0){
                        continue;
                    }
                    double border = (double) ((a1 * i) - (a1 * points[iminX][0]) + points[iminX][1]);
                
                    if (j < (int) border) {
                        board[j][i] = false;
                    }
                }
            }

            for (int j = (int) points[iminY][1]; j<h && j <= (int) points[imaxX][1]; j++) {
                if(j<0){
                    continue;
                }
                for (int i = (int) points[iminY][0]; i<w && i <= (int) points[imaxX][0]; i++) {
                   if(i<0){
                       continue;
                   }
                    double a2 = -(1 / a1);
                    double border = (double) ((a2 * i) - (a2 * points[iminY][0]) + points[iminY][1]);
                    if (j < border) {
                        board[j][i] = false;
                    }
                }
            }

            for (int j = (int) points[iminX][1]; j<h && j <= (int) points[imaxY][1]; j++) {
                for (int i = (int) points[iminX][0]; i<w && i <= (int) points[imaxY][0]; i++) {
                   if(i<0){
                       continue;
                   }
                    double a2 = -(1 / a1);
                    double border = (double) ((a2 * i) - (a2 * points[iminX][0]) + points[iminX][1]);
                    if (j > border) {
                        board[j][i] = false;
                    }

                }
            }

            for (int j = (int) points[imaxX][1]; j<h && j <= (int) points[imaxY][1]; j++) {
                for (int i = (int) points[imaxY][0]; i< w && i <= (int) points[imaxX][0]; i++) {
                    
                    double border = (double) ((a1 * i) - (a1 * points[imaxX][0]) + points[imaxX][1]);
                    if (j > border) {
                        board[j][i] = false;
                    }

                }
            }
            sboard = board;
        }
        //Caculation for the circle
        for (int i=0;i<h;i++){
            for(int j=0; j<w;j++){
                int dx= Math.abs(circleX - j);
                int dy=Math.abs(circleY -i);
                double sqa = Math.pow((double) dx,2)+Math.pow((double) dy,2);
                double d= Math.pow(sqa,0.5);
                if(d<=r){
                    board[i][j]=true;
                }
            }
        }
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(board[i][j]){
                    System.out.print("*");
                }
                else{
                    System.out.print(".");
                }
                if(j == w-1){
                    System.out.println();
                }
            }
        }

    }

}
