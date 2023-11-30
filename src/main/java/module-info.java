module com.example.presents_sql {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.presents_sql to javafx.fxml;
    exports com.example.presents_sql;
}