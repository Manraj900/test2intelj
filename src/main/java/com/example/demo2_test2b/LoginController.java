package com.example.demo2_test2b;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {

    public Button loginbutton;
    public TextField user_id;
    public TextField username;
    public TextField email;
    public TextField password;
    public Label message;

    public void LoginClick(ActionEvent actionEvent){

        String user_name=username.getText() ;
        String l_email=email.getText();
        String l_password=password.getText();







    }
}
