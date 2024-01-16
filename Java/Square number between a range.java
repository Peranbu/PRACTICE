import java.util.scanner;
class 
{
  public static void main(String args[])
  {
    Scanner input=new Scanner(System.in);
    System.out.println("enter the lower range");
    int lower=input.nextInt();
    System.out.println("enter the upper range");
    int upper=input.nextInt();
    for(int i=lower;i<upper;i++)
    {
      int sqrt=(int)Math.sqrt(i);
      if(sqrt*sqrt)==i
      {
      System.out.println(i+" ");
      }
    } 
  }
}
