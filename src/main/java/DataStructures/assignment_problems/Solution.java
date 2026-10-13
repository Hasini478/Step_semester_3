package DataStructures.assignment_problems;

class Solution {
    static void busiestRow(int[][] grid) {
        int maxRow = 0, maxTotal = 0;

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;

            for (int j = 0; j < grid[i].length; j++)
                sum += grid[i][j];

            if (i == 0 || sum > maxTotal) {
                maxTotal = sum;
                maxRow = i;
            }
        }

        System.out.println("Row " + maxRow + ", Total " + maxTotal);
    }
}
