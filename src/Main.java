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
            while (totalStudents > 15 || totalStudents < 1) {
                System.out.println("Enter less than 15 students!");
                System.out.println("Try again: ");
                totalStudents = scanner.nextInt();
            }
            mainStudents = new Student[totalStudents];
            for (int i = 0; i < totalStudents; i++) {
                String name;
                System.out.println("Enter Student " + (i + 1) + " name: ");
                scanner.nextLine();
                name = scanner.nextLine();
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

            while (true) {
                System.out.println("\n What would you like to do?\n 1 is print students by name.\n 2 is print students by final average.\n 3 is print mean of final averages.\n 4 is print median of final averages.\n 5 is print mode of final averages.\n 6 is print standard deviation with popular mean of final averages.\n 7 is to quit.\n");
                int userDesire = scanner.nextInt();
                if (userDesire == 7){
                    System.out.println("Thank you");
                    System.exit(0);
                }
                while (userDesire > 6 || userDesire < 1) {
                    System.out.println("Try Again: ");
                    userDesire = scanner.nextInt();
                }
                Student[] allStudents = stat.finalAverage(mainStudents, totalStudents);
                if (userDesire > 2) {
                    System.out.println("Do you want to calculate using quarter averages(1) or final averages(2): ");
                    int whatAverage = scanner.nextInt();
                    while (whatAverage > 2 || whatAverage < 1) {
                        System.out.println("Try again: ");
                        whatAverage = scanner.nextInt();
                    }
                    if (whatAverage == 1) stat.quarterAverageArray(allStudents, totalStudents);
                    else if (whatAverage == 2) stat.finalAverageArray(allStudents, totalStudents);
                    stat.insertionSort();
                }
                if (userDesire == 1) print.printName(allStudents, totalStudents);
                else if (userDesire == 2) print.printFinalAverage(allStudents, totalStudents);
                else if (userDesire == 3) stat.mean();
                else if (userDesire == 4) stat.median();
                else if (userDesire == 5) stat.mode();
                else if (userDesire == 6) stat.StandardDeviation();

            }
        } catch (InputMismatchException e) {
            System.out.println("Please Enter a valid Integer value! ");
            System.out.println("Program is exiting! ");
            System.exit(0);
        }
    }
}
