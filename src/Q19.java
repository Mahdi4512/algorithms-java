public class Q19 {
public static void main(String[]args){
    String s="htmmtmmhtmmtmm";
    System.out.println(d(s,0));
}
static boolean d(String s,int i){
    if(i==s.length())return false;
    if(found(s.charAt(i),s,i+1))return true;
    return d(s,i+1);
}
static boolean found(char c,String s,int i){
    if(i==s.length())return false;
    if(s.charAt(i)==c)return true;
    return found(c,s,i+1);
}
}
