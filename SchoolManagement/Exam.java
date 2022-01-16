package SchoolManagement;

import javax.swing.*;

public class Exam {
    private int examScore;
    public Course course;
    public Student student;

    public Exam(int examScore, Course course, Student student) {
        this.examScore = examScore;
        this.course = course;
        this.student = student;
    }

    public int getExamScore() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public void printResults(){
        String result = (student.name +"'s score is: " + getExamScore() + " in course " + course.courseName );
        JOptionPane.showMessageDialog(null,result);

    }
}

