import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;
public class yi {
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the n:");
        int n=input.nextInt();
        Random rnd=new Random();
        double a[][]=new double[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=rnd.nextInt(9);
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        long startr=System.nanoTime();
        System.out.println("det with recursion:"+det(a));
        long endr=System.nanoTime();
        long startg=System.nanoTime();
        System.out.println("det with guss:"+det2(a));
    long endg=System.nanoTime();
    double time1=(endr-startr)/1e6;
    double time2=(endg-startg)/1e6;
    System.out.println("time with recursion:"+time1);
    System.out.println("time with Gaussian method:"+time2);
    if(time1<time2){
        System.out.println("recursion method is faster than gaussian method!");
    }else if(time2<time1){
        System.out.println("the gaussian method is much faster than Recursion method!");
    }
    write(a,det(a),det2(a),time1,time2);
    }
static double det(double [][]a){
       int n=a.length;
       if(n==1){
           return a[0][0];
       }
        if(n==2){
            return a[1][1]*a[0][0]-a[1][0]*a[0][1];
        }
        int det=0;
        for(int j=0;j<n;j++){
            det+=Math.pow(-1,j)*a[0][j]*det(minor(a,0,j));
        }return det;
}
static double[][] minor(double matrix[][],int row,int col){
     int r=0;
     int n=matrix.length;
     double result[][]=new double[n-1][n-1];
     for(int i=0;i<n;i++){
         if(i==row)continue;
         int c=0;
         for(int j=0;j<n;j++){
             if(j==col)continue;
             result[r][c++]=matrix[i][j];
         }
         r++;
     }
     return result;
}
    static double det2(double a[][]){
        int n = a.length;
        int s = 0;
        double det = 1;
        for(int i = 0; i < n; i++){
            int p = i;
            for(int j = i + 1; j < n; j++){
                if(Math.abs(a[j][i]) > Math.abs(a[p][i])){
                    p = j;
                }
            }

            if(a[p][i] == 0) return 0; // ماتریس منفرد است

            // جابجایی سطرها اگر لازم بود
            if(p != i){
                double[] temp = a[i];
                a[i] = a[p];
                a[p] = temp;
                s++; // شمارش تعداد جابجایی‌ها
            }
            // حذف گاوسی برای صفر کردن زیر قطر
            for(int r = i + 1; r < n; r++){
                double f = a[r][i] / a[i][i];
                for(int c = i; c < n; c++){
                    a[r][c] -= f * a[i][c];
                }
            }

            // فقط یکبار در هر مرحله
            det *= a[i][i];
        }

        // تغییر علامت در پایان
        if(s % 2 != 0){
            det = -det;
        }
        return det;
    }

    static void write(double[][] arr, double detRec, double detGauss, double timeRec, double timeGauss) {
        File file = new File("matrix_output.txt");
        try (FileOutputStream fos = new FileOutputStream(file,true)) { // append = true
            StringBuilder sb = new StringBuilder();
            sb.append("Matrix:\n");
            for (double[] row : arr) {
                for (double val : row) {
                    sb.append(String.format("%.2f ", val));
                }
                sb.append("\n");
            }
            sb.append(String.format("Determinant (Recursion): %.4f\n", detRec));
            sb.append(String.format("Determinant (Gaussian Elimination): %.4f\n", detGauss));
            sb.append(String.format("Time (Recursion): %.4f ms\n", timeRec));
            sb.append(String.format("Time (Gaussian Elimination): %.4f ms\n", timeGauss));
            sb.append("--------------------------------------------------\n");
            
            fos.write(sb.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}