import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Adder
{
    public static void main(String[] args)
    {
        int startTerm = getStartTerm();
        int addTerm = getAddTerm();
        for(int term = startTerm; term < addTerm + startTerm; term++)
        {
            int iteration = 0;
            int current = term;
            while(current != 1)
            {
                iteration++;
                if(current % 2 == 0)
                    current /= 2;
                else
                {
                    current *= 3;
                    current++;
                }
            }
            recordAndPrint(term, iteration);
        }
    }

    private static int getStartTerm()
    {
        try {
            int temp = 1;
            Scanner sc = new Scanner(new File("data.dat"));
            while(sc.hasNextLine())
            {
                sc.nextLine();
                temp++;
            }
            sc.close();
            return temp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        };
        return -1;
    }

    public static int getAddTerm()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter how many terms you want to add to the file: ");
        int answer = sc.nextInt();
        while(answer < 1)
        {
            System.out.print("Invalid answer, please enter a new number: ");
            answer = sc.nextInt();
        }
        sc.close();
        return answer;
    }

    public static void recordAndPrint(int term, int iteration)
    {
        try {
            File file = new File("data.dat");
            File temp = new File("temp.dat");
            FileWriter fileWriter = new FileWriter(temp);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine())
                fileWriter.write(sc.nextLine() + "\n");
            fileWriter.write(term + " " + iteration);

            fileWriter.close();
            sc.close();

            temp.renameTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println(term + " " + iteration);
    }
}