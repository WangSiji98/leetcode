package com.oasis.problems.baidu;

public class MaxHeap {
    private int data[];
    private int size;
    private int capacity;

    public MaxHeap(int maxSize){
        //数组索引为0的位置不放元素
        data = new int[maxSize+1];
        this.size = 0;
        this.capacity = maxSize;
    }

    // heapif建堆
    public MaxHeap(int arr[],int maxSize){
        this.data = new int[maxSize + 1];
        this.capacity = maxSize;
        for(int i = 0; i < arr.length; i++){
            data[i+1] = arr[i];
        }
        this.size = arr.length;
        for(int i = size; i >= 1; i--){
            shiftDown(i);
        }
    }

    //向堆里面插入元素
    public void insert(int d){
        if(size == capacity){
            System.out.println("堆已满！");
            return;
        }
        //索引为0的位置不存放元素
        data[size + 1] = d;
        size++;
        //插入在最后的元素上移方法
        shiftUp(size);
    }

    //堆插入元素时的元素上移
    private void shiftUp(int i) {
        //数组可能越界问题始终不能忽视
        //当此元素比父元素大时，交换这两个元素位置
        while(i > 1 && data[i] > data[i / 2]){
            int t = data[i];
            data[i] = data[i/2];
            data[i/2] = t;
            i /= 2;
        }
    }

    //删除堆的最大元素
    public int deleteMax(){
        if(size == 0){
            System.out.println("堆已经是空的了！");
            return -1;
        }
        int t = data[1];
        //将最后一个元素放到第一个元素位置
        data[1] = data[size];
        size--;
        //然后将第一个元素下移到适当位置
        shiftDown(1);
        return t;
    }

    //堆删除元素时的元素下移
    private void shiftDown(int i) {

        while(2 * i <= size){
            // 将要将data[i]与data[j]交换
            int j = 2 * i;
            // 让j指向他的孩子结点中的大的那一个
            if(j + 1 <= size && data[j] < data[j + 1]){
                j += 1;
            }
            if (data[i] > data[j]) {
                break;
            }
            //元素下移
            // 交换 i, j
            int t = data[i];
            data[i] = data[j];
            data[j] = t;
            i = j;
        }
    }

    public void heapSort(int arr[],MaxHeap heap){
        for(int i = 0; i < arr.length; i++){
            heap.insert(arr[i]);
        }
        for(int i = arr.length-1; i >=0 ; i--){
            arr[i] = heap.deleteMax();
        }
    }

}
