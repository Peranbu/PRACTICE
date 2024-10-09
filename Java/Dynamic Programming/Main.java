import java.util.*;
public class Main{
    public static void main(String[] args){
        int arr[]={10,20,20,10,10,30,50,10,20};
        HashMap<Integer,Integer> m=new HashMap<>();
        int pair=0;
        for(int i=0;i<arr.length;i++){
            if(m.containsKey(arr[i])){
                m.put(arr[i],m.get(arr[i])+1);
                if(m.get(arr[i])>=2){
                    pair++;
                    m.put(arr[i],m.get(arr[i])-2);
                    System.out.println(m);
                }
            }else{
                m.put(arr[i],1);
            }
        }
        System.out.println(m);
    }
}