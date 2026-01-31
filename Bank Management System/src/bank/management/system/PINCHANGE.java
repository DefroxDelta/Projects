package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class PINCHANGE extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton cancel,change;
    String Pnum;

    PINCHANGE(String Pnum) {
        this.Pnum=Pnum;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel text = new JLabel("Enter the new pin :");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        text.setBounds(260, 300, 700, 35);
        image.add(text);

        JLabel pinValue = new JLabel("New pin :");
        pinValue.setForeground(Color.white);
        pinValue.setFont(new Font("System", Font.BOLD, 12));
        pinValue.setBounds(170, 350, 100, 20);
        image.add(pinValue);

        pin = new JPasswordField();
        pin.setBounds(320,350,100,20);
        image.add(pin);

        JLabel rvaluePin = new JLabel("Re-enter new pin :");
        rvaluePin.setForeground(Color.white);
        rvaluePin.setFont(new Font("System", Font.BOLD, 12));
        rvaluePin.setBounds(170, 380, 110, 20);
        image.add(rvaluePin);

        repin = new JPasswordField();
        repin.setBounds(320,380,100,20);
        image.add(repin);


        change = new JButton("Change");
        change.setBounds(400,475,100,20);
        change.addActionListener(this);
        image.add(change);

        cancel = new JButton("Cancel");
        cancel.setBounds(170,475,100,20);
        cancel.addActionListener(this);
        image.add(cancel);




        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();


                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match!");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid pin.");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid pin.");
                    return;
                }
                Conn conn = new Conn();
                String query1="UPDATE bank set Pnum = '"+rpin+"' where Pnum = '"+Pnum+"'";
                String query2="UPDATE login set Pnum = '"+rpin+"' where Pnum = '"+Pnum+"'";
                String query3="UPDATE signup5 set Pnum = '"+rpin+"' where Pnum = '"+Pnum+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);


                JOptionPane.showMessageDialog(null,"PIN changed successfully.");
                setVisible(false);
                new Transactions(Pnum).setVisible(true);

            }

            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transactions(Pnum).setVisible(true);
        }
    }


public static void main(String[] args) {
    new PINCHANGE("");
}
}

