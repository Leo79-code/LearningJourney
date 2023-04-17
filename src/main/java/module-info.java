module team.bupt.learningjourney {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.base;
    requires com.fasterxml.jackson.databind;

    exports team.bupt.learningjourney;
    exports team.bupt.learningjourney.utils;
    exports team.bupt.learningjourney.controller;
    exports team.bupt.learningjourney.entities;

    opens team.bupt.learningjourney.utils to javafx.fxml;
    opens team.bupt.learningjourney.controller to javafx.fxml;
    opens team.bupt.learningjourney.views.service.impl to javafx.base;
    opens team.bupt.learningjourney to javafx.fxml;
    opens team.bupt.learningjourney.entities to com.fasterxml.jackson.databind;
