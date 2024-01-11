import java.util.*;
// REVISING BACKTRACKING
// RAT IN A MAZE PROBLEM
public class Lecture2 {
    public static void ratPath(int maze[][],int r,int c,String p,List<String> pathList){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            pathList.add(p);
            return;
        }
        if(maze[r][c]!=0){// cell ko tabhi visit kar sakte hai jab it contains value as 1
            maze[r][c]=0;// marking the cell as 0 because we are visiting it
            if(r>0){
                // means we can travel upward
                ratPath(maze, r-1, c, p+'U',pathList);
            }
            if(r<maze.length-1){
                // means we can travel downward
                ratPath(maze, r+1, c, p+'D',pathList);
            }
            if(c>0){
                // means we can travel leftward
                ratPath(maze, r, c-1, p+'L',pathList);
            }
            if(c<maze[0].length-1){
                // means we can travel rightward
                ratPath(maze, r, c+1, p+'R',pathList);
            }
            // backtracking (now undo the change made, making it unvisited)
            maze[r][c]=1;
        }
    }
    public static void main(String[] args) {
        // int maze[][] ={
        // {1, 0, 0, 0},
        // {1, 1, 0, 1}, 
        // {1, 1, 0, 0},
        // {0, 1, 1, 1}
        // };
        int maze[][] ={
        {1,0},
        {1,0}
        };
        List<String> pathList = new ArrayList<>();
        ratPath(maze, 0, 0, "",pathList);
        // bas ek aur condition aayegi ki agar maze[r-1][c-1] ==0 means no path to reach at the end and return -1
        System.out.println("Rat has followed the following paths : "+pathList);
    }
}
