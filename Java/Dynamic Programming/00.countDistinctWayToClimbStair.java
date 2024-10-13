import java.util.*;
import java.io.*;
public class Solution{
    public static long countDistinctWayToClimbStair(int n) {
        if(n<=1) return n;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCases=scanner.nextInt();
        while (testCases-->0) { //post decrement operator untill the number becomes zero
            System.out.print("Enter the number of stairs: ");
            int n=scanner.nextInt();
            System.out.println("Number of distinct ways to climb the stairs: " + countDistinctWayToClimbStair(n));
        }
        scanner.close();
    }
}


//intialize dp
//dp[0] and add 
//for loop upto 1 and 
import java.util.*;
public class Main{
    public static List<List<Integer>> countDistinctWaysToClimbStair(int n) {
        List<List<Integer>>[] dp=new ArrayList[n+1];
        dp[0]=new ArrayList<>();
        dp[0].add(new ArrayList<>());
        for (int i=1;i<=n;i++){
            dp[i]=new ArrayList<>();
            if (i>=1){
                for (List<Integer> way:dp[i-1]){
                    List<Integer> newWay=new ArrayList<>(way);
                    newWay.add(1);
                    dp[i].add(newWay);
                }
            }
            if (i>=2){
                for(List<Integer> way:dp[i-2]) {
                    List<Integer> newWay=new ArrayList<>(way);
                    newWay.add(2);
                    dp[i].add(newWay);
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of stairs: ");
        int n = scanner.nextInt();
        List<List<Integer>> ways = countDistinctWaysToClimbStair(n);
        System.out.println("Number of distinct ways to climb the stairs: " + ways.size());
        for (List<Integer> way : ways) {
            System.out.println(way);
        }
        scanner.close();
    }
}

/*
count the ways only using 1 and 2 
input:5 
output:{1,1,1,1,1} , {1,1,1,2} , {1,1,2,1}, {1,2,1,1}, {1,2,2},{2,1,1,1},{2,1,2} and {2,2,1}.
*/
