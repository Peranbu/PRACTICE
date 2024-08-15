public class Main{
  public static void main(String[] args){
    int arr[]={0,1,2,0,1,2,0,1,2,0,1,2};
    int low=0;
    int mid=0;
    int high=arr.length-1;
    while(mid<=high){
      if(arr[mid]==0){
        swap(arr,low,mid);
        low++;
        mid++;
      }else if(arr[mid]==1){
        mid++;
      }else{
        swap(arr,mid,high);
        high--;
      }
    }
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
  }
  public static void swap(int arr[],int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }
}

output:0,0,0,1,1,1,2,2,2

  
