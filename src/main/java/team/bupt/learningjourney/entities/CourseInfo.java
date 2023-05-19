package team.bupt.learningjourney.entities;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Tianhang Sun
 * @date 2023/05/19
 * There are basic properties of Course
 */
public class CourseInfo {
    private String courseNo;
    private String semester;
    private String courseName;
    private String property;
    private float credit;
    private float grade;


    /**
     * No parameter constructor
     */
    public CourseInfo() {
    }

    /**
     * @param courseNo
     * @param semester
     * @param courseName
     * @param property
     * @param credit
     * @param grade
     * Assigning values
     */
    public CourseInfo(String courseNo, String semester, String courseName, String property, float credit, float grade) {
        this.courseNo = courseNo;
        this.semester = semester;
        this.courseName = courseName;
        this.property = property;
        this.credit = credit;
        this.grade = grade;
    }

//    public CourseInfo(String awardName, String year, String kind, String projectName, String member, String award, double bonus) {
//    }

    /**
     * @return {@link String}
     * Getter:get courseNo value
     */
    public String getCourseNo() {
        return courseNo;
    }

    /**
     * @param courseNo
     * Setter: set courseNo value
     */
    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    /**
     * @return {@link String}
     * Getter:get semester value
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester
     * Setter: set semester value
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * @return {@link String}
     * Getter:get course name value
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName
     * Setter: set course name value
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return {@link String}
     * Getter:Get course property value
     */
    public String getProperty() {
        return property;
    }

    /**
     * @param property
     * Setter: set course property value
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @return float
     * Getter:Get course credit value
     */
    public float getCredit() {
        return credit;
    }

    /**
     * @param credit
     * Setter: set course credit value
     */
    public void setCredit(float credit) {
        this.credit = credit;
    }

    /**
     * @return float
     * Getter:Get course grade value
     */
    public float getGrade() {
        return grade;
    }

    /**
     * @param grade
     * Setter: set course grade value
     */
    public void setGrade(float grade) {
        this.grade = grade;
    }
}



