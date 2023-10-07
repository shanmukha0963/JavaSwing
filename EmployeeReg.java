import java.awt.event.*;  
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;
import java.util.InputMismatchException;
public class EmployeeReg extends MouseAdapter implements ActionListener{
	JFrame jf1=new JFrame();
    JFrame f=new JFrame();
		  
   JLabel jl1=new JLabel("Employee Registration form");
   JLabel jl2=new JLabel("Name");
   JLabel jl3=new JLabel("ID");
   JLabel jl4=new JLabel("Gender");
   JLabel jl5=new JLabel("Address");
   JLabel jl6=new JLabel("Contact No");
   JLabel jl7=new JLabel("");
   
   JRadioButton r1=new JRadioButton("Male");    
   JRadioButton r2=new JRadioButton("Female");
   
   JTextField t1=new JTextField();
   JTextField t2=new JTextField();
   JTextField t3=new JTextField();
   
    JTextArea ta1=new JTextArea();
    JTable jt=new JTable ( );
 DefaultTableModel model = new DefaultTableModel();
   
   JButton jb1=new JButton("Update");
   JButton jb2=new JButton("Reset");
   JButton jb3=new JButton("Register");
   JButton jb4=new JButton("Reset Table");
   JButton b1=new JButton("register");
   JButton b2=new JButton("show details");
   JScrollPane jsp=new JScrollPane(jt);
   
   
   public EmployeeReg(){
	   f.setTitle("Options");
		  f.setBounds(300, 90, 300, 90);
		  f.setLayout(new FlowLayout());
		  f.setVisible(true);
		  
         Object[] columns={"ID","Name","Gender","Address","Contact No"};
		 model.setColumnIdentifiers(columns);
		 jt.setModel(model);
		 jt.setRowHeight(50);
         
		 f.add(b1);
		 b1.addActionListener(this);
		 f.add(b2);
		 b2.addActionListener(this);
		 
		  
		  

  }	  
   public void bounds(JFrame jf){
	      
		  jl1.setBounds(100,20,300,30);jf.add(jl1);
		  jl2.setBounds(100,20,100,100);jf.add(jl2);
		  t1.setBounds(200,60,100,20);jf.add(t1);
		  jl3.setBounds(100,70,100,100);jf.add(jl3);
		  t2.setBounds(200,110,100,20);jf.add(t2);
		  jl4.setBounds(95,110,100,100);jf.add(jl4);
		  r1.setBounds(200,150,100,20);jf.add(r1);
		  r2.setBounds(300,150,100,20);jf.add(r2);
		  jl5.setBounds(95,150,100,100);jf.add(jl5);
		  ta1.setBounds(200,200,90,70);jf.add(ta1);
		  jl6.setBounds(95,250,100,100);jf.add(jl6);
		  t3.setBounds(200,290,100,20);jf.add(t3);
		  
		  jb2.setBounds(230,350,100,20);jf.add(jb2);
		  jb2.addActionListener(this);
		  jb3.setBounds(95,350,100,20);jf.add(jb3);
		  jb3.addActionListener(this);  
		 }
		  public void details(JFrame f1){
			   jsp.setBounds(70,50,450,450);
			   f1.add(jsp);
			   jt.addMouseListener(this);
			   jb4.setBounds(230,500,150,20);f1.add(jb4);
		       jb4.addActionListener(this);
			   jb1.setBounds(95,500,100,20);f1.add(jb1);
		       jb1.addActionListener(this);
		  }
           Object[] row=new Object[5];
		   public void actionPerformed(ActionEvent ae){
			   if(ae.getActionCommand().equals("register")){
				  JFrame jf=new JFrame();
                  jf.setTitle("registration");
		          jf.setBounds(300, 90, 500, 500);
				  bounds(jf);
		          jf.setLayout(null);
				  jf.setVisible(true);
				   
			   }
			   if(ae.getActionCommand().equals("show details")){
				   JFrame f1=new JFrame();
                  f1.setTitle("registered employees");
		          f1.setBounds(300, 90, 600, 600);
				  details(f1);
		          f1.setLayout(null);
				   f1.setVisible(true);
				   
			   }
			   
			   
				   
			  if(ae.getActionCommand().equals("Register")){
				  String s1=t1.getText();
			   int no=t2.getText().length();
				  jl7.setText("");
				  if(!s1.equals("")&& no==4){
				  row[0]=t2.getText();
				  row[1]=t1.getText();
				   if (r1.isSelected())
                   row[2]=r1.getText();
                  else
                   row[2]=r2.getText();
				   row[3]=ta1.getText();
				   row[4]=t3.getText();
				  model.addRow(row);
				  JOptionPane.showMessageDialog(jf1,"registered successfully!!"); 
				  }
			  try{
			  if(s1.equals(""))
			  throw new InputMismatchException();
			  }catch (InputMismatchException e){
				  JOptionPane.showMessageDialog(jf1,"Name is not entered!!"); 
			  }
			  try{
			  if(no!=4)
			  throw new InputMismatchException();
			  }catch (InputMismatchException e){
				 JOptionPane.showMessageDialog(jf1,"Id should contain four digits!!");  
			  }
		 
			
			  
			  }
			  if(ae.getActionCommand().equals("Reset")){
				  t1.setText("");
				  t2.setText("");
				  t3.setText("");
			      ta1.setText("");
				  }
			  
			   if(ae.getActionCommand().equals("Update")){
				   int i=jt.getSelectedRow();
				 model.setValueAt(t2.getText(),i,0);
				 model.setValueAt(t1.getText(),i,1);
				 model.setValueAt(ta1.getText(),i,3);
				 model.setValueAt(t3.getText(),i,4);
				 JOptionPane.showMessageDialog(jf1,"updated successfully!!");
				  }
			   if(ae.getActionCommand().equals("Reset Table")){
				   while(model.getRowCount() > 0)
                   {
                     model.removeRow(0);
                   }
				   JOptionPane.showMessageDialog(jf1,"table resetted");
			   }
				   
		   };
		  public void mouseClicked(MouseEvent e){
		  
				   int i=jt.getSelectedRow();
				   t2.setText(model.getValueAt(i,0).toString());
				   t1.setText(model.getValueAt(i,1).toString());
				   ta1.setText(model.getValueAt(i,3).toString());
			       t3.setText(model.getValueAt(i,4).toString());
		  }
		  
   public static void main(String args[]){
   EmployeeReg er=new EmployeeReg();
	 }
 }