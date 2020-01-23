import java.io.*;
import java.util.*;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
public class GUIremove extends JPanel{
public JTextField text1,text2;
public JButton JButton5,JButton6; 
public File file = new File("ID.txt");
 public GUIremove(){
  this.setLayout(new BorderLayout());
  JLabel JLabel1 = new JLabel("Add Consumer");  
  JLabel1.setFont(new Font("ËÎÌו", Font.PLAIN, 18));
  JPanel JPanel2 = new JPanel(new FlowLayout(0));
  JPanel JPanel4 = new JPanel(new BorderLayout());
  JPanel JPanel5 = new JPanel();
  JPanel JPanel6 = new JPanel();
  JPanel JPanel3 = new JPanel(new FlowLayout(2));
  JPanel2.add(JLabel1);
  JLabel1.setPreferredSize(new Dimension(300,50));
  this.add(JPanel2,BorderLayout.NORTH);
  text1 = new JTextField(15);
  text2 = new JTextField(15);
  JPanel5.add(new JLabel("ID:"));
  JPanel5.add(text1);
  JPanel6.add(new JLabel("PS:"));
  JPanel6.add(text2);
  JPanel4.add(JPanel5,BorderLayout.NORTH);
  JPanel4.add(JPanel6,BorderLayout.CENTER);
  this.add(JPanel4,BorderLayout.CENTER);
  JButton5=new JButton("Done");
  JButton6=new JButton("Back");
  JButton5.addActionListener(new Listener()); 
  JPanel3.add(JButton5);
  JPanel3.add(JButton6);
 this.add(JPanel3,BorderLayout.SOUTH);}
 
 class Listener implements ActionListener {
  public void actionPerformed(ActionEvent e) {  String a = text1.getText();
   String b = text2.getText();
   if(a.equals("")||b.equals("")){
	  Object[] options ={ "OK", "Back" };
      JOptionPane.showOptionDialog(null, "You can't input null!", "Waring!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	  return;
   }
   ArrayList<String> check = new ArrayList<String>();
   String c = a+" "+b;
   try {  
            ObjectInputStream read = new ObjectInputStream(new FileInputStream(file));  
			check = (ArrayList<String>)read.readObject();
            for(int i = 0;i < check.size(); i ++)
			 {
			  if(check.get(i).equals(c)){
              read.close();
			  check.remove(i);
			  File file1 = new File("Ele/"+a+"ele.txt");
			  File file2 = new File("Gas/"+a+"gas.txt");	
			  File file3 = new File("Ewhistory/"+a+"ele.txt");
			  File file4 = new File("GWhistory/"+a+"gas.txt");
			  File file5 = new File("EMhistory/"+a+"ele.txt");
			  File file6 = new File("GMhistory/"+a+"gas.txt");
			  file1.delete();
			  file2.delete();
			  file3.delete();
			  file4.delete(); 
			  file5.delete();
			  file6.delete();
			  try {  
                   ObjectOutputStream writer = new ObjectOutputStream( new FileOutputStream(file,false));  
                   writer.writeObject(check);  
                   writer.close();   
                  } catch (FileNotFoundException e6) {  
                    e6.printStackTrace();  
                  } catch (IOException e7) {  
                    e7.printStackTrace();  
                  }  
			  Object[] options ={ "OK", "Back" };
              JOptionPane.showOptionDialog(null, "This ID has been removed!", "ok!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	          return;}}
			  read.close();
              Object[] options ={ "OK", "Back" };
              JOptionPane.showOptionDialog(null, "ID and password are not correct!", "waring!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);		  
        } catch (FileNotFoundException e3) {  
            e3.printStackTrace();  
        } catch (IOException e5) { 
            e5.printStackTrace();  
        } catch (ClassNotFoundException e4) {  
            e4.printStackTrace();  
        }
}}}