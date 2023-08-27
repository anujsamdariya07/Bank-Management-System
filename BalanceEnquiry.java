package bank.management.system;

import javax.swing.*;// For JFrame, JLabel, JTextField, JButton, ImageIcon
import java.awt.*;// For Color and Font
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For Action Listener
import java.sql.ResultSet;
import java.util.*;// For Random

public class BalanceEnquiry extends JFrame implements ActionListener
{
    int balance = 0;
    ImageIcon i1, i3;
    Image i2;
    JLabel label, balanceDisplay, currentBalance;
    JButton back;
    String stringPin;

    BalanceEnquiry(String strinPin)
    {
        this.stringPin = stringPin;

        setLayout(null);

        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0, 0, 900, 800);
        add(label);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.GRAY);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBounds(360, 460, 150, 25);
        back.addActionListener(this);
        label.add(back);

        Connections c = new Connections();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where stringPin = '"
                    + stringPin + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.
                            getString("stringAmount"));
                } else {
                    balance -= Integer.parseInt(rs.
                            getString("stringAmount"));
                }
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }

        balanceDisplay = new JLabel("Current Account Balance");
        balanceDisplay.setForeground(Color.WHITE);
        balanceDisplay.setFont(new Font("Raleway", Font.BOLD, 25));
        balanceDisplay.setBounds(153, 300, 400, 30);
        label.add(balanceDisplay);

        currentBalance = new JLabel("Rs. " + balance);
        currentBalance.setForeground(Color.WHITE);
        currentBalance.setFont(new Font("Raleway", Font.BOLD, 30));
        currentBalance.setBounds(160, 360, 400, 30);
        label.add(currentBalance);

        setSize(900, 800);
        setVisible(true);
        setLocation(350, 10);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(stringPin).setVisible(true);

    }

    public static void main(String[] args)
    {
        new BalanceEnquiry("");
    }
}
