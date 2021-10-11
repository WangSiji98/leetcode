package com.oasis.problems.baidu;

import java.util.Arrays;
import java.util.Random;

class QuickSort {

    // 手写快速排序
    // 带随机的版本
    private static Random random = new Random();

    public static void quickSort(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int mid = randomPartition(nums, l , r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
    }

    public static int randomPartition(int[] nums, int l, int r) {
        int k = l + random.nextInt(r - l + 1);
        swap(nums, l, k);
        return partition(nums, l, r);
    }

    public static int partition(int[] nums, int l, int r) {
        int base = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= base) {
                --r;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] <= base) {
                ++l;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }
        }
        nums[l] = base;
        return l;
    }

    private static void swap(int[] nums ,int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

public class QuickSortTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 6, 2, 9, 3, 4};
        System.out.println(Arrays.toString(nums));
        QuickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
