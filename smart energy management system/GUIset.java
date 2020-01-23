import java.util.*;
import java.io.*;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
public class GUIset extends JPanel{
public File file = new File("charge.txt");
public JButton JButton5,JButton6; 
public JTextField text1,text2;
 public GUIset(){
  this.setLayout(new BorderLayout());
  JLabel JLabel1 = new JLabel("Please set tariff:");
  JLabel1.setFont(new Font("??", Font.PLAIN, 18));
  JPanel JPanel2 = new JPanel(new FlowLayout(0));
  JPanel2.add(JLabel1);
  JLabel1.setPreferredSize(new Dimension(300,50));
  this.add(JPanel2,BorderLayout.NORTH);
  JButton5=new JButton("Done");
  JButton6=new JButton("Back");
  JButton5.addActionListener(new Listener()); 
  JPanel JPanel3 = new JPanel();
  JPanel JPanel1 = new JPanel(new FlowLayout(2));
  JPanel1.add(JPanel3);
  JPanel3.add(JButton5);
  JPanel3.add(JButton6);
  this.add(JPanel1,BorderLayout.SOUTH);
  JPanel JPanel4 = new JPanel(new BorderLayout());
  JPanel JPanel5 = new JPanel();
  JPanel JPanel6 = new JPanel();
  JPanel5.add(new JLabel("Ele:"));
  BufferedReader read =  null;
  try{
        read=new BufferedReader(new FileReader(file));
        String ele=read.readLine();
        String gas=read.readLine();
        read.close();
  text1 = new JTextField(ele,10);
  text2 = new JTextField(gas,10);
  JPanel5.add(text1);
  JPanel5.add(new JLabel("kw/h"));
  JPanel6.add(new JLabel("Gas:"));
  JPanel6.add(text2);
  JPanel6.add(new JLabel("kw/h"));
  JPanel4.add(JPanel5,BorderLayout.NORTH);
  JPanel4.add(JPanel6,BorderLayout.CENTER);
  this.add(JPanel4,BorderLayout.CENTER);
  }
  catch (IOException e) {  
  e.printStackTrace();}
  }
class Listener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
   String a = text1.getText();
   String b = text2.getText();
   BufferedWriter writer = null;
   try{
        writer=new BufferedWriter(new FileWriter(file,false));
        writer.write(a); 
        writer.newLine();
        writer.write(b); 
        writer.close();}
	catch (IOException q) {  
         q.printStackTrace();}
/*    JFrame newjframe = new JFrame();
	JLabel myjlabel=new JLabel("The charge has changed!");
	myjlabel.setFont(new Font("Arial", Font.PLAIN, 18));
	newjframe.getContentPane().add(myjlabel);
	this.setTitle("Energy Management");   
  this.setSize(700,400); 
  this.setLocation(400, 200);*/
//JOptionPane.showConfirmDialog(null, "The charge has changed!", "The charge has changed!", JOptionPane.YES_NO_OPTION); 
//JOptionPane.showMessageDialog(null, "The charge has changed!");
  Object[] options ={ "OK", "Back" };
  JOptionPane.showOptionDialog(null, "The charge has changed!", "The charge has changed!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);  
  }
}
} 