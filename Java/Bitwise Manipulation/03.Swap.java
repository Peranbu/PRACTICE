import java.util.*;
class Main{
  public static void main(String[] args){
    int a=5;
    int b=7;
    System.out.println(a+"   "+b);
    a=a^b;
    b=a^b;
    a=a^b;
    System.out.println(a+"   "+b);
  }
}

/*
output:
5   7
7   5
*/
