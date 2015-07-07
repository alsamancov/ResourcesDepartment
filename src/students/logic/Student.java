package students.logic;

import java.text.Collator;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Саманцов on 07.07.2015.
 */
public class Student implements Comparable {
    private int studentId;
    private String firstName;
    private String surName;
    private String patronymic;
    private Date dateOfBirth;
    private char sex;
    private int groupId;
    private int educationYear;

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setEducationYear(int educationYear) {
        this.educationYear = educationYear;
    }

    public int getStudentId() {

        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public char getSex() {
        return sex;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getEducationYear() {
        return educationYear;
    }

    public String toString(){
        return surName + " " + firstName + " " + patronymic + ", "
                + DateFormat.getDateInstance(DateFormat.SHORT).format(dateOfBirth)
                + ", Group ID=" + groupId + " Year:" + educationYear;
    }

    @Override
    public int compareTo(Object obj) {
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), obj.toString());
    }
}
