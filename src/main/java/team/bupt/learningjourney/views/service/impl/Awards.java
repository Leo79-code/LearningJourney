package team.bupt.learningjourney.views.service.impl;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import team.bupt.learningjourney.utils.StyleUtil;
import team.bupt.learningjourney.views.service.IPageService;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.paint.Color;


/**
 * @author
 */
public class Awards implements IPageService {

    @Override
    public Node generatePage(Pane root) {
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(Background.fill(Color.rgb(242, 202, 42, .7)));

        //top design
        BorderPane top = new BorderPane();
        //top center design
        HBox topCenter = new HBox();
        topCenter.setMinHeight(89);

        Text Awards = new Text("Awards");
        Awards.setFont(Font.font("STLiti", FontWeight.BOLD, 50));
        Awards.setFill(Color.rgb(189, 49, 36));
        topCenter.setAlignment(Pos.CENTER);
        topCenter.getChildren().addAll(Awards);
        //top bottom design
        HBox topBottom = new HBox(30);
        topBottom.setMinHeight(60);
        Text Year = new Text("Year: ");
        Year.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));
        ChoiceBox choiceBox1 = new ChoiceBox(FXCollections.observableArrayList("2020-2021", "2021-2022", "2022-2023", "2023-2024"));
        Text Kind = new Text("Kind: ");
        Kind.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));
        ChoiceBox choiceBox2 = new ChoiceBox(FXCollections.observableArrayList("Innovation", "Subject", "Business", "Sports", "Art", "Honorary Title"));
        Button Query = new Button("Query");
        Query.setTextFill(Color.rgb(147, 210, 243));
        Query.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        topBottom.getChildren().addAll(Year, choiceBox1, Kind, choiceBox2, Query);
        topBottom.setAlignment(Pos.CENTER);

        top.setCenter(topCenter);
        top.setBottom(topBottom);


        //center design
        HBox center = new HBox();
        TableView<Awards> table = new TableView();
        TableColumn awardName = new TableColumn("Award Name");
        TableColumn year = new TableColumn("year");
        TableColumn kind = new TableColumn("kind");
        TableColumn projectName = new TableColumn("projectName");
        TableColumn member = new TableColumn("member");
        TableColumn award = new TableColumn("award");
        TableColumn bonus = new TableColumn("bonus");

        awardName.setMinWidth(125);
        year.setMinWidth(125);
        kind.setMinWidth(125);
        projectName.setMinWidth(125);
        member.setMinWidth(125);
        award.setMinWidth(125);
        bonus.setMinWidth(125);
        table.getColumns().addAll(awardName, year, kind, projectName, member, award, bonus);
        center.getChildren().addAll(table);
        center.setAlignment(Pos.CENTER);

        //bottom design
        HBox bottom = new HBox(200);
        Button Modify = new Button("Modify");
        Modify.setTextFill(Color.rgb(84, 188, 189, .7));
        Modify.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Button Add = new Button("Add");
        Add.setTextFill(Color.rgb(84, 188, 189, .7));
        Add.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Button Delete = new Button("Delete");
        Delete.setTextFill(Color.rgb(84, 188, 189, .7));
        Delete.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        bottom.setMinHeight(100);
        bottom.getChildren().addAll(Modify, Add, Delete);
        bottom.setAlignment(Pos.CENTER);

        borderPane.setTop(top);
        borderPane.setCenter(center);
        borderPane.setBottom(bottom);

        return borderPane;
    }

}
