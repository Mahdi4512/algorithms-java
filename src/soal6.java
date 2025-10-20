public class soal6 {
    public static void main(String []args){
System.out.print(re(2,4));


    }
    static int re(int a,int b){
        if(b==0){
            return 0;
        }
        return a+re(a,b-1);

    }


}
