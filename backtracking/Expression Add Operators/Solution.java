import java.util.*;

class Solution {
    
    static public ArrayList<String> findExpr(String s, int target) {
        // code here
        ArrayList <String> ans = new ArrayList<>();
        solve(0,s,target,"",ans,0,0);
        return ans;
    }
    
    static void solve (int index,String num,int target,String curr,List<String> ans,long prev,long res){
        if(index==num.length()){
            if(res==target){
                ans.add(curr);
            }
            return;
        }     
        String st="";
        long currRes = 0;
        for(int i=index;i< num.length();i++){
            if(i>index && num.charAt(index)=='0') break;
            st+=num.charAt(i);
            currRes = currRes*10+(num.charAt(i)-'0');
            if(index==0){
                solve(i+1,num,target,st,ans,currRes,currRes);
            }else{
                solve(i+1,num,target,curr+"+"+st,ans,currRes,res+currRes);
                solve(i+1,num,target,curr+"-"+st,ans,-currRes,res-currRes);
                solve(i+1,num,target,curr+"*"+st,ans,prev*currRes,res-prev+(prev*currRes));
            }
        }
        
    }

    public static void main(String [] args){
        int [] a = {7,8,5};
        System.out.println("Input: s = `125`, target = 7 Output: "+findExpr("125",7));
        System.out.println("Input: s = `124`, target = 9 Output: "+findExpr("124",3));
    }
}

/*
Given a string s that contains only digits (0-9) and an integer target, return all possible strings by inserting the binary operator ' + ', ' - ', and/or ' * ' between the digits of s such that the resultant expression evaluates to the target value.

Note:

Operands in the returned expressions should not contain leading zeros. For example, 2 + 03 is not allowed whereas 20 + 3 is fine.
It is allowed to not insert any of the operators.
Driver code will print the final list of strings in lexicographically smallest order.
Examples:

Input: s = "124", target = 9
Output: ["1+2*4"]
Explanation: The valid expression that evaluate to 9 is 1 + 2 * 4
Input: s = "125", target = 7
Output: ["1*2+5", "12-5"]
Explanation: The two valid expressions that evaluate to 7 are 1 * 2 + 5 and 12 - 5.
Input: s = "12", target = 12
Output: ["12"] 
Explanation: s itself matches the target. No other expressions are possible.
Input: s = "987612", target = 200
Output: []
Explanation: There are no expressions that can be created from "987612" to evaluate to 200.
 */