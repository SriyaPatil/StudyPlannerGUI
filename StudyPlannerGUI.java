import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Subject {
    String name;
    int difficulty;
    int chapters;
    int completed;

    Subject(String name, int difficulty, int chapters, int completed) {
        this.name = name;
        this.difficulty = difficulty;
        this.chapters = chapters;
        this.completed = completed;
    }

    int pending() {
        return chapters - completed;
    }
}

public class StudyPlannerGUI extends JFrame {

    ArrayList<Subject> subjects = new ArrayList<>();

    JTextField nameField, diffField, chapField, compField, hoursField;
    JTextArea outputArea;

    public StudyPlannerGUI() {
        setTitle("AI Based Study Planner");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Subject Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Difficulty (1-5):"));
        diffField = new JTextField(5);
        add(diffField);

        add(new JLabel("Total Chapters:"));
        chapField = new JTextField(5);
        add(chapField);

        add(new JLabel("Completed Chapters:"));
        compField = new JTextField(5);
        add(compField);

        JButton addBtn = new JButton("Add Subject");
        add(addBtn);

        add(new JLabel("Available Study Hours Today:"));
        hoursField = new JTextField(10);
        add(hoursField);

        JButton generateBtn = new JButton("Generate Plan");
        add(generateBtn);

        outputArea = new JTextArea(20, 45);
        add(new JScrollPane(outputArea));

        // Add Subject Button Function
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int diff = Integer.parseInt(diffField.getText());
                int chap = Integer.parseInt(chapField.getText());
                int comp = Integer.parseInt(compField.getText());

                subjects.add(new Subject(name, diff, chap, comp));

                outputArea.append("Added: " + name + "\n");

                nameField.setText("");
                diffField.setText("");
                chapField.setText("");
                compField.setText("");
            }
        });

        // Generate Plan Button Function
        generateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double hours = Double.parseDouble(hoursField.getText());
                generatePlan(hours);
            }
        });
    }

    // AI Logic
    void generatePlan(double hours) {
        outputArea.append("\n======= AI GENERATED STUDY PLAN =======\n");

        double totalPriority = 0;

        for (Subject s : subjects) {
            totalPriority += s.difficulty * s.pending();
        }

        for (Subject s : subjects) {
            if (s.pending() == 0) continue;

            double priority = s.difficulty * s.pending();
            double timeAlloc = (priority / totalPriority) * hours;

            outputArea.append(
                "\nSubject: " + s.name +
                "\nPending Chapters: " + s.pending() +
                "\nDifficulty: " + s.difficulty +
                String.format("\nAllocated Time: %.2f hours\n", timeAlloc)
            );
        }
    }

    public static void main(String[] args) {
        new StudyPlannerGUI().setVisible(true);
    }
}