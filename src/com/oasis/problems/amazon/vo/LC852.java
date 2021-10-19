package com.oasis.problems.amazon.vo;

public class LC852 {

    // 二分
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (mid == 0) {
                l = mid + 1;
            } else if (mid == n - 1) {
                r = mid - 1;
            } else {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return l;
    }

}
