package team.bupt.learningjourney.views.service.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import team.bupt.learningjourney.views.service.IPageService;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import team.bupt.learningjourney.entities.CourseInfo;
import javafx.scene.layout.Background;
import team.bupt.learningjourney.controller.CourseController;

import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import java.io.IOException;

/**
 * @author
 */
public class Courses implements IPageService {



    @Override
    public Node generatePage(Pane root)  {



        Text label = new Text("Courses");
        label.setFont(Font.font("STLiti", FontWeight.BOLD, 50));
        label.setFill(Color.rgb(189, 49, 36));













        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(10);
        hbox1.setPadding(new Insets(40, 0, 40, 0));
        hbox1.getChildren().addAll(label);



        BorderPane bp = new BorderPane();
        bp.setBackground(Background.fill(Color.rgb(242, 202, 42, .7)));
        bp.setPadding(new Insets(0, 120, 0, 120));
        bp.setTop(hbox1);





        try {
            CourseController sr = new CourseController(bp);
            bp = sr.loadFile();

            return bp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}








