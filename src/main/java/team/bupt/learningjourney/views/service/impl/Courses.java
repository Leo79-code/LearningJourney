package team.bupt.learningjourney.views.service.impl;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Callback;
import team.bupt.learningjourney.utils.StyleUtil;
import team.bupt.learningjourney.views.service.IPageService;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * @author
 */
public class Courses implements IPageService {


    private final TableView<Person> table = new TableView<>();

    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person(1, "2021-2022-1", "Java", "Professional",4,99),
                    new Person(2, "2021-2022-2", "Database", "Professional",3,98)
            );
    final HBox hb = new HBox();

    @Override
    public Node generatePage(Pane root) {


        //final Label label = new Label("School Report");
        //label.setFont(new Font("Arial", 20));
        Text label = new Text("Courses");
        label.setFont(Font.font("STLiti", FontWeight.BOLD,50));
        label.setFill(Color.rgb(189,49,36));

        table.setEditable(true);

        TableColumn<Person, String> NoCol =
                new TableColumn<>("No");
        NoCol.setMinWidth(75);
        NoCol.setCellValueFactory(
                new PropertyValueFactory<>("no"));

        NoCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        NoCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setNo(Integer.parseInt(t.getNewValue()));
                });


        TableColumn<Person, String> SemesterCol =
                new TableColumn<>("Semester");
        SemesterCol.setMinWidth(175);
        SemesterCol.setCellValueFactory(
                new PropertyValueFactory<>("semester"));
        SemesterCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        SemesterCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setSemester(t.getNewValue());
                });

        TableColumn<Person, String> NameCol = new TableColumn<>("Name");
        NameCol.setMinWidth(175);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        NameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        NameCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setName(t.getNewValue());
                });

        TableColumn<Person, String> PropertyCol = new TableColumn<>("Property");
        PropertyCol.setMinWidth(160);
        PropertyCol.setCellValueFactory(
                new PropertyValueFactory<>("property"));
        PropertyCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        PropertyCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setProperty(t.getNewValue());
                });

        TableColumn<Person, String> CreditCol = new TableColumn<>("Credit");
        CreditCol.setMinWidth(145);
        CreditCol.setCellValueFactory(
                new PropertyValueFactory<>("credit"));
        CreditCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        CreditCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setCredit(Integer.parseInt(t.getNewValue()));
                });

        TableColumn<Person, String> GradeCol = new TableColumn<>("Grade");
        GradeCol.setMinWidth(145);
        GradeCol.setCellValueFactory(
                new PropertyValueFactory<>("grade"));
        GradeCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        GradeCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setGrade(Integer.parseInt(t.getNewValue()));
                });


        table.setItems(data);
        table.getColumns().addAll(NoCol,SemesterCol, NameCol,PropertyCol,CreditCol,GradeCol);

        //final TextField addsubject = new TextField();
        //addsubject.setPromptText("First Name");
        //addsubject.setMaxWidth(subjectCol.getPrefWidth());
        //final TextField addachievement = new TextField();
        //addachievement.setMaxWidth(achievementCol.getPrefWidth());
        //addachievement.setPromptText("Last Name");
        //final TextField addgrade = new TextField();
        //addgrade.setMaxWidth(gradeCol.getPrefWidth());
        //addgrade.setPromptText("grade");

        final Button ImButton = new Button("Import Data");
        ImButton.setTextFill(Color.rgb(84,188,189,.7));
        ImButton.setFont(Font.font("Verdana", FontWeight.BOLD, 15));


        //hb.getChildren().addAll(addsubject, addachievement, addgrade, expButton);
        hb.getChildren().addAll(ImButton);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(40, 0, 40, 0));
        hb.setSpacing(3);

        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(10);
        hbox1.setPadding(new Insets(40, 0, 40, 0));
        hbox1.getChildren().addAll(label);

        final VBox vbox = new VBox();
        vbox.setSpacing(0);
        //vbox.setAlignment(Pos.CENTER);
        //vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb);

        BorderPane bp = new BorderPane();
        bp.setBackground(Background.fill(Color.rgb(242,202,42,.7)));
        bp.setPadding(new Insets(0, 120, 0, 120));
        bp.setTop(hbox1);
        bp.setCenter(vbox);



        //VBox vbox = new VBox();
        //vbox.setAlignment(Pos.CENTER);
        //vbox.setPadding(new Insets(20,10,10,50));
        //vbox.setSpacing(10);

        //Label test = new Label("School Report");
        //StyleUtil.setFont(test, Color.BLACK, 20);
        //vbox.getChildren().add(test);

        //GridPane gridPane = new GridPane();
        //gridPane.setGridLinesVisible(true);
        //gridPane.setVgap(5);
        //gridPane.setHgap(10);
        //gridPane.setAlignment(Pos.CENTER);

        //HBox hbox1 = new HBox();
        //hbox1.setAlignment(Pos.CENTER);

        //Text text1 = new Text("School Report");

        //hbox1.getChildren().add(text1);
        //gridPane.add(text1,0,0);


        return bp;
    }
    public static class Person {

        private final SimpleStringProperty No;
        private final SimpleStringProperty Semester;
        private final SimpleStringProperty Name;
        private final SimpleStringProperty Property;
        private final SimpleStringProperty Credit;
        private final SimpleStringProperty Grade;



        private Person(int No, String Semester, String Name, String Property, int Credit, int Grade) {
            this.No = new SimpleStringProperty(Integer.toString(No));
            this.Semester = new SimpleStringProperty(Semester);
            this.Name = new SimpleStringProperty(Name);
            this.Property = new SimpleStringProperty(Property);
            this.Credit = new SimpleStringProperty(Integer.toString(Credit));
            this.Grade = new SimpleStringProperty(Integer.toString(Grade));
        }

        public String getNo() {
            return No.get();
        }

        public void setNo(int no) {
            No.set(Integer.toString(no));
        }

        public String getSemester() {
            return Semester.get();
        }

        public void setSemester(String sem) {
            Semester.set(sem);
        }

        public String Name() {
            return Name.get();
        }

        public void setName(String name) {
            Name.set(name);
        }

        public String getProperty() { return Property.get(); }

        public void setProperty(String pro) {
            Property.set(pro);
        }
        public String getCredit() {
            return Credit.get();
        }

        public void setCredit(int cre) {
            Credit.set(Integer.toString(cre));
        }
        public String getGrade() {
            return Grade.get();
        }

        public void setGrade(int gra) {
            Grade.set(Integer.toString(gra));
        }
    }
}