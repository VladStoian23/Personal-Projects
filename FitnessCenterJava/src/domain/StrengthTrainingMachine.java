package domain;

import java.util.Objects;

public class StrengthTrainingMachine extends TrainingMachine{
    private int MotionLevel;
    private String muscleGroup;

    public StrengthTrainingMachine(int serialNumber, boolean maintenance, String muscleGroup, int motionLevel) {
        super(serialNumber, maintenance);
        this.muscleGroup = muscleGroup;
        this.MotionLevel = motionLevel;
    }

    public int getMotionLevel() {
        return MotionLevel;
    }

    public void setMotionLevel(int motionLevel) {
        MotionLevel = motionLevel;
    }

    @Override
    public String toString() {
        return "StrengthTrainingMachine{" +
                "MotionLevel=" + MotionLevel +
                ", SerialNumber=" + SerialNumber +
                ", Maintenance=" + Maintenance + ", Price=" + getPrice() +
                '}';
    }

    @Override
    public int getPrice() {
        if(Objects.equals(muscleGroup, "arms") || Objects.equals(muscleGroup, "legs"))
        {
            if(Maintenance)
                return 1200;
            else
                return 600;
        } else
            if(Maintenance)
                return 1600;
            else
                return 800;
    }


}
