package students.logic;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Саманцов on 07.07.2015.
 */
public class ManagementSystem {
    private List<Group> groups;
    private Collection<Student> students;

    private static ManagementSystem instance;

    private ManagementSystem(){
        loadGroups();
        loadStudents();
    }

    public static synchronized ManagementSystem getInstance(){
        if(instance == null){
            instance = new ManagementSystem();
        }
        return instance;
    }

    public static void main(String[] args){
        try{
            System.setOut(new PrintStream("out.txt"));
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
            return;
        }

        ManagementSystem ms = ManagementSystem.getInstance();

        printString("All list of group");
        printString("*****************");
        List<Group> allGroups = ms.getGroups();
    }

    public List<Group> getGroups(){
        return groups;
    }

    public Collection<Student> getAllStudents(){
        return students;
    }

    public Collection<Student> getStudentsFromGroup(Group group, int year){
        Collection<Student> l = new TreeSet<Student>();
        for(Student si : students){
            if(si.getGroupId() == group.getGroupId() && si.getEducationYear() == year) {
                l.add(si);
            }
        }
        return l;
    }

    public void moveStudentsToGroup(Group oldGroup, int oldYear, Group newGroup, int newYear){
        for(Student si: students){
            if(si.getGroupId() == oldGroup.getGroupId() && si.getEducationYear() == oldYear){
                si.setGroupId(newGroup.getGroupId());
                si.setEducationYear(newYear);
            }
        }
    }

    public void removeStudentsFromGroup(Group group, int year){
        Collection<Student> tmp = new TreeSet<Student>();
        for(Student si : students){
            if(si.getGroupId() != group.getGroupId() || si.getEducationYear() != year){
                tmp.add(si);
            }
        }
        students = tmp;
    }

    public void insertStudent(Student student){
        students.add(student);
    }

    public void updateStudent(Student student){
        Student updStudent = null;
        for(Student si : students){
            if(si.getStudentId() == student.getStudentId()){
                updStudent = si;
                break;
            }
        }
        updStudent.setFirstName(student.getFirstName());
        updStudent.setPatronymic(student.getPatronymic());
        updStudent.setSurName(student.getSurName());
        updStudent.setSex(student.getSex());
        updStudent.setDateOfBirth(student.getDateOfBirth());
        updStudent.setGroupId(student.getGroupId());
        updStudent.setEducationYear(student.getEducationYear());
    }

    public void deleteStudent(Student student){
        Student delStudent = null;
        for(Student si : students){
            if(si.getStudentId() == student.getStudentId()){
                delStudent = si;
                break;
            }
        }
        students.remove(delStudent);
    }

    public void loadStudents(){
        if(students == null){
            students = new TreeSet<Student>();
        } else {
            students.clear();
        }

        Student s = null;
        Calendar c = Calendar.getInstance();

        s = new Student();
        s.setStudentId(1);
        s.setFirstName("Ivan");
        s.setPatronymic("Sergeevich");
        s.setSurName("Stepanov");
        s.setSex('M');
        c.set(1990, 3, 20);
        s.setDateOfBirth(c.getTime());
        s.setGroupId(2);
        s.setEducationYear(2006);
        students.add(s);

        s = new Student();
        s.setStudentId(2);
        s.setFirstName("Nataly");
        s.setPatronymic("Andreevna");
        s.setSurName("Chichikova");
        s.setSex('W');
        c.set(1990, 6, 10);
        s.setDateOfBirth(c.getTime());
        s.setGroupId(2);
        s.setEducationYear(2006);
        students.add(s);

        s = new Student();
        s.setStudentId(3);
        s.setFirstName("Peter");
        s.setPatronymic("Victorovych");
        s.setSurName("Sushkin");
        s.setSex('M');
        c.set(1991, 3, 12);
        s.setDateOfBirth(c.getTime());
        s.setEducationYear(2006);
        s.setGroupId(1);
        students.add(s);

        s = new Student();
        s.setStudentId(4);
        s.setFirstName("Veronika");
        s.setPatronymic("Sergeevna");
        s.setSurName("Kovaleva");
        s.setSex('W');
        c.set(1991, 7, 19);
        s.setDateOfBirth(c.getTime());
        s.setEducationYear(2006);
        s.setGroupId(1);
        students.add(s);
    }

    public void loadGroups(){}

    public static void printString(Object s){
        try{
            System.out.println(new String(s.toString().getBytes("windows-1251"), "windows-1252"));
        } catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
    }

    public static void printString(){
        System.out.println();
    }
}
