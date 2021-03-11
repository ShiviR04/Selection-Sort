import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AllStudents print = new AllStudents();
        Statistics stat = new Statistics();
        Student[] mainStudents;
        try {
            System.out.println("How many students will you enter?");
            int totalStudents = scanner.nextInt();
            while (totalStudents > 15 || totalStudents < 0) {
                System.out.println("Enter less than 15 students!");
                System.out.println("Try again: ");
                totalStudents = scanner.nextInt();
            }
            mainStudents = new Student[totalStudents];
            for (int i = 0; i < totalStudents; i++) {
                String name;
                System.out.println("Enter Student " + (i + 1) + " name: ");
                name = scanner.nextLine();
                scanner.next();
                System.out.println("Enter Student " + (i + 1) + " graduation year: ");
                int graduationYear = scanner.nextInt();
                double[] quarterAverage = new double[4];
                for (int y = 0; y < 4; y++) {
                    System.out.println("Enter Student " + (i + 1) + " quarter " + (y + 1) + " average:");
                    double q = scanner.nextDouble();
                    while (q > 100 || q < 0) {
                        System.out.println("Try again: ");
                        q = scanner.nextDouble();
                    }
                    quarterAverage[y] = q;
                }
                Student newStudent = new Student(name, graduationYear, 0, quarterAverage);
                mainStudents[i] = newStudent;
            }
            boolean actionRepeat = true;
            while (actionRepeat) {
                System.out.println("What would you like to do?\n 1 is print students by name.\n 2 is print students by final average.\n 3 is print mean of final averages.\n 4 is print median of final averages.\n 5 is print mode of final averages.\n 6 is print standard deviation with popular mean of final averages.\n ");
                int userDesire = scanner.nextInt();
                Student[] allStudents = stat.finalAverage(mainStudents, totalStudents);
                switch (userDesire) {
                    case 1:
                        print.printName(allStudents, totalStudents);
                    case 2:
                        print.printFinalAverage(allStudents, totalStudents);
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please Enter a valid Integer value! ");
            System.out.println("Program is exiting! ");
            System.exit(0);
        }
    }
}
