import service.Service;
import ui.Ui;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.addCardioMachine(1, true, 5);
        service.addStrengthTrainingMachine(2, false, "legs", 10);
        service.addStrengthTrainingMachine(3,true,"core", 20);
        Ui ui = new Ui(service);
        ui.run();
    }
}