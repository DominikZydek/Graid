import java.awt.event.ActionEvent;

public class MainScreen {
    public static void showSchedule(ActionEvent e, TypeOfUser typeOfUser, MainScreenGUI mainScreen) {
        switch (typeOfUser) {
            case Student:
            case Parent:
                mainScreen.studentParentSchedule();
                break;
            case Teacher:
                mainScreen.teacherSchedule();
                break;
        }
    }
    public static void showAssignments(ActionEvent e, TypeOfUser typeOfUser, MainScreenGUI mainScreen) {
        switch (typeOfUser) {
            case Student:
            case Parent:
                mainScreen.studentParentAssignments();
                break;
            case Teacher:
                mainScreen.teacherAssignments();
                break;
        }

    }
    public static void showTests(ActionEvent e, TypeOfUser typeOfUser, MainScreenGUI mainScreen) {
        switch (typeOfUser) {
            case Student:
            case Parent:
                mainScreen.studentParentTests();
                break;
            case Teacher:
                mainScreen.teacherTests();
                break;
        }

    }
    public static void showGrades(ActionEvent e, TypeOfUser typeOfUser, MainScreenGUI mainScreen) {
        switch (typeOfUser) {
            case Student:
            case Parent:
                mainScreen.studentParentGrades();
                break;
            case Teacher:
                mainScreen.teacherGrades();
                break;
        }

    }
}
