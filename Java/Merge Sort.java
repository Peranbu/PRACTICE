import java.util.*;
public class Main{
    private static void merge(int arr[],int low,int mid,int high) {
        ArrayList<Integer>temp=new ArrayList<>();
        int left=low;
        int right=mid+1;
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for (int i=low;i<=high;i++){
            arr[i]=temp.get(i-low); //accessing elements in the array
        }
    }
    private static void mergeSort(int[] arr,int low,int high){
        if(low>=high) return;
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void main(String[] args){
        int[] arr={12,11,13,5,6,7};
        System.out.println("Original array: "+Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println("Sorted array: "+Arrays.toString(arr));
    }
}




/*
EXPLANATION

Initial Array: [38, 27, 43, 3, 9, 82, 10]
Divide step:
   [38, 27, 43]            [3, 9, 82, 10]
   [38, 27] [43]           [3, 9] [82, 10]
   [38] [27] [43] [3] [9]  [82] [10]

Merge step:
   [27, 38] [43]           [3, 9] [10, 82]
   [27, 38, 43]            [3, 9, 10, 82]
Final merge:
   [3, 9, 10, 27, 38, 43, 82]


*/
