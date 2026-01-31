package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

    JButton login,clear,signup;
    JTextField T1;
    JPasswordField p1;
    Login() {
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader. getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Oswald",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("CARD NO : ");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(200,150,300,30);
        add(cardno);
        T1 = new JTextField();
        T1.setBounds(330,150,250,30);
        T1.setFont(new Font("Arial",Font.BOLD,14));
        add(T1);


        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(200,220,400,30);
        add(pin);
        p1 = new JPasswordField();
        p1.setBounds(330,220,250,30);

        add(p1);

        login =  new JButton("SIGN IN");
        login.setBounds(330,280,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear =  new JButton("CLEAR");
        clear.setBounds(480,280,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);

        add(clear);

        signup =  new JButton("SIGN UP");
        signup.setBounds(330,320,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);

        add(signup);



        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setLocation(350,200);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            T1.setText("");
            p1.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardno = T1.getText();
            String pin = p1.getText();
            String query="select * from login where Cnum = '"+cardno+"' and Pnum = '"+pin+"'";
            try {
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect pin or cardno!");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == login) {

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SIGNUP1().setVisible(true);

        }
    }
    public static void main(String[] args) {

        new Login();
    }

    }
