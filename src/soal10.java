import java.util.Scanner;

public class soal10 {
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter n:");
        int n=input.nextInt();
        System.out.print(re(n));
    }
    static int fac(int n){
        if(n<=1){
            return 1;
        }
        return n*fac(n-1);
    }
    static double re(int n){
        if(n==1){
            return 1.0;
        }
        return 1.0/fac(n)+re(n-1);
    }
}
