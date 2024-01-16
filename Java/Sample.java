import java.util.Scanner;
import java.util.scanner;
class Sample{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("enter the lower limit");
        int lower=input.nextInt();
        System.out.println("enter the upper limit");
        int upper=input.nextInt();
        for(int i=lower;i<upper;i++){
            int sqrt=(int)Math.sqrt(i);
            if(sqrt*sqrt==i){
                System.out.println(i+" ");
            }
        }
    }
}