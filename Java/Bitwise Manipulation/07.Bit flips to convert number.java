class Main{
  public static void main(String[] args){
    int start=10;
    int end=7;
    int n=satrt^end;
    int count=0;
    while(n>0){
      n=n&(n-1);
      count++
    }
    System.out.println(count);
  }
}

//power set
import java.util.*;
import java.util.List;
import java.util.ArrayList;
class Main{
  public static List<List<Integer>> Generate(int[] num){
    int n=num.length;
    int pow=(int)Math.pow(2,n);
    List<List<Integer>>power=new ArrayList<>();
    for(int i=0;i<pow;i++){
      List<Integer>sum=new ArrayList<>();
      for(int j=0;j<n;j++){
        if((i&(1<<j))!=0){
          sum.add(num[j]);
        }
      }
      power.add(sum);
    }
    return power;
  }
  public static void main(String[] args){
    int[] num={1,2,3};
    List<List<Integer>>result=Generate(num);
    for(List<Integer>answer:result){
      System.out.println(answer);
    }
  }
}

//Single number
class Main{
  public static void main(String[] args){
    int[] number={5,1,2,1,2,4};
    int n=number.length;
    for(int i=0;i<n-1;i++){
      xor=xor^number[i];
    }
    System.out.println(xor);
  }
}

//single number - 2
class Main{
  public static void main(String[] args){
    int[] num={4,4,4,5,5,5,6,6,7,2};
    int one=0;
    int two=0;
    int n=num.length;
    for(int i=0;i<n-1;i++){
      one=(one^num[i])&~two;
      two=(two^num[i])&~one;
    }
    System.out.println(one);
  }
}
