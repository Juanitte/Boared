module com.juanite {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.sql;
    requires java.xml.bind;

    opens com.juanite to javafx.fxml;
    exports com.juanite;
    exports com.juanite.controller;
    exports com.juanite.model.domain;
    exports com.juanite.model.domain.interfaces;
    exports com.juanite.model.DAO;
    opens com.juanite.model.connections to java.xml.bind;
}
