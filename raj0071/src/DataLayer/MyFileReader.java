package DataLayer;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyFileReader {
    public void showVehicles() throws FileNotFoundException {
        File file = new File("vehicles.txt");
        Scanner scan = new Scanner(file);

        System.out.println("id:\t\ttitle:\t\ttype:\t\tselling price:\t\tproduction price:\t\t");

        scan.useDelimiter("\\|");

        while(scan.hasNext())
        {
            System.out.print(scan.next() + "\t\t");
        }
    }

    public void showUsers() throws FileNotFoundException {
        File file = new File("users.txt");
        Scanner scan = new Scanner(file);

        System.out.println("id:\t\tname:\t\tsurname:");

        scan.useDelimiter("\\|");

        while(scan.hasNext())
        {
            System.out.print(scan.next() + "\t\t");
        }
    }

    public void addUser(String name, String surname) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        int usersCount = lines + 1;

        BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));

        writer.write("\n" + usersCount + "|" + name + "|" + surname);

        writer.close();
    }

    public void addVehicle(String title, String type, String sellingPrice, String productionPrice) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("vehicles.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();

        int vehicleCount = lines + 1;

        BufferedWriter writer = new BufferedWriter(new FileWriter("vehicles.txt", true));

        writer.write("\n" + vehicleCount + "|" + title + "|" + type + "|" + sellingPrice + "|" + productionPrice);

        writer.close();
    }

    public void findVehicle(String toFind) throws IOException {
        File file = new File("vehicles.txt");
        Scanner scan = new Scanner(file);

        System.out.println("id:\ttitle:\ttype:\tsell:\tproduction:\t");

        while(scan.hasNext())
        {
            String temp = scan.next();

            if(temp.contains(toFind))
            {
                String splitText[] = temp.split("\\|");
                for(String word : splitText)
                {
                    System.out.print(word + "\t");
                }
            }
        }
    }

    public void increasePrice(double percent) throws IOException {
        File file = new File("vehicles.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter("vehicles.txt"));

        Scanner scan = new Scanner(file);

        while(scan.hasNext())
        {
            String temp = scan.next();

            String splitText[] = temp.split("\\|");

            double sell = Double.parseDouble(splitText[3]);

            sell = sell * percent;

            for(String word : splitText)
            {
                System.out.print(word + "\t");
            }
        }
    }
}
