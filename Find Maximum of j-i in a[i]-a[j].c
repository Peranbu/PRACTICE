//Condition a[i]<=a[j] and j-i 
//Right element compare with left element
//a[i] and a[j] are index i.e.,)Poaition of the number and i and j are actual numbers
//OUTPUT : Right element smaller than left number = which Index = Output
#include<stdio.h>
#include<limits.h>
#include<malloc.h>
int main()
{
  int start,end,size,input,min,max;
  int *arr=NULL;
  scanf("%d",size);
  max=INT_MIN;
  arr=((int *)calloc(size,sizeof(int)));
  for(input=0;input<=size;input++)
    scanf("%d",arr[input]);
  for(start=0;start<=size;start++){
  for(end=size-1;end>+start;end--){
  if((end-start)>=max && arr[start]<=arr[end])
    max=end-start;
  }
  printf("%d\n",max);
  }
  free(arr);
return 0;
}




//EXPLANATION
#include<stdio.h>
#include<limits.h>  //Minimum and Maximum number
#include<malloc.h>  //malloc and calloc store data
int main()
{
	//declare variable
	int start,end,max,size,input;
	int *arr=NULL; //NULL is for header file
	//size of the array
	scanf("%d",&size);
	max=INT_MIN;//giving value to max and INT_MIN is for header file
	arr=(int *)calloc(size,sizeof(int));
	//for loop to get input
	for(input=0;input<=size;input++)
	scanf("%d",arr[input]);
	//nested loop for comparing
	for(start=0;start<=size;start++){ //starting from the size
		for(end=size-1;end>=start;end--){  //starting from the end and reversing
			//logic
			if((end-start)>=max && arr[start]<=arr[end]) //left num compare to right and position of left number shooould be small
			max=end-start; //Then store in max
		}
		printf("%d\n",max);
	}
	free(arr);// to store the value
}
  
