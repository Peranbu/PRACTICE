// Linear Equation    i.e.,) aX+b+c=0
// Find the value of X
// %f=float  using becoz natural number(1,2,3...) or decimal number can be present(0.1,0.2.....)

#include<stdio.h>
#include<string.h>
float solve (float a,float b,float c)
{
    float X;
    if(a==0) //a=0 then X=0
    {
        printf("Cannot be predicted");
    }
    else
    {
        X=-(b+c)/a;
    }
    return X;
}
int main()
{
    float a,b,c,X;
    printf("enter the value of a,b,c");
    scanf("%f %f %f",&a,&b,&c);
    X=solve(a,b,c);
    printf("solution of the given equation is =%f",X);
    return 0;
}
