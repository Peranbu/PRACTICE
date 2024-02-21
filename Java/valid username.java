import java.util.Scanner;
public class username{
  public static void main(String args[]){
    Scanner input=new Scanner(System.in);
    String s1=input.nextLine();
    String s2=input.nextLine();
    if (s1.equals(s2))
      System.out.println("valid");
    else
      System.out.println("invalid");
  }
}
