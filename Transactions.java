
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, ministatement, pinchange, fastcash, balance,exit;
    
    String pinnumber;
    Transactions(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(215,220,800,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
         deposit = new JButton("Deposit");
        deposit.setBounds(170,320,150,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
          withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,320,150,20);
         withdrawl.addActionListener(this);
        image.add(withdrawl);
        
          fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,345,150,20);
         fastcash.addActionListener(this);
        image.add(fastcash);
        
          ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,345,150,20);
         ministatement.addActionListener(this);
        image.add(ministatement);
        
        
         pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,370,150,20);
         pinchange.addActionListener(this);
        image.add(pinchange);
        
          balance = new JButton("Balance Enquiry");
        balance.setBounds(355,370,150,20);
         balance.addActionListener(this);
        image.add(balance);
        
          exit = new JButton("Exit");
        exit.setBounds(355,395,150,20);
         exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,700);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            
        }else if (ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new Transactions("");
    }
    
}
