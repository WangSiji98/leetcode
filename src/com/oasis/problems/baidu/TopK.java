package com.oasis.problems.baidu;

import com.oasis.problems.hot100.QuickSelect;
import java.util.Random;

public class TopK {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        int randomK = randomPartition(nums, l, r);
        if (k == randomK) {
            return nums[k];
        }
        return randomK < k ? quickSelect(nums, randomK + 1, r, k) : quickSelect(nums, l , randomK - 1, k);
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int base = nums[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= base) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, r);
        return i;
    }

    private void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        TopK quickSelect = new TopK();
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(quickSelect.findKthLargest(nums, k));
    }

}
