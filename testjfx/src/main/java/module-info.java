module com.example.testjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.persistence;


    //requires org.controlsfx.controls;

    opens com.example.testjfx to javafx.fxml;
    exports com.example.testjfx;
    exports com.example.testjfx.model;
    opens com.example.testjfx.model to javafx.fxml;
}