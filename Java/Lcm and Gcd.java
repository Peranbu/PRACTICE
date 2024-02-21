import java.util.Scanner;
public class LcmGcd{
    stattic int calculateGcd(int a,int b){
      while(b!=0){
        int temp=b;
        b=a%b;
        a=temp;
      }
      return a;
    }
    static int calculateLcm(int a,int b){
      return(a*b)/calculateGcd(a,b);
    }
    public static void main(String args[]){
      Scanner input=new Scanner(System.in);
      int num1=input.nextInt();
      int num2=input.nextInt();
      int gcd=calculateGcd(num1,num2);
      System.out.println("the output"+gcd);
      int lcm=calculateLcm(num1,num2);
      System.out.println("the output"+lcm);
      input.close();
    }
}
