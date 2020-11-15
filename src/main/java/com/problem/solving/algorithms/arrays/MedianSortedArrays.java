package com.problem.solving.algorithms.arrays;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively.
Return the median of the two sorted arrays.
Time complexity O(LOGn)
 */
public class MedianSortedArrays {

  /*
     1. Calculate median m1 and m2 of both arrays
     2. if m1 and m2 are equal simply return m1 or m2 and we are done.
     3. if m1 > m2 then median is present in one of below two arrays
          i.  From first element of array1 to m1.
          ii. From m2 to last element of array 2.
     4. If m2>m1 then median is present in one of below subarrays
          i.  From m1 to last element of array1
          ii. From first element of array2 to m2
     5. Repeat the above process until size of both subarrays becomes 2.
     6. If size of array is 2 then use below formula to get the median
               Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
   */

  public static int medianOfSortedArrays(int[] arrOne, int[] arrTwo, int startA, int endA,
      int startB, int endB) {
    //
    if (endA - startA == 1) {
      return (Math.max(arrOne[startA],
          arrTwo[startB])
          + Math.min(arrOne[endA], arrTwo[endB]))
          / 2;
    }
    // Get median of array one
    int medianOfArrayOne = median(arrOne, startA, endA);
    //Get median of array two
    int medianOfArrayTwo = median(arrTwo, 0, arrTwo.length - 1);

    // if both medians are equal we are done here
    if (medianOfArrayOne == medianOfArrayTwo) {
      return medianOfArrayOne;
    } else if (medianOfArrayOne < medianOfArrayTwo) {
      // Take mid of first array
      int midOfFirstArray = (endA + startA + 1) / 2;
      int midOfSecondArray = (startB + endB + 1) / 2;
      return medianOfSortedArrays(arrOne, arrTwo, midOfFirstArray, endA, startB, midOfSecondArray);
    } else { // medianOfArrayOne > medianOfArrayTwo
      int midOfFirstArray = (endA + startA + 1) / 2;
      int midOfSecondArray = (startB + endB + 1) / 2;
      return medianOfSortedArrays(arrOne, arrTwo, startA, midOfFirstArray, midOfSecondArray, endB);

    }
  }

  private static int median(int[] input, int start, int end) {
    int n = end - start + 1;
    if (n % 2 == 0) {
      return (input[start + (n / 2)] + input[start + (n / 2 - 1)]);
    } else {
      return input[start + n / 2];
    }
  }

  public static void main(String[] args) {
    int ar1[] = {1, 2, 3, 6};
    int ar2[] = {4, 6, 8, 10};
    int n1 = ar1.length;
    int n2 = ar2.length;
    if (n1 != n2) {
      System.out.println(
          "Doesn't work for arrays "
              + "of unequal size");
    } else if (n1 == 0) {
      System.out.println("Arrays are empty.");
    } else if (n1 == 1) {
      System.out.println((ar1[0] + ar2[0]) / 2);
    } else {
      System.out.println(
          "Median is "
              + medianOfSortedArrays(
              ar1, ar2, 0,
              ar1.length - 1, 0, ar2.length - 1));
    }
  }
}

