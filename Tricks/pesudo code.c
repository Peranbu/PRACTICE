#include <stdio.h>
void print(int *arr,int m,int n)
{
    int i,j;
    for (i=0;i<m;i++)
      for (j=0;j<n;j++)
        printf("%d ",*((arr+i*n) + j));
}
int main()
{
    int arr[][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int m = 3, n = 3;
  // We can also use "print(&arr[0][0], m, n);" and "print((int *)arr[0], m, n);"
    print((int *)arr, m, n);
    return 0;
}
/*
With m = 3 and n = 3, the function print((int *)arr, m, n); will proceed as follows:
For i = 0 (first row):
j = 0: *((arr + 0 * 3) + 0) => *((arr + 0) + 0) => *arr which is 1.
j = 1: *((arr + 0 * 3) + 1) => *((arr + 0) + 1) => *(arr + 1) which is 2.
j = 2: *((arr + 0 * 3) + 2) => *((arr + 0) + 2) => *(arr + 2) which is 3.
For i = 1 (second row):
j = 0: *((arr + 1 * 3) + 0) => *((arr + 3) + 0) => *(arr + 3) which is 4.
j = 1: *((arr + 1 * 3) + 1) => *((arr + 3) + 1) => *(arr + 4) which is 5.
j = 2: *((arr + 1 * 3) + 2) => *((arr + 3) + 2) => *(arr + 5) which is 6.
For i = 2 (third row):
j = 0: *((arr + 2 * 3) + 0) => *((arr + 6) + 0) => *(arr + 6) which is 7.
j = 1: *((arr + 2 * 3) + 1) => *((arr + 6) + 1) => *(arr + 7) which is 8.
j = 2: *((arr + 2 * 3) + 2) => *((arr + 6) + 2) => *(arr + 8) which is 9.
*/




#include <stdio.h>
const int M = 3;
void print(int (*arr)[M])
{
    int i, j;
    for (i = 0; i < M; i++)
    for (j = 0; j < M; j++)
        printf("%d ", arr[i][j]);
}
int main()
{
    int arr[][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    print(arr);
    return 0;
}
/*

*/





#include <stdio.h>
#include <stdlib.h>
int main() {
    int rows = 3;
    int* jaggedArray[3];
    // Define the number of columns in each row
    jaggedArray[0] = (int*)malloc(3 * sizeof(int)); // 3 columns
    jaggedArray[1] = (int*)malloc(2 * sizeof(int)); // 2 columns
    jaggedArray[2] = (int*)malloc(4 * sizeof(int)); // 4 columns
    // Initialize the jagged array
    jaggedArray[0][0] = 1; jaggedArray[0][1] = 2; jaggedArray[0][2] = 3;
    jaggedArray[1][0] = 4; jaggedArray[1][1] = 5;
    jaggedArray[2][0] = 6; jaggedArray[2][1] = 7; jaggedArray[2][2] = 8; jaggedArray[2][3] = 9;
    // Print the jagged array
    for (int i = 0; i < rows; i++) {
        int cols = (i == 0) ? 3 : (i == 1) ? 2 : 4;
        for (int j = 0; j < cols; j++) {
            printf("%d ", jaggedArray[i][j]);
        }
        printf("\n");
    }
    // Free allocated memory
    for (int i = 0; i < rows; i++) {
        free(jaggedArray[i]);
    }
    return 0;
}


/*
java
public class JaggedArray {
    public static void main(String[] args) {
        // Create a jagged array
        int[][] jaggedArray = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
        // Print the jagged array
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}


python
def print_jagged_array(jagged_array):
    for row in jagged_array:
        for element in row:
            print(element, end=' ')
        print()
# Create a jagged array
jagged_array = [
    [1, 2, 3],
    [4, 5],
    [6, 7, 8, 9]
]
# Print the jagged array
print_jagged_array(jagged_array)

*/



