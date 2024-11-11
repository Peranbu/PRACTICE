//rotated sorted array 2
import java.util.*;
class Main{
    public static boolean solve(int[] arr,int k){
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==k) return true;
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                low=low+1;
                high=high-1;
                continue;
            }
            if(arr[low]<=k){
                if(arr[low]<=k && k<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(arr[mid]<=k && k<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] arr={7,8,1,2,3,3,3,4,5};
        int k=3;
        boolean ans=solve(arr,k);
        if(ans==false){
            System.out.println("not founf");
        }else{
            System.out.println("founf");
        }
    }
}

//rotated sorted array 1

import java.util.*;
class Main{
    public static int solve(int[] arr,int k){
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==k){
                return mid;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=k && k<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(arr[mid]<=k && k<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr={7,8,9,1,2,3,4,5,6};
        int k=2;
        int ans=solve(arr,k);
        if(ans==-1){
            System.out.println("not present");
        }else{
            System.out.println("present"+ans);
        }
    }
}
