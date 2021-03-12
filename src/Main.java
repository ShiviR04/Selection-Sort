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
                System.out.println("\n What would you like to do?\n 1 is print students by name.\n 2 is print students by final average.\n 3 is print mean of final averages.\n 4 is print median of final averages.\n 5 is print mode of final averages.\n 6 is print standard deviation with popular mean of final averages.\n 7 is to add.\n 8 is to reset.\n 9 is to quit");
                int userDesire = scanner.nextInt();
                if (userDesire == 9){
                    System.out.println("Thank you");
                    System.exit(0);
                }
                while (userDesire > 9 || userDesire < 1) {
                    System.out.println("Try Again: ");
                    userDesire = scanner.nextInt();
                }
                Student[] allStudents = stat.finalAverage(mainStudents, totalStudents);
                if (userDesire > 2 && userDesire < 7) {
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
                else if (userDesire == 7) {
                    System.out.println("How many students will you add?");
                    int newTotalStudents = scanner.nextInt();
                    while (newTotalStudents + totalStudents > 15) {
                        System.out.println("Enter a number at or less than " + (15 - totalStudents));
                    }
                    Student[] temp = new Student[newTotalStudents];
                    scanner.nextLine();
                    for (int i = 0; i < newTotalStudents; i++) {
                        String name;
                        System.out.println("Enter Student " + (i + 1) + " name: ");
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
                        temp[i] = newStudent;
                    }
                    Student[] newMainStudents = new Student[totalStudents + newTotalStudents];
                    for (int i = 0; i < totalStudents; i++) System.arraycopy(allStudents[i], 0, newMainStudents[i], 0, totalStudents);
                    for (int i = 0; i < newTotalStudents; i++) System.arraycopy(temp[i], 0, newMainStudents, totalStudents, newTotalStudents);
                }
                else if (userDesire == 8) {
                    System.out.println("How many students will you enter?");
                    totalStudents = scanner.nextInt();
                    while (totalStudents > 15 || totalStudents < 1) {
                        System.out.println("Enter less than 15 students!");
                        System.out.println("Try again: ");
                        totalStudents = scanner.nextInt();
                    }
                    scanner.nextLine();
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
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please Enter a valid Integer value! ");
            System.out.println("Program is exiting! ");
            System.exit(0);
        } catch (NullPointerException e) {
            System.out.println("Please Enter a valid Integer value! ");
            System.out.println("Program is exiting! ");
            System.exit(0);
        }
    }
}
