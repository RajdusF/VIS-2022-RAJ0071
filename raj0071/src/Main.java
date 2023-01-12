import DataLayer.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Database db = new Database();

        double percent;

        System.out.println(" 1 - Show Vehicles");
        System.out.println(" 2 - Show Users");
        System.out.println(" 2 - Add User");
        System.out.println(" 4 - Add Vehicle");
        System.out.println(" 5 - Find Vehicle");
        System.out.println(" 6 - Increase Vehicle cost");
        System.out.println(" 7 - Increase Vehicle cost by id");

        BufferedReader ans = new BufferedReader(new InputStreamReader(System.in));
        String answer = ans.readLine();

        switch(answer) {
            case "1":
                db.showVehicles();
                break;

            case "2":
                db.showUsers();
                break;

            case "3":
                System.out.println("Name: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                String name = ans.readLine();

                System.out.println("Surname: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                String surName = ans.readLine();

                db.addUser(name, surName);
                break;

            case "4":
                System.out.println("title: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                String title = ans.readLine();

                System.out.println("type: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                String type = ans.readLine();

                System.out.println("sellingPrice: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                String sellingPrice = ans.readLine();

                System.out.println("productionPrice: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                String productionPrice = ans.readLine();

                db.addVehicle(title, type, sellingPrice, productionPrice);
                break;

            case "5":
                System.out.println("title: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                String toFind = ans.readLine();

                db.findVehicle(toFind);
                break;

            case "6":
                System.out.println("increase by (%): ");
                Scanner scan = new Scanner(System.in);
                percent = 1 + (scan.nextDouble() / 100);

                db.increasePrice( String.valueOf(percent) );
                break;

            case "7":
                System.out.println("id: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                String id = ans.readLine();

                System.out.println("increase by (%): ");
                scan = new Scanner(System.in);
                percent = 1 + (scan.nextDouble() / 100);

                db.increasePrice( id, String.valueOf(percent) );
                break;
        }

    }
}