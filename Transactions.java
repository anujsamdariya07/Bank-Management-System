package bank.management.system;

import javax.swing.*;// For JFrame, JLabel, JTextField, JButton, ImageIcon
import java.awt.*;// For Color and Font
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For Action Listener
import java.util.*;// For Random

public class Transactions extends JFrame implements ActionListener
{
    ImageIcon i1, i3;
    Image i2;
    JLabel label, introduction;
    JButton deposit, cashWithdrawl, fastCash, pinChange, balanceEnquiry,
            exit;
    String stringPin;
    Transactions(String stringPin)
    {
        this.stringPin = stringPin;

        // Turning on the default layout of the frame
        setLayout(null);

        // Setting title to the frame
        setTitle("Transaction");

        // Adding the background image
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0, 0, 900, 800);
        add(label);

        // Please select your transaction
        introduction = new JLabel("Please Select Your Transaction");
        introduction.setForeground(Color.WHITE);
        introduction.setFont(new Font("Raleway", Font.BOLD, 20));
        introduction.setBounds(180, 260, 300, 30);
        label.add(introduction);

        // Deposit Button
        deposit = new JButton("Deposit");
        deposit.setBackground(Color.GRAY);
        deposit.setForeground(Color.BLACK);
        deposit.setFont(new Font("Raleway", Font.BOLD, 15));
        deposit.setBounds(160, 370, 150, 25);
        deposit.addActionListener(this);
        label.add(deposit);

        // Cash Withdrawl Button
        cashWithdrawl = new JButton("Cash Withdrawl");
        cashWithdrawl.setBackground(Color.GRAY);
        cashWithdrawl.setForeground(Color.BLACK);
        cashWithdrawl.setFont(new Font("Raleway", Font.BOLD, 15));
        cashWithdrawl.setBounds(160, 400, 150, 25);
        cashWithdrawl.addActionListener(this);
        label.add(cashWithdrawl);

        // Fast Cash Button
        fastCash = new JButton("Fast Cash");
        fastCash.setBackground(Color.GRAY);
        fastCash.setForeground(Color.BLACK);
        fastCash.setFont(new Font("Raleway", Font.BOLD, 15));
        fastCash.setBounds(360, 370, 150, 25);
        fastCash.addActionListener(this);
        label.add(fastCash);

        // Pin Change Button
        pinChange = new JButton("Pin Change");
        pinChange.setBackground(Color.GRAY);
        pinChange.setForeground(Color.BLACK);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 15));
        pinChange.setBounds(160, 430, 150, 25);
        pinChange.addActionListener(this);
        label.add(pinChange);

        // Balance Enquiry Button
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBackground(Color.GRAY);
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 14));
        balanceEnquiry.setBounds(360, 400, 150, 25);
        balanceEnquiry.addActionListener(this);
        label.add(balanceEnquiry);

        // Exit Button
        exit = new JButton("Exit");
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Raleway", Font.BOLD, 15));
        exit.setBounds(360, 430, 150, 25);
        exit.addActionListener(this);
        label.add(exit);

        // Setting the starting size of the frame
        setSize(900, 800);
        // Turning on the visibility of the frame
        setVisible(true);
        // Setting the starting location of the frame
        setLocation(350, 10);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit)
        {
            System.exit(0);
        } else if(ae.getSource()== deposit)
        {
            setVisible(false);
            new Deposit(stringPin).setVisible(true);
        } else if(ae.getSource() == cashWithdrawl)
        {
            setVisible(false);
            new Withdraw(stringPin).setVisible(true);
        } else if(ae.getSource() == fastCash)
        {
            setVisible(false);
            new FastCash(stringPin).setVisible(true);
        } else if(ae.getSource() == pinChange)
        {
            setVisible(false);
            new PinChange(stringPin).setVisible(true);
        } else if(ae.getSource() == balanceEnquiry)
        {
            setVisible(false);
            new BalanceEnquiry(stringPin).setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new Transactions("");
    }
}
