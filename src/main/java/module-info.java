module team.bupt.learningjourney {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens team.bupt.learningjourney to javafx.fxml;
    exports team.bupt.learningjourney;
    exports team.bupt.learningjourney.utils;
    opens team.bupt.learningjourney.utils to javafx.fxml;
}