package team.bupt.learningjourney.views.service.impl;

import team.bupt.learningjourney.utils.StyleUtil;
import team.bupt.learningjourney.views.service.IPageService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * @author
 */
public class Timetable implements IPageService {

    @Override
    public Node generatePage(Pane root) {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        Label test = new Label("Timetable");
        StyleUtil.setFont(test, Color.BLACK, 20);
        vbox.getChildren().add(test);
        return vbox;
    }

}