class Main{
  public static void main(String[] args){
    int n=13454;
    int reverse=0;
    while(n>0){
      int num=n%10;
      reverse=(reverse*10)+num;
      n=n/10;
    }
    System.out.println(reverse);
  }
}



class Main{
  public static void main(String[] args){
    int n=12345;
    stringBuilder sb=new StringBuilder(String.valueOf(n));
    sb.reverse();
    System.out.println(sb.toString());
  }
}



