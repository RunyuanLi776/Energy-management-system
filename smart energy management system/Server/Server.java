import java.util.*;
import java.io.*;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
public class Server extends JFrame{
 public Server(){
try{
  UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
  this.setTitle("Energy Management");   
  this.setSize(700,400); 
  this.setLocation(600, 350);
  GUIserver a= new GUIserver(); 
  a.JButton3.addActionListener(new setListener());
  a.JButton1.addActionListener(new addListener());
  a.JButton2.addActionListener(new removeListener());
  a.JButton5.addActionListener(new billListener());
  a.JButton4.addActionListener(new readingsListener());
  this.add(a);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setVisible(true);  
  this.setResizable(true);
  ArrayList<String> ID = new ArrayList<String>();
  ID.add("ID PS");
  try {  
        File files = new File ("ID.txt"); 
        ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream(files,false));  
        os.writeObject(ID);
        os.close();  
        } catch (FileNotFoundException e){  
            e.printStackTrace();  
        } catch (IOException e){  
            e.printStackTrace();  
        } 
    }
 catch(Exception e){}}
public static void main (String[] args){
  Server a = new Server();
}
class setListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    getContentPane().removeAll();
    GUIset a= new GUIset(); 
	a.JButton6.addActionListener(new ServerListener());
    getContentPane().add(a);	
	getContentPane().validate();   
    repaint();
  }
}
class ServerListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    getContentPane().removeAll();
    GUIserver a= new GUIserver(); 
	a.JButton3.addActionListener(new setListener());
	a.JButton1.addActionListener(new addListener());
	a.JButton2.addActionListener(new removeListener());
    a.JButton5.addActionListener(new billListener());
    a.JButton4.addActionListener(new readingsListener());
    getContentPane().add(a);	
	getContentPane().validate();   
    repaint();
  }
}
class addListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    getContentPane().removeAll();
    GUIadd s= new GUIadd(); 
	s.JButton6.addActionListener(new ServerListener());
    getContentPane().add(s);	
	getContentPane().validate();   
    repaint();
  }
}
class removeListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    getContentPane().removeAll();
    GUIremove s= new GUIremove(); 
	s.JButton6.addActionListener(new ServerListener());
    getContentPane().add(s);	
	getContentPane().validate();   
    repaint();
  }
}
class billListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    getContentPane().removeAll();
    billGUI s= new billGUI(); 
	s.JButton6.addActionListener(new ServerListener());
    getContentPane().add(s);	
	getContentPane().validate();   
    repaint();
  }
}
class readingsListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    getContentPane().removeAll();
    GUIreadings s= new GUIreadings(); 
	s.JButton6.addActionListener(new ServerListener());
    getContentPane().add(s);	
	getContentPane().validate();   
    repaint();
  }
}
}