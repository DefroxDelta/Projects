package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FASTCASH extends JFrame implements ActionListener {


    JButton hundred,fiveHundred,thousand,twoThousand,fiveThousand,tenThousand,back;
    String Pnum;

    FASTCASH(String Pnum){

        this.Pnum=Pnum;


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel text = new JLabel("Please select withdrawl amount :");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);

        hundred = new JButton("Rs 100");
        hundred.setBounds(170,398,150,30);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(350,398,150,30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        thousand = new JButton("Rs 1000");
        thousand.setBounds(170,431,150,30);
        thousand.addActionListener(this);
        image.add(thousand);

        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(350,431,150,30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(170,465,150,30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("Rs 10000 ");
        tenThousand.setBounds(350,465,150,30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("Back");
        back.setBounds(350,500,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
        setVisible(false);
        new Transactions(Pnum).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("SELECT * FROM bank where Pnum = '" + Pnum + "'");
                int balance = 0;

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else if(rs.getString("type").equals("Withdrawl")) {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }

                Date date = new Date();
                String query = "INSERT into bank values('"+Pnum+"','"+date+"','Withdraw','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" debited successfully.");

                setVisible(false);
                new Transactions(Pnum).setVisible(true);
            }


            catch(Exception e){
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {

        new FASTCASH("");
    }
}

