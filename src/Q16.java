public class Q16 {
    public static void main(String []args){
int arr[]={1,2,3,4};
sub(arr,0,"");
    }
static void sub(int arr[],int i,String s){
        if(i==arr.length){
            System.out.println("{"+s.trim()+"}");
            return;
        }
        sub(arr,i+1,s+arr[i]+" ");
        sub(arr,i+1,s);
}


}
