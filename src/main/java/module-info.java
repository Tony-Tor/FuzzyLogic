module org.astu.students.fuzzylogic {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.astu.students.fuzzylogic to javafx.fxml;
    exports org.astu.students.fuzzylogic;
}