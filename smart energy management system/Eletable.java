import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Eletable{
 public int a,aday,aweek;
 public int ause,aweekuse,amonthuse;
 public double adaycost,aweekcost,amonthcost,charge; 
 public ArrayList<Integer> adayuse = new ArrayList<Integer>();
 public SimpleDateFormat matter1,matter2,matter3;
 public Date d2,d1;
 public String text,time;
 public int[] date1;
 public String[] date;
 public ArrayList<Double> day,week,month;
 public ArrayList<String> weekhistory,monthhistory;
 public File file1,file2,files; 
 public Eletable(String s)
 {text	= s;
  files = new File ("Ele/"+text);
  file1 = new File("EMhistory/"+text);
  file2 = new File("EWhistory/"+text); 
  try  
    { 
       matter1=new SimpleDateFormat("HH:mm:ss");
	   matter2=new SimpleDateFormat("yyyy-MM-dd");
	   matter3=new SimpleDateFormat("E");
	   time = matter1.format(new Date());
	   d2 = matter1.parse("23:59:59");}
  catch (Exception e)  {  }
  date=  matter2.format(new Date()).split("-");
  date1 = new int[3];
  for(int i =0;i<3;i++){ date1[i] = Integer.parseInt(date[i]);}
  for(int i =0;i<=date1[2];i++)
  {adayuse.add(0);}
   aday =date1[2];
}
 public void start(){
 BufferedReader br=null;
    try{
        File file=new File("charge.txt");
        br = new BufferedReader(new FileReader(file));
        String temp=br.readLine();
        charge=Double.valueOf(temp);
        day = new ArrayList<Double>();
        week = new ArrayList<Double>();
        month = new ArrayList<Double>();
		monthhistory = new ArrayList<String>();
		weekhistory = new ArrayList<String>();
        day.add(0.0);
        day.add(0.0);
        week.add(0.0);
        week.add(0.0);
        month.add(0.0);
	    month.add(0.0);
     try {  
          ObjectOutputStream os = new ObjectOutputStream( new FileOutputStream(files,false)); 
           os.writeObject(day); 
           os.writeObject(week);
           os.writeObject(month);
           os.writeObject(adayuse);
           os.close();  
          } 
	  catch (FileNotFoundException e) {e.printStackTrace();} 
	  catch (IOException e) {e.printStackTrace();}  }
	  catch (IOException e) { e.printStackTrace();} 
 try  
    { 	d1 =  matter1.parse(matter1.format(new Date()));}
  catch (Exception e)  {  }
  java.util.Timer timer = new java.util.Timer();
  timer.schedule(new java.util.TimerTask() { 
  public void run(){ 
	a++;  
    ause=(int)(Math.random()*3);
    adayuse.set(aday,ause+adayuse.get(aday));
    aweekuse=aweekuse+ause;
    amonthuse=amonthuse+ause;
	adaycost=charge*(int)adayuse.get(aday);
    aweekcost=charge*aweekuse;
    amonthcost=charge*amonthuse;
	day.set(0,(int)adayuse.get(aday)+0.0);
    day.set(1,adaycost);
    week.set(0,aweekuse+0.0);
    week.set(1,aweekcost);
    month.set(0,amonthuse+0.0);
    month.set(1,amonthcost);
	try {  
          ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(files,false));  
          os.writeObject(day); 
          os.writeObject(week);
          os.writeObject(month);
          os.writeObject(adayuse);
          os.close();  
        } catch (FileNotFoundException e) {timer.cancel();} 
		  catch (IOException e) {  
            e.printStackTrace();  }
	if(a%2880==0&&a!=0)
    {aday++;
     adayuse.add(0);
	 String week = matter3.format(new Date());
	 String[] date2= matter2.format(new Date()).split("-");
	 if(week.equals("ÐÇÆÚÒ»"))
	{
    BufferedWriter writer = null;
   try{ aweek++;
        writer=new BufferedWriter(new FileWriter(file2,true));
        writer.write(aweek+" "+aweekuse+" "+aweekcost); 
        writer.newLine();
        writer.close();}
	catch (IOException q) {  
         q.printStackTrace();}
		 aweekuse=0;}
	 if(date2[2].equals("01"))
    {
    BufferedWriter writer = null;
   try{ 
        writer=new BufferedWriter(new FileWriter(file1,true));
        writer.write(date1[1]+" "+amonthuse+" "+amonthcost); 
        writer.newLine();
        writer.close();
		date1[1]++;}
	catch (IOException q) {  
         q.printStackTrace();}
	  amonthuse=0;
     }} 
   } },d2.getTime()-d1.getTime()+30*1000,30*1000);
 }
}