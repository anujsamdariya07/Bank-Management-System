package bank.management.system;

import javax.swing.*;// For JFrame, JLabel, JTextField, JButton, ImageIcon
import java.awt.*;// For Color and Font
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For Action Listener
import java.sql.ResultSet;
import java.util.*;// For Random

public class FastCash extends JFrame implements ActionListener
{
    ImageIcon i1, i3;
    Image i2;
    JLabel label, introduction;
    JButton rs100, rs200, rs500, rs1000, rs5000, rs10000, back;
    String stringPin;
    FastCash(String stringPin)
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
        introduction = new JLabel("Please Select Withdrawl Amount");
        introduction.setForeground(Color.WHITE);
        introduction.setFont(new Font("Raleway", Font.BOLD, 20));
        introduction.setBounds(180, 260, 300, 30);
        label.add(introduction);

        // Rs. 100 Button
        rs100 = new JButton("Rs. 100");
        rs100.setBackground(Color.GRAY);
        rs100.setForeground(Color.BLACK);
        rs100.setFont(new Font("Raleway", Font.BOLD, 15));
        rs100.setBounds(160, 370, 150, 25);
        rs100.addActionListener(this);
        label.add(rs100);

        // Rs. 200 Button
        rs200 = new JButton("Rs. 200");
        rs200.setBackground(Color.GRAY);
        rs200.setForeground(Color.BLACK);
        rs200.setFont(new Font("Raleway", Font.BOLD, 15));
        rs200.setBounds(160, 400, 150, 25);
        rs200.addActionListener(this);
        label.add(rs200);

        // Rs. 500 Button
        rs500 = new JButton("Rs. 500");
        rs500.setBackground(Color.GRAY);
        rs500.setForeground(Color.BLACK);
        rs500.setFont(new Font("Raleway", Font.BOLD, 15));
        rs500.setBounds(360, 370, 150, 25);
        rs500.addActionListener(this);
        label.add(rs500);

        // Rs. 1000 Button
        rs1000 = new JButton("Rs. 1000");
        rs1000.setBackground(Color.GRAY);
        rs1000.setForeground(Color.BLACK);
        rs1000.setFont(new Font("Raleway", Font.BOLD, 15));
        rs1000.setBounds(360, 400, 150, 25);
        rs1000.addActionListener(this);
        label.add(rs1000);

        // Rs. 5000 Button
        rs5000 = new JButton("Rs. 5000");
        rs5000.setBackground(Color.GRAY);
        rs5000.setForeground(Color.BLACK);
        rs5000.setFont(new Font("Raleway", Font.BOLD, 15));
        rs5000.setBounds(160, 430, 150, 25);
        rs5000.addActionListener(this);
        label.add(rs5000);

        // Rs. 10000 Button
        rs10000 = new JButton("Rs. 10000");
        rs10000.setBackground(Color.GRAY);
        rs10000.setForeground(Color.BLACK);
        rs10000.setFont(new Font("Raleway", Font.BOLD, 15));
        rs10000.setBounds(360, 430, 150, 25);
        rs10000.addActionListener(this);
        label.add(rs10000);

        // Back Button
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(360, 460, 150, 25);
        back.addActionListener(this);
        label.add(back);

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
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(stringPin).setVisible(true);
        } else
        {
            String stringAmount = ((JButton)(ae.getSource())).getText().
                    substring(4);
            Connections c = new Connections();
            try
            {
                ResultSet rs =c.s.executeQuery("select * from bank where stringPin = '"
                        + stringPin + "'");
                int balance = 0;
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rs.
                                getString("stringAmount"));
                    } else
                    {
                        balance -= Integer.parseInt(rs.
                                getString("stringAmount"));
                    }
                }
                if((ae.getSource() != back) && (balance < Integer.parseInt(stringAmount)))
                {
                    JOptionPane.showMessageDialog(null,
                            "Insufficient Balance");
                }

                Date date = new Date();
                String query = "insert into bank values('" + stringPin + "', '" +
                        date + "', '" + "Deposit" + "', '" + stringAmount + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,
                        "Rs. " + stringAmount + " Debited Successfully");
                setVisible(false);
                new Transactions(stringPin).setVisible(true);
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args)
    {
        new FastCash("");
    }
}
