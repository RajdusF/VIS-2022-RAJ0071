package App;

import DataLayer.Database.Gateway;
import DataLayer.File.MyFileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean dbSelected = false;
        boolean fileSelected = false;
        double percent;
        boolean exit = false;

        Gateway db = new Gateway();
        MyFileReader fr = new MyFileReader();

        System.out.println("Select operating storage:");
        System.out.println(" 0 - Database");
        System.out.println(" 1 - File");
        System.out.print("OPTION: ");

        BufferedReader ans = new BufferedReader(new InputStreamReader(System.in));
        String answer = ans.readLine();

        System.out.println();

        if(answer.equals("0"))
        {
            dbSelected = true;
            System.out.println("Database selected");
        }


        if(answer.equals("1")) {
            fileSelected = true;
            System.out.println("File selected");
        }

        do {
            if(dbSelected) {
                System.out.println(" 0 - Exit");
                System.out.println(" 1 - Show Vehicles");
                System.out.println(" 2 - Show Users");
                System.out.println(" 3 - Add User");
                System.out.println(" 4 - Add Vehicle");
                System.out.println(" 5 - Find Vehicle");
                System.out.println(" 6 - Increase Vehicle cost");
                System.out.println(" 7 - Increase Vehicle cost by id");

                System.out.print("\nOPTION: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                answer = ans.readLine();

                switch (answer) {
                    case "0":
                        exit = true;
                        break;

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
                        String surname = ans.readLine();

                        db.addUser(name, surname);
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

                        db.increasePrice(String.valueOf(percent));
                        break;

                    case "7":
                        System.out.println("id: ");
                        ans = new BufferedReader(new InputStreamReader(System.in));
                        String id = ans.readLine();

                        System.out.println("increase by (%): ");
                        scan = new Scanner(System.in);
                        percent = 1 + (scan.nextDouble() / 100);

                        //TRANSACTION SCRIPT
                        db.increasePrice(id, String.valueOf(percent));
                        break;
                }
            }

            if(fileSelected) {
                System.out.println(" 0 - Exit");
                System.out.println(" 1 - Show Vehicles");
                System.out.println(" 2 - Show Users");
                System.out.println(" 3 - Add User");
                System.out.println(" 4 - Add Vehicle");
                System.out.println(" 5 - Find Vehicle");

                System.out.print("\nOPTION: ");
                ans = new BufferedReader(new InputStreamReader(System.in));
                answer = ans.readLine();

                switch (answer) {
                    case "0":
                        exit = true;
                        break;

                    case "1":
                        fr.showVehicles();
                        break;

                    case "2":
                        fr.showUsers();
                        break;

                    case "3":
                        System.out.println("Name: ");
                        ans = new BufferedReader(new InputStreamReader(System.in));
                        String name = ans.readLine();

                        System.out.println("Surname: ");
                        ans = new BufferedReader(new InputStreamReader(System.in));
                        String surname = ans.readLine();

                        fr.addUser(name, surname);
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

                        fr.addVehicle(title, type, sellingPrice, productionPrice);
                        break;

                    case "5":
                        System.out.println("title: ");
                        ans = new BufferedReader(new InputStreamReader(System.in));
                        String toFind = ans.readLine();

                        fr.findVehicle(toFind);
                        break;
                }
            }

            System.out.println("\n");
        }while(!exit);
    }
}