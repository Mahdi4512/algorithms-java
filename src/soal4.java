public class soal4 {
    public static void main(String []args){
d(13);
    }
static void d(int a){
        if(a==1){
            System.out.print("1");
            return;
        }
        d(a/2);
        System.out.print(a%2);
}
}
