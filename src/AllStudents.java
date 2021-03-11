import java.util.InputMismatchException;
import java.util.Scanner;

public class AllStudents {
    Statistics stat = new Statistics();

    public void printName(Student[] printStudents, int totalStudents){
        for(int i = 0; i <totalStudents; i++){
            int index = i;
            //String name = printStudents[i].getName();
            for(int y = 0; y < totalStudents; y++){
                if (printStudents[i].getName().compareTo(printStudents[y].getName()) > 0){
                    Student sorted = printStudents[index];
                    printStudents[index] = printStudents[i];
                    printStudents[i] = sorted;
                }
            }
        }
        for(int i = 0; i < totalStudents; i++) System.out.println(printStudents[i]);
    }

    public void printFinalAverage(Student[] printStudents, int totalStudents) {
        for (int i = 0; i < totalStudents; i++) {
            int index = i;
            double average = printStudents[i].getFinalAverage();
            for (int y = 0; y < totalStudents; y++) {
                if (printStudents[i].getFinalAverage() > average) {
                    average = printStudents[y].getFinalAverage();
                    index = y;
                }
            }
            if (index != i) {
                Student sorted = printStudents[index];
                printStudents[index] = printStudents[i];
                printStudents[i] = sorted;
            }
        }
        for(int i = 0; i < totalStudents; i++) System.out.println(printStudents[i]);
    }
}

/*
public class AllStudents {
    Statistics stat = new Statistics();

    public void printName(Student[] printStudents, int totalStudents){
        for(int i = 0; i <totalStudents; i++){
            int index = i;
            String name = printStudents[i].getName();
            for(int y = 0; y < totalStudents; y++){
                if (printStudents[y].getName().compareTo(name) < 0){
                    name = printStudents[y].getName();
                    index = y;
                }
            }
            if (index != i){
                Student sorted = printStudents[index];
                printStudents[index] = printStudents[i];
                printStudents[i] = sorted;
            }
        }
        for(int i = 0; i < totalStudents; i++) System.out.println(printStudents[i]);
    }

    public void printFinalAverage(Student[] printStudents, int totalStudents) {
        for (int i = 0; i < totalStudents; i++) {
            int index = i;
            double average = printStudents[i].getFinalAverage();
            for (int y = 0; y < totalStudents; y++) {
                if (printStudents[i].getFinalAverage() > average) {
                    average = printStudents[y].getFinalAverage();
                    index = y;
                }
            }
            if (index != i) {
                Student sorted = printStudents[index];
                printStudents[index] = printStudents[i];
                printStudents[i] = sorted;
            }
        }
        for(int i = 0; i < totalStudents; i++) System.out.println(printStudents[i]);
    }
}

 */
