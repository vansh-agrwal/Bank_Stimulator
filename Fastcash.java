
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balance,back;
    
    String pinnumber;
    Fastcash(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(215,220,800,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
         deposit = new JButton("Rs 100");
        deposit.setBounds(170,320,150,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
          withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355,320,150,20);
         withdrawl.addActionListener(this);
        image.add(withdrawl);
        
          fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,345,150,20);
         fastcash.addActionListener(this);
        image.add(fastcash);
        
          ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355,345,150,20);
         ministatement.addActionListener(this);
        image.add(ministatement);
        
        
         pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,370,150,20);
         pinchange.addActionListener(this);
        image.add(pinchange);
        
          balance = new JButton("Rs 10000");
        balance.setBounds(355,370,150,20);
         balance.addActionListener(this);
        image.add(balance);
        
          back = new JButton("Back");
        back.setBounds(355,395,150,20);
         back.addActionListener(this);
        image.add(back);
        
        setSize(900,700);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
                String amount = ((JButton)ae.getSource()).getText().substring(3); // Rs 500
                Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                   balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }  
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficient Balnce");
                return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount + " Debited Sucessfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } 
            catch (Exception e){
                System.out.println(e);
            }
        }
        
    }
    
    public static void main(String args[]){
        new Fastcash("");
    }
    
}
