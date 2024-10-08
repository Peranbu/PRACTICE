/*
Gcd of the number

repeatedly minus the smaller number from larger number until 0 - It is the gcd
*/
class Main{
  public static int findGcd(int a,int b){
    while(a>0 &&b>0){
      if(a>b){
        a=a%b;
      }else{
        b=b%a;
      }
    }
    if(a==0){
      return b;
    }
    return a;
  }
  public static int findLcm(int a,int b){
    return a*b/findGcd(a,b)
  }
  public static void main(String[] args){
    int a=20;
    int b=15;
    int result=findGcd(a,b);
    int result1=findLcm(a,b)
    System.out.println(result + " " + result1);
  }
}

/*
Armstrong number
*/
import java.util.*;
class Main{
  public static boolean isArmstrong(int a){
    int k=String.valueOf(a).length();
    int sum=0;
    int num=a;
    while(num>0){
      int id=num%10;
      sum+=Math.pow(id,k);
      num=num/10;
    }
    return sum==a;
  }
  public static void main(String[] args){
    int a=153;
    if(isArmstrong(a)){
      System.out.println("Armstrong");
    }else{
      System.out.println("not Armstrong");
    }
  }
}

/*
find all the divisors
*/
import java.util.*;
class Main{
    public static ArrayList<Integer> find(int n){
        ArrayList<Integer> divisors=new ArrayList<>();
        int sqrtn=(int) Math.sqrt(n);
        for(int i=1;i<=sqrtn;i++){
            if(n%i==0){
                divisors.add(i);
                if(i!=n/i){
                    divisors.add(n/i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
        
    }
    public static void main(String[] args){
        int Number=36;
        ArrayList<Integer> divisor1=find(Number);
        for(int divisor:divisor1){
            System.out.print(divisor+" ");
        }
        System.out.println();
    }
}

//prime number
import java.util.*;
class Main{
    static boolean isPrime(int n){
        int cnt=0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                cnt+=1;
                if(n/i!=i){
                    cnt+=1;
                }
            }
        }
        if(cnt==2){
            return true;
        }else{
            return false;
        }
    }
    public static void  main(String[] args){
        int n=1345;
        boolean is=isPrime(n);
        if(is){
            System.out.println("prime");
        }else{
            System.out.println("not");
        }
    }
}

//prime factors of a given number
import java.util.*;
class Main{
    public static ArrayList<Integer> primeFactors(int n){
        ArrayList<Integer> factors = new ArrayList<>();
        // Factor out the number 2
        while (n % 2 == 0){
            factors.add(2);
            n /= 2;
        }
        // Factor out odd numbers from 3 onwards
        for (int i = 3; i <= Math.sqrt(n); i += 2){
            while (n % i == 0){
                factors.add(i);
                n /= i;
            }
        }
        // This condition is to check if n is a prime number greater than 2
        if (n > 2){
            factors.add(n);
        }
        return factors;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> factors = primeFactors(n);
        for (int factor : factors){
            System.out.print(factor + " ");
        }
        scanner.close();
    }
}


