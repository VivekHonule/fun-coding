import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RatInAMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orderOfMatrix = Integer.parseInt(scanner.nextLine());
        String matrixElementsStr = scanner.nextLine();
        int[][] maze = createIntMatrix(matrixElementsStr, orderOfMatrix);
        List<String> direction = findPathInMaze(maze);
        showDirection(direction);
    }

    private static void showDirection(List<String> direction) {
        if (direction.isEmpty()) {
            System.out.println("Path does not exist to reach Destination");
        }

        for (String str : direction) {
            System.out.print(str);
        }
    }

    private static List<String> findPathInMaze(int[][] maze) {
        List<String> path = new ArrayList<>();
        boolean pathFound = performMove(maze, 0, 0, 0, 0, path);
        if (pathFound) {
            return path;
        }
        return Collections.emptyList();
    }

    private static boolean performMove(int[][] maze, int xPrevious, int yPrevious, int xCurrent, int yCurrent, List<String> path) {
        boolean leftMovePossible = isLeftMovePossible(maze, yPrevious, xCurrent, yCurrent);
        boolean rightMovePossible = isRightMovePossible(maze, yPrevious, xCurrent, yCurrent);
        boolean upMovePossible = isUpMovePossible(maze, xPrevious, xCurrent, yCurrent);
        boolean downMovePossible = isDownMovePossible(maze, xPrevious, xCurrent, yCurrent);

        //break condition.
        if (xCurrent == maze.length - 1 && yCurrent == maze.length - 1) {
            return true;
        }

        if (!leftMovePossible && !rightMovePossible && !upMovePossible && !downMovePossible) {
            return false;
        }

        if (downMovePossible) {
            path.add("D");
            boolean isValidMove = performMove(maze, xCurrent, yCurrent, xCurrent + 1, yCurrent, path);
            if (!isValidMove) {
                path.remove(path.size() - 1);
            } else {

                return true;
            }
        }

        if (rightMovePossible) {
            path.add("R");
            boolean isValidMove = performMove(maze, xCurrent, yCurrent, xCurrent, yCurrent + 1, path);
            if (!isValidMove) {
                path.remove(path.size() - 1);
            } else {
                return true;
            }
        }
        return false;
    }

    private static boolean isDownMovePossible(int[][] maze, int xPrevious, int xCurrent, int yCurrent) {
        if (xCurrent + 1 == xPrevious) {
            return false;
        }
        if (xCurrent == maze.length - 1) {
            return false;
        }
        int mazeBlock = maze[xCurrent + 1][yCurrent];
        return mazeBlock == 1;
    }

    private static boolean isUpMovePossible(int[][] maze, int xPrevious, int xCurrent, int yCurrent) {
        if (xCurrent - 1 == xPrevious) {
            return false;
        }
        if (xCurrent == 0) {
            return false;
        }
        int mazeBlock = maze[xCurrent - 1][yCurrent];
        return mazeBlock == 1;
    }

    private static boolean isRightMovePossible(int[][] maze, int yPrevious, int xCurrent, int yCurrent) {
        if (yCurrent + 1 == yPrevious) {
            return false;
        }
        if (yCurrent == maze.length - 1) {
            return false;
        }
        int mazeBlock = maze[xCurrent][yCurrent + 1];
        return mazeBlock == 1;
    }

    private static boolean isLeftMovePossible(int[][] maze, int yPrevious, int xCurrent, int yCurrent) {
        if (yCurrent - 1 == yPrevious) {
            return false;
        }
        if (yCurrent == 0) {
            return false;
        }
        int mazeBlock = maze[xCurrent][yCurrent - 1];
        return mazeBlock == 1;
    }

    private static int[][] createIntMatrix(String matrixElementsStr, int orderOfMatrix) {
        String[] strArr = matrixElementsStr.split(" ");
        int[][] intMatrix = new int[orderOfMatrix][orderOfMatrix];
        int count = 0;
        for (int i = 0; i < orderOfMatrix; i++) {
            for (int j = 0; j < orderOfMatrix; j++) {
                int anInt = Integer.parseInt(strArr[count++]);
                intMatrix[i][j] = anInt;
            }
        }
        return intMatrix;
    }
}


/*
Sample Input:

1 0 0 0
1 1 0 0
1 0 0 0
1 1 1 1

1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1

1 0 0 0
1 1 1 0
1 0 1 0
0 0 1 1
 */