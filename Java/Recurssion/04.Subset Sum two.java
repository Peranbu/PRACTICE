//answer
//adding the numbers and allowing duplicates
//printing the duplicates
//main class
import java.util.*;
public class Main{
  public static void printAnswer(List<List<Integer>> ans){
    System.out.println(ans.toString().replace(","," "));
  }// to remove ,'s
  public static void findSubset(int ind,int[] arr,List<Integer>ds,List<List<Integer>>answer){
    answer.add(new ArrayList<>(ds));
    for(int i=ind;i<arr.length;i++){ 
      if(i!=ind && arr[i]==arr[i-1]) continue;
      ds.add(arr[i]);
      findSubset(i+1,arr,ds,answer);//moving to next element
      ds.remove(ds.size()-1); //removing the element
    }
  }
  public static List<List<Integer>>duplicates(int[] arr){
    Arrays.sort(arr);
    List<List<Integer>>answer=new ArrayList<>();
    findSubset(0,arr,new ArrayList<>(),answer); //getting the answer 
    /*
    starting from 0
    array
    storing in ds
    getting the final answer
    */
    return answer;
  }
  public static void main(String[] args){
    int[] arr={1,2,2};
    List<List<Integer>>result=duplicates(arr);
    printAnswer(result);
}
}

/*
output
[[]  [1]  [1  2]  [1  2  2]  [2]  [2  2]]
*/
