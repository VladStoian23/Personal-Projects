package gui;

import domain.Weather;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import service.Service;

import java.util.Collection;
import java.util.Set;

public class Controller {
    private Service service;
    private int Starting_hour,Ending_hour;
    public Controller(Service service) {
        this.service = service;
    }

    @FXML
    private ComboBox<String> DescriptionsComboBox;

    @FXML
    private ListView<Weather> ListViewForCombo;

    @FXML
    private ListView<Weather> SortedListView;

    void populateList()
    {
        Collection<Weather> obiectCollection=service.sortedByStartHoursFromRepository();//incerc sa ii dau altcv
        ObservableList<Weather> obiectObservableList= FXCollections.observableArrayList(obiectCollection);
        SortedListView.setItems(obiectObservableList);
    }


    void populeDescriptionComboBox()
    {
        Set<String> sourceDescriptions=service.getDescriptionInformation();
        DescriptionsComboBox.setItems(FXCollections.observableArrayList(sourceDescriptions));

    }

    void populateAvailableWeathers()
    {
        Collection<Weather> obiectCollection=service.availableWeather(String.valueOf(Starting_hour));
        ObservableList<Weather> obiectObservableList=FXCollections.observableArrayList(obiectCollection);
        ListViewForCombo.setItems(obiectObservableList);

    }

    public void initialize(){
        populateList();
        populeDescriptionComboBox();

        DescriptionsComboBox.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
            if(newValue!=null)
            {
                Starting_hour= Integer.parseInt(newValue);
                populeDescriptionComboBox();
                populateAvailableWeathers();//update the available object list
            }

        });
    }

}
