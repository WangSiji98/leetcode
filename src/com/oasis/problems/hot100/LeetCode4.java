package com.oasis.problems.hot100;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 + len2) % 2 != 0) {
            return findKthNumber(nums1, nums2, (len1 + len2) / 2 + 1);
        } else {
            return (findKthNumber(nums1, nums2, (len1 + len2) / 2) + findKthNumber(nums1, nums2, (len1 + len2) / 2 + 1)) / 2.0;
        }
    }

    public double findKthNumber(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthNumber = 0;

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

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode4 leetCode4 = new LeetCode4();
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{3, 4};
        System.out.println(leetCode4.findMedianSortedArrays(nums1, nums2));
    }

}
