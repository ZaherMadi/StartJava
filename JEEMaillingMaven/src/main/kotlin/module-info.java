module com.example.jeemaillingmaven {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens com.example.jeemaillingmaven to javafx.fxml;
    exports com.example.jeemaillingmaven;
}