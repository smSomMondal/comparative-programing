import java.util.*;

class Solution {
    
    static public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        ArrayList<String> ans=new ArrayList<>();
        move(0,0,"",ans,n-1,maze,'S');
        return ans;
    }
    
    static void move(int curRow,int curCol,String str,List path,int goal,int[][] maze,char dir){
        if(curRow==goal && curCol==goal){
            path.add(str);
            return;
        }
        /*if(curRow>goal){
            return;
        }*/
        if(curCol>goal || curRow>goal || curCol<0 || curRow<0){
            return;
        }
        if(maze[curRow][curCol]==0){
            return;
        }
        maze[curRow][curCol]=0;
        
        
        /* lexicographically smallest order D<L<R<U*/
        //Down
        move(curRow+1,curCol,str+"D",path,goal,maze,'D');
        //Left
        move(curRow,curCol-1,str+"L",path,goal,maze,'L');
        //Right
        move(curRow,curCol+1,str+"R",path,goal,maze,'R');
        //Up
        move(curRow-1,curCol,str+"U",path,goal,maze,'U');
        
        maze[curRow][curCol]=1;
    }


    public static void main(String [] args){
        int [] a = {7,8,5};
        System.out.println(ratInMaze());
        
    }
}

/*

Consider a rat placed at position (0, 0) in an n x n square matrix maze[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.

Note: Return the final result vector in lexicographically smallest order.

Examples:

Input: maze[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell (1, 1) is blocked.
Input: maze[][] = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: DDRR and RRDD.
 */