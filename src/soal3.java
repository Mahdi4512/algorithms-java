public class soal3 {
    public static void main(String []args){
int arr[]={1,2,3,4};
re(arr,0);

    }
    static void re(int arr[],int i){
        if(i==arr.length){
            return;
        }
        re(arr,i+1);
        System.out.print(arr[i]+" " );
    }


}
