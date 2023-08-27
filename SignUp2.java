package bank.management.system;

import javax.swing.*;// For JFrame, JLabel, JTextField, JButton, ImageIcon
import java.awt.*;// For Color and Font
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For Action Listener
import java.util.*;// For Random

public class SignUp2 extends JFrame implements ActionListener
{
    JLabel introduction, religion, category, income, educationalQualification,
            occupation, panNumber, aadharNumber, seniorCitizen, existingAccount;
    JTextField panNumberTextField, aadharNumberTextField;
    JComboBox religionComboBox, categoryComboBox, incomeComboBox,
            educationalQualificationComboBox, occupationComboBox;
    JRadioButton seniorCitizenRadioButtonYes, seniorCitizenRadioButtonNo,
            existingAccountRadioButtonYes, existingAccountRadioButtonNo;
    ButtonGroup seniorCitizenButtonGroup, existingAccountButtonGroup;
    JButton next;
    String formNumber;

    SignUp2(String formNumber)
    {
        this.formNumber = formNumber;

        // For turning on the custom layout
        setLayout(null);

        // Assigning title to the frame
        setTitle("Page 2 - New Account Application Form : Personal Details");

        // Page 2 - Additional Details
        introduction = new JLabel("Page 2: Additional Details");
        introduction.setFont(new Font("Raleway", Font.BOLD, 30));
        introduction.setBounds(275, 5, 400, 100);
        add(introduction);

        // Religion
        religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 25));
        religion.setBounds(50, 150, 200, 30);
        add(religion);

        // Religion Combo-Box
        String [] religionSet = {"", "Hindu", "Muslim", "Christian", "Buddhist",
            "Jain", "Others"};
        religionComboBox = new JComboBox(religionSet);
        religionComboBox.setFont(new Font("Raleway", Font.BOLD, 15));
        religionComboBox.setBackground(Color.WHITE);
        religionComboBox.setBounds(400, 150, 400, 30);
        add(religionComboBox);

        // Category
        category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 25));
        category.setBounds(50, 200, 200, 30);
        add(category);

        // Category Combo-Box
        String [] categorySet = {"", "General", "OBC", "SC", "ST", "Others"};
        categoryComboBox = new JComboBox(categorySet);
        categoryComboBox.setFont(new Font("Raleway", Font.BOLD, 15));
        categoryComboBox.setBackground(Color.WHITE);
        categoryComboBox.setBounds(400, 200, 400, 30);
        add(categoryComboBox);

        // Income
        income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 25));
        income.setBounds(50, 250, 200, 30);
        add(income);

        // Income Combo-Box
        String [] incomeSet = {"", "More than 25,00,000",
                "Between 25,00,000 to 15,00,000",
                "Between 15,00,000 to 10,00,000",
                "Between 10,00,000 to 5,00,000",
                "Less Than 5,00,000"};
        incomeComboBox = new JComboBox(incomeSet);
        incomeComboBox.setFont(new Font("Raleway", Font.BOLD, 15));
        incomeComboBox.setBackground(Color.WHITE);
        incomeComboBox.setBounds(400, 250, 400, 30);
        add(incomeComboBox);

        // Educational Qualification
        educationalQualification = new JLabel("Educational Qualification: ");
        educationalQualification.setFont
                (new Font("Raleway", Font.BOLD, 25));
        educationalQualification.setBounds(50, 300, 400, 30);
        add(educationalQualification);

        // Educational Qualification Combo-Box
        String [] educationalQualificationSet = {"", "Post-Graduate",
                "Graduate", "Intermediate", "Marticulate"};
        educationalQualificationComboBox = new JComboBox
                (educationalQualificationSet);
        educationalQualificationComboBox.setFont
                (new Font("Raleway", Font.BOLD, 15));
        educationalQualificationComboBox.setBackground(Color.WHITE);
        educationalQualificationComboBox.setBounds
                (400, 300, 400, 30);
        add(educationalQualificationComboBox);

        // Occupation
        occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 25));
        occupation.setBounds(50, 350, 200, 30);
        add(occupation);

        // Occupation Combo-Box
        String [] occupationSet = {"", "Full-time Employee",
                "Part-time Employee", "Intern", "Self-employed",
                "Others"};
        occupationComboBox = new JComboBox(occupationSet);
        occupationComboBox.setFont(new Font("Raleway", Font.BOLD, 15));
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setBounds(400, 350, 400, 30);
        add(occupationComboBox);

        // Pan Number
        panNumber = new JLabel("Pan Number: ");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 25));
        panNumber.setBounds(50, 400, 400, 30);
        add(panNumber);

        // Pan Number TextField
        panNumberTextField = new JTextField();
        panNumberTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        panNumberTextField.setBounds(400, 400, 400, 30);
        add(panNumberTextField);

        // Aadhar Number
        aadharNumber = new JLabel("Aadhar Number: ");
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 25));
        aadharNumber.setBounds(50, 450, 400, 30);
        add(aadharNumber);

        // Aadhar Number TextField
        aadharNumberTextField = new JTextField();
        aadharNumberTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharNumberTextField.setBounds(400, 450, 400, 30);
        add(aadharNumberTextField);

        // Senior Citizen
        seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 25));
        seniorCitizen.setBounds(50, 500, 400, 30);
        add(seniorCitizen);

        // Senior Citizen Yes Radio Button
        seniorCitizenRadioButtonYes = new JRadioButton("Yes");
        seniorCitizenRadioButtonYes.setBackground(Color.WHITE);
        seniorCitizenRadioButtonYes.
                setFont(new Font("Raleway", Font.BOLD, 15));
        seniorCitizenRadioButtonYes.setBounds(400, 500, 150, 30);
        add(seniorCitizenRadioButtonYes);

        // Senior Citizen No Radio Button
        seniorCitizenRadioButtonNo = new JRadioButton("No");
        seniorCitizenRadioButtonNo.setBackground(Color.WHITE);
        seniorCitizenRadioButtonNo.
                setFont(new Font("Raleway", Font.BOLD, 15));
        seniorCitizenRadioButtonNo.setBounds(650, 500, 150, 30);
        add(seniorCitizenRadioButtonNo);

        // Senior Citizen Button Group
        seniorCitizenButtonGroup = new ButtonGroup();
        seniorCitizenButtonGroup.add(seniorCitizenRadioButtonYes);
        seniorCitizenButtonGroup.add(seniorCitizenRadioButtonNo);

        // Existing Account
        existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 25));
        existingAccount.setBounds(50, 550, 400, 30);
        add(existingAccount);

        // Existing Account Yes Radio Button
        existingAccountRadioButtonYes = new JRadioButton("Yes");
        existingAccountRadioButtonYes.setBackground(Color.WHITE);
        existingAccountRadioButtonYes.
                setFont(new Font("Raleway", Font.BOLD, 15));
        existingAccountRadioButtonYes.setBounds(400, 550, 150, 30);
        add(existingAccountRadioButtonYes);

        // Existing Account No Radio Button
        existingAccountRadioButtonNo = new JRadioButton("No");
        existingAccountRadioButtonNo.setBackground(Color.WHITE);
        existingAccountRadioButtonNo.
                setFont(new Font("Raleway", Font.BOLD, 15));
        existingAccountRadioButtonNo.setBounds(650, 550, 150, 30);
        add(existingAccountRadioButtonNo);

        // Existing Account Button Group
        existingAccountButtonGroup = new ButtonGroup();
        existingAccountButtonGroup.add(existingAccountRadioButtonYes);
        existingAccountButtonGroup.add(existingAccountRadioButtonNo);

        // Next Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(700, 620, 100, 30);
        next.addActionListener(this);

        add(next);

        // For setting the background color of the page
        getContentPane().setBackground(Color.WHITE);

        // For assigning size
        setSize(900, 800);
        // For making the frame visible
        setVisible(true);
        // For initialising start location
        setLocation(350, 10);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String stringFormNumber = "" + formNumber;
        String stringReligion = (String)religionComboBox.getSelectedItem();
        String stringCategory = (String)categoryComboBox.getSelectedItem();
        String stringIncome = (String)incomeComboBox.getSelectedItem();
        String stringEducationalQualification = (String)educationalQualificationComboBox.
                getSelectedItem();
        String stringOccupation = (String)occupationComboBox.getSelectedItem();
        String stringPanNumber = panNumberTextField.getText();
        String stringAadharNumber = aadharNumberTextField.getText();
        String stringSeniorCitizen = null;
        if(seniorCitizenRadioButtonYes.isSelected())
        {
            stringSeniorCitizen = "Yes";
        }
        else if(seniorCitizenRadioButtonNo.isSelected())
        {
            stringSeniorCitizen = "No";
        }
        String stringExistingAccount = null;
        if(existingAccountRadioButtonYes.isSelected())
        {
            stringExistingAccount = "Yes";
        }
        else if(existingAccountRadioButtonNo.isSelected())
        {
            stringExistingAccount = "No";
        }

        try
        {
            if(stringReligion.equals("") || stringCategory.equals("") ||
                    stringIncome.equals("") || stringEducationalQualification.equals("")
                     || stringOccupation.equals("") || stringPanNumber.equals("") ||
                    stringAadharNumber.equals("") || stringSeniorCitizen.equals("") ||
                    stringExistingAccount.equals(""))
            {
                JOptionPane.showMessageDialog(null,
                        "Please fill all the entries.");
            }
            else
            {
                Connections c2 = new Connections();
                String queryTwo = "insert into signup2 values('" + stringFormNumber +"', '" +
                        stringReligion + "', '" + stringCategory + "', '" + stringIncome +
                        "', '" + stringEducationalQualification + "', '" + stringOccupation +
                        "', '" + stringPanNumber + "', '" + stringAadharNumber + "', '" +
                        stringSeniorCitizen + "', '" + stringExistingAccount + "')";
                c2.s.executeUpdate(queryTwo);

                setVisible(false);
                new SignUp3(stringFormNumber).setVisible(true);
            }

        } catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args)
    {
        new SignUp2("");
    }
}
