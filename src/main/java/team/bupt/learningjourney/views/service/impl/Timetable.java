package team.bupt.learningjourney.views.service.impl;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import team.bupt.learningjourney.views.service.IPageService;

import java.io.IOException;


/**
 * @author Liu Jian
 */
public class Timetable implements IPageService {

    @Override
    public Node generatePage(Pane root) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/view-timetable.fxml"));
        Parent node = null;
        try {
            node = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return node;
    }
}