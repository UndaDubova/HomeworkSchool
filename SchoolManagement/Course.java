package SchoolManagement;

public class Course {
    public String courseName;
    public String courseTeacher;

    public Course(String courseName, String courseTeacher) {
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    @Override
    public String toString() {
        return " " + courseName + '\'' +
                ", teacher: " + courseTeacher + '\'';
    }
}

