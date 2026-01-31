package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SIGNUP1 extends JFrame implements ActionListener {
    long random;
    JTextField n1,f1,m1,a1,c1,s1,p1;
    JButton np;
    JRadioButton male,female,trans,Other,married,unmarried,other2;
    JDateChooser dateChooser;
    SIGNUP1(){
        setLayout(null);


        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);
        JLabel formno = new JLabel("Application form no- "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,28));
        formno.setBounds(250,20,600,40);
        add(formno);


        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personDetails.setBounds(305,80,400,25);
        add(personDetails);


        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(100,160,400,20);
        add(name);

        n1 = new JTextField();
        n1.setFont(new Font("Raleway",Font.BOLD,14));
        n1.setBounds(300,160,400,20);
        add(n1);

        JLabel fname = new JLabel("Fathers name:");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(100,190,400,20);
        add(fname);

        f1 = new JTextField();
        f1.setFont(new Font("Raleway",Font.BOLD,14));
        f1.setBounds(300,190,400,20);
        add(f1);


        JLabel dob = new JLabel("Date of birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(100,220,400,20);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,220,400,20);
        add(dateChooser);


        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(100,250,400,20);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,250,60,20);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(380,250,70,20);
        female.setBackground(Color.WHITE);
        add(female);

        trans = new JRadioButton("Transgender");
        trans.setBounds(480,250,100,20);
        trans.setBackground(Color.WHITE);
        add(trans);

        Other = new JRadioButton("Others");
        Other.setBounds(610,250,80,20);
        Other.setBackground(Color.WHITE);
        add(Other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(trans);
        genderGroup.add(Other);


        JLabel gmail = new JLabel("GMail:");
        gmail.setFont(new Font("Raleway",Font.BOLD,15));
        gmail.setBounds(100,280,400,20);
        add(gmail);

        m1 = new JTextField();
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBounds(300,280,400,20);
        add(m1);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,15));
        marital.setBounds(100,310,400,20);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,310,90,20);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420,310,90,20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other2 = new JRadioButton("Others");
        other2.setBounds(550,310,90,20);
        other2.setBackground(Color.WHITE);
        add(other2);

        ButtonGroup mary = new ButtonGroup();
        mary.add(married);
        mary.add(unmarried);
        mary.add(other2);


        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(100,340,400,20);
        add(address);

        a1 = new JTextField();
        a1.setFont(new Font("Raleway",Font.BOLD,14));
        a1.setBounds(300,340,400,20);
        add(a1);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(100,370,400,20);
        add(city);

        c1 = new JTextField();
        c1.setFont(new Font("Raleway",Font.BOLD,14));
        c1.setBounds(300,370,400,20);
        add(c1);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(100,400,400,20);
        add(state);

        s1 = new JTextField();
        s1.setFont(new Font("Raleway",Font.BOLD,14));
        s1.setBounds(300,400,400,20);
        add(s1);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD,15));
        pincode.setBounds(100,430,400,20);
        add(pincode);

        p1 = new JTextField();
        p1.setFont(new Font("Raleway",Font.BOLD,14));
        p1.setBounds(300,430,400,20);
        add(p1);

        np = new JButton("Next");
        np.setBackground(Color.BLACK);
        np.setForeground(Color.white);
        np.setFont(new Font("Raleway",Font.BOLD,14));
        np.setBounds(600,600,80,20);
        np.addActionListener( this);
        add(np);


        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = n1.getText();
        String fname = f1.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender= null;
        if(male.isSelected()){
            gender="Male";
        }
        else if (female.isSelected()) {
            gender="Female";
        }
        else if (trans.isSelected()) {
            gender="Trans";
        } else if (Other.isSelected()) {
            gender="Other";
        }

        String Gmail = m1.getText();

        String marrital = null;
        if(married.isSelected()){
            marrital="Married";
        }
        else if (unmarried.isSelected()) {
            marrital="Unmarried";
        }
        else if (other2.isSelected()) {
            marrital="Others";
        }

        String address= a1.getText();
        String city= c1.getText();
        String state= s1.getText();
        String pin= p1.getText();

        try {
            Conn c =new Conn();
            String query="insert into signup3 values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+Gmail+"','"+marrital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SIGNUP2(formno).setVisible(true);


        }
        catch(Exception e){
                System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SIGNUP1();
    }
}
