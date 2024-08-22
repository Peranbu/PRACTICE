//largest number,if,largest number,reverse
import java.util.*;
public class Main{
  public static int[] nextPerm(int[] A){
    int n=A.length;
    int ind=-1;//find largest
    for(int i=n-2;i>=0;i--){
      if(A[i]<A[i+1]){
        ind=i;
        break;
      }
    }
    if(ind==-1){//if no largest reverse the whole array
      reverseArray(A,0,n-1);
      return A;
    }//2nd largest in ind
    for(int i=n-1;i>=0;i--){
      if(A[i]>A[ind]){
        int tmp=A[i];
        A[i]=A[ind];
        A[ind]=tmp;
        break;
      }
    }
    reverseArray(A,ind+1,n-1);
    return A;
  }//reverse function
  private static void reverseArray(int[] a,int start,int end){
    while(start<end){
      int temp=a[start];
      a[start]=a[end];
      a[end]=temp;
      start++;
      end--;
    }
  }//main func
  public static void main(String[] args){
    int[] array={2,1,5,4,3,0,0};
    int[] ans=nextPerm(array);
    for(int i=0;i<ans.length;i++){
      System.out.println(ans[i]+" ");
}
  }
}

output://largest number,if,largest number,reverse
import java.util.*;
public class Main{
  public static int[] nextPerm(int[] A){
    int n=A.length;
    int ind=-1;
    for(int i=n-1;i>=0;i--){
      if(A[i]<A[i+1]){
        ind=i;
        break;
      }
    }
    if(ind==-1){
      reverseArray(A,0,n-1);
      return A;
    }//2nd largest
    for(int i=n-1;i>=0;i--){
      if(A[i]>A[ind]){
        int tmp=A[i];
        A[i]=A[ind];
        A[ind]=tmp;
        break;
      }
    }
    reverseArray(A,ind+1,n-1);
    return A;
  }
  private static void reverseArray(int[] a,int start,int end){
    while(start<end){
      int temp=a[start];
      a[start]=a[end];
      a[end]=temp;
      start++;
      end--;
    }
  }
  public static void main(String[] args){
    int[] array={2,1,5,4,3,0,0};
    int[] ans=nextPerm(array);
    for(int i=0;i<ans.length;i++){
      System.out.println(ans[i]+" ");
}
  }
}


output//largest number,if,largest number,reverse
import java.util.*;
public class Main{
  public static int[] nextPerm(int[] A){
    int n=A.length;
    int ind=-1;
    for(int i=n-1;i>=0;i--){
      if(A[i]<A[i+1]){
        ind=i;
        break;
      }
    }
    if(ind==-1){
      reverseArray(A,0,n-1);
      return A;
    }//2nd largest
    for(int i=n-1;i>=0;i--){
      if(A[i]>A[ind]){
        int tmp=A[i];
        A[i]=A[ind];
        A[ind]=tmp;
        break;
      }
    }
    reverseArray(A,ind+1,n-1);
    return A;
  }
  private static void reverseArray(int[] a,int start,int end){
    while(start<end){
      int temp=a[start];
      a[start]=a[end];
      a[end]=temp;
      start++;
      end--;
    }
  }
  public static void main(String[] args){
    int[] array={2,1,5,4,3,0,0};
    int[] ans=nextPerm(array);
    for(int i=0;i<ans.length;i++){
      System.out.println(ans[i]+" ");
}
  }
}

//output:2300145
