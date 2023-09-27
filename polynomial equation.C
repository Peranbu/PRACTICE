//Polynomial Equation
//2X square + 3X + 1
//sub x=2;
// %1f=1.0*float
////%.21f== round off
#include <stdio.h>
int main(){
    double a, b, c, x;

    printf("Enter the coefficient of x^2 (a): ");
    scanf("%lf", &a);
    printf("Enter the coefficient of x (b): ");
    scanf("%lf", &b);

    printf("Enter the constant term (c): ");
    scanf("%lf", &c);

    printf("Enter the value of x: ");
    scanf("%lf", &x);

    double result = a * x * x + b * x + c;

    printf("Result of the polynomial %.2lfx^2 + %.2lfx + %.2lf at x = %.2lf is %.2lf\n", a, b, c, x, result);

    return 0;
}
