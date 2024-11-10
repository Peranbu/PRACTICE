public class Main{
    public static int solve(int n,int key,int[] arr){
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==key){
                ans=mid;
                low=mid+1;
            }else if(key<arr[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int n=3;
        int key=7;
        int[] arr={1,3,7};
        System.out.println(solve(n,key,arr));
    }
}

//output:2
//space:O(logN)
//time:O(1)
