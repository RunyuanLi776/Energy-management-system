import java.util.*;
import java.io.*;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
public class GUIreadings extends JPanel{
public File file;
public JButton JButton1,JButton2,JButton3,JButton5,JButton6; 
public JTextField text1;
public GUIreadings(){
  this.setLayout(new BorderLayout());
  JLabel JLabel1 = new JLabel("Check Readings!");
  JLabel1.setFont(new Font("Courier", Font.PLAIN, 18));
  JPanel JPanel2 = new JPanel(new FlowLayout(0));
  JPanel2.add(JLabel1);
  JLabel1.setPreferredSize(new Dimension(300,50));
  this.add(JPanel2,BorderLayout.NORTH);
  JButton1=new JButton("check this day");
  JButton2=new JButton("check this week");
  JButton3=new JButton("check this month");
  JPanel JPanel5 = new JPanel();
  JPanel5.add(new JLabel("ID:"));
  text1 = new JTextField(10);
  JPanel5.add(text1);
  JPanel JPanel3 = new JPanel();
  JPanel JPanel1 = new JPanel(new GridLayout(0,1,0,10));
  JPanel1.add(JPanel5);
  JPanel1.add(JButton1);
  JPanel1.add(JButton2);
  JPanel1.add(JButton3);
  JButton1.addActionListener(new Listener());
  JButton2.addActionListener(new Listener());
  JButton3.addActionListener(new Listener());  
  JPanel JPanel6 = new JPanel();
  JPanel6.add(JPanel1);
  this.add(JPanel6,BorderLayout.CENTER);
  JPanel JPanel4 = new JPanel(new FlowLayout(2));
  JButton5=new JButton("Done");
  JButton6=new JButton("Back");
  JPanel4.add(JButton5);
  JPanel4.add(JButton6);
  this.add(JPanel4,BorderLayout.SOUTH);
}
class Listener implements ActionListener{
  JLabel J1,J2,J3;
  JPanel P1,P2,P3,P4;
  File file1,file2;
  public void actionPerformed(ActionEvent e) {
   java.util.Timer timer = new java.util.Timer();
   String id = text1.getText();
   file1 = new File("Ele/"+id+"ele.txt");
   file2 = new File("Gas/"+id+"gas.txt");
   try{
       if(!file1.exists()){
       Object[] options ={ "OK", "Back" };
       JOptionPane.showOptionDialog(null, "This user does not exist!", "Waring!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);;
	   return;}}
    catch(Exception e1){
       e1.printStackTrace();}
   try{
    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	JFrame myframe = new JFrame();
	myframe.setTitle("Eletable readings");   
    myframe.setSize(500,250); 
    myframe.setLocation(650, 420);
    myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	J1 = new JLabel("Readings of "+id);
    J1.setFont(new Font("Arial", Font.PLAIN, 16));
    P1= new JPanel(new FlowLayout(0));
    P1 .add(J1);
    J1.setPreferredSize(new Dimension(300,50));
    myframe.add(P1,BorderLayout.NORTH);
    J2 = new JLabel();
    P2= new JPanel();
	J2.setFont(new Font("Courier", Font.PLAIN, 20));
    P2.add(J2);
    J3 = new JLabel();
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
   timer.schedule(new java.util.TimerTask() { 
    public void run(){ 
           try {  
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(file1));  
            ArrayList<Double> eleday = (ArrayList<Double>) is.readObject();
            ArrayList<Double> eleweek = (ArrayList<Double>) is.readObject();
            ArrayList<Double> elemonth = (ArrayList<Double>) is.readObject();
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(file2));  
            ArrayList<Double> gasday = (ArrayList<Double>) os.readObject();
            ArrayList<Double> gasweek = (ArrayList<Double>) os.readObject();
            ArrayList<Double> gasmonth = (ArrayList<Double>) os.readObject();
            if(e.getActionCommand()=="check this day")
			{J2.setText("Ele:Today usage: "+eleday.get(0)+" Today cost: "+eleday.get(1));
			J3.setText("Gas:Today usage: "+gasday.get(0)+" Today cost: "+gasday.get(1));}
            else if(e.getActionCommand()=="check this week") 
            {J2.setText("this week usage: "+eleweek.get(0)+" this week cost: "+eleweek.get(1));  
		    J3.setText("this week usage: "+gasweek.get(0)+" this week cost: "+gasweek.get(1)); }
		    else if(e.getActionCommand()=="check this month") 
			{J2.setText("this month usage: "+elemonth.get(0)+" this month cost: "+elemonth.get(1));  
	         J3.setText("this month usage: "+gasmonth.get(0)+" this month cost: "+gasmonth.get(1)); }
            is.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    } },0,30*1000);
  }
}
}