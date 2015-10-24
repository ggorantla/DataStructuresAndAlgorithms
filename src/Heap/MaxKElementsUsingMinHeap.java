package Heap;

import java.util.PriorityQueue;

/**
 * Created by ggorantla on 10/24/2015.
 */
public class MaxKElementsUsingMinHeap {
    public static void main(String[] args) {
        int[] arr = { 3, 46, 2, 56, 3, 38, 93, 45, 6, 787, 34, 76, 44, 6, 7, 86, 8, 44, 56 };
        int[] result = getTopElements(arr, 5);
        for (int i : result)
        {
            System.out.print(i + ",");
        }
    }
    public static int[] getTopElements(int[] arr, int k){
        PriorityQueue<Integer> kelements = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            if (kelements.size() < k){
                kelements.add(arr[i]);
            }else if (kelements.peek() < arr[i]){
                kelements.poll();
                kelements.add(arr[i]);
            }
        }
        int[] results = new int[kelements.size()];
        int index = 0;
        while (!kelements.isEmpty()){
            results[index++] = kelements.poll();
        }
        return results;
    }
}
