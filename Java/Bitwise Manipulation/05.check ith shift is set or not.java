class Main{
  public static boolean leftshift(int n,int i){
    int mask=1<<i;
    return(mask & n)!=0;
  }
  public static boolean rightShift(int n,int i){
    int mask=n>>i;
    return(mask&1)==0;
  }
  public static void main(String[] args){
    int n=13;
    int i=2;
    if(leftshift(n,i)){
      System.out.println("it is set");
    }else{
      System.out.println("not");
    }if(rightShift(n,i)){
      System.out.println("not");
    }else{
      System.out.println("it is set");
    }
  }
}
/*
it is set
it is set
*/
