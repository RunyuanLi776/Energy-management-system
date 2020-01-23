import java.util.*;
import java.io.*;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
public class GUIserver extends JPanel{
JButton JButton1,JButton2,JButton3,JButton4,JButton5;
  public GUIserver(){  
  this.setLayout(new BorderLayout());
  JButton1=new JButton("Add Consumer");
  JButton2=new JButton("Remove Consumer");
  JButton3=new JButton("Set tariff");
  JButton4=new JButton("Check readings");
  JButton5=new JButton("Check historic bill");
  JButton JButton6=new JButton("back");
  //JButton1.addActionListener(new AddListener());  
  //JButton2.addActionListener(this);  
  //JButton4.addActionListener(this);  
  //JButton5.addActionListener(this);  
  JButton1.setFont(new Font("宋体", Font.PLAIN, 18));
  JButton2.setFont(new Font("宋体", Font.PLAIN, 18));
  JButton3.setFont(new Font("宋体", Font.PLAIN, 18));
  JButton4.setFont(new Font("宋体", Font.PLAIN, 18));
  JButton5.setFont(new Font("宋体", Font.PLAIN, 18));	
  JPanel JPanel1 = new JPanel(new GridLayout(0,1,0,10));
  JPanel JPanel2 = new JPanel(new FlowLayout(0));
  JPanel JPanel3 = new JPanel();
  JPanel JPanel4 = new JPanel(new FlowLayout(2));
  JPanel JPanel5 = new JPanel(new BorderLayout());
  JPanel4.add(JButton6);
  JLabel JLabel1 = new JLabel();
  JPanel2.add(JLabel1);
  JLabel1.setPreferredSize(new Dimension(100,40));
  this.add(JPanel2,BorderLayout.NORTH);
  this.add(JPanel4,BorderLayout.SOUTH);
  JPanel1.add(JButton1);   
  JPanel1.add(JButton2);
  JPanel1.add(JButton3);
  JPanel1.add(JButton4); 
  JPanel1.add(JButton5); 
  JPanel3.add(JPanel1);
  this.add(JPanel3,BorderLayout.CENTER);
}
 }