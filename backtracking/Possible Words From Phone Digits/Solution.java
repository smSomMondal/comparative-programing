import java.util.*;

class Solution {
    
    String [] dia = {"",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz",
    };
    
    ArrayList<String> ans;
    
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        
        List <Integer> re = new ArrayList<>();
        for(int a : arr){
            if(a != 0 && a !=1 ) re.add(a);
        }
        
        //Integer[] intArr = re.toArray(new Integer[0]);

        // If you need int[]
        // int[] intArr = arrToInt(arr);
        
        int n = re.size();
        int [] nArr = new int[n];
        for(int i=0;i<n;i++){
            nArr[i]=re.get(i);
        }
        
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(n==0){
            return ans;
        }
        backtrack(0,sb,nArr,n-1);
        return ans;
    }
    
    void backtrack(int j,StringBuilder sb,int[] arr,int n){
        if(j==n){
            
            for(int i=0;i<dia[arr[j]].length();i++){
                sb.append(dia[arr[j]].charAt(i));
                ans.add(sb.toString());
                sb.deleteCharAt(j);
            }
            if(arr[j]==1 || arr[j]==0){
                ans.add(sb.toString());
            }
            return;
        }
        
        
        for(int i=0;i<dia[arr[j]].length();i++){
            sb.append(dia[arr[j]].charAt(i));
            backtrack(j+1,sb,arr,n);
            sb.deleteCharAt(j);
        }
    }

    public static void main(String [] args){
        System.out.println("Input: n = 8, k = 3 Output: "+combinationSum(8,3));
        System.out.println("Input: n = 15, k = 5 Output: "+combinationSum(15,5));
        System.out.println("Input: n = 5, k = 2 Output: "+combinationSum(5,2));
        System.out.println("Input: n = 16, k = 2 Output: "+combinationSum(16,2));
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