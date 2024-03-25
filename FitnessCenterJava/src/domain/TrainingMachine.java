package domain;

public abstract class TrainingMachine {
    protected int SerialNumber;
    protected boolean Maintenance;
    public abstract int getPrice();

    public TrainingMachine(int serialNumber, boolean maintenance) {
        SerialNumber = serialNumber;
        Maintenance = maintenance;
    }

    public int getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        SerialNumber = serialNumber;
    }

    public boolean isMaintenance() {
        return Maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        Maintenance = maintenance;
    }

    public String toString() {
        return "TrainingMachine{" +
                "SerialNumber = " + SerialNumber +
                ", Maintenance = " + Maintenance + ", Price=" + getPrice() +
                '}';
    }


}
