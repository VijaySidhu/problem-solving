package com.problem.solving.algorithms.arrays;

import java.util.HashSet;

/*
    The main idea is to iterate every number in arr. We use the number as a target to find
    two other numbers which make total zero.For those two other numbers, we move pointers, l and r,
    to try them.l start from left to right and r start from right to left.
 */
public class TripletSum {
    /*
i. First, we sort the array, so we can easily move i around and know how to adjust l and r.
    If the number is the same as the number before, we have used it as a target already, continue.
    We always start the left pointer from i+1 because the combination of 0~i has already been tried.
    Now we calculate the total:
    If the total is less than zero, we need it to be larger, so we move the left pointer.
    If the total is greater than zero, we need it to be smaller, so we move the right pointer.
    If the total is zero, then add it to our result
    We need to move the left and right pointers to the next different numbers, so we do not get repeating result.
    We do not need to consider i after arr[i] > 0, since the sum of 3 positive will be always greater than zero.
    We do not need to try the last two since there are no rooms for l and r pointers.
    You can think of it as the last two have been tried by all others.
*/
/*
    int[][] findTriplets(int arr[], int length) {
        res = []
        arr.sort()
        for(i = 0  to i < length - 2 ){                    // #[8]
            if(arr[i] > 0)
                break                                  // #[7]
            if( i > 0 and arr[i] == arr[i-1])
            continue                               // #[1]
                    l, r = i+1, length-1                       // #[2]
            while( l < r ){
                total = arr[i]+arr[l]+arr[r]
                if(total < 0)                          // #[3]
                    l += 1
                else if (total>0)                      // #[4]
                    r-=1
                else:                                  // #[5]
                res.append([arr[i], arr[l], arr[r]])
                while(l<r and arr[l]==arr[l+1]){   // #[6]
                    l += 1
                }
                while(l<r and arr[r]==arr[r-1]){   // #[6]
                    r -= 1
                }
                l += 1
                r -= 1
            }
        }
        return res
    }*/

    // function to print triplets with 0 sum
    // Complexity Analysis:
    //Time Complexity: O(n2).
    //Since two nested loops is required, so the time complexity is O(n2).
    //Auxiliary Space: O(n).
    //Since a hashmap is required, so the time complexity is linear.
    static void findTriplets(int arr[], int n) {
        boolean found = false;

        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to
            // "-arr[i]"
            HashSet<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x)) {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                } else {
                    s.add(arr[j]);
                }
            }
        }

        if (found == false) {
            System.out.printf(" No Triplet Found\n");
        }
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        int n = arr.length;
        findTriplets(arr, n);
    }
}
