package bank.management.system;

import javax.swing.*;// For JFrame, JLabel, JTextField, JButton, ImageIcon
import java.awt.*;// For Color and Font
import java.awt.event.ActionEvent;// For ActionEvent
import java.awt.event.ActionListener;// For Action Listener
import java.sql.ResultSet;
import java.util.*;// For Random

public class PinChange extends JFrame implements ActionListener
{
    ImageIcon i1, i3;
    Image i2;
    JLabel label, text, newPin, confirmNewPin;
    JPasswordField newPinTextField, confirmNewPinTextField;
    JButton change, back;
    String stringPin;

    PinChange(String stringPin)
    {
        this.stringPin = stringPin;

        // Turning on custom layout
        setLayout(null);

        // Setting the image for background
        i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0, 0, 900, 800);
        add(label);

        // 'Change your pin'
        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 25));
        text.setBounds(225, 280, 400, 30);
        label.add(text);

        // New Pin
        newPin = new JLabel("New Pin:");
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("Raleway", Font.BOLD, 25));
        newPin.setBounds(155, 370, 200, 30);
        label.add(newPin);

        // New Pin Textfield
        newPinTextField = new JPasswordField();
        newPinTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        newPinTextField.setBounds(310, 370, 200, 25);
        label.add(newPinTextField);

        // Confirm New Pin
        confirmNewPin = new JLabel("Confirm Pin:");
        confirmNewPin.setForeground(Color.WHITE);
        confirmNewPin.setFont(new Font("Raleway", Font.BOLD, 25));
        confirmNewPin.setBounds(155, 405, 200, 30);
        label.add(confirmNewPin);

        // Confirm New Pin TextField
        confirmNewPinTextField = new JPasswordField();
        confirmNewPinTextField.setForeground(Color.WHITE);
        confirmNewPinTextField.setFont(new Font("Raleway", Font.BOLD, 15));
        confirmNewPinTextField.setBounds(310, 405, 200, 25);
        label.add(confirmNewPinTextField);

        // Change Button
        change = new JButton("Change");
        change.setForeground(Color.BLACK);
        change.setBackground(Color.GRAY);
        change.setFont(new Font("Raleway", Font.BOLD, 15));
        change.setBounds(160, 455, 150, 30);
        change.addActionListener(this);
        label.add(change);

        // Back Button
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.GRAY);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBounds(360, 455, 150, 30);
        back.addActionListener(this);
        label.add(back);

        // Starting size of the frame
        setSize(900, 800);
        // Starting location of the frame
        setLocation(350, 10);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == change)
        {
            try {
                String stringNewPin = newPinTextField.getText();
                String stringConfirmNewPin = confirmNewPinTextField.getText();

                if (!stringNewPin.equals(stringConfirmNewPin)) {
                    JOptionPane.showMessageDialog(null,
                            "Pin Doesn't Match.");
                    return;
                }

                if(stringNewPin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,
                            "Please Enter New Pin.");
                    return;
                } else if(stringConfirmNewPin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,
                            "Please Confirm Your New Pin.");
                    return;
                }

                Connections c = new Connections();
                String query = "update bank set stringPin = '" + stringNewPin +
                        "' where stringPin = '" + stringPin + "'";
                String query2 = "update signup3 set stringPin = '" + stringNewPin +
                        "' where stringPin = '" + stringPin + "'";
                String query3 = "update login set stringPin = '" + stringNewPin +
                        "' where stringPin = '" + stringPin + "'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,
                        "Pin Changed Successfully.");
                setVisible(false);
                new Transactions(stringNewPin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(stringPin).setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new PinChange("").setVisible(true);
    }
}
