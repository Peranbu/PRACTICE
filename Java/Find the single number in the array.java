public class Main{
  public static void main(String[] args){
    inr array[]={1,1,2,3,3,4,4,5,5};
    int xor=0;
    for(int i=0;i<array.length();i++){
      xor ^= array[i];
    }
    System.out.println(xor);
  }
}

output:2

  
