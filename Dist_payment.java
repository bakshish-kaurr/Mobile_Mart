import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
class Dist_payment extends JFrame implements ActionListener,ItemListener,FocusListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox c1;
	JButton b1,exitbtn;
	JPanel p1,p2;
	Color clr1,clr2,clr3,clr4;
	Connection conn;
	Statement stmt;
	Dist_payment()
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Mobile Mart: Inventory Control Hub");
		setLayout(new BorderLayout());
		clr1=Color.decode("#89A8B2");
	    clr2=Color.decode("#B3C8CF");
	    clr3=Color.decode("#E5E1DA");
	    clr4=Color.decode("#F1F0E8");
		p1=new JPanel();
        p1.setBackground(clr1);
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		p2=new JPanel();
        p2.setBackground(clr3);
		p2.setLayout(null);
		l1=new JLabel("Distributor Payment");
		l1.setFont(new Font("Arial",Font.BOLD,40));
		l2=new JLabel("Distributor ID:");
		l2.setFont(new Font("Arial",Font.BOLD,30));
		c1=new JComboBox();
		c1.setFont(new Font("Arial",Font.BOLD,25));
		c1.addItem("-select-");
		l3=new JLabel("Name:");
		l3.setFont(new Font("Arial",Font.BOLD,30));
		t1=new JTextField();
		t1.setFont(new Font("Arial",Font.BOLD,25));
		l4=new JLabel("Mobile:");
		l4.setFont(new Font("Arial",Font.BOLD,30));
		t2=new JTextField();
		t2.setFont(new Font("Arial",Font.BOLD,25));
		l5=new JLabel("City:");
		l5.setFont(new Font("Arial",Font.BOLD,30));
		t3=new JTextField();
		t3.setFont(new Font("Arial",Font.BOLD,25));
		l6=new JLabel("Balance:");
		l6.setFont(new Font("Arial",Font.BOLD,30));		
		t4=new JTextField();
		t4.setFont(new Font("Arial",Font.BOLD,25));		
		l7=new JLabel("Amt paid:");
		l7.setFont(new Font("Arial",Font.BOLD,30));
		t5=new JTextField();
		t5.setFont(new Font("Arial",Font.BOLD,25));
		l8=new JLabel("New Balance:");
		l8.setFont(new Font("Arial",Font.BOLD,30));
		t6=new JTextField();
		t6.setFont(new Font("Arial",Font.BOLD,25));
		b1=new JButton("Save");
		b1.setFont(new Font("Arial",Font.BOLD,30));
		exitbtn=new JButton("Exit");
		exitbtn.setFont(new Font("Arial",Font.BOLD,20));
		l1.setForeground(clr4);
		l2.setForeground(clr1);
		l3.setForeground(clr1);
		l4.setForeground(clr1);
		l5.setForeground(clr1);
		l6.setForeground(clr1);
		l7.setForeground(clr1);	
		l8.setForeground(clr1);
		t1.setForeground(clr4);
		t2.setForeground(clr4);
		t3.setForeground(clr4);
		t4.setForeground(clr4);
		t5.setForeground(clr4);
		t6.setForeground(clr4);
		c1.setForeground(clr4);		
		t1.setBackground(clr1);
		t2.setBackground(clr1);
		t3.setBackground(clr1);	
        t4.setBackground(clr1);
		t5.setBackground(clr1);
		t6.setBackground(clr1);	
        c1.setBackground(clr1);
        exitbtn.setForeground(clr1);			
		b1.setForeground(clr4);
		exitbtn.setBackground(clr4);
		b1.setBackground(clr1);
		l2.setBounds(350,10,250,50);
		c1.setBounds(650,15,250,40);
		l3.setBounds(350,70,250,50);
		t1.setBounds(650,75,250,40);
		l4.setBounds(350,130,200,50);
		t2.setBounds(650,135,250,40);
		l5.setBounds(350,190,200,50);
		t3.setBounds(650,195,250,40);
		l6.setBounds(350,250,250,50);
		t4.setBounds(650,255,250,40);
		l7.setBounds(350,310,250,50);
		t5.setBounds(650,315,250,40);
		l8.setBounds(350,370,250,50);
		t6.setBounds(650,375,250,40);
		b1.setBounds(570,450,150,50);
		exitbtn.setBounds(1150,480,80,30);
		p1.add(l1);
        p2.add(l2);
		p2.add(c1);
		p2.add(l3);
		p2.add(t1);
		p2.add(l4);
		p2.add(t2);
		p2.add(l5);
		p2.add(t3);
		p2.add(l6);
		p2.add(t4);
		p2.add(l7);
		p2.add(t5);
		p2.add(l8);
		p2.add(t6);
		p2.add(b1);
		p2.add(exitbtn);
		add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory_master","root","");
			stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select d_id from party");
            while(rs.next()) 
			{
                c1.addItem(rs.getString("d_id"));
            }			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t6.setEditable(false);
		b1.addActionListener(this);
		c1.addItemListener(this);
		t5.addFocusListener(this);
		exitbtn.addActionListener(this);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new Dist_payment();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exitbtn)
		this.dispose();
	    if(e.getSource()==b1)
		{		
			try
			{
				if(t5.getText().equals("")||c1.getSelectedItem().equals("-select-"))
			    JOptionPane.showMessageDialog(this,"Enter all details.");
		        else
			    {
                    String s1="insert into payment values('"+c1.getSelectedItem()+"','"+t1.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"')";
				    stmt.executeUpdate(s1);
			        JOptionPane.showMessageDialog(this,"Record saved.");
					double balance=Double.parseDouble(t6.getText());
                    int d_id=Integer.parseInt(c1.getSelectedItem().toString());
                    String updt="update party set balance="+balance+" where d_id="+ d_id;
			        stmt.executeUpdate(updt);
					c1.setSelectedIndex(0);
				    t1.setText("");
				    t2.setText("");
				    t3.setText("");
				    t4.setText("");
				    t5.setText("");
				    t6.setText("");	
			    }												
			}
			catch(Exception except)
	        {
		   	    System.out.println(except);
		    }			
		}
	}
	public void focusGained(FocusEvent f)
	{}
	public void focusLost(FocusEvent f)
	{
		try
		{
			if(f.getSource()==t5)
			{
				double bal=Double.parseDouble(t4.getText().trim());
				bal=Math.round(bal*100.0)/100.0;
				double amt=Double.parseDouble(t5.getText().trim());
				amt=Math.round(amt*100.0)/100.0;
				if(amt>bal)
				JOptionPane.showMessageDialog(this,"Payment exceeds the outstanding value.");
				else
				t6.setText(String.format("%.2f",bal-amt));
            } 
		}
		catch(NumberFormatException ex)
		{
            JOptionPane.showMessageDialog(this,"Value must be a number.");
        }
	}
	public void itemStateChanged(ItemEvent i)
	{
		if(i.getSource()==c1)
		{
			try
		    {
			    String ss="select * from party where d_id='"+c1.getSelectedItem()+"'";
		        ResultSet rss1=stmt.executeQuery(ss);
		        if(rss1.next())
	            { 
		            t1.setText(rss1.getString(2));
					t2.setText(rss1.getString(4));
					t3.setText(rss1.getString(5));
					t4.setText(rss1.getString(6));		        
	            }
		    }
		    catch(SQLException s)
	    	{
		    	System.out.println(s);
		    }
		}
	}
}