package bank.management.system;

import javax.swing.*;// For JFrame, JLabel, JTextField, JButton, ImageIcon
import java.awt.*;// For Color and Font
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For Action Listener
import java.util.*;// For Random
import com.toedter.calendar.JDateChooser;// For Calendar

public class SignUp extends JFrame implements ActionListener
{
    long random;
    JLabel introduction, formNumber, name, fatherName, dob, gender, emailAddress,
            martialStatus, address, city, state, pinCode;
    JTextField nameTextField, fatherNameTextField, emailAddressTextField,
            addressTextField, cityTextField, stateTextField, pinCodeTextField;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried;
    ButtonGroup genderGroup, martialStatusGroup;
    JButton next;

    SignUp()
    {
        // Turning on the custom layout
        setLayout(null);

        // Assigning title to the Frame
        setTitle("Page 1 - New Account Application Form : Personal Details");

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        // Application Form Number
        formNumber = new JLabel("Application Form No. " + random);
        formNumber.setFont(new Font("Raleway", Font.BOLD, 38));
        formNumber.setBounds(200, 25, 500, 50);
        add(formNumber);

        // Introduction
        introduction = new JLabel("Page 1: Personal Details");
        introduction.setFont(new Font("Raleway", Font.BOLD, 30));
        introduction.setBounds(275, 100, 500, 50);
        add(introduction);

        // Name
        name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 25));
        name.setBounds(50, 205, 500, 30);
        add(name);

        // Name Textfield
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        nameTextField.setBounds(300, 205, 400, 30);
        add(nameTextField);

        // Father's Name
        fatherName = new JLabel("Father's Name : ");
        fatherName.setFont(new Font("Raleway", Font.BOLD, 25));
        fatherName.setBounds(50, 245, 500, 30);
        add(fatherName);

        // Father's Name Textfield
        fatherNameTextField = new JTextField();
        fatherNameTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        fatherNameTextField.setBounds(300, 245, 400, 30);
        add(fatherNameTextField);

        // Date of Birth
        dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 25));
        dob.setBounds(50, 285, 500, 30);
        add(dob);

        // Date Chooser
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 285, 400, 30);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dateChooser);

        // Gender
        gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD, 25));
        gender.setBounds(50, 325, 500, 30);
        add(gender);

        // Male Gender RadioButton
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 15));
        male.setBounds(300, 325, 150, 30);
        male.setBackground(Color.WHITE);
        add(male);

        // Female Gender RadioButton
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        female.setBounds(550, 325, 150, 30);
        female.setBackground(Color.WHITE);
        add(female);

        // Grouping Gender RadioButtons
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // Email Address
        emailAddress = new JLabel("Email Address : ");
        emailAddress.setFont(new Font("Raleway", Font.BOLD, 25));
        emailAddress.setBounds(50, 365, 500, 30);
        add(emailAddress);

        // Email Address TextField
        emailAddressTextField = new JTextField();
        emailAddressTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        emailAddressTextField.setBounds(300, 365, 400, 30);
        add(emailAddressTextField);

        // Martial Status
        martialStatus = new JLabel("Martial Status : ");
        martialStatus.setFont(new Font("Raleway", Font.BOLD, 25));
        martialStatus.setBounds(50, 405, 500, 30);
        add(martialStatus);

        // Married RadioButton
        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 15));
        married.setBounds(300, 405, 150, 30);
        married.setBackground(Color.WHITE);
        add(married);

        // Unmarried RadioButton
        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 15));
        unmarried.setBounds(550, 405, 150, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        // Grouping Marital Status RadioButtons
        martialStatusGroup = new ButtonGroup();
        martialStatusGroup.add(married);
        martialStatusGroup.add(unmarried);

        // Address
        address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD, 25));
        address.setBounds(50, 445, 500, 30);
        add(address);

        // Address TextField
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        addressTextField.setBounds(300, 445, 400, 30);
        add(addressTextField);

        // City
        city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD, 25));
        city.setBounds(50, 485, 500, 30);
        add(city);

        // City TextField
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        cityTextField.setBounds(300, 485, 400, 30);
        add(cityTextField);

        // State
        state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD, 25));
        state.setBounds(50, 525, 500, 30);
        add(state);

        // State TextField
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        stateTextField.setBounds(300, 525, 400, 30);
        add(stateTextField);

        // Pin Code
        pinCode = new JLabel("Pin Code : ");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 25));
        pinCode.setBounds(50, 565, 500, 30);
        add(pinCode);

        // Pin Code TextField
        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCodeTextField.setBounds(300, 565, 400, 30);
        add(pinCodeTextField);

        // Next
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600, 605, 100, 30);
        next.addActionListener(this);
        add(next);

        // For setting the background color of the entire frame
        getContentPane().setBackground(Color.WHITE);

        // For assigning size
        setSize(900, 800);
        // For making the frame visible
        setVisible(true);
        // For initialising starting location
        setLocation(350, 10);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
            String stringFormNumber = "" + random;
            String stringName = nameTextField.getText();
            String stringDob = ((JTextField) dateChooser.getDateEditor().
                    getUiComponent()).getText();
            String stringGender = null;
            if (male.isSelected())
            {
                stringGender = "Male";
            } else if (female.isSelected())
            {
                stringGender = "Female";
            }
            String stringEmailAddress = emailAddressTextField.getText();
            String stringMaritalStatus = null;
            if (married.isSelected()) {
                stringMaritalStatus = "Married";
            } else if (unmarried.isSelected()) {
                stringMaritalStatus = "Unmarried";
            }

            String stringAddress = addressTextField.getText();
            String stringCity = cityTextField.getText();
            String stringState = stateTextField.getText();
            String stringPinCode = pinCodeTextField.getText();

            try {
                if (stringName.equals("") || stringDob.equals("") || stringGender.equals("") ||
                stringEmailAddress.equals("") || stringMaritalStatus.equals("") ||
                        stringAddress.equals("") || stringCity.equals("") ||
                        stringState.equals("") || stringPinCode.equals(""))
                {
                    JOptionPane.showMessageDialog
                            (null, "Please fill all the fields.");
                } else {
                    Connections c = new Connections();
                    String query3 = "insert into signup1 values('" + stringFormNumber + "', '"
                            + stringName + "', '" + stringDob + "', '" +
                            stringGender + "', '" + stringEmailAddress + "', '" +
                            stringMaritalStatus + "', '" + stringAddress + "', '" +
                            stringCity + "', '" + stringState + "', '"
                            + stringPinCode + "')";
                    c.s.executeUpdate(query3);

                    setVisible(false);
                    new SignUp2(stringFormNumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    public static void main(String[] args)
    {
        new SignUp();
    }
}
