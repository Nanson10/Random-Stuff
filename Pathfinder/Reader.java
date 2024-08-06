package Pathfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    private File file;
    private char[][] map;
    private Coordinates start;

    /**
     * Created by Nanson10.
     * 
     * @param file is the file to be read.
     */
    public Reader(File file) {
        this.file = file;
        map = new char[getHeight()][getLength()];
        recordMap();
        start = new Coordinates(getX(), getY());
    }

    /**
     * Created by Nanson10.
     * 
     * @return the map of the file.
     */
    public char[][] getMap() {
        char[][] temp = new char[map.length][map[0].length];
        for (int a = 0; a < map.length; a++)
            for (int b = 0; b < map[0].length; b++)
                temp[a][b] = map[a][b];
        return temp;
    }

    /**
     * Created by Nanson10.
     * Records the map into a char[][].
     */
    private void recordMap() {
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            int rowNum = 0;
            String row;

            while (sc.hasNext()) {
                row = sc.nextLine();
                for (int a = 0; a < row.length(); a++) {
                    map[rowNum][a] = row.charAt(a);
                }
                rowNum++;
            }

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Created by Nanson10.
     * 
     * @return the height of the map.
     */
    private int getHeight() {
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            int height = 0;

            while (sc.hasNext()) {
                sc.nextLine();
                height++;
            }

            sc.close();
            return height;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return -1;
    }

    /**
     * Created by Nanson10.
     * 
     * @return the length of the map.
     */
    private int getLength() {
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            int longest = 0;

            while (sc.hasNext()) {
                String next = sc.nextLine();
                if (next.length() > longest)
                    longest = next.length();
            }

            sc.close();
            return longest;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return -1;
    }

    /**
     * Created by Nanson10.
     * 
     * @return the x coordinate of the start.
     */
    private int getX() {
        try {
            Scanner sc = new Scanner(file);

            int x = sc.nextInt();

            sc.close();
            return x;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return -1;
    }

    /**
     * Created by Nanson10.
     * 
     * @return the y coordinate of the start.
     */
    private int getY() {
        try {
            Scanner sc = new Scanner(file);

            sc.nextInt();
            int y = sc.nextInt();

            sc.close();
            return y;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return -1;
    }

    /**
     * Created by Nanson10.
     * 
     * @return the coordinates of the start.
     */
    public Coordinates getCoordinates() {
        return new Coordinates(start);
    }
}
