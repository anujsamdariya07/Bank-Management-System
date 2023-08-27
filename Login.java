package bank.management.system;

// For JFrame, JLabel, JTextField, JButton, ImageIcon

import javax.swing.*;
import java.awt.Color;// For Color
import java.awt.Font;// For Font
import java.awt.Image;// For Image
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For ActionListener
import java.sql.ResultSet;// For ResultSet

public class Login extends JFrame implements ActionListener
{
    ImageIcon i1, i3;
    Image i2;
    JLabel label, welcome, cardNumber, pin;
    JTextField cardNumberTextField;
    JPasswordField pinTextField;
    JButton signIn, clear, signUp, exit;

    Login()
    {
        // Assigning title to the frame
        setTitle("Automated Teller Machine");

        // Turning on the custom layout
        setLayout(null);

        // Adding image to the frame
        i1 = new ImageIcon(ClassLoader.
                getSystemResource("icons/logo.jpg"));
        i2 = i1.getImage().getScaledInstance
                        (100, 100, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(100, 50, 100, 100);
        add(label);

        // Setting the background color of the entire frame
        getContentPane().setBackground(Color.WHITE);

        // Welcome to the ATM
        welcome = new JLabel("Welcome to the ATM");
        welcome.setFont(new Font("Osward", Font.BOLD, 38));
        welcome.setBounds(200, 50, 400, 100);
        add(welcome);

        // Card Number
        cardNumber = new JLabel("Card No. : ");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 30));
        cardNumber.setBounds(100, 200, 300, 40);
        add(cardNumber);

        // Card Number TextField
        cardNumberTextField = new JTextField();
        cardNumberTextField.setBounds(300, 210, 250, 30);
        cardNumberTextField.setFont(new Font("Arial", Font.BOLD, 23));
        add(cardNumberTextField);

        // Pin
        pin = new JLabel("Pin : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        pin.setBounds(100, 270, 200, 40);
        add(pin);

        // Pin TextField
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 280, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 23));
        add(pinTextField);

        // Sign In Button
        signIn = new JButton("Sign In");
        signIn.setFont(new Font("Raleway", Font.BOLD, 15));
        signIn.setBounds(300, 350, 100, 25);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);

        // Clear Button
        clear = new JButton("Clear");
        clear.setFont(new Font("Raleway", Font.BOLD, 15));
        clear.setBounds(450, 350, 100, 25);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        // Sign Up Button
        signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Raleway", Font.BOLD, 15));
        signUp.setBounds(300, 400, 100, 25);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        // Exit Button
        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway", Font.BOLD, 15));
        exit.setBounds(450, 400, 100, 25);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        // For assigning size
        setSize(800, 600);
        // For making the frame visible
        setVisible(true);
        // Set starting location
        setLocation(250, 150);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == signIn)
        {
            Connections connection = new Connections();
            String stringCardNumber = cardNumberTextField.getText();
            String stringPin = pinTextField.getText();
            String queryLogin = "select * from login where stringCardNumber = '"
                    + stringCardNumber + "' and stringPin = '" + stringPin + "'";
            try
            {
                ResultSet rs = connection.s.executeQuery(queryLogin);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(stringPin).setVisible(true);
                } else
                {
                    JOptionPane.showMessageDialog(null,
                            "Incorrect Card Number or Pin");
                }
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == clear)
        {
            cardNumberTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == signUp)
        {
            setVisible(false);
            new SignUp().setVisible(true);
        }
        else if(ae.getSource() == exit)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new Login();
    }
}
