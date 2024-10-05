class main{
    public static int and(int a,int b){
        return a&b;
    }
     public static int or(int a,int b){
        return a|b;
    }
     public static int not(int a){
        return ~a&1;
    }
     public static int xor(int a,int b){
        return a^b;
    }
     public static int nand(int a,int b){
        return ~(a&b)&1;
    }
     public static int nor(int a,int b){
        return (~a|b)&1;
    }
     public static int xnor(int a,int b){
        return ~(a^b)&1;
    }
    public static void main(String[] args){
        int a=1;
        int b=0;
        System.out.println(and(a,b));
        System.out.println(or(a,b));
        System.out.println(not(a));
        System.out.println(xor(a,b));
        System.out.println(nand(a,b));
        System.out.println(nor(a,b));
        System.out.println(xnor(a,b));
    }
}

/*
and -- 1&1=1 else 0
or -- 0|0=0 else 1
xor -- same number=0 else 1
nand -- 1&1=0 else 1
nor -- 0|0=1 else 0
xnor -- same number=1 else 0 

not -- opposite
*/
