import java.io.*;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
import java.util.*;
public class GUIadd extends JPanel{
public JTextField text1,text2;
public JButton JButton5,JButton6; 
public File file = new File("ID.txt");
 public GUIadd(){
  this.setLayout(new BorderLayout());
  JLabel JLabel1 = new JLabel("Add Consumer");  
  JLabel1.setFont(new Font("??", Font.PLAIN, 18));
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
  public void actionPerformed(ActionEvent e) {
   String a = text1.getText();
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
              String[] ID=check.get(i).split(" ");
			  if(a.equals(ID[0])){
			  Object[] options ={ "OK", "Back" };
              JOptionPane.showOptionDialog(null, "This ID has been registed!", "Waring!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
              read.close();
	          return;}}
			  check.add(c);
			  read.close();  
        } catch (FileNotFoundException e3) {  
            e3.printStackTrace();  
        } catch (IOException e5) { 
            e5.printStackTrace();  
        } catch (ClassNotFoundException e4) {  
            e4.printStackTrace();  
        }
    try {  
          ObjectOutputStream writer = new ObjectOutputStream( new FileOutputStream(file,false));  
          writer.writeObject(check);  
           writer.close();   
        } catch (FileNotFoundException e6) {  
            e6.printStackTrace();  
        } catch (IOException e7) {  
            e7.printStackTrace();  
        }  
    File file1 = new File("Ele/"+a+"ele.txt");
    try{
       if(!file1.exists()){
          file1.createNewFile();}}
    catch(Exception e1){
      e1.printStackTrace();}
	 File file3 = new File("EWhistory/"+a+"ele.txt");
    try{
       if(!file3.exists()){
          file3.createNewFile();
	try{
        BufferedWriter writer=new BufferedWriter(new FileWriter(file3,true));
        writer.write("nothing"); 
        writer.newLine();
        writer.close();}
	catch (IOException q) {  
         q.printStackTrace();}}}
    catch(Exception e1){
       e1.printStackTrace();}
	    File file5 = new File("EMhistory/"+a+"ele.txt");
    try{
       if(!file5.exists()){
          file5.createNewFile();
	   try{
        BufferedWriter writer=new BufferedWriter(new FileWriter(file5,true));
        writer.write("nothing"); 
        writer.newLine();
        writer.close();}
	catch (IOException q) {  
         q.printStackTrace();}}}
    catch(Exception e1){
       e1.printStackTrace();}
    Gastable gas = new Gastable(a+"gas.txt");
    File file2 = new File("Gas/"+a+"gas.txt");
    try{
       if(!file2.exists()){
          file2.createNewFile();}}
    catch(Exception e2){
       e2.printStackTrace();}
	File file4 = new File("GWhistory/"+a+"gas.txt");
    try{
       if(!file4.exists()){
          file4.createNewFile();
	try{
        BufferedWriter writer=new BufferedWriter(new FileWriter(file4,true));
        writer.write("nothing"); 
        writer.newLine();
        writer.close();}
	catch (IOException q) {  
         q.printStackTrace();}}}
    catch(Exception e1){
       e1.printStackTrace();}
	File file6 = new File("GMhistory/"+a+"gas.txt");
    try{
       if(!file6.exists()){
          file6.createNewFile();
	   try{
        BufferedWriter writer=new BufferedWriter(new FileWriter(file6,true));
        writer.write("nothing"); 
        writer.newLine();
        writer.close();}
	catch (IOException q) {  
         q.printStackTrace();}}}
    catch(Exception e1){
       e1.printStackTrace();}
	Eletable ele = new Eletable(a+"ele.txt");
    ele.start();
	gas.start();
   Object[] options ={ "OK", "Back" };
   JOptionPane.showOptionDialog(null, "The charge has changed!", "The charge has changed!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);  
  }
}
}