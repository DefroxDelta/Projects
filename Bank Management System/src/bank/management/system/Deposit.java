package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener {
    JButton amount1,deposit,cancel;
    JTextField amount;
    String Pnum;

    Deposit(String Pnum) {

        this.Pnum=Pnum;

        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to deposit ");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        text.setBounds(200,300,700,35);
        image.add(text);

        JLabel amount1 = new JLabel("Amount :");
        amount1.setForeground(Color.white);
        amount1.setFont(new Font("System",Font.BOLD,12));
        amount1.setBounds(250,400,50,20);
        image.add(amount1);

        amount = new JTextField();
        amount.setBounds(320,400,100,20);
        image.add(amount);


        deposit = new JButton("Deposit");
        deposit.setBounds(400,490,100,20);
        deposit.addActionListener(this);

        image.add(deposit);

        cancel = new JButton("Cancel");
        cancel.setBounds(170,490,100,20);
        cancel.addActionListener(this);
        image.add(cancel);

        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() ==deposit){
            String number = amount.getText();
            Date date = new Date();

            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Amount cannot be null! Please enter valid amount.");
            }
            else{
                try{
                Conn conn = new Conn();
                    String query1 = "INSERT INTO bank (Pnum, date, type, amount) VALUES ('"+Pnum+"', '"+date+"', 'Deposit', '"+number+"')";
                conn.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Deposited successfully." );
                setVisible(false);
                new Transactions(Pnum).setVisible(true);
            }
                catch(Exception e){
                    System.out.println(e);
                }
        }

        }
        else if (ae.getSource()==cancel) {
            setVisible(false);
            new Transactions(Pnum).setVisible(true);
        }

    }


    public static void main(String[] args) {
        new Deposit("");
    }

}
