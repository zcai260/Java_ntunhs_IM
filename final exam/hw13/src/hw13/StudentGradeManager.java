package hw13;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentGradeManager extends JFrame {
    private JButton addButton, findButton, deleteButton, listButton;
    private JTextField nameField, heightField, weightField;
    private JTextArea textArea;
    private Map<String, Student> students;
    private static final String FILENAME = "BMI.csv";

    public StudentGradeManager() {
        super("BMI Calculator and CSV Saver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new FlowLayout());

        students = new HashMap<>();
        
        nameField = new JTextField(10);
        heightField = new JTextField(10);
        weightField = new JTextField(10);
        
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Height (cm):"));
        add(heightField);
        add(new JLabel("Weight (kg):"));
        add(weightField);

        addButton = new JButton("Add/Calculate BMI");
        addButton.addActionListener(this::addOrCalculateBMI);
        add(addButton);

        findButton = new JButton("Find Student");
        findButton.addActionListener(this::findStudent);
        add(findButton);

        deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(this::deleteStudent);
        add(deleteButton);

        listButton = new JButton("List Students");
        listButton.addActionListener(this::listStudents);
        add(listButton);


        textArea = new JTextArea(15, 50);
        add(new JScrollPane(textArea));

        loadFromFile(students, FILENAME);

        setVisible(true);
    }

    private void addOrCalculateBMI(ActionEvent e) {
        String name = nameField.getText();
        String heightText = heightField.getText();
        String weightText = weightField.getText();

        if (name.isEmpty() || heightText.isEmpty() || weightText.isEmpty()) {
            textArea.setText("Please enter all fields: Name, Height, Weight.");
            return;
        }

        try {
            double height = Double.parseDouble(heightText);
            double weight = Double.parseDouble(weightText);
            double bmi = weight / ((height / 100) * (height / 100));
            String bmiFormatted = String.format("%.2f", bmi);

            Student student = new Student(name, height, weight, bmiFormatted);
            students.put(name, student);

            textArea.setText("BMI calculated for " + name + ": " + bmiFormatted);
            saveToCSV(e);
        } catch (NumberFormatException ex) {
            textArea.setText("Invalid height or weight. Please enter numeric values.");
        }
    }

    private void findStudent(ActionEvent e) {
        String name = nameField.getText();
        if (name.isEmpty()) {
            textArea.setText("Please enter a name.");
            return;
        }
        Student student = students.get(name);
        if (student != null) {
            textArea.setText("Found: " + student);
        } else {
            textArea.setText("Student not found: " + name);
        }
    }

    private void deleteStudent(ActionEvent e) {
        String name = nameField.getText();
        if (name.isEmpty()) {
            textArea.setText("Please enter a name.");
            return;
        }
        if (students.remove(name) != null) {
            textArea.setText("Student deleted: " + name);
            saveToCSV(e);
        } else {
            textArea.setText("Student not found: " + name);
        }
    }

    private void listStudents(ActionEvent e) {
        StringBuilder builder = new StringBuilder("All Students:\n");
        for (Student student : students.values()) {
            builder.append(student).append("\n");
        }
        textArea.setText(builder.toString());
    }

    private void saveToCSV(ActionEvent e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            writer.write("Name,Height,Weight,BMI");
            writer.newLine();
            for (Student student : students.values()) {
                writer.write(student.toCSV());
                writer.newLine();
            }
            
        } catch (IOException ex) {
            textArea.setText("Error saving data: " + ex.getMessage());
        }
    }

    private static void loadFromFile(Map<String, Student> students, String filename) {
        File file = new File(filename);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double height = Double.parseDouble(parts[1]);
                double weight = Double.parseDouble(parts[2]);
                String bmi = parts[3];
                Student student = new Student(name, height, weight, bmi);
                students.put(name, student);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new StudentGradeManager();
    }
}
