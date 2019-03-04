package com.Recruitment;

public class SearchMatrix extends Question {
    private int[][] matrix;
    private int target;

    SearchMatrix(int target) {
        this.target = target;
    }

    @Override
    public String description() {
        return "Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:\n" +
                "\t1.Integers in each row are sorted in ascending from left to right.\n" +
                "\t2.Integers in each column are sorted in ascending from top to bottom.";
    }
//    此题在leetcode上暴力求解通过
    @Override
    public void input() {
        matrix = new int[][]{
                {1, 4, 7, 11, 15, 20},
                {2, 5, 8, 12, 19, 25},
                {3, 6, 9, 16, 22, 27},
                {10, 13, 14, 17, 24, 29},
                {18, 21, 23, 26, 30, 31},
        };

        for (int[] matrix1 : matrix) {
            for (int i : matrix1) {
                System.out.print(String.format("%02d", i) + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void resolve() {

    }
}
