package it.polito.tdp.flight;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.flight.model.Airline;
import it.polito.tdp.flight.model.Airport;
import it.polito.tdp.flight.model.Model;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FlightController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Airline> boxAirline;

    @FXML
    private ComboBox<Airport> boxAirport;

    @FXML
    private TextArea txtResult;

    private Model model;
    
    public void setModel(Model model) {
		this.model = model;
		boxAirline.getItems().addAll(model.getAllAirline());
	}
    
    @FXML
    void doRaggiungibili(ActionEvent event) {
    	
    }

    @FXML
    void doServiti(ActionEvent event) {
    	if(boxAirline.getValue() != null){
			Airline a = boxAirline.getValue(); 
			List<Airport> temp = new ArrayList<>(model.getAirportRaggiungibili(a));
			txtResult.setText(temp.toString());
			boxAirport.getItems().clear();
			boxAirport.getItems().addAll(temp);
    	}
    	else{
    		txtResult.setText("Errore");
    	}
    }

    @FXML
    void initialize() {
        assert boxAirline != null : "fx:id=\"boxAirline\" was not injected: check your FXML file 'Flight.fxml'.";
        assert boxAirport != null : "fx:id=\"boxAirport\" was not injected: check your FXML file 'Flight.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Flight.fxml'.";

    }

	
}
