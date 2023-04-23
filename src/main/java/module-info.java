module com.juanite {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;

    opens com.juanite to javafx.fxml;
    exports com.juanite;
    exports com.juanite.controller;
}
