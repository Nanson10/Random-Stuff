import java.io.File;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a file number: ");
        number = sc.nextInt();
        File file = new File("Pathfinder/map" + number + ".dat");
        while (!file.exists()) {
            System.out.print("Invalid file number, please enter a new one: ");
            number = sc.nextInt();
            file = new File("Pathfinder/map" + number + ".dat");
        }
        sc.close();
        Reader reader = new Reader(file);
        Pather.printPath(reader);
    }
}