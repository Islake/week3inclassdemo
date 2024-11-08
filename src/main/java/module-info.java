module com.example.week3inclassdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week3inclassdemo to javafx.fxml;
    exports com.example.week3inclassdemo;
}