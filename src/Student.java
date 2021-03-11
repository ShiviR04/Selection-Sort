import java.util.Arrays;

public class Student {
    private String name;
    private int graduationYear;
    private int finalAverage;
    private double[] quarterAverage = new double[4];

    public Student(String name, int graduationYear, int finalAverage, double[] quarterAverage) {
        this.name = name;
        this.graduationYear = graduationYear;
        this.finalAverage = finalAverage;
        this.quarterAverage = quarterAverage;
    }

    public String getName(){
        return name; }

    public void setName(String name) {
        this.name = name; }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public int getFinalAverage() {
        return finalAverage;
    }

    public void setFinalAverage(int finalAverage) {
        this.finalAverage = finalAverage;
    }

    public double[] getQuarterAverage() {
        return quarterAverage;
    }

    public void setQuarterAverage(double[] quarterAverage) {
        this.quarterAverage = quarterAverage;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", graduationYear=" + graduationYear + ", finalAverage=" + finalAverage + ", quarterAverage=" + Arrays.toString(quarterAverage) + '}';
    }
}
