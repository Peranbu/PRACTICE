public class Main{
    public static String count(int number1,int number2){
      //convert to string
        String num1=String.valueOf(number1);
        String num2=String.valueOf(number2);
        if(number1<number2){
            return "Not possible";
        }
        int maxLen=Math.max(num1.length(),num2.length());
      //same format    num1:678 num2:78 -----------------> num1:678 num2:078
        num1=String.format("%d"+maxLen+"d",number1);
        num2=String.format("%d"+maxLen+"d",number2);
        int borrow=0;
        int carry=0;
        for(int i=maxLen-1;i>=0;i--){
          //convert to numeric values
            int digit1=Character.getNumericValue(num1.charAt(i));
            int digit2=Character.getNumericValue(num2.charAt(i))+carry;
            if(digit1<digit2){
                borrow++;
                carry=1;
            }else{
                carry=0;
            }
        }
      //return in string 
        return String.valueOf(borrow);
    }
    public static void main(String[] args){
        int number1=567;
        int number2=478;
        System.out.println(count(number1,number2));
    }
}
