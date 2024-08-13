public class Main{
  public static void main(String[] args){
    int array[]={1,1,1,1,0,0,0,0,1,0};
    int n=array.length;
    int count=0;
    int maxl=0;
    for(int i=0;i<n;i++){
      if(array[i]==1){
        count++;
        maxl=Math.max(maxl,count);
      }
      else{
        count=0;
      }
    }
    System.out.pritln(maxl);
  }
}
