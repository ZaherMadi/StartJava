module com.example.testjfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    //requires org.controlsfx.controls;

    opens com.example.testjfx to javafx.fxml;
    exports com.example.testjfx;
}