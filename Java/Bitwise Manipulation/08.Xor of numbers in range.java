class Main{
  static int xor(int n){
    if(n%4==0){
      return n;
    }else if(n%4==1){
      return 1;
    }else if(n%4==2){
      return n+1;
    }else{
      return 0;
    }
  }
  static int print(int l,int r){
    return xor(r)-xor(l-1);
  }
  public static void main(String[] args){
    int l=1;
    int r=9;
    int result=print(l,r);
    System.out.println(result);
  }
}

//output : 1



//Divide without multiplication and divison symbol
/*
negative 
abs
temp for divisor
temp*2 == temp<<1 store result
find multiple and remaining
return multiple

*/
class Main{
    public static int divide(int dividend,int divisor){
        if(divisor==0) throw new ArithmeticException("not possible");
        boolean negative=(dividend<0)^(divisor<0); // for negative value
      //abs value
        long absdivi=Math.abs((long) dividend);
        long absdiv=Math.abs((long) divisor);
        int result=0;
        while(absdivi>=absdiv){
            long temp=absdiv;
            int multiple=1;
          //temp<<1 == temp*2 to find the no of multiples
            while(absdivi>=(temp<<1)){
              // repeat untill the last smallest number
                temp<<=1;
                multiple<<=1;
            }
            absdivi-=temp;
            result+=multiple;
        }
        return negative ? -result:result;
    }
    public static void main(String args[]){
        int dividend=30;
        int divisor=-5;
        int result=divide(dividend,divisor);
        System.out.println(result);
    }
}
/*
First, tempDivisor = 8, multiple = 1.
We left-shift tempDivisor by 1: 
8×2=16 multiple = 2.
We left-shift again: 
16×2=32

start from the 1st step 
43-32=11 
11/8=3

8-3=5
*/
