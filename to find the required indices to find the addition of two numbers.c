#include<stdio.h>
#include<stdlib.h>
int* twosum(int* nums,int numsize,int target,int* returnsize)
{
    int* indices=(int*)malloc(2*sizeof(int));
    for(int i=0;i<numsize;i++)
    {
        int complement=target-nums[i];
        for(int j=i+1;j<numsize;j++)
        {
            if(nums[j]==complement)
            {
                indices[0]=i;
                indices[1]=j;
                *returnsize=2;
                return indices;
            }
        }
    }
    *returnsize=0;
    free(indices);
    return NULL;
}
int main()
{
    int numsize;
    int target;
    int returnsize;
    printf("enter the number of elements");
    scanf("%d",&numsize);
    int *nums=(int*)malloc(numsize*sizeof(int));
    printf("enter the elements in the array");
    for(int i=0;i<numsize;i++)
    {
        scanf("%d",&nums[i]);
    }
    printf("enter the target");
    scanf("%d",&target);
    int* result=twosum(nums,numsize,target,&returnsize);
    if(returnsize > 0)
    {
        printf("the required indices is:[%d %d]\n",result[0],result[1]);
        free(result);
    }
    else
    {
        printf("no solution");
    }
    free(nums);
    return 0;
}
