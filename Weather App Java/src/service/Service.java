package service;

import domain.StartingHoursComparator;
import domain.Weather;
import repository.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Service {
    private Repository repo;

    public Service(Repository repo) {
        this.repo = repo;
    }

    public ArrayList<Weather> getAllRoutesFromRepository(){
        return repo.getAllWeathers();
    }
//sort by start hours
    public ArrayList<Weather> sortedByStartHoursFromRepository(){
        ArrayList<Weather> sortedObiecte = (ArrayList<Weather>) repo.getAllWeathers().stream()
                .sorted(new StartingHoursComparator())
                .collect(Collectors.toList());
        return sortedObiecte;
    }


    public Set<String> getDescriptionInformation(){
        Set<String> Descriptions = new HashSet<>();
        for(Weather obieect: repo.getAllWeathers())
        {
            Descriptions.add(obieect.getDescription());
        }
        return Descriptions;
    }
  public ArrayList<Weather> availableWeather(String description)
    {
        ArrayList<Weather> available = (ArrayList<Weather>) repo.getAllWeathers().stream()
                .filter(object -> object.getDescription().equals(description))
                .collect(Collectors.toList());
        return available;
    }
    /*!!!!!!!!for the description filtering after the combo box things !!!!!!!!!!!! */



}
