//formula
//i=0 , minheigh=arr[0],maxheight=arr[n-1],ans=max-min
//i=1,(minheight=arr[0]+k,arr[i]-k),maxheight=arr[i-1]+k,arr[n-1]-k),ans=min(ans,min,max)
//i=2 continue upto n
#include<stdio.h>
#include<math.h>
#include<stdlib.h>
int compare(const void *a,const void *b)
{
return(*(int *)a-*(int *)b)
}
int minimizethedifference(int arr[],int n,int k)
{
//sort in ascending order
qsort(arr,n,sizeof(int),compare)
int ans=arr[n-1]-arr[0];
for(i=1;i<n;i++)
{
int minheight=fmin(arr[0]+k,arr[i]-k);
int maxheight=fmax(arr[i-1]+k,arr[n-1]-k);
ans=fmin(ans,minheight,maxheight);
}
return ans;
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
    printf("Enter the number of partitions (k): ");
    scanf("%d", &k);
    int result = minimizeMaxDifference(arr, n, k);
    printf("The minimum maximum difference is: %d\n", result);
    return 0;
}
