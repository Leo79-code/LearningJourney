package team.bupt.learningjourney.entities;

/**
 * @author Jiayi Meng
 * @date 2023/05/19
 * define an award object
 */
public class Award {
    private String awardName;
    private String year;
    private String kind;
    private String projectName;
    private String member;
    private String award;
    private double bonus;

    public Award() {
    }

    public Award(String awardName, String year, String kind, String projectName, String member, String award, double bonus) {
        this.awardName = awardName;
        this.year = year;
        this.kind = kind;
        this.projectName = projectName;
        this.member = member;
        this.award = award;
        this.bonus = bonus;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
