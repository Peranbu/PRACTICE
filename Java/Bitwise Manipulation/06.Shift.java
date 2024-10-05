//clear ith shift

class Main{
  public static void main(String[] args){
    int n=13;
    int i=2;
    int mask= ~(1<<i);
    int result=n&mask;
    System.out.println(result);
  }
}
//input:1101
//output:1001


// toggle ith shift
class Main{
  public static void main(String[] args){
    int n-13;
    int i=2;
    int mask=1<<i;
    int result=n^i;
    System.out.println(result);
  }
}

//input:1101
//output:1001

//Remove the last bit
class Main{
  public static void main(String[] args){
    int n=15;
    int result=n & (n-1);
    System.out.println(result);
  }
}

//check wheather the number is divisible by power of 2
class Main{
  public static void main(String[] args){
    int n=16;
    int result= n&(n-1);
    if(reuslt==0){
      System.out.println("it is divisible")
    }else{
      System.out.println("it is not");
    }
  }
}
//time complexity:


//count the no of set bits -- number of 1's in the number
//Brain Kernighan's Algorithm
class Main{
  public static void main(String[] args){
    int n=13;
    int count=0;
    while(n>0){
      n=n&(n-1);
      count++;
    }
    System.out.println(count);
  }
}
//time complexity:O(logn)
//space complexity:O(K)
