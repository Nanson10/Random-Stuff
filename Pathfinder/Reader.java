package Pathfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    private File file;
    private char[][] data;

    public Reader(File file) {
        this.file = file;
        data = new char[getHeight()][getLength()];
        recordData();
    }

    public char[][] getData() {
        char[][] temp = new char[data.length][data[0].length];
        for (int a = 0; a < data.length; a++)
            for (int b = 0; b < data[0].length; b++)
                temp[a][b] = data[a][b];
        return temp;
    }

    private void recordData() {
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            int rowNum = 0;
            String row;

            while (sc.hasNext()) {
                row = sc.nextLine();
                for (int a = 0; a < row.length(); a++) {
                    data[rowNum][a] = row.charAt(a);
                }
                rowNum++;
            }

            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

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

    public int getX() {
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

    public int getY() {
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
}
