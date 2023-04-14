package team.bupt.learningjourney.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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

    //readValue方法，将文件解析并且保存到List里，CoursesTime类就是POJO定义的
    public AwardsController(BorderPane bp) throws IOException {
        this.bp = bp;
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
