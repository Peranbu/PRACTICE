//it llabs not 1labs l=L
//divide by repeated subtraction
#include <stdio.h>
#include <limits.h>
#include <stdlib.h>
//declare avriables
int divide(int dividend, int divisor) {
  //special case i..e,) divisor=0 and then answer=infinity
    if (divisor == 0 || (dividend == INT_MIN && divisor == -1)) 
    {
        return INT_MAX;
    }
  // find the signs i.e.,)positive or negative using exor gate(^)
    int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
  //change the sign to positive using llabs
    long long ldividend = llabs((long long)dividend);
    long long ldivisor = llabs((long long)divisor);
  //initialize
    long long result = 0;
  //logic = to do repeated subtratcion
    while (ldividend >= ldivisor) 
    {
        long long temp = ldivisor,multiple = 1//store the value in long long temp
        while (ldividend >= (temp << 1)) 
      {
            temp <<= 1;
            multiple <<= 1;
        }
        ldividend -= temp;
        result += multiple;
    }
    result = sign * result;
    if (dividend > INT_MAX) 
    {
        return INT_MAX;
    } else if (dividend < INT_MIN) 
    {
        return INT_MIN;
    }
    return (int)result;
}

int main() 
{
    int n, m;
    printf("Enter the dividend: ");
    scanf("%d", &m);
    printf("Enter the divisor: ");
    scanf("%d", &n);
    int result = divide(m,n);
    printf("Result: %d\n",result);
    return 0;
}
