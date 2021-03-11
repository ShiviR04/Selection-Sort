import java.util.ArrayList;
import java.util.List;

public class Statistics {
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

    public double mean(Student[] allStudents, int totalStudents) {
        double total = 0;
        for(int i = 0; i < totalStudents; i++){
            total = total + allStudents[i].getFinalAverage();
        }
        mean = total/totalStudents;
        System.out.println("The mean is: " + mean);
        return mean;
    }

    public void mode(Student[] allStudents, int totalStudents){
        List<Integer> mode = new ArrayList<Integer>();
        int maxCount=0;
        for (int i = 0; i < totalStudents; ++i){
            int count = 0;
            for (int j = 0; j < totalStudents; ++j){
                if (allStudents[j].getFinalAverage() == allStudents[i].getFinalAverage()) ++count;
            }
            if (count > maxCount){
                maxCount = count;
                mode.clear();
                mode.add(allStudents[i].getFinalAverage());
            } else if ( count == maxCount ){
                mode.add(allStudents[i].getFinalAverage());
            }
        }
        System.out.println("Mode: " + mode + " and they occur " + maxCount + " times.");
    }
    public void median(Student[] allStudents, int totalStudents){
        double median = 0;
        if (totalStudents % 2 != 0) median = allStudents[totalStudents / 2].getFinalAverage();
        else{
            int middle = totalStudents/2;
            double preMedian = allStudents[middle].getFinalAverage() + allStudents[(middle - 1)].getFinalAverage();
            median = preMedian/2;
        }
        System.out.println("The median is: " + median);
    }

    public void StandardDeviation(Student[] allStudents, int totalStudents){
        double sum=0;
        for(int i=0;i<totalStudents;i++) {
            sum += Math.pow((allStudents[i].getFinalAverage() - mean), 2);
        }
        mean = sum/totalStudents;
        double std = Math.sqrt(mean);
        System.out.println("The Population Standard Deviation of the data is " + std);
    }
}
