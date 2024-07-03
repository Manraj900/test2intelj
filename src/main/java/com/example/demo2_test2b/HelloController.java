package com.example.demo2_test2b;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public TableView<User> productTable;
    public TableColumn<User,Integer> grade_id;
    public TableColumn <User,String> student_name;
    public TableColumn <User,String> subject;
    public TableColumn <User,String> score;
    public TextField ggrade_id;
    public TextField gstudent_name;
    public TextField gsubject;
    public TextField gscore;
    @FXML
    private Label welcomeText;

    ObservableList<User> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        fethdata();

    }

    private void fethdata() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/product";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM student_name";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int grade_id = resultSet.getInt("grade_id");
                String student_name = resultSet.getString("student_name");
                String subject = resultSet.getString("subject");
                String score = resultSet.getString("score");
                productTable.getItems().add(new User(grade_id, student_name, subject, score));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertData(ActionEvent actionEvent) {

        String student_name = gstudent_name.getText();
        String subject = gsubject.getText();
        String score = gscore.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/product";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `student_name`( `student_name`, `subject`, `score`) VALUES ('"+student_name+"','"+subject+"','"+score+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void UpdateData(ActionEvent actionEvent) {

        String grade_id = ggrade_id.getText();
        String student_name = gstudent_name.getText();
        String subject = gsubject.getText();
        String score = gscore.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/product";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `student_name` SET `student_name`='"+student_name+"',`subject`='"+subject+"',`score`='"+score+"' WHERE grade_id='"+grade_id+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {

        String grade_id = ggrade_id.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/product";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM student_name WHERE grade_id='"+grade_id+"'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {

                String student_name = resultSet.getString("student_name");
                String subject = resultSet.getString("subject");
                String score = resultSet.getString("score");

                gstudent_name.setText(student_name);
                gsubject.setText(subject);
                gscore.setText(score);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void DeleteData(ActionEvent actionEvent) {

        String grade_id = ggrade_id.getText();




        String jdbcUrl = "jdbc:mysql://localhost:3306/product";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM `student_name` WHERE grade_id='"+grade_id+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grade_id.setCellValueFactory(new PropertyValueFactory<User,Integer>("grade_id"));
        student_name.setCellValueFactory(new PropertyValueFactory<User,String>("student_name"));
        subject.setCellValueFactory(new PropertyValueFactory<User,String>("subject"));
        score.setCellValueFactory(new PropertyValueFactory<User,String>("score"));
        productTable.setItems(list);

    }
}