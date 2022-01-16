package SchoolManagement;

import javax.swing.*;
import java.util.ArrayList;
import java.lang.String;

public class School {

    //VARIABLES
    private Teacher loggedInTeacher;
    private Student loggedInStudent;
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Exam> exams = new ArrayList<>();

    //CONSTRUCTOR

    public School() {
    }

    //GETTERS SETTERS
    public Teacher getLoggedInTeacher() {
        return loggedInTeacher;
    }

    public void setLoggedInTeacher(Teacher loggedInTeacher) {
        this.loggedInTeacher = loggedInTeacher;
    }

    public Student getLoggedInStudent() {
        return loggedInStudent;
    }

    public void setLoggedInStudent(Student loggedInStudent) {
        this.loggedInStudent = loggedInStudent;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
    }

    //LOGIN AND MENU METHODS

    public String createAccount() {

        String[] optionsAcc = {"teacher", "student"};
        String optChoiceTwo = (String) JOptionPane.showInputDialog(
                null,
                "Hello, are you a student or a teacher?",
                "Create an account",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsAcc,
                optionsAcc[0]
        );
        if (optChoiceTwo.equals("teacher")) {
            String teacherName = getName();
            if (teacherName != null) {
                String teacherPswrd = getPassword();
                Teacher teacher = new Teacher(teacherName, teacherPswrd);
                teachers.add(teacher);
                return "Account for teacher " + teacherName + " was made successfully";
            }
            return "Something went wrong in createAccount";
        } else if (optChoiceTwo.equals("student")) {
            String studentName = getName();
            if (studentName != null) {
                String studentPswrd = getPassword();
                Student student = new Student(studentName, studentPswrd);
                students.add(student);
                return "Account for student: " + studentName + " was made successfully";
            }
            return "Something went wrong in createAccount";
        } else {
            return "Something went wrong in createAccount";
        }

    }

    private String getName() {

        String name = JOptionPane.showInputDialog("Enter username");
        boolean exists = checkExists(name);

        if (exists) {
            JOptionPane.showMessageDialog(null, "Someone with your name already has an account");
            return null;
        } else {
            return name;
        }

    }
    private String getPassword() {
        String password = "";
        boolean doubleChecked = false;
        while (!doubleChecked) {
            password = JOptionPane.showInputDialog("Please input your password");
            String password2 = JOptionPane.showInputDialog("Please repeat your password");
            if (password.equals(password2)) {
                doubleChecked = true;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Passwords don't match, try again");
            }
        }
        return password;
    }
    private boolean checkExists(String username) {
        boolean check1 = false;

        for (int i = 0; i < teachers.size(); i++) {

            if (teachers.get(i).getName().equals(username)) {
                check1 = true;
            }
        }
        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getName().equals(username)) {
                check1 = true;
            }
        }

        return check1;
    }

    public Teacher logInTeacher() {
        loggedInTeacher = null;
        String logInUsername = JOptionPane.showInputDialog("Enter username");
        String logInPassword = JOptionPane.showInputDialog("Please input your password");
        boolean exists = false;
        while (!exists) {
            exists = checkExists(logInUsername);
            if (exists) {
                if (checkTeacherPassword(logInUsername, logInPassword)) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Log in attempt was unsuccessful");
                }
            } else {
                JOptionPane.showMessageDialog(null, "You need to create an account first ");
                break;
            }
        }
        return loggedInTeacher;
    }

    public Student logInStudent() {
        loggedInStudent = null;
        String logInUsername = JOptionPane.showInputDialog("Enter username");
        String logInPassword = JOptionPane.showInputDialog("Please input your password");
        boolean exists = false;
        while (!exists) {
            exists = checkExists(logInUsername);
            if (exists) {
                if (checkStudentPassword(logInUsername, logInPassword)) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Log in attempt was unsuccessful");
                }
            } else {
                JOptionPane.showMessageDialog(null, "You need to create an account first ");
                break;
            }
        }
        return loggedInStudent;
    }

    public boolean checkTeacherPassword(String username, String password) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().equals(username)) {
                if (teachers.get(i).getPassword().equals(password)) {
                    loggedInTeacher = teachers.get(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkStudentPassword(String username, String password) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(username)) {
                if (students.get(i).getPassword().equals(password)) {
                    loggedInStudent = students.get(i);
                    return true;
                }
            }
        }
        return false;
    }

    public String teacherMenuInput() {
        String theChoice;

        String[] availableChoices = {"View courses", "Add courses", "Remove courses", "Edit courses", "View exam scores", "Add exam scores", "Remove exam scores", "Edit exam scores","View students", "View teachers", "Remove students", "Delete account", "Log out"};

        theChoice = (String) JOptionPane.showInputDialog(
                null,
                "Select from the options below",
                "Teacher menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                availableChoices,
                availableChoices[0]
        );
        return theChoice;
    }

    public String studentMenuInput() {
        String theChoice;

        String[] availableChoices = {"View exam scores", "View courses and teachers", "Delete account", "Log out"};

        theChoice = (String) JOptionPane.showInputDialog(
                null,
                "Select from the options below",
                "Teacher menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                availableChoices,
                availableChoices[0]
        );
        return theChoice;
    }

    public String teacherMenuSwitch() {
        String teachChoice;
        do {
            teachChoice = teacherMenuInput();

            switch (teachChoice) {
                case "Add courses":
                    String name = (String) JOptionPane.showInputDialog(null, "Please input the name of the course");
                    String teacher = loggedInTeacher.getName();
                    addCourse(name, teacher);
                    break;
                case "View courses":
                    viewCourses();
                    break;
                case "Remove courses":
                    String input = JOptionPane.showInputDialog(null, "Please input the name of the course you want to remove");
                    deleteCourse(input);
                    break;
                case "Edit courses":
                    String oldName = JOptionPane.showInputDialog(null, "Please input the old name of the course");
                    String newName = JOptionPane.showInputDialog(null, "Please input the new name of the course");
                    editCourse(oldName, newName);
                    break;
                case "Add exam scores":
                    int score = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input student's score"));
                    String courseName = JOptionPane.showInputDialog(null, "Please input course name");
                    String studentName = JOptionPane.showInputDialog(null, "Please input student name");
                    Course course = findCourse(courseName);
                    Student student = findStudent(studentName);
                    addExam(score, course, student);
                    break;
                case "View exam scores":
                    viewExamResults();
                    break;
                case "Remove exam scores":
                    courseName = JOptionPane.showInputDialog(null, "Please input course name");
                    studentName = JOptionPane.showInputDialog(null, "Please input student name");
                    course = findCourse(courseName);
                    student = findStudent(studentName);
                    deleteExamScore(student, course);
                    break;
                case "Edit exam scores":
                    courseName = JOptionPane.showInputDialog(null, "Please input course name");
                    studentName = JOptionPane.showInputDialog(null, "Please input student name");
                    course = findCourse(courseName);
                    student = findStudent(studentName);
                    int newScore = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input student's score"));

                    editExam(student, course, newScore);
                    break;
                case "View students":
                    viewStudents();
                    break;
                case "View teachers":
                    viewTeachers();
                    break;
                case "Remove students":
                    String inputStudent = JOptionPane.showInputDialog(null, "Please input the name od the student you want to remove");
                    deleteStudent(inputStudent);
                    break;
                case "Delete account":
                    String delName = loggedInTeacher.getName();
                    deleteTeacher(delName);
                    break;
                case "Log out":
                    loggedInTeacher = null;
                    break;
            }
        }
        while (!teachChoice.equals("Log out"));
        return teachChoice;
    }

    public String studentMenuSwitch() {
        String studChoice = studentMenuInput();
        do {
            studChoice = studentMenuInput();
            switch (studChoice) {
                case "View courses and teachers":
                    viewCourses();
                    break;
                case "View exam scores":
                    viewExamResults();
                    break;
                case "Delete account":

                    String name = (String) JOptionPane.showInputDialog(null, "Confirm your name to delete your account");
                    if (loggedInStudent.getName().equals(name)) {
                        deleteStudent(name);
                        JOptionPane.showMessageDialog(null, "Account deleted successfully");
                    }

                    break;
                case "Log out":
                    loggedInStudent = null;
                    break;
            }
        }while (!studChoice.equals("Log out"));
        return studChoice;
    }


    //ADD
    public Course addCourse(String name, String teacher) {
        Course course = new Course(name, teacher);
        courses.add(course);
        return course;
    }

    public Exam addExam(int score, Course course, Student student) {
        Exam exam = new Exam(score, course, student);
        exams.add(exam);
        return exam;

    }

    //DELETE
    public void deleteStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
            }
        }
    }

    public void deleteTeacher(String name) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getName().equals(name)) {
                teachers.remove(i);
            }
        }
    }

    public void deleteCourse(String name) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(name)) {
                courses.remove(i);
            }
        }
    }

    public void deleteExamScore(Student s, Course c) {
        for (int i = 0; i < exams.size(); i++) {
            if (exams.get(i).getStudent().equals(s)) {
                if (exams.get(i).getCourse().equals(c)) {
                    exams.remove(i);
                }
            }
        }
    }

    //EDIT
    /*public void editStudent(String oldName, String newName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(oldName)) {
                students.get(i).setName(newName);
            }
        }
    }*/

    /*public void editTeacher(String oldName, String newName) {
        for (int i = 0; i < teachers.size(); i++) {
            if (students.get(i).getName().equals(oldName)) {
                students.get(i).setName(newName);
            }
        }
    }*/

    public void editCourse(String oldName, String newName) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(oldName)) {
                courses.get(i).setCourseName(newName);
            }
        }
    }

    public void editExam(Student s, Course c, int newGrade) {
        for (int i = 0; i < exams.size(); i++) {
            if (exams.get(i).getStudent().equals(s)) {
                if (exams.get(i).getCourse().equals(c)) {
                    exams.get(i).setExamScore(newGrade);
                }
            }
        }
    }

    //VIEW
    public void viewStudents() {
        String result = students.toString();
        JOptionPane.showMessageDialog(null,"List of all students: " + result);
        }

    public void viewTeachers() {
        String result = teachers.toString();
        JOptionPane.showMessageDialog(null,"List of all teachers: " + result);
    }

    public void viewCourses() {
        String result = courses.toString();
        JOptionPane.showMessageDialog(null,"List of all courses: " + result);
    }

    public void viewExamResults() {
        for (int i = 0; i < exams.size(); i++) {
            exams.get(i).printResults();
        }
    }

    //OTHERS

    public Course findCourse(String courseName) {
        Course course = null;
        for (int i = 0; i < courses.size(); i++) {
            if (courseName.equals(courses.get(i).courseName)) {
                course = courses.get(i);

            }
        }
        return course;
    }
    public Student findStudent(String studentName) {

        Student student = null;
        for (int i = 0; i < students.size(); i++) {
            if (studentName.equals(students.get(i).getName())) {
                student = students.get(i);

            }
        }
        return student;
    }
}






