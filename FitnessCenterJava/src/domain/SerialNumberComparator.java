package domain;

import java.util.Comparator;

public class SerialNumberComparator implements Comparator<TrainingMachine> {

    @Override
    public int compare(TrainingMachine o1, TrainingMachine o2) {
        if (o1.getSerialNumber() > o2.getSerialNumber())
            return -1;
        else if (o1.getSerialNumber() < o2.getSerialNumber())
            return 1;
        else
            return 0;
    }

}
