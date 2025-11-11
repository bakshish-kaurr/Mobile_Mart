import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
class Sale_item extends JFrame implements ActionListener,ItemListener,FocusListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JComboBox c1,c2;
	JButton b1,exitbtn;
	JPanel p1,p2;
	Color clr1,clr2,clr3,clr4;
	Connection conn;
	Statement stmt;
	int serial;
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    Date currentDate=new Date();
	Sale_item()
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
		l1=new JLabel("Sale Item");
		l1.setFont(new Font("Arial",Font.BOLD,40));
		l2=new JLabel("Bill No.:");
		l2.setFont(new Font("Arial",Font.BOLD,30));
		t1=new JTextField();
		t1.setFont(new Font("Arial",Font.BOLD,25));
		l3=new JLabel("Date:");
		l3.setFont(new Font("Arial",Font.BOLD,30));
		t2=new JTextField();
		t2.setFont(new Font("Arial",Font.BOLD,25));
		l4=new JLabel("Cust_Name:");
		l4.setFont(new Font("Arial",Font.BOLD,30));
		t3=new JTextField();
		t3.setFont(new Font("Arial",Font.BOLD,25));
		l5=new JLabel("Mobile:");
		l5.setFont(new Font("Arial",Font.BOLD,30));
		t4=new JTextField();
		t4.setFont(new Font("Arial",Font.BOLD,25));
		l6=new JLabel("Company:");
		l6.setFont(new Font("Arial",Font.BOLD,30));		
		c1=new JComboBox();
		c1.setFont(new Font("Arial",Font.BOLD,25));
		c1.addItem("-select-");
		c1.addItem("Samsung");
		c1.addItem("Realme");
		c1.addItem("Vivo");
		c1.addItem("OnePlus");
		l7=new JLabel("Model:");
		l7.setFont(new Font("Arial",Font.BOLD,30));
		c2=new JComboBox();
		c2.setFont(new Font("Arial",Font.BOLD,25));	
        c2.addItem("-select-");		
		l8=new JLabel("MRP:");
		l8.setFont(new Font("Arial",Font.BOLD,30));
		t5=new JTextField();
		t5.setFont(new Font("Arial",Font.BOLD,25));
		l9=new JLabel("Qty in hand:");
		l9.setFont(new Font("Arial",Font.BOLD,30));
		t6=new JTextField();
		t6.setFont(new Font("Arial",Font.BOLD,25));
		l10=new JLabel("Qty to sale:");
		l10.setFont(new Font("Arial",Font.BOLD,30));
		t7=new JTextField();
		t7.setFont(new Font("Arial",Font.BOLD,25));
		l11=new JLabel("Amount:");
		l11.setFont(new Font("Arial",Font.BOLD,30));
		t8=new JTextField();
		t8.setFont(new Font("Arial",Font.BOLD,25));
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
		l9.setForeground(clr1);
		l10.setForeground(clr1);
		l11.setForeground(clr1);	
		t1.setForeground(clr4);
		t2.setForeground(clr4);
		t3.setForeground(clr4);
		t4.setForeground(clr4);
		t5.setForeground(clr4);
		t6.setForeground(clr4);
		t7.setForeground(clr4);
		t8.setForeground(clr4);
		c1.setForeground(clr4);	
		c2.setForeground(clr4);			
		t1.setBackground(clr1);
		t2.setBackground(clr1);
		t3.setBackground(clr1);	
        t4.setBackground(clr1);
		t5.setBackground(clr1);
		t6.setBackground(clr1);	
        t7.setBackground(clr1);
		t8.setBackground(clr1);
        c1.setBackground(clr1);
		c2.setBackground(clr1);
        exitbtn.setForeground(clr1);			
		b1.setForeground(clr4);
		exitbtn.setBackground(clr4);
		b1.setBackground(clr1);
		l2.setBounds(350,10,250,50);
		t1.setBounds(650,15,250,40);
		l3.setBounds(350,70,250,50);
		t2.setBounds(650,75,250,40);
		l4.setBounds(150,130,200,50);
		t3.setBounds(350,135,250,40);
		l5.setBounds(650,130,200,50);
		t4.setBounds(780,135,250,40);
		l6.setBounds(150,190,150,50);
		c1.setBounds(350,195,250,40);
		l7.setBounds(650,190,150,50);
		c2.setBounds(780,195,250,40);
		l8.setBounds(350,250,150,50);
		t5.setBounds(650,255,250,40);
		l9.setBounds(350,310,250,50);
		t6.setBounds(650,315,250,40);
		l10.setBounds(350,370,180,50);
		t7.setBounds(650,375,250,40);
		l11.setBounds(350,430,250,50);
		t8.setBounds(650,435,250,40);
		b1.setBounds(570,490,150,50);
		exitbtn.setBounds(1150,480,80,30);
		p1.add(l1);
        p2.add(l2);
		p2.add(t1);
		p2.add(l3);
		p2.add(t2);
		p2.add(l4);
		p2.add(t3);
		p2.add(l5);
		p2.add(t4);
		p2.add(l6);
		p2.add(c1);
		p2.add(l7);
		p2.add(c2);
		p2.add(l8);
		p2.add(t5);
		p2.add(l9);
		p2.add(t6);
		p2.add(l10);
		p2.add(t7);
		p2.add(l11);
		p2.add(t8);
		p2.add(b1);
		p2.add(exitbtn);
		add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
		t2.setText(sdf.format(currentDate));		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory_master","root","");
			stmt=conn.createStatement();	
            ResultSet rs=stmt.executeQuery("SELECT MAX(bill_no) FROM sale");
	        if(rs.next()) 
			{
		       serial=rs.getInt(1)+1;
		       if(serial<601) 
			   serial=601;
	        }
			else 
			{
		       serial=601;
	        }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		t1.setText(String.valueOf(serial));
		t1.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		t8.setEditable(false);
		b1.addActionListener(this);
		exitbtn.addActionListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
		c1.setSelectedIndex(0);
		c2.setSelectedIndex(0);
		t2.addFocusListener(this);
		t4.addFocusListener(this);
		t5.addFocusListener(this);
		t7.addFocusListener(this);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new Sale_item();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exitbtn)
		this.dispose();	
	    if(e.getSource()==b1)
		{			
			try
			{
				if(t3.getText().equals("")||t7.getText().equals("")||c1.getSelectedItem().equals("-select-")||c2.getSelectedItem().equals("-select-"))
			    JOptionPane.showMessageDialog(this,"Enter all details.");
		        else
			    {
                    String s1="insert into sale values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+c1.getSelectedItem()+"','"+c2.getSelectedItem()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"')";
				    stmt.executeUpdate(s1);
			        JOptionPane.showMessageDialog(this,"Record saved.");
					
			    }				
				ResultSet rs=stmt.executeQuery("select MAX(bill_no) from sale");
	            if(rs.next()) 
			    {
		            serial=rs.getInt(1)+1;
		            if(serial<601) 
			        serial=601;
	            }
			    else 
			    {
		            serial=601;
	            }	
                ResultSet check=stmt.executeQuery("select qty from stock where company='"+c1.getSelectedItem()+"' and model='"+c2.getSelectedItem()+"'");
	            if(check.next()) 
				{
		            int qty=check.getInt("qty");
		            int new_qt=qty-Integer.parseInt(t7.getText().trim());
					if (new_qt==0) 
					{
	                    stmt.executeUpdate("delete from stock where company='"+c1.getSelectedItem()+"' and model='"+c2.getSelectedItem()+"'");
	                } 
					else 
					{	
		                stmt.executeUpdate("update stock set qty="+new_qt+" where company='"+c1.getSelectedItem()+"' and model='"+c2.getSelectedItem()+"'");
                    }
				} 				
                t1.setText(String.valueOf(serial));
		 		t2.setText(sdf.format(currentDate));
				c1.setSelectedIndex(0);
				c2.setSelectedIndex(0);
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");						
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
	    if(f.getSource()==t2)
		{
            String dateText=t2.getText().trim();
            try
			{
                sdf.setLenient(false);
                Date enteredDate = sdf.parse(dateText);
                if(enteredDate.after(new Date())) 
				{
                    JOptionPane.showMessageDialog(this,"Future dates are not allowed.");
                    t2.requestFocus();
                }
	        } 
			catch(Exception e)
			{
                JOptionPane.showMessageDialog(this,"Invalid date format! Use dd-MM-yyyy.");
                t2.requestFocus();
            }
        }
		if(f.getSource()==t4)
		{
            String mobileText=t4.getText().trim();
			if(!mobileText.matches("\\d{10}")) 
			{
                JOptionPane.showMessageDialog(this,"Mobile number must be exactly 10 digits.");
                t4.requestFocus();
            }
		}
		if(f.getSource()==t7)
		{
			try
			{
				int qt=Integer.parseInt(t7.getText().trim());
				int total_qt=Integer.parseInt(t6.getText().trim());
				if(qt>total_qt)
				{
					JOptionPane.showMessageDialog(this,"Not enough stock.");
				}
				int mrp=Integer.parseInt(t5.getText().trim());
				int amt=qt*mrp;
				double amtt=Math.round(amt*100.0)/100.0;
				t8.setText(String.format("%.2f",amtt));
			}
			catch(NumberFormatException ex)
		    {
                JOptionPane.showMessageDialog(this,"Value must be a number.");
            }
		}
	}
	public void itemStateChanged(ItemEvent i)
	{
		if(i.getSource()==c1 && i.getStateChange()==ItemEvent.SELECTED)
		{
			c2.removeAllItems();
			c2.addItem("-select-");
			int index=c1.getSelectedIndex();
			if(index==1)
			{
				c2.addItem("Samsung Galaxy S24 Ultra");
				c2.addItem("Samsung Galaxy A55 5G");
				c2.addItem("Samsung Galaxy M14 5G");
				c2.addItem("Samsung Galaxy Z Flip5");
			}
			else if(index==2)
			{
				c2.addItem("Realme GT 5 Pro");
				c2.addItem("Realme 11 Pro+ 5G");
				c2.addItem("Realme Narzo 60 5G");
				c2.addItem("Realme C55");
			}
			else if(index==3)
			{
				c2.addItem("Vivo X100 Pro");
				c2.addItem("Vivo V29 Pro");
				c2.addItem("Vivo T2 5G");
				c2.addItem("Vivo Y100");
			}
			else if(index==4)
			{
				c2.addItem("OnePlus 12");
				c2.addItem("OnePlus Nord 3 5G");
				c2.addItem("OnePlus Nord CE 3 Lite");
				c2.addItem("OnePlus Open");
			}
		}
		if(i.getSource()==c2 && i.getStateChange()==ItemEvent.SELECTED)
		{
			try
			{
				String slc=(String)c2.getSelectedItem();
                if(slc==null||slc.equals("-select-")) 
				{
                    t5.setText("");
					t6.setText("");
                    return;
                }
				ResultSet rst=stmt.executeQuery("select qty,mrp from stock where model='"+c2.getSelectedItem()+"'");
                if(rst.next()) 
		        {
                    t5.setText(rst.getString("mrp"));
					t6.setText(rst.getString("qty"));
                }			
			    else 
				{
                    t5.setText("");
					JOptionPane.showMessageDialog(this,"Model not found in stock.");
                }
			}
			catch(Exception ex)
		    {
			    System.out.println(ex);
		    }
		}	
	}
}