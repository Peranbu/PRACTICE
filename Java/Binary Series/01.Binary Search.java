//lower bound 
import java.util.*;
class Main{
    public static int lower(int[] arr,int n,int x){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr={3,5,8,9,15,19};
        int n=5;int x=9;
        int ind=lower(arr,n,x);
        System.out.println(ind);
        System.out.println(arr[ind]);
    }
}

//output:if x=9 then output should be 9 or greater than 9
//output:index of 9(3)

//upper bound
import java.util.*;
class Main{
    public static int upper(int[] nums,int n,int x){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr={3,5,8,9,15,19};
        int n=5;int x=9;
        int ind=lower(arr,n,x);
        System.out.println(ind);
        System.out.println(arr[ind]);
    }
}

//output: index of 15(4)


//search insert position
import java.util.*;
public class Main {
    public static int insert(int[] arr, int x) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high) {
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={3,5,8,15,19};
        int x=9;
        int ind=insert(arr,x);
        System.out.println(ind);
        // Create a new array to insert the element
        int[] newArr=new int[arr.length+1];
        for(int i=0,j=0;i<arr.length+1;i++){
            if(i==ind){
                newArr[i]=x;
            } else {
                newArr[i]=arr[j++];
            }
        }
        
        // Print the new array
        System.out.println("Array after insertion:");
        for (int num : newArr) {
            System.out.print(num + " ");
        }
    }
}
//time complexity:O(LogN)
//space:O(1)



//floor and ceil
import java.util.*;

public class Main{
  //floor---arr[mid]<=x
    static int findFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = arr[mid];
                //look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }
  //ceil--lower bound
    static int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = arr[mid];
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int f = findFloor(arr, n, x);
        int c = findCeil(arr, n, x);
        return new int[] {f, c};
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = 6, x = 5;
        int[] ans = getFloorAndCeil(arr, n, x);
        System.out.println("The floor and ceil are: " + ans[0]
                           + " " + ans[1]);
    }
} 


//time complexity:O(logN)
//space:O(1)
