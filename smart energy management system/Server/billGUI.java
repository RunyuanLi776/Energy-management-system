import java.util.*;
import java.io.*;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
public class billGUI extends JPanel{
public File file1;
public JButton JButton5,JButton6; 
public JTextField text1,text2;
public billGUI(){
  this.setLayout(new BorderLayout());
  JLabel JLabel1 = new JLabel("Check bill!");
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
  JPanel5.add(new JLabel("ID:"));
  text1 = new JTextField(10);
  JPanel5.add(text1);
  JPanel6.add(new JLabel("Mo:"));
  text2 = new JTextField(10);
  JPanel6.add(text2);
  JPanel4.add(JPanel5,BorderLayout.NORTH);
  JPanel4.add(JPanel6,BorderLayout.CENTER);
  this.add(JPanel4,BorderLayout.CENTER);
  }
  
class Listener implements ActionListener {
JLabel J1,J2,J3;
JPanel P1,P2,P3,P4;
String data1,data2,elecost,gascost;
  public void actionPerformed(ActionEvent e) {
   String a = text1.getText();
   String b = text2.getText();
   ArrayList<String> month = new ArrayList<String>();
   int i = 0;
   BufferedReader reader1 = null;
   BufferedReader reader2 = null;
   file1 = new File("EMhistory/"+a+"ele.txt");
   try{
       if(!file1.exists()){
       Object[] options ={ "OK", "Back" };
       JOptionPane.showOptionDialog(null, "This user does not exist!", "Waring!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);;
	   return;}}
    catch(Exception e1){
       e1.printStackTrace();}
	try{
	reader1 = new BufferedReader(new FileReader(file1));
	while((data1 = reader1.readLine()) != null){
    String[] s1=data1.split(" ");
    if(b.equals(s1[0])){
	  elecost = s1[1];
	  reader2 = new BufferedReader(new FileReader("GMhistory/"+a+"gas.txt"));
	  while((data2 = reader2.readLine()) != null){
		  String[] s2=data2.split(" ");
		  if(b.equals(s2[0])){gascost = s2[1];}
	}
	 try{
    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	JFrame myframe = new JFrame();
	myframe.setTitle("Eletable readings");   
    myframe.setSize(500,250); 
    myframe.setLocation(650, 420);
    myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	J1 = new JLabel("Readings of "+a);
    J1.setFont(new Font("Arial", Font.PLAIN, 16));
    P1= new JPanel(new FlowLayout(0));
    P1 .add(J1);
    J1.setPreferredSize(new Dimension(300,50));
    myframe.add(P1,BorderLayout.NORTH);
    J2 = new JLabel(b+"month ele "+elecost);
    P2= new JPanel();
	J2.setFont(new Font("Courier", Font.PLAIN, 20));
    P2.add(J2);
    J3 = new JLabel(b+"month gas "+gascost);
    P3= new JPanel();
    P4= new JPanel(new BorderLayout());
	J3.setFont(new Font("Courier", Font.PLAIN, 20));
    P3.add(J3);
	P4.add(P2,BorderLayout.NORTH);
	P4.add(P3,BorderLayout.CENTER);
	myframe.add(P4,BorderLayout.CENTER);
    myframe.setVisible(true);  
    myframe.setResizable(true);}
   catch(Exception e1){}
	return;}
  }
   Object[] options ={ "OK", "Back" };
   JOptionPane.showOptionDialog(null, "There are no cost in this month!", "Waring!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);;
  }
    catch (IOException e1) {  
  e1.printStackTrace();}
}}
}