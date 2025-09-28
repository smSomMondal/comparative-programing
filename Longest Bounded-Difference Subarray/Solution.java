import java.util.*;

public class Solution {
    public static ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        // https://youtu.be/dBOQq-VH44s?si=e4MnM2M3mjyoOpRj
        // https://www.geeksforgeeks.org/problems/longest-bounded-difference-subarray/1
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        
        int n = arr.length, start = 0, end = 0;
        
        int resStart = 0, resEnd = 0;
        while (end < n) {
            
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end])
                minQueue.pollLast();
           
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end])
                maxQueue.pollLast();
                
            minQueue.addLast(end);
            maxQueue.addLast(end);
            
            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {
                       
                if (start == minQueue.peekFirst())
                    minQueue.pollFirst();
                if (start == maxQueue.peekFirst())
                    maxQueue.pollFirst();
                start += 1;
            }
            
            if (end - start > resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }
            end += 1;
        }

       
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = resStart; i <= resEnd; i++)
            res.add(arr[i]);
            
        return res;
    }

    public static void main(String []args){
        int arr[] = {8, 4, 5, 6, 7}, x = 3 ;
        int arr2[] = {1, 10, 12, 13, 14}, x2 = 2 ;
        System.out.println(longestSubarray(arr,x));
        System.out.println(longestSubarray(arr2,x2));
    }
}