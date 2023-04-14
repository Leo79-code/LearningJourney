package team.bupt.learningjourney.entities;

import javafx.beans.property.SimpleStringProperty;
public class CourseInfo {
    private String courseNo;
    private String semester;
    private String courseName;
    private String property;
    private float credit;
    private float grade;


    public CourseInfo() {
    }

    public CourseInfo(String courseNo, String semester, String courseName, String property, float credit, float grade) {
        this.courseNo = courseNo;
        this.semester = semester;
        this.courseName = courseName;
        this.property = property;
        this.credit = credit;
        this.grade = grade;
    }

    public CourseInfo(String awardName, String year, String kind, String projectName, String member, String award, double bonus) {
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}



