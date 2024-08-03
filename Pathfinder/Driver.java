package Pathfinder;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        Reader reader = new Reader(new File("Pathfinder/map1.dat"));
        Pather.printPath(reader);
    }
}