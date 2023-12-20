import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num=input.nextInt();
        int reversedNum=0,originalNum=num,remainder;
        while (num!=0){
            remainder=num % 10;
            reversedNum=reversedNum*10+remainder;
            num/=10;
        }
        if(originalNum==reversedNum){
            System.out.println(originalNum+" is a palindrome");
        }else{
            System.out.println(originalNum+" is not a palindrome");
        }
    }
}
