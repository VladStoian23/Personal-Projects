package service;

import domain.CardioMachine;
import domain.SerialNumberComparator;
import domain.StrengthTrainingMachine;
import domain.TrainingMachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Service {
    protected ArrayList<TrainingMachine> MemElements = new ArrayList<TrainingMachine>();

    public void addCardioMachine(int serialNumber, boolean maintenance, int resistanceLevel){
        for(TrainingMachine trainingMachine: MemElements)
        {
            if(trainingMachine.getSerialNumber() == serialNumber)
                return;
        }
        CardioMachine cardioMachineToAdd = new CardioMachine(serialNumber, maintenance, resistanceLevel);
        MemElements.add(cardioMachineToAdd);
    }

    public void addStrengthTrainingMachine(int serialNumber, boolean maintenance, String muscleGroup, int motionLevel)
    {
        for(TrainingMachine trainingMachine: MemElements)
        {
           if(trainingMachine.getSerialNumber() == serialNumber)
               return;
        }
        StrengthTrainingMachine strengthTrainingMachineToAdd = new StrengthTrainingMachine(serialNumber, maintenance, muscleGroup, motionLevel);
        MemElements.add(strengthTrainingMachineToAdd);
    }

    public void getAllMachines()
    {
        for(TrainingMachine trainingMachine: MemElements)
        {
            System.out.printf(trainingMachine.toString());
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }
    public ArrayList<TrainingMachine> showMachinesCondition(int givenPrice, int givenLevel)
    {
        ArrayList<TrainingMachine> sortedConditionList;
        sortedConditionList = (ArrayList<TrainingMachine>) MemElements.stream()
                .filter(machine->machine.getPrice()<givenPrice)
                .filter(machine -> {
                    if(machine instanceof CardioMachine)
                        return ((CardioMachine) machine).getResistanceLevel()>givenLevel;
                    else return ((StrengthTrainingMachine) machine).getMotionLevel()>givenLevel;
                })
                .collect(Collectors.toList());
        sortedConditionList.sort(new SerialNumberComparator());
        return sortedConditionList;
    }

    public ArrayList<TrainingMachine> MaintenanceIsNeeded() {
        return MemElements.stream()
                .filter(TrainingMachine::isMaintenance)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            MaintenanceIsNeeded().forEach(machine -> {
                try {
                    writer.write(machine.toString());
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
