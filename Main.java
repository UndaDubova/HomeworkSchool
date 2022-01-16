import SchoolManagement.*;

import javax.swing.*;
import java.lang.String;

    public class Main {
    public static void main(String[] args) {
        School school1 = new School();
        String optChoice;
        do {
            optChoice = logInWindow();
            switch (optChoice) {
                case "Create an account":
                    JOptionPane.showMessageDialog(null, school1.createAccount());
                    break;
                case "Log in as teacher":
                    school1.logInTeacher();
                    if (school1.getLoggedInTeacher() != null){
                    school1.teacherMenuSwitch();
                    }
                case "Log in as student":
                    school1.logInStudent();
                    if (school1.getLoggedInStudent() != null){
                    school1.studentMenuSwitch();
                    }
                case "Exit":
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    break;
            }

        }
        while (!optChoice.equals("Exit"));
    }

    public static String logInWindow() {
        String[] optionsMain = {"Create an account", "Log in as teacher","Log in as student", "Exit"};
        String optChoice;
        optChoice = (String) JOptionPane.showInputDialog(
                null,
                "Welcome to the school management system, please choose from the options below!",
                "School management system",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsMain,
                optionsMain[0]
        );
        return optChoice;
    }
}


