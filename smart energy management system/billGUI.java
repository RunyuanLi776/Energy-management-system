import java.util.*;
import java.io.*;

import javax.swing.*;  
import java.awt.*; 
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
 
public class billGUI extends JPanel{
public File file1;
public JButton JButton5,JButton6; 
public JTextField text1,text2;
public JRadioButton radio1,radio2;
public ButtonGroup ButtonGroup1;
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
  radio1 = new JRadioButton("Ele");
  radio2 = new JRadioButton("Gas");
  ButtonGroup1= new ButtonGroup();
  ButtonGroup1.add(radio1);
  ButtonGroup1.add(radio2);  
  JButton5.addActionListener(new Listener()); 
  JPanel JPanel3 = new JPanel();
  JPanel JPanel1 = new JPanel(new FlowLayout(2));
  JPanel1.add(JPanel3);
  JPanel3.add(JButton5);
  JPanel3.add(JButton6);
  this.add(JPanel1,BorderLayout.SOUTH);
  JPanel JPanel4 = new JPanel(new BorderLayout());
  JPanel JPanel5 = new JPanel();
  JPanel JPanel6 = new JPanel(new GridLayout(0,1,0,5));
  JPanel JPanel7 = new JPanel();
  JPanel JPanel8 = new JPanel();
  JPanel JPanel9 = new JPanel();
  JPanel5.add(new JLabel("ID:"));
  text1 = new JTextField(10);
  JPanel5.add(text1);
  JPanel7.add(radio1);
  JPanel8.add(radio2);
  JPanel6.add(JPanel7);
  JPanel6.add(JPanel8);
  JPanel9.add(JPanel6);
  JPanel4.add(JPanel5,BorderLayout.NORTH);
  JPanel4.add(JPanel9,BorderLayout.CENTER);
  this.add(JPanel4,BorderLayout.CENTER);
  }
  
class Listener implements ActionListener{
JLabel J1;
JPanel P1,P2,P3,P4;
Object[][] table = new Object[100][3];
JTable T1;
JScrollPane scroll;
String data1,data2,elecost,gascost;
  public void actionPerformed(ActionEvent e) {
   String[] s2 = {"month","usage","cost"};
   String a = text1.getText();
   ArrayList<String> month = new ArrayList<String>();
   int i = 0;
   int j = 0;
   int check=0;
   BufferedReader reader1 = null;
//   BufferedReader reader2 = null;
   if(radio1.isSelected())
   file1 = new File("EMhistory/"+a+"ele.txt");
   else if(radio2.isSelected())
   file1 = new File("GMhistory/"+a+"gas.txt"); 
   else
   {
	   Object[] options ={ "OK", "Back" };
       JOptionPane.showOptionDialog(null, "Please check the radio!", "Waring!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	   return;   
   }
   try{
       if(!file1.exists()){
       Object[] options ={ "OK", "Back" };
       JOptionPane.showOptionDialog(null, "This user does not exist!", "Waring!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	   return;}}
    catch(Exception e1){
       e1.printStackTrace();}
	try{
	reader1 = new BufferedReader(new FileReader(file1));
	reader1.readLine();
	while((data1 = reader1.readLine()) != null){
	check = 1;
    String[] s1=data1.split(" ");
	for(;j<3;j++)
    {table[i][j] = s1[j];}
    i++;
	j=0;} 
	if(check == 0)
	{Object[] options ={ "OK", "Back" };
    JOptionPane.showOptionDialog(null, "There are no bills!", "Waring!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	return;}}
    catch (IOException e1) {  
    e1.printStackTrace();}
	 try{
    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	JFrame myframe = new JFrame();
	T1 = new JTable(table,s2);
	T1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	TableColumn column = null;  
    int colunms = T1.getColumnCount();  
    for(int q = 0; q < colunms; q++)  
        {  
            column = T1.getColumnModel().getColumn(q);  
            column.setPreferredWidth(140);  
        }  
	scroll = new JScrollPane(T1);
    scroll.setPreferredSize(new Dimension(442,200));
	myframe.setTitle("Eletable readings");   
    myframe.setSize(470,400); 
    myframe.setLocation(650, 420);
    myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	J1 = new JLabel("Readings of "+a);
    J1.setFont(new Font("Arial", Font.PLAIN, 16));
    P1= new JPanel(new FlowLayout(0));
    P1.add(J1);
    J1.setPreferredSize(new Dimension(300,50));
    myframe.add(P1,BorderLayout.NORTH);
    P2= new JPanel();
	P2.add(scroll); 	
    P4= new JPanel(new BorderLayout());
	P4.add(P2);
	myframe.add(P4,BorderLayout.CENTER);
    myframe.setVisible(true);  
    myframe.setResizable(true);}
   catch(Exception e1){}
  }
}}