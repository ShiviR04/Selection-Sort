import java.util.InputMismatchException;
import java.util.Scanner;

public class AllStudents {
    public void printName(Student[] printStudents, int totalStudents) {
        for (int i = 0; i < totalStudents; i++) {
            int index = i;
            String name = printStudents[i].getName();
            for (int y = i + 1; y < totalStudents; y++) {
                if (printStudents[y].getName().compareTo(name) < 0) {
                    name = printStudents[y].getName();
                    index = y;
                }
            }
            if (index != i) {
                Student sorted = printStudents[index];
                printStudents[index] = printStudents[i];
                printStudents[i] = sorted;
            }
        }
        for (int i = 0; i < totalStudents; i++) System.out.println(printStudents[i] + "\n");
    }

    public Student[] printFinalAverage(Student[] printStudents, int totalStudents) {
        for (int i = 0; i < totalStudents; i++) {
            int index = i;
            double average = printStudents[i].getFinalAverage();
            for (int y = i + 1; y < totalStudents; y++) {
                if (printStudents[y].getFinalAverage() > average) {
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
        for (int i = 0; i < totalStudents; i++) System.out.println(printStudents[i] + "\n");
        return printStudents;
    }
}
