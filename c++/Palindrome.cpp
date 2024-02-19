#include<iostream>
#include<algorithm>
using namespace std;
int main()
{
string n;
cout<<"enter the input";
cin>>n;
string reversed=n;
reverse(reversed.begin(),reversed.end());
if(reversed==n)
{
cout<<"it is a palindrome"
    }
else
{
cout<<"it is not a  palindrome"
    }
return 0;
}
