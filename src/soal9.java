import java.util.Scanner;

public class soal9 {
public static void main(String []args){
    Scanner input=new Scanner(System.in);
    System.out.print("Enter n :");
    int n=input.nextInt();
System.out.print("result:"+sum(n));

}
static int fac(int n){
    if(n<=1){
        return 1;
    }
    return n*fac(n-1);
}
static int sum(int n){
    if(n==1){
        return 1;
    }
return fac(n)+sum(n-1);
}

}
