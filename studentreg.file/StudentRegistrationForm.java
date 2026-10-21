import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    JLabel lblName, lblRoll, lblEmail, lblGender, lblCourse;
    JTextField txtName, txtRoll, txtEmail;
    JRadioButton male, female;
    JComboBox<String> course;
    JButton btnRegister, btnClear;
    ButtonGroup bg;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

        // Labels
        lblName = new JLabel("Name:");
        lblRoll = new JLabel("Roll No:");
        lblEmail = new JLabel("Email:");
        lblGender = new JLabel("Gender:");
        lblCourse = new JLabel("Course:");

        // Text Fields
        txtName = new JTextField();
        txtRoll = new JTextField();
        txtEmail = new JTextField();

        // Radio Buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);

        // Combo Box
        String courses[] = {"BCA", "B.Tech", "B.Sc", "MCA", "MBA"};
        course = new JComboBox<>(courses);

        // Buttons
        btnRegister = new JButton("Register");
        btnClear = new JButton("Clear");

        btnRegister.addActionListener(this);
        btnClear.addActionListener(this);

        // Add Components
        add(lblName);
        add(txtName);

        add(lblRoll);
        add(txtRoll);

        add(lblEmail);
        add(txtEmail);

        add(lblGender);
        add(genderPanel);

        add(lblCourse);
        add(course);

        add(btnRegister);
        add(btnClear);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegister) {

            String name = txtName.getText();
            String roll = txtRoll.getText();
            String email = txtEmail.getText();

            String gender = "";
            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";

            String selectedCourse = course.getSelectedItem().toString();

            JOptionPane.showMessageDialog(this,
                    "Student Registered Successfully!\n\n" +
                    "Name: " + name +
                    "\nRoll No: " + roll +
                    "\nEmail: " + email +
                    "\nGender: " + gender +
                    "\nCourse: " + selectedCourse);
        }

        if (e.getSource() == btnClear) {
            txtName.setText("");
            txtRoll.setText("");
            txtEmail.setText("");
            bg.clearSelection();
            course.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}