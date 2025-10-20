import java.util.Scanner;

public class soal13 {
    public static void main(String []args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        hanoi(n,'S','D','A');

    }
    static void hanoi(int n,char s,char d,char a){
        if(n==1){
            System.out.println("1 from "+s+" to "+d);
        return;
        }
        hanoi(n-1,s,a,d);
        System.out.println("disk "+n+" from "+s+" to "+d);
        hanoi(n-1,a,d,s);
    }
}
