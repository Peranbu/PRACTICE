import java.util.*;
class Main{
  public static int one(int bits,int num){
    int mask=(1<<bits)-1;
    return ~num&mask;
  }
  public static int two(int bits,int num){
    int one=one(bits,num);
    return (one+1)&((1<<bits)-1);
  }
  public static void main(String[] args){
    int bits=4;
    int num=5;
    int ones=one(bits,num);
    System.out.println(Integer.toBinaryString(ones));
    int twos=two(bits,num);
    System.out.println(Integer.toBinaryString(twos));
  }
}

/*
output:
1010
1011
*/
