public class ss {
    public static void main(String []args){
        int arr[]={1,54,66554,234,90};
        System.out.println("max:"+max(arr,0));
    }
    static int max(int arr[],int i){
        if(i==arr.length-1){
            return arr[i];
        }
        int m=arr[i];
        int d=max(arr,i+1);
        if(m>d){
            return m;
        }else
        return d;
    }



}