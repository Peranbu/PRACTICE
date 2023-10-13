//header file
#include<stdio.h>
//using bubbleosrt
void bubblesort(int arr[],int n)
{
for(int i=0;i<n-1;i++)
{
for(int j=0;j<n-i-1;j++)
{
   //to arrange in order using swapping
if(arr[j]>arr[j+1])//arr[j] is current element and arr[j+1] is next element this needs to be swapped 
  //to get the correct order of numbers
{
int temp=arr[j];
arr[j]=arr[j+1];
arr[j+1]=temp;
}
}
}
}
int main()
{
int n,k;
printf("enter the number of elements");
scanf("%d",&n);
int arr[n];
printf("enter the elements");
for(int i=0;i<n;i++)
{
scanf("%d",&arr[i]);
}
  printf("enter the value of k");
  scanf("%d",&k);
if(k<1 || k>n)
{
printf("invalid input");
}
else
{
  bubblesort(arr,n);
  //for smallest number
printf("the %dth smallest element is:%d\n",k,arr[k-1]);
  // if you want print largest element else ignore
printf("the %dth largest element is:%d\n",k,arr[n-k]);
}
return 0;
}
