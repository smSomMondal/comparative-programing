import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> ans ;
    static public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        
        ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        backtrack(1,0,temp,k,n);
        
        return ans;
    }
    
    static void backtrack(int start,int sum ,List<Integer> temp,int count,int target){
        
        if(count==0){
            if(sum==target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        
        for(int i= start;i<=9;i++){
            if(sum+i>target) break;
            
            temp.add(i);
            
            backtrack(i+1,sum+i,temp,count-1,target);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String [] args){
        System.out.println("Input: n = 8, k = 3 Output: "+combinationSum(8,3));
        
        System.out.println("Input: n = 16, k = 3 Output: "+combinationSum(16,3));
    }
}

/*
Given two integers n and k, the task is to find all valid combinations of k numbers that adds up to n based on the following conditions:

Only numbers from the range [1, 9] used.
Each number can only be used at most once.
Note: You can return the combinations in any order, the driver code will print them in sorted order.

Examples:

Input: n = 9, k = 3
Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
Explanation: There are three valid combinations of 3 numbers that sum to 9: [1 ,2, 6], [1, 3, 5] and [2, 3, 4].

Input: n = 3, k = 3
Output: []
Explanation: It is not possible to pick 3 distinct numbers from 1 to 9 that sum to 3, so no valid combinations exist.

 */