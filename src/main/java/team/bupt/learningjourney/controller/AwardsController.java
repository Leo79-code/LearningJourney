package team.bupt.learningjourney.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import team.bupt.learningjourney.entities.Award;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AwardsController {
    BorderPane bp = new BorderPane();
    //定义的变量
    ObjectMapper objectMapper = new ObjectMapper();
    //Jackson库用于数据绑定的类
    File jsonFile = new File("src/main/resources/json/Awards.json");
    //json文件
    JsonNode rootNode = objectMapper.readTree(jsonFile);
    //树模型的json节点
    List<Award> awards = objectMapper.readValue(jsonFile, new TypeReference<>() {
    });
    String year;
    String kind;
    //readValue方法，将文件解析并且保存到List里，CoursesTime类就是POJO定义的
    public AwardsController(BorderPane borderPane) throws IOException {
        this.bp = borderPane;
        //top design
        BorderPane top = new BorderPane();
        top.setPadding(new Insets(40, 0, 40, 0));
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
        ChoiceBox<String> choiceBox1 = new ChoiceBox<String>(FXCollections.observableArrayList("2020-2021", "2021-2022", "2022-2023", "2023-2024"));
        choiceBox1.setOnAction(e->year=choiceBox1.getSelectionModel().getSelectedItem());

        Text Kind = new Text("Kind: ");
        Kind.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));
        ChoiceBox<String> choiceBox2 = new ChoiceBox<String>(FXCollections.observableArrayList("Innovation", "Subject", "Business", "Sports", "Art", "Honorary Title"));
        choiceBox2.setOnAction(e->kind=choiceBox2.getSelectionModel().getSelectedItem());
        Button Query = new Button("Query");
        Query.setTextFill(Color.rgb(147, 210, 243));
        Query.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        topBottom.getChildren().addAll(Year, choiceBox1, Kind, choiceBox2, Query);
        topBottom.setAlignment(Pos.CENTER);

        top.setCenter(topCenter);
        top.setBottom(topBottom);


        borderPane.setTop(top);

        Query.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("year : "+year);
                System.out.println("kind : "+kind);
                loadFile();
            }
        });

    }

    public BorderPane loadFile() {

        TableView<Award> table = new TableView<>();

        final ObservableList<Award> data = FXCollections.observableArrayList();

        TableColumn<Award, String> awardNameCol = new TableColumn<>("Award Name");
        awardNameCol.setMinWidth(200);
        awardNameCol.setCellValueFactory(new PropertyValueFactory<>("awardName"));

        awardNameCol.setCellFactory(TextFieldTableCell.<Award>forTableColumn());
        awardNameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Award, String> t) -> {
                    ((Award) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setAwardName(t.getNewValue());
                });


        TableColumn<Award, String> yearCol =
                new TableColumn<>("Year");
        yearCol.setMinWidth(75);
        yearCol.setCellValueFactory(
                new PropertyValueFactory<>("year"));
        yearCol.setCellFactory(TextFieldTableCell.<Award>forTableColumn());
        yearCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Award, String> t) -> {
                    ((Award) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setYear(t.getNewValue());
                });

        TableColumn<Award, String> kindCol = new TableColumn<>("Kind");
        kindCol.setMinWidth(115);
        kindCol.setCellValueFactory(
                new PropertyValueFactory<>("kind"));
        kindCol.setCellFactory(TextFieldTableCell.<Award>forTableColumn());
        kindCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Award, String> t) -> {
                    ((Award) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setKind(t.getNewValue());
                });

        TableColumn<Award, String> projectNameCol = new TableColumn<>("Project Name");
        projectNameCol.setMinWidth(195);
        projectNameCol.setCellValueFactory(
                new PropertyValueFactory<>("projectName"));
        projectNameCol.setCellFactory(TextFieldTableCell.<Award>forTableColumn());
        projectNameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Award, String> t) -> {
                    ((Award) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProjectName(t.getNewValue());
                });

        TableColumn<Award, String> memberCol = new TableColumn<>("Member");
        memberCol.setMinWidth(145);
        memberCol.setCellValueFactory(
                new PropertyValueFactory<>("member"));
        memberCol.setCellFactory(TextFieldTableCell.<Award>forTableColumn());
        memberCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Award, String> t) -> {
                    ((Award) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setMember(t.getNewValue());
                });

        TableColumn<Award, String> awardCol = new TableColumn<>("Award");
        awardCol.setMinWidth(125);
        awardCol.setCellValueFactory(
                new PropertyValueFactory<>("award"));
        awardCol.setCellFactory(TextFieldTableCell.<Award>forTableColumn());
        awardCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Award, String> t) -> {
                    ((Award) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setAward(t.getNewValue());
                });

        TableColumn<Award, String> bonusCol = new TableColumn<>("Bonus");
        bonusCol.setMinWidth(75);
        bonusCol.setCellValueFactory(
                new PropertyValueFactory<>("bonus"));
        bonusCol.setCellFactory(TextFieldTableCell.<Award>forTableColumn());
        bonusCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Award, String> t) -> {
                    ((Award) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setBonus(Double.parseDouble(t.getNewValue()));
                });

        table.setEditable(true);
        table.getColumns().addAll(awardNameCol, yearCol, kindCol, projectNameCol, memberCol, awardCol,bonusCol);
        awardNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAwardName()));
        yearCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getYear()));
        kindCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKind()));
        projectNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProjectName()));
        memberCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMember()));
        awardCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAward()));
        bonusCol.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getBonus())));

        for (Award award : awards) {
            data.add(
                    new Award(award.getAwardName(), award.getYear(), award.getKind(), award.getProjectName(), award.getMember(), award.getAward(),award.getBonus())
            );
        }
        table.setItems(data);


        final VBox vbox = new VBox();
        vbox.setSpacing(0);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);


        bp.setCenter(vbox);

        return this.bp;
    }
}
