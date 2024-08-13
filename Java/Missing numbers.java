public class Main{
  public static void main(String[] args){
    int arr[]={1,2,4,5};
    int xor1=0;
    int xor2=0;
    int n=arr.length+1;
    for(int i=0;i<arr.length;i++){
      xor1=xor1^arr[i];
    } // print all the elements in the given arrayy
    for(int i=1;i<=n;i++){
      xor2=xor2^i;
    } // print all the elements ---> length of the array
    System.out.println(xor1^xor2);
  }
}

/*
1^1=0
2^2=0
3^3=0


  output:1,2,3,4,5

*/
