package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener {


    JButton deposit,withdrawl,fastCash,stmt,pinChange,balanceEnquiry,Exit;
    String Pnum;

    Transactions(String Pnum){

        this.Pnum=Pnum;


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,398,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(350,398,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,431,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        stmt = new JButton("Mini Statement");
        stmt.setBounds(350,431,150,30);
        stmt.addActionListener(this);
        image.add(stmt);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,465,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(350,465,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        Exit = new JButton("Exit");
        Exit.setBounds(350,500,150,30);
        Exit.addActionListener(this);
        image.add(Exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(Pnum).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(Pnum).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FASTCASH(Pnum).setVisible(true);
        }else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PINCHANGE(Pnum).setVisible(true);
        }

    }
    public static void main(String[] args) {

        new Transactions("");
    }
}
