public class soal5 {
    public static void main(String []args){
int arr[]={1,2,43,4};
System.out.print(max(arr,0));


    }
    static int max(int arr[],int i){
      if(i==arr.length-1){
          return arr[i];
      }
      int m;
      m=max(arr,i+1);
      if(arr[i]>m){
          return arr[i];
      } else {
          return m;
      }
    }
}
