package bank.management.system;

import javax.swing.*;// For JFrame, JLabel, JTextField, JButton, ImageIcon
import java.awt.*;// For Color and Font
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For Action Listener
import java.sql.ResultSet;
import java.util.*;// For Random

public class MiniStatement extends JFrame
{
    ImageIcon i1, i3;
    Image i2;
    JLabel indianBank, cardNumber;
    String stringPin;

    MiniStatement(String stringPin)
    {
        this.stringPin = stringPin;

        setLayout(null);

        setTitle("Mini-Statement");

        indianBank = new JLabel("- - - - - Indian Bank - - - - -");
        indianBank.setFont(new Font("Raleway", Font.BOLD, 20));
        indianBank.setBounds(90, 30, 300, 20);
        add(indianBank);

        cardNumber = new JLabel();
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNumber.setBounds(100, 60, 300, 20);
        add(cardNumber);

        try
        {
            Connections c = new Connections();
            ResultSet rs = c.s.executeQuery("select * from login where stringPin = '"
            + stringPin + "'");
            while(rs.next())
            {
                cardNumber.setText("Card Number: " + rs.getString
                        ("stringCardNumber"));
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }

        setSize(420, 600);
        setVisible(true);
        setLocation(450, 100);
    }

    public static void main(String[] args)
    {
        new MiniStatement("");
    }
}
