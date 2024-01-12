// word search in a matrix
    // THOUGHT PROCESS --> Start tarvelling the matrix and search for the cell where the first character of the string matches with the character in the cell, once the match occurs make call to the wordSearch function 
    // Ab hum index ko badhate jaayenge and we will keep on checking that the index character matches with the cell value or not , if yes than mark the cell as '*' that means visited and make recursive calls for searching in {left,right,up,down} cell and once the calls are finished now BACKTRACK and replace the cells with the same character
    public static boolean wordSearch(char m[][],int r,int c,int index,String word){
        if(index==word.length()) return true;
        boolean ans = false;
        if(r<0 || c<0 || r>=m.length || c>=m[0].length){
            return false;
        }
        if(m[r][c]==word.charAt(index)){
            m[r][c] = '*';
            ans = wordSearch(m, r+1, c, index+1, word) || wordSearch(m, r-1, c, index+1, word) || wordSearch(m, r, c+1, index+1, word) || wordSearch(m, r, c-1, index+1, word);

            m[r][c] = word.charAt(index);
        }
        return ans;
    }
