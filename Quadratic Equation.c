//b^2 + or - squareroot of b^2-4ac divided by 2a
//%lf not %1f 
// x=no value and find the x value
//dont forgot to write imaginary and real


#include<stdio.h>
#include<math.h>
int main()
{
	double a,b,c,discriminant,realpart1,realpart2,real,imaginarypart;
	printf("enter the coefficients of a b and c");
	scanf("%lf %lf %lf",&a,&b,&c);
	discriminant=b*b-4*a*c;
	if(discriminant>0)
	{
		realpart1=(-b+sqrt(discriminant))/(2*a);
		realpart2=(-b-sqrt(discriminant))/(2*a);
		printf("realpart1= %.2lf and realpart2=%.2lf",realpart1,realpart2);
	}
	else if(discriminant==0)
	{
		realpart1=realpart2=-b/(2*a);
		printf("realpart1==realpart2==%.2lf",realpart1);
	}
	else
	{
		imaginarypart=sqrt(-discriminant)/(2*a);
		real=-b/(2*a);
		printf("realpart1=%.2lf+%.2lfi and realpart2=%.2lf-%.2lfi",real,imaginarypart,real,imaginarypart);
	}
	return 0;
}
