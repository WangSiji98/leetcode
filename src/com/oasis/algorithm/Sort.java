package com.oasis.algorithm;

public class Sort {

    // 快速排序
    public static void quickSort(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int mid = partition(nums, l, r);
        quickSort(nums, l, mid - 1);
        quickSort(nums, mid + 1, r);
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

    // 归并排序
    public void mergeSort(int[] nums) {

    }

    // 主函数
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4, 6, 5};
        print(nums);
        quickSort(nums, 0, nums.length - 1);
        print(nums);
    }

    private static void print(int[] nums) {
        for (int num: nums) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }

}
