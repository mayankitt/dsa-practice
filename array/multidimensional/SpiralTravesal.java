package array.multidimensional;

import java.util.ArrayList;

class SpiralTraversal {
    public static void main(String args[]) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        printSpiral(matrix);
    }

    public static void printSpiral(int[][] matrix) {
        ArrayList<Integer> spiralArray = getSpiralArray(matrix);
        for(int element: spiralArray) {
            System.out.println(element);
        }
    }

    public static ArrayList<Integer> getSpiralArray(int[][] matrix) {
        int leftBorder = 0;
        int rightBorder = matrix[0].length - 1;
        int topBorder = 0;
        int bottomBorder = matrix.length - 1;
        Direction direction = Direction.RIGHT;
        ArrayList<Integer> spiralArray = new ArrayList<>();
        while (rightBorder >= leftBorder && bottomBorder >= topBorder) {
            switch(direction) {
                case RIGHT:     for(int i = leftBorder; i <= rightBorder; i++)
                                    spiralArray.add(matrix[topBorder][i]);
                                topBorder++;
                                break;
                case DOWN:      for(int i = topBorder; i <= bottomBorder; i++)
                                    spiralArray.add(matrix[i][rightBorder]);
                                rightBorder--;
                                break;
                case LEFT:      for(int i = rightBorder; i >= leftBorder; i--)
                                    spiralArray.add(matrix[bottomBorder][i]);
                                bottomBorder--;
                                break;
                case UP:        for(int i = bottomBorder; i >= topBorder; i--)
                                    spiralArray.add(matrix[i][leftBorder]);
                                leftBorder++;
                                break;
            }
            direction = getNextDirection(direction);
        }
        return spiralArray;
    }

    public static Direction getNextDirection(Direction d) {
        Direction next = null;
        if (d == Direction.LEFT)
            next = Direction.UP;
        else if (d == Direction.DOWN)
            next = Direction.LEFT;
        else if (d == Direction.RIGHT)
            next = Direction.DOWN;
        else if (d == Direction.UP)
            next = Direction.RIGHT;
        
        return next;
    }
}

enum Direction {
    LEFT, RIGHT, DOWN, UP;
}