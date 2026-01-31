package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.*;


public class SIGNUP3 extends JFrame implements ActionListener {
    JRadioButton Savings,FD,Current,RD;
    JCheckBox A1,B1,C1,D1,E1,F1,G1;
    JButton submit,cancel;
    String formno;


    SIGNUP3(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel l1 = new JLabel("Page 3 - Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type : ");
        type.setFont(new Font("Raleway",Font.BOLD,15));
        type.setBounds(80,120,200,20);
        add(type);

        Savings = new JRadioButton("Basic Savings Account");
        Savings.setBounds(300,120,160,20);
        Savings.setBackground(Color.WHITE);
        add(Savings);

        Current = new JRadioButton(" Current Account");
        Current.setBounds(470,120,150,20);
        Current.setBackground(Color.WHITE);
        add(Current);

        FD = new JRadioButton("Fixed Deposit Account");
        FD.setBounds(300,140,160,20);
        FD.setBackground(Color.WHITE);
        add(FD);

        RD = new JRadioButton("Reccuring Deposit Account");
        RD.setBounds(470,140,200,20);
        RD.setBackground(Color.WHITE);
        add(RD);

        ButtonGroup Accuntgroup = new ButtonGroup();
        Accuntgroup.add(Savings);
        Accuntgroup.add(Current);
        Accuntgroup.add(FD);
        Accuntgroup.add(RD);

        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,15));
        card.setBounds(80,200,200,20);
        add(card);

        JLabel cnum = new JLabel("XXXX-XXXX-XXXX-2004");
        cnum.setFont(new Font("Raleway",Font.BOLD,15));
        cnum.setBounds(300,200,200,20);
        add(cnum);

        JLabel pin = new JLabel("Pin no :");
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(80,250,200,20);
        add(pin);

        JLabel pnum = new JLabel("XXXX");
        pnum.setFont(new Font("Raleway",Font.BOLD,15));
        pnum.setBounds(300,250,200,20);
        add(pnum);

        JLabel services = new JLabel("Services required :");
        services.setFont(new Font("Raleway",Font.BOLD,15));
        services.setBounds(80,300,200,20);
        add(services);

        A1=new JCheckBox("ATM Card");
        A1.setBackground(Color.WHITE);
        A1.setFont(new Font("Raleway",Font.BOLD,12));
        A1.setBounds(300,300,80,20);
        add(A1);

        B1=new JCheckBox("Internet Banking");
        B1.setBackground(Color.WHITE);
        B1.setFont(new Font("Raleway",Font.BOLD,12));
        B1.setBounds(400,300,120,20);
        add(B1);

        C1=new JCheckBox("Mobile Banking");
        C1.setBackground(Color.WHITE);
        C1.setFont(new Font("Raleway",Font.BOLD,12));
        C1.setBounds(540,300,120,20);
        add(C1);

        D1=new JCheckBox("Cheque Book");
        D1.setBackground(Color.WHITE);
        D1.setFont(new Font("Raleway",Font.BOLD,12));
        D1.setBounds(300,320,100,20);
        add(D1);

        E1=new JCheckBox("E-Statement");
        E1.setBackground(Color.WHITE);
        E1.setFont(new Font("Raleway",Font.BOLD,12));
        E1.setBounds(400,320,100,20);
        add(E1);

        F1=new JCheckBox("SMS-EMail alerts");
        F1.setBackground(Color.WHITE);
        F1.setFont(new Font("Raleway",Font.BOLD,12));
        F1.setBounds(540,320,100,20);
        add(F1);

        G1=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        G1.setBackground(Color.WHITE);
        G1.setFont(new Font("Raleway",Font.BOLD,12));
        G1.setBounds(80,500,580,15);
        add(G1);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.setBounds(600,600,100,20);
        submit.addActionListener(this);
        add(submit);


        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,15));
        cancel.setBounds(80,600,100,20);
        cancel.addActionListener(this);
        add(cancel);



        getContentPane().setBackground(Color.WHITE);
        setSize(800, 800);
        setLocation(350,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType=null;
            if(Savings.isSelected()){
                accountType="Savings Account";
            }
            if(Current.isSelected()){
                accountType="Current Account";
            }
            if(FD.isSelected()){
                accountType="Fixed Deposit Account";
            }
            if(RD.isSelected()){
                accountType="Reccuring Deposit Account";
            }

            Random random = new Random();
            String Cnum = ""+Math.abs(random.nextLong()%90000000L+5040936000000000L);
            String Pnum = ""+Math.abs((random.nextLong() % 9000L)+1000L);
            String facility = "";

            if(A1.isSelected()){
                facility=facility+"ATM Card";
            }
            else if (B1.isSelected()) {
                facility=facility+"Internet Banking";
            }
            else if (C1.isSelected()) {
                facility=facility+"Mobile Banking";
            }
            else if (D1.isSelected()){
                facility=facility+"Cheque Book";
            }
            else if (E1.isSelected()) {
                facility=facility+"E-Statement";
            }
            else if (F1.isSelected()) {
                facility=facility+"SMS-EMail alerts";
            }

            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"ACC type required");
                }
                Conn conn = new Conn();
                String query1="insert into signup5 values('"+formno+"','"+accountType+"','"+Cnum+"','"+Pnum+"','"+facility+"')";
                String query2="insert into login values('"+formno+"','"+Cnum+"','"+Pnum+"')";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card No: "+Cnum+"\n Pin: "+Pnum);
                setVisible(false);
                new Deposit(Pnum).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        else if (ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);

        }
    }

    public static void main(String[] args) {
        new SIGNUP3("");

    }
}
