module com.example.zeiterfassung_atl {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.zeiterfassung_atl to javafx.fxml;
    exports com.example.zeiterfassung_atl;
}