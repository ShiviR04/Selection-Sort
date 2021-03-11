import java.util.ArrayList;
import java.util.List;

public class Statistics {
    double[] unsorted;
    double[] sorted;
    double mean;

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

    public double[] quarterAverageArray(Student[] allStudents, int totalStudents) {
        unsorted = new double[totalStudents * 4];
        int nextPoint = 0;
        for (int i = 0; i < totalStudents; i++) {
            nextPoint = 4 * i;
            System.arraycopy(allStudents[i].getQuarterAverage(), 0, unsorted, nextPoint, 4);
        }
        return unsorted;
    }

    public double[] finalAverageArray(Student[] allStudents, int totalStudents){
        unsorted = new double[totalStudents];
        for (int i = 0; i < totalStudents; i++) unsorted[i] = allStudents[i].getFinalAverage();
        return unsorted;
    }

    public double[] insertionSort() {
        for (int j = 1; j < unsorted.length; j++) {
            double key = unsorted[j];
            int i = j - 1;
            while ((i > -1) && (unsorted[i] > key)) {
                unsorted[i + 1] = unsorted[i];
                i--;
            }
            unsorted[i + 1] = key;
        }
        sorted = unsorted;
        return sorted;
    }

    public double mean() {
        double total = 0;
        for (int i = 0; i < sorted.length; i++) {
            total = total + sorted[i];
        }
        mean = total / sorted.length;
        System.out.println("The mean is: " + mean);
        return mean;
    }

    public void mode() {
        List<Double> mode = new ArrayList<>();
        int maxCount = 0;
        for (int i = 0; i < sorted.length; ++i) {
            int count = 0;
            for (int j = 0; j < sorted.length; ++j) {
                if (sorted[j] == sorted[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                mode.clear();
                mode.add(sorted[i]);
            } else if (count == maxCount) {
                mode.add(sorted[i]);
            }
        }
        System.out.println("Mode: " + mode + " and they occur " + maxCount + " times.");
    }

    public void median() {
        double median = 0;
        if (sorted.length % 2 != 0) median = sorted[sorted.length / 2];
        else {
            int middle = sorted.length / 2;
            double preMedian = sorted[middle] + sorted[(middle - 1)];
            median = preMedian / 2;
        }
        System.out.println("The median is: " + median);
    }

    public void StandardDeviation(){
        double sum=0;
        for(int i=0;i<sorted.length;i++) {
            sum += Math.pow((sorted[i]-mean), 2);
        }
        mean = sum/sorted.length;
        double std =Math.sqrt(mean);
        System.out.println("The Population Standard Deviation of the data is " + std);
    }
}