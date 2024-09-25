//declare
//base case
//check palindrome if wanted
//recurssion
//code for palindrome checking
//main class
import java.util.*;
class Main{
  public static List<List<String>>Partition(String s){
    List<List<String>>res=new ArrayList<>();
    List<String>temp=new ArrayList<>();
    PartitionHelper(0,s,temp,res);
    return res;
  }
  public static void PartitionHelper(int ind,String s,List<String>temp,List<List<String>>res){
    if(ind==s.length()){
      res.add(new ArrayList<>(temp));
      return ;
    }
    for(int i=ind;i<s.length();i++){
      if(isPalindrome(s,ind,i)){
        temp.add(s.substring(ind,i+1));
        PartitionHelper(i+1,s,temp,res);
        temp.remove(temp.size()-1);
      }
    }
  }
  public static boolean isPalindrome(String s,int left,int right){
    while(left<right){
      if(s.charAt(left++)!=s.charAt(right--)) return false;
    }
    return true;
  }
  public static void main(String[] args){
    String s="aab";
    List<List<String>>result=Partition(s);
    for(List<String>output:result){
      System.out.println(output);
    }
  }
}
