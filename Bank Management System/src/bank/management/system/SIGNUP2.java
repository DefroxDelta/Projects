package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SIGNUP2 extends JFrame implements ActionListener {
    JTextField aadhar,pan;
    JButton np;
    JRadioButton sc1,sc2,EA1,EA2;
    JComboBox religion,Category,Income,eduQual,Occu;
    String formno;

    SIGNUP2(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetails.setBounds(305,80,400,25);
        add(additionalDetails);


        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,15));
        name.setBounds(100,160,400,20);
        add(name);

        String valReligion[] = {"Hindu","Muslim","Christian","Sikh","Buddist","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,160,400,20);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fname = new JLabel("Category :");
        fname.setFont(new Font("Raleway",Font.BOLD,15));
        fname.setBounds(100,190,400,20);
        add(fname);

        String valCategory[] = {"General","OBC","SC","ST","Other"};
        Category = new JComboBox(valCategory);
        Category.setBounds(300,190,400,20);
        Category.setBackground(Color.WHITE);
        add(Category);


        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(100,220,400,20);
        add(dob);

        String valIncome[] = {"Null","<3,00,000","<5,00,000","<10,00,000",">10,00,000"};
        Income = new JComboBox(valIncome);
        Income.setBounds(300,220,400,20);
        Income.setBackground(Color.WHITE);
        add(Income);


        JLabel gender = new JLabel("Educational Qualification:");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(100,260,400,20);
        add(gender);


        String valEduQual[] = {"Secondary","Higher Secondary","Non-Graduation","UnderGraduate","Post Graduate","Doctorate","Others"};
        eduQual = new JComboBox(valEduQual);
        eduQual.setBounds(300,260,400,20);
        eduQual.setBackground(Color.WHITE);
        add(eduQual);


        JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("Raleway",Font.BOLD,15));
        marital.setBounds(100,296,400,20);
        add(marital);

        String valOccu[] = {"Salaried","Self-employed","Businessman","Student","Unemployed","Retired","Others"};
        Occu = new JComboBox(valOccu);
        Occu.setBounds(300,300,400,20);
        Occu.setBackground(Color.WHITE);
        add(Occu);


        JLabel pan1 = new JLabel("PAN No:");
        pan1.setFont(new Font("Raleway",Font.BOLD,15));
        pan1.setBounds(100,340,400,20);
        add(pan1);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,340,400,20);
        add(pan);

        JLabel ADHAR = new JLabel("Aadhar No :");
        ADHAR.setFont(new Font("Raleway",Font.BOLD,15));
        ADHAR.setBounds(100,370,400,20);
        add(ADHAR);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,370,400,20);
        add(aadhar);

        JLabel seniorcitizen = new JLabel("Senior citizen:");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,15));
        seniorcitizen.setBounds(100,400,400,20);
        add(seniorcitizen);

        sc1 = new JRadioButton("Yes");
        sc1.setFont(new Font("Raleway",Font.BOLD,15));
        sc1.setBounds(300,400,60,20);
        sc1.setBackground(Color.WHITE);
        add(sc1);

        sc2 = new JRadioButton("NO");
        sc2.setFont(new Font("Raleway",Font.BOLD,14));
        sc2.setBounds(380,400,60,20);
        sc2.setBackground(Color.WHITE);
        add(sc2);

        ButtonGroup SENIORGROUP = new ButtonGroup();
        SENIORGROUP.add(sc1);
        SENIORGROUP.add(sc2);

        JLabel pincode = new JLabel("Existing account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,15));
        pincode.setBounds(100,430,400,20);
        add(pincode);

        EA1 = new JRadioButton("Yes");
        EA1.setFont(new Font("Raleway",Font.BOLD,14));
        EA1.setBounds(300,430,60,20);
        EA1.setBackground(Color.WHITE);
        add(EA1);

        EA2 = new JRadioButton("No");
        EA2.setFont(new Font("Raleway",Font.BOLD,14));
        EA2.setBounds(380,430,60,20);
        EA2.setBackground(Color.WHITE);
        add(EA2);

        ButtonGroup EXISTGROUP = new ButtonGroup();
        EXISTGROUP.add(EA1);
        EXISTGROUP.add(EA2);




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
        String sreligion  = (String) religion.getSelectedItem();
        String scategory = (String)  Category.getSelectedItem();
        String sincome = (String)  Income.getSelectedItem();
        String seduQual= (String)  eduQual.getSelectedItem();
        String soccupation = (String)  Occu.getSelectedItem();
        String span = pan.getText();
        String saadhar = aadhar.getText();

        String state = null ;
        if(sc1.isSelected()){
            state="Yes";
        }
        else if (sc2.isSelected()) {
            state="No";
        }

        String Exist= null;
        if(EA1.isSelected()){
            Exist="Yes";
        }
        else if (EA2.isSelected()) {
            Exist="No";
        }


        try {
                Conn c =new Conn();
                String query="insert into signup4 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seduQual+"','"+soccupation+"','"+state+"','"+saadhar+"','"+span+"','"+Exist+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SIGNUP3(formno).setVisible(true);
            }

        catch(Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SIGNUP2("");
    }
}