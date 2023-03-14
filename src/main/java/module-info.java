module team.bupt.learningjourney {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens team.bupt.learningjourney to javafx.fxml;
    exports team.bupt.learningjourney;
}