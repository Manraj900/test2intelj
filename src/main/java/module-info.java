module com.example.demo2_test2b {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.demo2_test2b to javafx.fxml;
    exports com.example.demo2_test2b;
}