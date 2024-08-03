package Pathfinder;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Pather implements Restrictable {
    private static char[][] data;
    private static int x, y;
    private static ArrayList<Coordinates> current, next;

    public static void printPath(Reader reader) {
        data = reader.getData();
        x = reader.getX();
        y = reader.getY();

        if (data[x][y] == '#')
            throw new InvalidParameterException("x and y cannot refer to coordinates of an impassable wall.");

        printData();
    }

    private static void printData() {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++)
                System.out.print(data[row][col]);
            System.out.println();
        }
    }

    public boolean checkRestrictions() {

    }
}
