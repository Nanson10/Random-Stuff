import java.util.ArrayList;

public class Coordinates {
    private int x, y;

    public Coordinates(Coordinates other) {
        this.x = other.x;
        this.y = other.y;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Created by Nanson10.
     * 
     * @param data is the char[][] being acted upon.
     * @return the char at the corresponding x and y values.
     */
    public char getElement(char[][] data) {
        return data[x][y];
    }

    /**
     * Created by Nanson10.
     * 
     * @return the 4 adjacent neighbors of this coordinate that is stored in an
     *         ArrayList, no guarentee that these coordinates are inbounds.
     */
    public ArrayList<Coordinates> getNeighbors() {
        ArrayList<Coordinates> temp = new ArrayList<Coordinates>();
        for (int xChange = -1; xChange <= 1; xChange++)
            for (int yChange = -1; yChange <= 1; yChange++)
                if (Math.abs(xChange + yChange) == 1)
                    temp.add(new Coordinates(x + xChange, y + yChange));
        return temp;
    }

    @Override
    public boolean equals(Object coordinates) {
        if (coordinates instanceof Coordinates) {
            Coordinates temp = (Coordinates) coordinates;
            return x == temp.x && y == temp.y;
        } else
            return false;
    }
}
