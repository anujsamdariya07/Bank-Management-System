package bank.management.system;

import javax.swing.*;// For JFrame, JLabel, JTextField, JButton, ImageIcon
import java.awt.*;// For Color and Font
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For Action Listener
import java.util.*;// For Random

public class SignUp3 extends JFrame implements ActionListener
{
    String formNumber;
    JLabel introduction, accountType, cardNumber, cardNumberDummy,
            cardNumberInstructions, pin, pinDummy, pinInstructions, servicesRequired;
    JRadioButton savingAccount, fixedDepositAccount, currentAccount,
            recurringDepositAccount;
    ButtonGroup accountTypeButtonGroup;
    JButton submit, cancel;
    JCheckBox atmCard, internetBanking, mobileBanking, alerts, chequeBook,
            eStatement, terms;

    SignUp3(String formNumber)
    {
        this.formNumber = formNumber;

        // Turning on custom layout
        setLayout(null);

        // Giving title name
        setTitle("Page 3 - New Account Application Form : Account Details");

        // Introduction
        introduction = new JLabel("Page 3: Account Details");
        introduction.setFont(new Font("Raleway", Font.BOLD, 30));
        introduction.setBounds(250, 20, 400, 80);
        add(introduction);

        // Account Type
        accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 25));
        accountType.setBounds(70, 120, 200, 30);
        add(accountType);

        // Saving Account Radio Button
        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setBackground(Color.WHITE);
        savingAccount.setForeground(Color.BLACK);
        savingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        savingAccount.setBounds(200, 170, 200, 25);
        add(savingAccount);

        // Fixed Deposit Account Radio Button
        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setBackground(Color.WHITE);
        fixedDepositAccount.setForeground(Color.BLACK);
        fixedDepositAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        fixedDepositAccount.setBounds(400, 170, 300, 25);
        add(fixedDepositAccount);

        // Current Account Radio Button
        currentAccount = new JRadioButton("Current Account");
        currentAccount.setForeground(Color.BLACK);
        currentAccount.setBackground(Color.WHITE);
        currentAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        currentAccount.setBounds(200, 210, 200, 25);
        add(currentAccount);

        // Recurring Deposit Account Radio Button
        recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setForeground(Color.BLACK);
        recurringDepositAccount.setBackground(Color.WHITE);
        recurringDepositAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        recurringDepositAccount.setBounds(400, 210, 300, 25);
        add(recurringDepositAccount);

        // Account Type Button Group
        accountTypeButtonGroup = new ButtonGroup();
        accountTypeButtonGroup.add(savingAccount);
        accountTypeButtonGroup.add(fixedDepositAccount);
        accountTypeButtonGroup.add(currentAccount);
        accountTypeButtonGroup.add(recurringDepositAccount);

        // Card Number
        cardNumber = new JLabel("Card Number:");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 25));
        cardNumber.setBounds(70, 270, 200, 30);
        add(cardNumber);

        // Card Number Dummy
        cardNumberDummy = new JLabel("XXXX-XXXX-XXXX-0468");
        cardNumberDummy.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNumberDummy.setBounds(300, 270, 400, 30);
        add(cardNumberDummy);

        // Card Number Instructions
        cardNumberInstructions = new JLabel("Your 16 Digits Card Number");
        cardNumberInstructions.setFont(new Font("Raleway", Font.BOLD, 15));
        cardNumberInstructions.setBounds(70, 310, 300, 15);
        add(cardNumberInstructions);

        // Pin
        pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(70, 360, 200, 30);
        add(pin);

        // Pin Dummy
        pinDummy = new JLabel("XXXX");
        pinDummy.setFont(new Font("Raleway", Font.BOLD, 20));
        pinDummy.setBounds(300, 360, 200, 30);
        add(pinDummy);

        //  Pin Instructions
        pinInstructions = new JLabel("Your 4 Digit Password");
        pinInstructions.setFont(new Font("Raleway", Font.BOLD, 15));
        pinInstructions.setBounds(70, 400, 200, 15);
        add(pinInstructions);

        // Services Required
        servicesRequired = new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Raleway", Font.BOLD, 25));
        servicesRequired.setBounds(70, 450, 300, 30);
        add(servicesRequired);

        // ATM Card Check Box
        atmCard = new JCheckBox("ATM Card");
        atmCard.setForeground(Color.BLACK);
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Raleway", Font.BOLD, 20));
        atmCard.setBounds(200, 500, 200, 25);
        add(atmCard);

        // Internet Banking Check Box
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setForeground(Color.BLACK);
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 20));
        internetBanking.setBounds(400, 500, 200, 25);
        add(internetBanking);

        // Mobile Banking Check Box
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setForeground(Color.BLACK);
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 20));
        mobileBanking.setBounds(200, 545, 200, 25);
        add(mobileBanking);

        // Email & SMS Alerts Check Box
        alerts = new JCheckBox("Email & SMS Alerts");
        alerts.setForeground(Color.BLACK);
        alerts.setBackground(Color.WHITE);
        alerts.setFont(new Font("Raleway", Font.BOLD, 20));
        alerts.setBounds(400, 545, 400, 25);
        add(alerts);

        // Cheque Book Check Box
        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setForeground(Color.BLACK);
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 20));
        chequeBook.setBounds(200, 590, 200, 25);
        add(chequeBook);

        // E-Statement Check Box
        eStatement = new JCheckBox("E-Statement");
        eStatement.setForeground(Color.BLACK);
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Raleway", Font.BOLD, 20));
        eStatement.setBounds(400, 590, 200, 25);
        add(eStatement);

        // Terms Check Box
        terms = new JCheckBox("I hereby declare that the above entered details " +
                "are correct to the best of my knowledge");
        terms.setForeground(Color.BLACK);
        terms.setBackground(Color.WHITE);
        terms.setFont(new Font("Raleway", Font.BOLD, 15));
        terms.setBounds(70, 650, 800, 15);
        add(terms);

        // Submit Button
        submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Raleway", Font.BOLD, 15));
        submit.setBounds(250, 690, 100, 30);
        submit.addActionListener(this);
        add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Raleway", Font.BOLD, 15));
        cancel.setBounds(450, 690, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        // Setting the background color of the frame
        getContentPane().setBackground(Color.WHITE);

        // Setting the starting size of the frame
        setSize(900, 800);
        // Turning on the visibility of the frame
        setVisible(true);
        // Setting the starting location of the frame
        setLocation(350, 10);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String stringFormNumber = "" + formNumber;
            String stringAccountType = null;
            if(savingAccount.isSelected())
            {
                stringAccountType = "Saving Account";
            } else if(fixedDepositAccount.isSelected())
            {
                stringAccountType = "Fixed Deposit Account";
            } else if(currentAccount.isSelected())
            {
                stringAccountType = "Current Account";
            } else if(recurringDepositAccount.isSelected())
            {
                stringAccountType = "Recurring Deposit Account";
            }

            String stringServicesRequired = "";
            if(atmCard.isSelected())
            {
                stringServicesRequired = stringServicesRequired + "ATM Card";
            } else if(internetBanking.isSelected())
            {
                stringServicesRequired = stringServicesRequired + " Internet Banking";
            } else if(mobileBanking.isSelected())
            {
                stringServicesRequired  = stringServicesRequired + " Mobile Banking";
            } else if(alerts.isSelected())
            {
                stringServicesRequired = stringServicesRequired + " Email & SMS Alerts";
            } else if(chequeBook.isSelected())
            {
                stringServicesRequired = stringServicesRequired + " Cheque Book";
            } else if(eStatement.isSelected())
            {
                stringServicesRequired = stringServicesRequired + " E-Statement";
            }

            Random random = new Random();
            String stringCardNumber = Math.abs(random.nextLong() %
                    10000000000000000L) + 1000000000000000L + "";
            String stringPin =  Math.abs(random.nextLong() % 10000) + 1000L+"" ;

            try
            {
                if(stringAccountType.equals("") || stringServicesRequired.equals(""))
                {
                    JOptionPane.showMessageDialog(null,
                            "Please select atleast one of the choices.");
                } else
                {
                    Connections c3 = new Connections();
                    String queryThree = "insert into signup3 values ('" +
                            stringFormNumber + "', '" + stringAccountType + "', '" +
                            stringServicesRequired + "', '" + stringCardNumber + "', '" +
                            stringPin + "')";
                    String queryThree2 = "insert into login values ('" +
                            stringFormNumber + "', '"+ stringCardNumber +
                            "', '" + stringPin + "')";
                    c3.s.executeUpdate(queryThree);
                    c3.s.executeUpdate(queryThree2);

                    JOptionPane.showMessageDialog(null,
                            "Card Number: " + stringCardNumber + "\nPin: " +
                            stringPin);

                    setVisible(false);
                    new Login().setVisible(true);
                }
            } catch(Exception e)
            {
                System.out.println(e);
            }
        } else if(ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new SignUp3("");
    }
}
