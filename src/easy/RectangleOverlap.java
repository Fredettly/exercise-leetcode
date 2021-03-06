/**
 * Created by xwx_ on 2020/3/18
 */


/**
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Example 1:
 *
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 *
 * Example 2:
 *
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 *
 * Notes:
 *
 *     1.Both rectangles rec1 and rec2 are lists of 4 integers.
 *     2.All coordinates in rectangles will be between -10^9 and 10^9.
 */
public class RectangleOverlap {
    public boolean isRectangleOverLap(int[] rec1, int[] rec2) {
        boolean rowsOk = Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]);
        boolean colsOk = Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
        return rowsOk && colsOk;
    }

    public static void main(String[] args) {
//        int[] rec1 = {0, 0, 1, 1};
        int[] rec1 = {0, 0, 2, 2};
//        int[] rec2 = {1, 0, 2, 1};
        int[] rec2 = {1, 1, 3, 3};
        RectangleOverlap rectangleOverlap = new RectangleOverlap();
        boolean rectangleOverLap = rectangleOverlap.isRectangleOverLap(rec1, rec2);
        System.out.println(rectangleOverLap);
    }
}
