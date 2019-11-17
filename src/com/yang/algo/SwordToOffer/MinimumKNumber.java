package com.yang.algo.SwordToOffer;

import sun.text.resources.cldr.haw.FormatData_haw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName MinimumKNumber
 * @Description 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @Author YangC
 * @Date 2019/9/6 19:57
 **/
public class MinimumKNumber {

    //方法1 直接API排序
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length || input == null){
            return new ArrayList<>();
        }
        Arrays.sort(input);
        int[] res = Arrays.copyOfRange(input, 0, k);
        List<Integer> list1 = Arrays.stream(res).boxed().collect(Collectors.toList());
//        list1 = new ArrayList<>(list1);
        return (ArrayList<Integer>) list1;
    }

    //方法2 堆
    public ArrayList<Integer> getMinKNumsByHeap(int[] arr, int k){
        if (k < 1 || k > arr.length){
            return new ArrayList<>();
        }
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i ++){
            heapInsert(kHeap, arr[i], i);
        }
        for (int i = k; i != arr.length; i ++){
            if (arr[i] < kHeap[0]){
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        List<Integer> list1 = Arrays.stream(kHeap).boxed().collect(Collectors.toList());
        return (ArrayList<Integer>) list1;
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize){
            if (arr[left] > arr[index]){
                largest = left;
            }
            if (right < heapSize && arr[right] > arr[largest]){
                largest = right;
            }
            if (largest != index){
                swap(arr, largest, index);
            }else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    private void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0){
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]){
                swap(arr, parent, index);
                index = parent;
            }else {
                break;
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }


    public static void main(String[] args) {
        System.out.println(new MinimumKNumber().getMinKNumsByHeap(new int[]{3, 4, 5, 2, 31, 2}, 3));
    }
}


/**
 * 对于Arrays.asList()方法需要注意以下几点：
 * 1.该方法返回的是基于数组的List视图（List view）。所以，这种方式是将数组转换为List的最快的方式。因为返回的只是视图，不需要多余的内存来创建新的List以及复制操作。
 *
 * 2.该方法返回的List是长度是固定的(fixed)，不是只读的。所以我们不能进行删除、添加操作，而可以使用set()方法进行修改元素操作。如果你对返回的List执行add()添加新元素，会返回UnsupportedOperationException。至于为什么报这个异常，文章末尾我会给出解释。
 *
 * 3.因为该方法返回的是基于原数组的List视图，所以，当我们使用set方法修改了List中的元素的时候，那么原来的数组也会跟着改变（这是视图的特性）。
 *
 * 4.从java 5开始，该方法支持泛型，所以我们可以从数组中得到类型安全ArrayList。
 *
 * 注意：
 * 1.如果我们想让转换为只读的List，可以使用Collections.unmodifiableList()方法来将数组转换为指定List。
 *
 * 2.如果想返回的方法能够进行添加、删除元素操作，则可以使用new ArrayList(Arrays.asList(array)) ，这样就会创建一个对象类型的ArrayList，并将数组的内容拷贝过去。
 * */