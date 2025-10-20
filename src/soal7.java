public class soal7 {
    public static void main(String []args){

System.out.print("result:"+re(16,24));


    }
    static int re(int a,int b){
        if(b==0){
            return a;
        }
return re(b,a%b);

    }


}
