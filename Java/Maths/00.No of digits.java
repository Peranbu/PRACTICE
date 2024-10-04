class Main{
    public static int count(int n){
        int cnt=0;
        while(n>0){
            int last=n%10;
            cnt=cnt+1;
            n=n/10;
        }
        return cnt;
    }
    public static void main(String[] args){
        int n=12345;
        int result=count(n);
        System.out.println(result);
    }
}





class Main{
  public static int count(int n){
    int cnt=0;
    while(n>0){
      cnt=cnt+1;
      n=n/10;
    }
    return cnt;
  }
  public static void main(String[] args{
  }
}






import java.util.*;
class Main{
  public static int count(int n){
    int cnt=(int)(Math.log10(n)+1);
    return cnt;
  }
  public static void main(String[] args){
    
  }
}
