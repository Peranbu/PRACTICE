#include<stdio.h>
void rearrange(int arr[],int n)  //mistake 1 arr = arr[]
{
  // declare variables  
int left=0;
int right=n-1;  
while(left<=right)
{
while(arr[left]<0) //finding the 1st positive number
{
left++;
}
while(arr[right]>=0) //finding the 1st negative number
{
right--;
}
if(left<=right)   // left <= right swap the elements
{
int temp=arr[left];
arr[left]=arr[right];
arr[right]=temp;
left++;
right--;
}
}
}
int main()
{
int n;
printf("enter the no of elements");
scanf("%d",&n);
int arr[n];
printf("enter the numbers in the array");
for(int i=0;i<n;i++)
{
scanf("%d",&arr[i]);
}
rearrange(arr,n);    // forgot semicolon  and do not change the order
printf("the reversed number is:");
for(int i=0;i<n;i++)
{
printf("%d",arr[i]);   //printf ah scan pannanum 
}
return 0;
}

