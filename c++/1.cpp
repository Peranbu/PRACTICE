#include <iostream>
#include <string>
using namespace std;
int main() {
    string input;
    cout << "Enter a string: ";
    cin >> input;
    string reversed = input;
    reverse(reversed.begin(), reversed.end());
    if (input == reversed) {
        cout << "It is a palindrome" << endl;
    } else {
        cout << "It is not a palindrome" << endl;
    }
    return 0;
}
