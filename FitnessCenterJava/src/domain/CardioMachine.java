package domain;

public class CardioMachine extends TrainingMachine{
    private int ResistanceLevel;

    public CardioMachine(int serialNumber, boolean maintenance, int resistanceLevel) {
        super(serialNumber, maintenance);
        this.ResistanceLevel = resistanceLevel;
    }

    @Override
    public int getPrice() {
        if (ResistanceLevel < 10)
            if (Maintenance) return 1000;
            else return 500;
        else
            if (Maintenance) return 400;
            else return 200;
    }

    public int getResistanceLevel() {
        return ResistanceLevel;
    }

    public void setResistanceLevel(int resistanceLevel) {
        ResistanceLevel = resistanceLevel;
    }

    @Override
    public String toString() {
        return "CardioMachine{" +
                "ResistanceLevel=" + ResistanceLevel +
                ", SerialNumber=" + SerialNumber +
                ", Maintenance=" + Maintenance + ", Price=" + getPrice() +
                '}';
    }
}
