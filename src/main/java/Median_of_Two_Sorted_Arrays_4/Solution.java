package Median_of_Two_Sorted_Arrays_4;

public class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int totalSize = nums1.length + nums2.length;

    if (totalSize % 2 != 0) {
      return getKthElement(nums1, nums2, totalSize / 2 + 1);
    } else {
      return (getKthElement(nums1, nums2, totalSize / 2) + getKthElement(nums1, nums2, totalSize / 2 + 1)) / 2;
    }

  }

  private double getKthElement(int[] nums1, int[] nums2, int k) {

    int length1 = nums1.length;
    int length2 = nums2.length;
    int index1 = 0;
    int index2 = 0;

    while (true) {

      if (index1 == length1) {
        return nums2[index2 + k - 1];
      }

      if (index2 == length2) {
        return nums1[index1 + k - 1];
      }

      if (k == 1) {
        return Math.min(nums1[index1], nums2[index2]);
      }

      int half = k / 2 ;

      int nextIndex1 = Math.min(index1 + half, nums1.length) - 1;
      int nextIndex2 = Math.min(index2 + half, nums2.length) - 1;

      int p1 = nums1[nextIndex1];
      int p2 = nums2[nextIndex2];

      if(p1 <= p2) {
        k -= (nextIndex1 - index1 + 1);
        index1 = nextIndex1 + 1;
      } else {
        k -= (nextIndex2 - index2 + 1);
        index2 = nextIndex2 + 1;
      }

    }
  }

}
