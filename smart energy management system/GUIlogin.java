import java.util.*;
import java.io.*;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
public class GUIlogin extends JPanel{
public JButton JButton5,JButton6; 
public JTextField text1,text2;
 public GUIlogin(){
  this.setLayout(new BorderLayout());
  JLabel JLabel1 = new JLabel("LOG IN:");
  JLabel1.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
  JPanel JPanel2 = new JPanel(new FlowLayout(0));
  JPanel2.add(JLabel1);
  JLabel1.setPreferredSize(new Dimension(300,50));
  this.add(JPanel2,BorderLayout.NORTH);
  JButton5=new JButton("Done");
  JButton6=new JButton("Back"); 
  JPanel JPanel3 = new JPanel();
  JPanel JPanel1 = new JPanel(new FlowLayout(2));
  JPanel1.add(JPanel3);
  JPanel3.add(JButton5);
  JPanel3.add(JButton6);
  this.add(JPanel1,BorderLayout.SOUTH);
  JPanel JPanel4 = new JPanel(new BorderLayout());
  JPanel JPanel5 = new JPanel();
  JPanel JPanel6 = new JPanel();
  JPanel5.add(new JLabel("ID:"));
  text1 = new JTextField(10);
  text2 = new JTextField(10);
  JPanel5.add(text1);
  JPanel6.add(new JLabel("PS:"));
  JPanel6.add(text2);
  JPanel4.add(JPanel5,BorderLayout.NORTH);
  JPanel4.add(JPanel6,BorderLayout.CENTER);
  this.add(JPanel4,BorderLayout.CENTER);
  }
 }