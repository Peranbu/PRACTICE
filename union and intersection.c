#include<stdio.h>
void findunion(int arr1[],int arr2[],int m,int n)
{
  int i=0,j=0;
while(i<m && j<n)
{
if(arr1[i]<arr2[j])
{
printf("%d",arr1[i]);
  i++;
}
else if(arr2[j]<arr1[i])
{
printf("%d",arr2[j]);
  j++;
}
else
{
printf("%d",arr1[i]);
i++;
j++;
}
}
//to print other numbers
while(i<m)
{
printf("%d",arr1[i]);
  i++;
}
while(j<n)
{
printf("%d",arr2[j]);
j++;
}
}
//to find intersection
void findintersection(int arr1[],int arr2[],int m,int n)
{
int i=0,j=0;
while(i<m && j<n)
{
if(arr1[i]<arr2[j])
{
printf("%d",arr1[i]);
i++;
}
else if(arr2[j]<arr1[i])
{
printf("%d",arr2[j]);
j++;
}
else
{
printf("%d",arr1[i]);
i++;
j++;
}
}
}
int main()
{
int arr1[100];
int arr2[100];
int m,n;
printf("enter no of elements in 1st array");
scanf("%d",&m);
printf("enter the elements in 1st array");
for(int i=0;i<m;i++)
{
scanf("%d",&arr1[i]);
}
printf("enter the number of elements in 2nd array");
scanf("%d",&n);
printf("enter the elements int the 2nd array");
for(int i=0;i<n;i++)
{
scanf("%d",&arr2[i]);
}
printf("union\n");
findunion(arr1, arr2, m, n);
printf("\nintersection\n");
findintersection(arr1, arr2, m, n);
return 0;
}
