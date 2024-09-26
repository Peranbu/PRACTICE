import java.util.*;
class Main{
  public static int convert(String n){
    int len=n.length();
    int num=0;
    int p2=1;
    for(int i=len-1;i>=0;i--){
      if(n.charAt(i)=='1'){
        num+=p2;
      }
      p2=p2*2;
    }
    return num;
  }
  public static void main(String[] args){
    String n="1101";
    int Binary=convert(n);
    System.out.println(Binary);
  }
}

/*
  output:13
  */
