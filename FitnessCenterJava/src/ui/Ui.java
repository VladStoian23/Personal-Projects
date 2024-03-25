package ui;

import domain.TrainingMachine;
import service.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Service service;

    public Ui(Service service) {
        this.service = service;
    }

    public void addMachine()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of machine (cardio or strength): ");
        String typeOfMachine = scanner.nextLine();

        System.out.println("Enter the serial number (int): ");
        int serialNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Specify if it requires regular maintenance (true/false)");
        boolean maintenance = scanner.nextBoolean();
        System.out.println(maintenance);
        if(typeOfMachine.equalsIgnoreCase("cardio"))
        {
            System.out.println("Enter the resistance level (int)");
            int resistanceLevel = scanner.nextInt();
            scanner.nextLine();
            service.addCardioMachine(serialNumber,maintenance,resistanceLevel);
        } else if (typeOfMachine.equalsIgnoreCase("strength")) {
            System.out.printf("Enter the muscle group: (legs/arms/core)");
            String muscleGroup = scanner.nextLine();

            System.out.println("Enter the motion level (int)");
            int motionLevel = scanner.nextInt();
            scanner.nextLine();
            service.addStrengthTrainingMachine(serialNumber,maintenance,muscleGroup,motionLevel);
        }
    }

    public void getAllMachines() {
        service.getAllMachines();
    }

    public void showMachinesCondition()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the price: ");
        int givenPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the level: ");
        int givenLevel = scanner.nextInt();
        scanner.nextLine();
        ArrayList<TrainingMachine> showMachines = service.showMachinesCondition(givenPrice,givenLevel);
        for(TrainingMachine machines: showMachines)
        {
            System.out.println(machines);
            System.out.printf("\n");
        }

    }

    public void displayMenu()

    {
        System.out.println("0 - Exit");
        System.out.println("1 - Add a new machine");
        System.out.println("2 - Get all machines");
        System.out.println("3 - Show machines based on condition");

    }

    public void run()
    {   while (true)
    {
        this.displayMenu();
        System.out.println("Input a command: ");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        switch (command)
        {
            case 0:
                return;
            case 1:
                addMachine();
                break;
            case 2:
                getAllMachines();
                break;
            case 3:
                showMachinesCondition();
                break;
        }
    }
    }
}
