import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Pather {

    /**
     * Created by Nanson10.
     * 
     * @param reader is a reader.
     * @throws NullPointerException      if reader is null.
     * @throws InvalidParameterException if the coordinates refer to an impassable
     *                                   wall.
     */
    public static void printPath(Reader reader) {
        if (reader == null)
            throw new NullPointerException("reader cannot be null");

        char[][] data = reader.getMap();
        Coordinates coordinates = reader.getCoordinates();

        if (data[coordinates.getX()][coordinates.getY()] == '#')
            throw new InvalidParameterException("coordinates cannot refer to an impassable wall.");

        printData(data);
        System.out.println();

        setDistances(data, coordinates);

        printData(data);
    }

    /**
     * Created by Nanson10.
     * 
     * @param data        is the map that the pathfinder is altering.
     * @param coordinates is the starting coordinates of the map.
     */
    private static void setDistances(char[][] data, Coordinates coordinates) {
        ArrayList<Coordinates> current = new ArrayList<Coordinates>(), next = new ArrayList<Coordinates>(),
                done = new ArrayList<Coordinates>();

        // Initializes the first distance
        next.add(coordinates);
        int distance = 0;

        // While there is still another tile that can be accessed
        while (next.size() >= 1) {
            done = mergeArrayLists(done, current);
            current = next;
            next = new ArrayList<Coordinates>();

            // Add all neighbors of current tiles
            for (int a = 0; a < current.size(); a++) {
                Coordinates coords = current.get(a);
                String string = String.valueOf(distance);
                data[coords.getX()][coords.getY()] = string.charAt(string.length() - 1);
                next = mergeArrayLists(next, coords.getNeighbors());
            }

            // Clean out any invalid coordinates
            for (int a = next.size() - 1; a >= 0; a--) {
                Coordinates coords = next.get(a);
                int coordX = coords.getX(), coordY = coords.getY();
                if (coordX < 0 || coordY < 0 || coordX >= data.length || coordY >= data[0].length
                        || coords.getElement(data) == '#' || containsElement(done, coords))
                    next.remove(a);
            }
            // Removes duplicate coordinates
            removeDuplicates(next);

            distance++;
        }
    }

    /**
     * Created by Nanson10.
     * 
     * @param data        is the arraylist that is being searched in.
     * @param coordinates is the coordinates being searched for.
     * @return true if there is another set of coordinates inside data with the same
     *         info as coordinates, false otherwise.
     */
    private static boolean containsElement(ArrayList<Coordinates> data, Coordinates coordinates) {
        for (Coordinates coords : data)
            if (coords.equals(coordinates))
                return true;
        return false;
    }

    /**
     * Created by Nanson10.
     * 
     * @param one is a Coordinates ArrayList whose duplicates are being removed.
     */
    private static void removeDuplicates(ArrayList<Coordinates> one) {
        for (int root = 0; root < one.size() - 1; root++)
            for (int check = one.size() - 1; check > root; check--)
                if (one.get(root).equals(one.get(check)))
                    one.remove(check);
    }

    /**
     * Created by Nanson10.
     * 
     * @param one is a Coordinates ArrayList.
     * @param two is a Coordinates ArrayList.
     * @return a Coordinates ArrayList that contains elements from one and two.
     */
    private static ArrayList<Coordinates> mergeArrayLists(ArrayList<Coordinates> one, ArrayList<Coordinates> two) {
        ArrayList<Coordinates> temp = new ArrayList<Coordinates>(one);
        for (Coordinates coordinates : two)
            temp.add(coordinates);
        return temp;
    }

    /**
     * Created by Nanson10.
     * 
     * @param data is data being printed out.
     */
    private static void printData(char[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++)
                System.out.print(data[row][col]);
            System.out.println();
        }
    }
}
