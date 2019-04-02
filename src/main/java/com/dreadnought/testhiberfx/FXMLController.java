package com.dreadnought.testhiberfx;

import com.dreadnought.model.Person;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {
    PersonController controller = new PersonController();
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField textfield;
    @FXML
    private Button deletebtn;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (!textfield.getText().trim().equals("")) {
            if (controller.getPerson(textfield.getText()) == null) {
                Person p = new Person(textfield.getText().toUpperCase());
                controller.crearPerson(p);  
            }else{
                label.setText("Ese nombre ya esta en la lista!.");
            }
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void delete(ActionEvent event) {
        if (!textfield.getText().trim().equals("")) {
            if (controller.deletePerson(textfield.getText()) != null) {
                label.setText("Ese nombre ha sido borrado de la lista!.");
            }else{
                label.setText("Ese nombre no existe en la lista!.");
            }
        }
    }

    @FXML
    private void mouseClicked(MouseEvent event) {
        label.setText("");
    }
}
