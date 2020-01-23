import java.util.*;
import java.io.*;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
public class Client extends JFrame{
public GUIlogin gui;
public File file = new File("ID.txt");
 public Client(){
try{
  UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
  this.setTitle("Energy Management");   
  this.setSize(700,400); 
  this.setLocation(600, 350);
  gui= new GUIlogin(); 
  gui.JButton5.addActionListener(new Listener());
  this.add(gui);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setVisible(true);  
this.setResizable(true);}
 catch(Exception e){}}
public static void main (String[] args){
  Client a = new Client();
}

class Listener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
   String a = gui.text1.getText();
   String b = gui.text2.getText();
   ArrayList<String> check = new ArrayList<String>();
   String c = a+" "+b;
   try {  
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(file));  
			check = (ArrayList<String>)read.readObject();
            for(int i = 0;i < check.size(); i ++)
			 {
              String[] ID=check.get(i).split(" ");
			  if(a.equals(ID[0])&&b.equals(ID[1])){
			  Object[] options ={ "OK", "Back" };
              JOptionPane.showOptionDialog(null, "ok!", "ok!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
              read.close();
	          return;}}
			  read.close();  
			  Object[] options ={ "OK", "Back" };
              JOptionPane.showOptionDialog(null, "Wrong!", "Wrong!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        } catch (FileNotFoundException e3) {  
            e3.printStackTrace();  
        } catch (IOException e5) { 
            e5.printStackTrace();  
        } catch (ClassNotFoundException e4) {  
            e4.printStackTrace();  
        }
}
} 
 }