package bank.management.system;

import javax.swing.*;// For JFrame, JLabel, JTextField, JButton, ImageIcon
import java.awt.*;// For Color and Font
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For Action Listener
import java.util.*;// For Random

public class Withdraw extends JFrame implements ActionListener
{
    ImageIcon i1, i3;
    Image i2;
    JLabel label, introduction;
    JTextField amountTextField;
    JButton withdraw, back;
    String stringPin;

    Withdraw(String stringPin)
    {
        this.stringPin = stringPin;

        // Turning on the custom layout of the frame
        setLayout(null);

        // Setting the title of the frame
        setTitle("Deposit");

        // Adding the background image to the frame
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0, 0, 900, 800);
        add(label);

        // Introduction
        introduction = new JLabel("Enter the amount you want to withdraw");
        introduction.setForeground(Color.WHITE);
        introduction.setFont(new Font("Raleway", Font.BOLD, 19));
        introduction.setBounds(155, 250, 400, 30);
        label.add(introduction);

        // amountTextField TextField
        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        amountTextField.setBounds(160, 300, 350, 25);
        label.add(amountTextField);

        // Withdraw Button
        withdraw = new JButton("Withdraw");
        withdraw.setForeground(Color.BLACK);
        withdraw.setBackground(Color.GRAY);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 15));
        withdraw.setBounds(360, 428, 150, 25);
        withdraw.addActionListener(this);
        label.add(withdraw);

        // Back Button
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.GRAY);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBounds(360, 460, 150, 25);
        back.addActionListener(this);
        label.add(back);



        // Setting the starting size of the frame
        setSize(900, 800);
        // Turning on the visibility of the frame
        setVisible(true);
        // Setting the staring location of the frame
        setLocation(300, 10);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == withdraw)
        {
            String stringAmount = amountTextField.getText();
            Date date = new Date();
            if(stringAmount.equals(""))
            {
                JOptionPane.showMessageDialog(null,
                        "Please enter the amount you want to deposit.");
            } else
            {
                try
                {
                    Connections c6 = new Connections();
                    String query = "insert into bank values('" + stringPin + "', '" +
                            date + "', '" + "Withdraw" + "', '" + stringAmount + "')";
                    c6.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,
                            "Rs." + stringAmount + " Withdrawn Successfully.");

                    setVisible(false);
                    new Transactions(stringPin).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(stringPin).setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new Withdraw("");
    }
}
