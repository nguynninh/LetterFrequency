module com.nguyenninh.letterfrequency {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.nguyenninh.letterfrequency to javafx.fxml;
    exports com.nguyenninh.letterfrequency;
    exports com.nguyenninh.letterfrequency.controllers;
    opens com.nguyenninh.letterfrequency.controllers to javafx.fxml;
    opens com.nguyenninh.letterfrequency.entity to javafx.base;
}