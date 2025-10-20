public class soal2 {
   public static void main(String []args){
    double arr[]={1,2,3,4};
    System.out.print("result:"+avg(arr,0));
   }
   static double avg(double []arr,int i){
       if(i==arr.length-1)return arr[i];
       double sum=avg(arr,i+1);
       int re=arr.length-i-1;
       return (arr[i]+sum*re)/(re+1);

   }



}
