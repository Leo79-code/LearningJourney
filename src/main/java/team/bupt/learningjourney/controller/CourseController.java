package team.bupt.learningjourney.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import team.bupt.learningjourney.entities.CourseInfo;
import team.bupt.learningjourney.entities.Journal;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CourseController {
    BorderPane bp = new BorderPane();
    //定义的变量
    ObjectMapper objectMapper = new ObjectMapper();
    //Jackson库用于数据绑定的类
    File jsonFile = new File("src/main/resources/json/Courses.json");
    //json文件
    JsonNode rootNode = objectMapper.readTree(jsonFile);
    //树模型的json节点
    List<CourseInfo> courses = objectMapper.readValue(jsonFile, new TypeReference<>() {
    });

    //readValue方法，将文件解析并且保存到List里，CoursesTime类就是POJO定义的
    public CourseController(BorderPane bp) throws IOException {
        this.bp = bp;
    }

    public BorderPane loadFile() {

        TableView<CourseInfo> table = new TableView<>();



        final ObservableList<CourseInfo>data = FXCollections.observableArrayList();

        TableColumn<CourseInfo, String> NoCol = new TableColumn<>("No");
        NoCol.setMinWidth(75);
        NoCol.setCellValueFactory(new PropertyValueFactory<>("no"));

        NoCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        NoCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCourseNo(t.getNewValue());
                });


        TableColumn<CourseInfo, String> SemesterCol =
                new TableColumn<>("Semester");
        SemesterCol.setMinWidth(175);
        SemesterCol.setCellValueFactory(
                new PropertyValueFactory<>("semester"));
        SemesterCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        SemesterCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSemester(t.getNewValue());
                });

        TableColumn<CourseInfo, String> NameCol = new TableColumn<>("Name");
        NameCol.setMinWidth(175);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        NameCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        NameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCourseName(t.getNewValue());
                });

        TableColumn<CourseInfo, String> PropertyCol = new TableColumn<>("Property");
        PropertyCol.setMinWidth(160);
        PropertyCol.setCellValueFactory(
                new PropertyValueFactory<>("property"));
        PropertyCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        PropertyCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProperty(t.getNewValue());
                });

        TableColumn<CourseInfo, String> CreditCol = new TableColumn<>("Credit");
        CreditCol.setMinWidth(145);
        CreditCol.setCellValueFactory(
                new PropertyValueFactory<>("credit"));
        CreditCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        CreditCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCredit(Float.parseFloat(t.getNewValue()));
                });

        TableColumn<CourseInfo, String> GradeCol = new TableColumn<>("Grade");
        GradeCol.setMinWidth(145);
        GradeCol.setCellValueFactory(
                new PropertyValueFactory<>("grade"));
        GradeCol.setCellFactory(TextFieldTableCell.<CourseInfo>forTableColumn());
        GradeCol.setOnEditCommit(
                (TableColumn.CellEditEvent<CourseInfo, String> t) -> {
                    ((CourseInfo) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGrade(Float.parseFloat(t.getNewValue()));
                });
        table.setEditable(true);
        table.getColumns().addAll(NoCol, SemesterCol, NameCol, PropertyCol, CreditCol, GradeCol);
        NoCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCourseNo()));
        SemesterCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSemester()));
        NameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCourseName()));
        PropertyCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProperty()));
        CreditCol.setCellValueFactory(cellData -> new SimpleStringProperty(Float.toString(cellData.getValue().getCredit())));
        GradeCol.setCellValueFactory(cellData -> new SimpleStringProperty(Float.toString(cellData.getValue().getGrade())));


        for (CourseInfo course : courses) {
            data.add(
                    new CourseInfo(course.getCourseNo(), course.getSemester(), course.getCourseName(), course.getProperty(), course.getCredit(), course.getGrade())
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

