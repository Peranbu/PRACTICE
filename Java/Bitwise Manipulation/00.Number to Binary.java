import java.util.*;
public class Main{
    public static String convert(int n){
        StringBuilder res=new StringBuilder();
        if(n==0){
            return "0";
        }
        while(n>0){
            if(n%2==1){
                res.append('1');
            }else{
                res.append('0');
            }
            n=n/2;
        }
        return res.reverse().toString();
    }
    public static void main(String[] args){
        int n=13;
        String Binary=convert(n);
        System.out.println(Binary);
    }
}
/*
output:1101
*/
