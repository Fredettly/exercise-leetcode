/**
 * Created by xwx_ on 2020/3/25
 */

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 *
 * Return the total surface area of the resulting shapes.
 *
 *
 *
 * Example 1:
 *
 * Input: [[2]]
 * Output: 10
 *
 * Example 2:
 *
 * Input: [[1,2],[3,4]]
 * Output: 34
 *
 * Example 3:
 *
 * Input: [[1,0],[0,2]]
 * Output: 16
 *
 * Example 4:
 *
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 *
 * Example 5:
 *
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 *
 *
 *
 * Note:
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */


public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int len = grid.length, area = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int level = grid[i][j];
                if (level > 0) {
                    area += (level << 2) + 2;
                    area -= i > 0 ? Math.min(level, grid[i - 1][j]) << 1 : 0;
                    area -= j > 0 ? Math.min(level, grid[i][j - 1]) << 1 : 0;
                }
            }
        }
        return area;
    }


    public static void main(String[] args) {
        int grid[][] = {{1, 0}, {0, 2}};
//        int grid[][] = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        SurfaceAreaOf3DShapes areaOf3dShapes = new SurfaceAreaOf3DShapes();
        int res = areaOf3dShapes.surfaceArea(grid);
        System.out.println(res);
    }
}
