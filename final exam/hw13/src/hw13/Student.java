package hw13;
//StudentGradeManager
public class Student {
    private String name;
    private double height;
    private double weight;
    private String bmi;

    public Student(String name, double height, double weight, String bmi) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBmi() {
        return bmi;
    }

    public String toCSV() {
        return name + "," + height + "," + weight + "," + bmi;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Height: " + height + ", Weight: " + weight + ", BMI: " + bmi;
    }
}
