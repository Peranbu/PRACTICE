#include<stdio.h>
#include<math.h>
#define N4       //to define no of lines
void rotatematrix(int mat[][100],int n)
{
 //declare temp to reverse the value and also storing
int temp;
//to get the input
for(int i=0;i<n;i++)
{
for(int j=i;j<n;j++)
{
temp=mat[i][j];
mat[i][j]=mat[j][i];
mat[j][i]=temp;
}
}
//reverse the number
for(int i=0;i<n;i++)
{
for(int j=0;j<n/2;j++)
{
temp=mat[i][j];
mat[i][j]=mat[i][n-1-j];
mat[i][n-1-j]=temp;
}
}
}
void printmatrix(int mat[][100],int n)
{
  for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
{
printf("%d\t",mat[i][j]);
}
  printf("\n"); //arrangement
}
}
int main()
{
  int n;
printf("enter the no of elements");
scanf("%d",&n);
int mat[100][100];
printf("enter the elements");
  for(int i=0;i<n;i++)
    {
for(int j=0;j<n;j++)
  {
scanf("%d",&mat[i][j]);
  }
    }
rotatematrix(mat,n);  //same in the 4th line do not change the arrangement
printf("answer \n");
  printmatrix(mat,n);  //same in the 29th line do not change the arrangement
return 0;
}
