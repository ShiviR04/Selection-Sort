public class Statistics {

    public Student[] finalAverage(Student[] allStudents, int totalStudents) {
        for (int i = 0; i < totalStudents; i++) {
            double total = 0;
            int average = 0;
            double[] quarters = allStudents[i].getQuarterAverage();
            for (int y = 0; y < 4; y++) {
                total = total + quarters[y];
                average = (int) (total / 4);
                allStudents[i].setFinalAverage(average);
            }
        }
        return allStudents;
    }



}
