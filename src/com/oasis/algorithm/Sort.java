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
    public static int[] mergeSort(int[] a, int l, int r){
        int mid = (l + r) >> 1;
        if(l<r){
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            //左右归并
            merge(a, l, mid, r);
        }
        return a;
    }

    public static void merge(int[] a, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i= l;
        int j = mid + 1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i <= mid && j <= r){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组 
        while(i <= mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j <= r){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x = 0; x < temp.length; x++){
            a[x + l] = temp[x];
        }
    }

    // 主函数
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4, 6, 5};
        print(nums);
//        quickSort(nums, 0, nums.length - 1);
        nums = mergeSort(nums, 0, nums.length - 1);
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
