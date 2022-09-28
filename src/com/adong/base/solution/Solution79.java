package com.adong.base.solution;

/**
 * @author beiting
 * @Description Solution79
 * @Date 2022-09-27 10:21 PM
 */
public class Solution79 {

    public static boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        char[] words = word.toCharArray();
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[0].length; x++) {
                if(backTrace(board, visited, y, x, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backTrace(char[][] board, int[][] visited,
                              int y, int x, char[] word, int index) {
        if(index == word.length) {
            return true;
        }
        if(x >= 0 && x < board[0].length && y >= 0 && y < board.length &&
                visited[y][x] != 1 && word[index] == board[y][x]) {
            visited[y][x] = 1;
            index++;
            if(backTrace(board, visited, y - 1, x, word, index)||
                    backTrace(board, visited, y + 1, x, word, index)||
                    backTrace(board, visited, y, x - 1, word, index)||
                    backTrace(board, visited, y, x + 1, word, index)) {
                return true;
            }
            visited[y][x] = 0;
        }
        return false;
    }

    // [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
    //"SEE"
    public static void main(String[] args) {

        char[][] board = new char[3][4];
        board[0] = new char[]{'A','B','C','E'};
        board[1] = new char[]{'S','F','C','S'};
        board[2] = new char[]{'A','D','E','E'};
        System.out.println(Solution79.exist(board, "SEE"));
    }
}
