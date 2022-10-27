# Python3 program to find second 

# largest element in an array

 

def print2largest(arr, 

                  arr_size):

if (arr_size < 2):   

    print(" Invalid Input ")

    return

arr.sort

for i in range(arr_size-2, 

                 -1, -1):

 if (arr[i] != arr[arr_size - 1]) :

 print("The second largest element is", 

            arr[i])

      return

print("No second largest element")

 

Myarr = [12, 35, 1, 10, 34, 1]

n = len(Myarr)

print2largest(Myarr, n)

 

# This code is contributed by Samagra Agrawal
