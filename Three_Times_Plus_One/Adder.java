import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Adder implements Runnable {
    private static File file = new File("Three_Times_Plus_One/data.dat");
    private static ArrayList<Long> iterations = new ArrayList<Long>();

    public static void main(String[] args) {
        long startTerm = getStartTerm();
        long addTerm = getAddTerm();
        long update = startTerm / 2;
        long temp = 0;
        for (long term = startTerm; term < addTerm + startTerm; term++) {
            long iteration = 0;
            long current = term;
            while (current != 1) {
                iteration++;
                if (current % 2 == 0)
                    current /= 2;
                else {
                    current *= 3;
                    current++;
                }
            }
            recordAndPrint(term, iteration);
            if (temp == update) {
                updateFile(new ArrayList<Long>(iterations));
                iterations = new ArrayList<Long>();
                temp = 0;
                update = term / 2;
            } else
                temp++;
        }
        updateFile(new ArrayList<Long>(iterations));
    }

    private static void updateFile(ArrayList<Long> iterations) {
        try {
            File temp = new File("Three_Times_Plus_One/temp.dat");
            FileWriter fileWriter = new FileWriter(temp);
            Scanner sc = new Scanner(file);

            while (sc.hasNext())
                fileWriter.write(sc.nextLine() + "\n");

            for (int a = 0; a < iterations.size(); a++) {
                fileWriter.write(String.valueOf(iterations.get(a).intValue()));
                if (a != iterations.size() - 1)
                    fileWriter.write("\n");
            }

            temp.renameTo(file);

            fileWriter.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static long getStartTerm() {
        try {
            long temp = 1;
            Scanner sc = new Scanner(new File("Three_Times_Plus_One/data.dat"));
            while (sc.hasNext()) {
                sc.next();
                temp++;
            }
            sc.close();
            return temp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        ;
        return -1;
    }

    public static long getAddTerm() {
        Scanner sc = new Scanner(System.in);
        System.out.println("There are currently " + (getStartTerm() - 1) + " term(s).");
        System.out.print("Please enter how many terms you want to add to the file: ");
        long answer = sc.nextLong();
        while (answer < 1) {
            System.out.print("Invalid answer, please enter a new number: ");
            answer = sc.nextLong();
        }
        sc.close();
        return answer;
    }

    public static void recordAndPrint(long term, long iteration) {
        iterations.add(iteration);
        System.out.println(term + " " + iteration);
    }

    @Override
    public void run() {
        try {
            File temp = new File("Three_Times_Plus_One/temp.dat");
            FileWriter fileWriter = new FileWriter(temp);
            Scanner sc = new Scanner(file);

            while (sc.hasNext())
                fileWriter.write(sc.nextLine() + "\n");

            for (int a = 0; a < iterations.size(); a++) {
                fileWriter.write(String.valueOf(iterations.get(a).intValue()));
                if (a != iterations.size() - 1)
                    fileWriter.write("\n");
            }

            temp.renameTo(file);

            fileWriter.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}