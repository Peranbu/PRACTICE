class Main{
  public static void main(String[] args){
    int n=121;
    int rev=0;
    int dup=n;
    while(n>0){
      int temp=n%10;
      rev=(rev*10)+temp;
      n=n/10;
    }
    if(dup==rev){
      System.out.println(true);
    }
    else{
      System.out.println(false);
    }
  }
}



class Main{
  public static boolean isPalindrome(String str){
    StringBuilder sb=new StringBuilder(str);
    StringBuilder reversed=sb.reverse().toString();
    str.isEquals(reversed);
  }
  public static void main(String[] args){
    String input=12345;
    if(isPalindrome(input)){
      System.out.println(true);
    }else{
      System.out.println(false);
    }
  }
}


class Main{
    public static boolean isPalindrome(int num){
        StringBuilder sb=new StringBuilder(String.valueOf(num));
        return sb.toString().equals(sb.reverse().toString());
    }
    public static void main(String[] args){
        for(int i=0;i<100;i++){
            if(isPalindrome(i)){
                System.out.println(i);
            }
        }
    }
}
