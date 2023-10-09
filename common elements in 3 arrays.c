#include<stdio.h>
void findcommonelements(int arr1[],int arr2[],int arr3[],int n1,int n2,int n3)
{
int i=0;
int j=0;
int k=0;
  //logic
while(i<n1&&j<n2&&k<n3)
{
if(arr1[i]==arr2[j] && arr2[j]==arr3[k]) 
{
printf("%d\n",arr1[i]);
i++;
j++;
k++;
}
else if(arr1[i]<arr2[j])
{
i++;
}
else if(arr2[j]<arr3[k])
{
j++;
}
else
{
k++;
}
}
}
int main()
{
  int n1,n2,n3;
printf("enter no of elements");
scanf("%d",&n1);
int arr1[n1];
printf("enter the elements");
for(int i=0;i<n1;i++)
{
scanf("%d",&arr1[i]);
}
printf("enter no of elements");
scanf("%d",&n2);
int arr2[n2];
printf("enter the elements");
for(int i=0;i<n2;i++)
{
scanf("%d",&arr2[i]);
}
printf("enter no of elements");
scanf("%d",&n3);
int arr3[n3];
printf("enter the elements");
for(int i=0;i<n3;i++)
{
scanf("%d",&arr3[i]);
}
printf("THE COMMON ELEMENTS ARE = \n");
findcommonelements(arr1,arr2,arr3,n1,n2,n3);
return 0;
}
