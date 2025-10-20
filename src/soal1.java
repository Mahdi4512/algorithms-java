public class soal1 {
    public static void main(String []args){
        System.out.print(re(8,4));

    }
    static int re(int a,int b){
        if(a<b){
            return 0;
        }
return 1+re(a-b,b);
    }
    




}
