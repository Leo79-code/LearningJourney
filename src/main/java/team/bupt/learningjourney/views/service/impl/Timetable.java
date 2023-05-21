package team.bupt.learningjourney.views.service.impl;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import java.io.IOException;

import team.bupt.learningjourney.views.service.IPageService;

/**
 * @author Liu Jian
 * @date 2023/03/27
 * Load FXML pages and return page nodes
 *
 */
public class Timetable implements IPageService {

    @Override
    public Node generatePage(Pane root) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/view-timetable.fxml"));
        Parent node;
        try {
            node = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return node;
    }
}