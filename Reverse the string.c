#include<stdio.h>
#include<string.h>
void reversestring(char str[],int lenght)
{
  //logic
  int start=0;//starting point 0
  int end=lenght-1;//comming in reverse from the ending
  while(start<end){
    char temp=str[start];
    str[start]=str[end];
    str[end]=temp;
    start++;
    end--;//reverse order
    }
  }
int main()
{
  char input[100];
  printf("enter the string");// get the input
  fgets(input,sizeof(input),stdin);// instead of scanf
  input[strcspn(input,"\n")]='0';//strcspn=calculate the lenght and line exp:to remove the newline character
        int lenght=strlen(input);//lenght of the input string 
        reversestring(input,lenght);//function to reverse the string
        printf("the reversedstring:%s\n",input);
return 0;
}
