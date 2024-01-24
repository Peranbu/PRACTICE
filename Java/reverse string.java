import java.util.Scanner;
class 
{
  public static void main(String args[])
  {
    Scanner input=new Scanner(System.in);
    String reversed=" ";
    String name=input.nextLine();
    int len=name.lenght();
    for(int i=len-1;i>=0;i--)
    {
      reversed=reversed+name.charAt(i);
    }
    System.out.println(empty);
  }
}
