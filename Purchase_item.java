import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
class Purchase_item extends JFrame implements ActionListener,ItemListener,FocusListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JComboBox c1,c2,c3;
	JButton b1,exitbtn;
	JPanel p1,p2;
	Color clr1,clr2,clr3,clr4;
	Connection conn;
	Statement stmt;
	int serial,srl;
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    Date currentDate=new Date();
	Purchase_item()
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
		l1=new JLabel("Purchase Item");
		l1.setFont(new Font("Arial",Font.BOLD,40));
		l2=new JLabel("Sr No.:");
		l2.setFont(new Font("Arial",Font.BOLD,30));
		t1=new JTextField();
		t1.setFont(new Font("Arial",Font.BOLD,25));
		l3=new JLabel("Date:");
		l3.setFont(new Font("Arial",Font.BOLD,30));
		t2=new JTextField();
		t2.setFont(new Font("Arial",Font.BOLD,25));
		l4=new JLabel("Distributor Id:");
		l4.setFont(new Font("Arial",Font.BOLD,30));
		c1=new JComboBox();
		c1.setFont(new Font("Arial",Font.BOLD,25));
		c1.addItem("-select-");
		l5=new JLabel("D Name:");
		l5.setFont(new Font("Arial",Font.BOLD,30));
		t3=new JTextField();
		t3.setFont(new Font("Arial",Font.BOLD,25));
		l6=new JLabel("Balance:");
		l6.setFont(new Font("Arial",Font.BOLD,30));
		t4=new JTextField();
		t4.setFont(new Font("Arial",Font.BOLD,25));
		l7=new JLabel("Company:");
		l7.setFont(new Font("Arial",Font.BOLD,30));
		c2=new JComboBox();
		c2.setFont(new Font("Arial",Font.BOLD,25));
		c2.addItem("-select-");
		c2.addItem("Samsung");
		c2.addItem("Realme");
		c2.addItem("Vivo");
		c2.addItem("OnePlus");
		l8=new JLabel("Model:");
		l8.setFont(new Font("Arial",Font.BOLD,30));
		c3=new JComboBox();
		c3.setFont(new Font("Arial",Font.BOLD,25));
		c3.addItem("-select-");
		l9=new JLabel("MRP:");
		l9.setFont(new Font("Arial",Font.BOLD,30));
		t5=new JTextField();
		t5.setFont(new Font("Arial",Font.BOLD,25));
		l10=new JLabel("Cost Price:");
		l10.setFont(new Font("Arial",Font.BOLD,30));
		t6=new JTextField();
		t6.setFont(new Font("Arial",Font.BOLD,25));
		l11=new JLabel("Quantity:");
		l11.setFont(new Font("Arial",Font.BOLD,30));
		t7=new JTextField();
		t7.setFont(new Font("Arial",Font.BOLD,25));
		l12=new JLabel("Amount:");
		l12.setFont(new Font("Arial",Font.BOLD,30));
		t8=new JTextField();
		t8.setFont(new Font("Arial",Font.BOLD,25));
		l13=new JLabel("Updated Balance:");
		l13.setFont(new Font("Arial",Font.BOLD,30));
		t9=new JTextField();
		t9.setFont(new Font("Arial",Font.BOLD,25));
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
		l12.setForeground(clr1);
		l13.setForeground(clr1);
		t1.setForeground(clr4);
		t2.setForeground(clr4);
		t3.setForeground(clr4);
		t4.setForeground(clr4);
		t5.setForeground(clr4);
		t6.setForeground(clr4);
		t7.setForeground(clr4);
		t8.setForeground(clr4);
		t9.setForeground(clr4);	
		c1.setForeground(clr4);	
		c2.setForeground(clr4);	
		c3.setForeground(clr4);			
		t1.setBackground(clr1);
		t2.setBackground(clr1);
		t3.setBackground(clr1);	
        t4.setBackground(clr1);
		t5.setBackground(clr1);
		t6.setBackground(clr1);	
        t7.setBackground(clr1);
		t8.setBackground(clr1);
		t9.setBackground(clr1);	
        c1.setBackground(clr1);
		c2.setBackground(clr1);
		c3.setBackground(clr1);
        exitbtn.setForeground(clr1);			
		b1.setForeground(clr4);
		exitbtn.setBackground(clr4);
		b1.setBackground(clr1);
		l2.setBounds(350,0,250,50);
		t1.setBounds(650,5,250,40);
		l3.setBounds(350,60,250,50);
		t2.setBounds(650,65,250,40);
		l4.setBounds(350,120,250,50);
		c1.setBounds(650,125,250,40);
		l5.setBounds(200,180,150,50);
		t3.setBounds(350,185,250,40);
		l6.setBounds(650,180,150,50);
		t4.setBounds(780,185,250,40);
		l7.setBounds(200,240,150,50);
		c2.setBounds(350,245,250,40);
		l8.setBounds(650,240,150,50);
		c3.setBounds(780,245,250,40);
		l9.setBounds(350,300,250,50);
		t5.setBounds(650,305,250,40);
		l10.setBounds(50,360,180,50);
		t6.setBounds(220,365,250,40);
		l11.setBounds(510,360,250,50);
		t7.setBounds(650,365,100,40);
		l12.setBounds(790,360,250,50);
		t8.setBounds(920,365,250,40);
		l13.setBounds(370,420,280,50);
		t9.setBounds(650,425,250,40);
		b1.setBounds(570,490,150,50);
		exitbtn.setBounds(1150,480,80,30);
		p1.add(l1);
        p2.add(l2);
		p2.add(t1);
		p2.add(l3);
		p2.add(t2);
		p2.add(l4);
		p2.add(c1);
		p2.add(l5);
		p2.add(t3);
		p2.add(l6);
		p2.add(t4);
		p2.add(l7);
		p2.add(c2);
		p2.add(l8);
		p2.add(c3);
		p2.add(l9);
		p2.add(t5);
		p2.add(l10);
		p2.add(t6);
		p2.add(l11);
		p2.add(t7);
		p2.add(l12);
		p2.add(t8);
		p2.add(l13);
		p2.add(t9);
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
		    ResultSet rs=stmt.executeQuery("select MAX(sr_no) from purchase");
	        if(rs.next()) 
			{
		       serial=rs.getInt(1)+1;
		       if(serial<401) 
			   serial=401;
	        }
			else 
			{
		       serial=401;
	        }
            ResultSet rs1=stmt.executeQuery("select d_id from party");
            while(rs1.next()) 
			{
                c1.addItem(rs1.getString("d_id"));
            }			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		t1.setText(String.valueOf(serial));
		t1.setEditable(false);
		//t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		t8.setEditable(false);
		t9.setEditable(false);
		//c2.setEnabled(false);
		b1.addActionListener(this);
		exitbtn.addActionListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		t2.addFocusListener(this);
		t5.addFocusListener(this);
		t6.addFocusListener(this);
		t7.addFocusListener(this);
		t8.addFocusListener(this);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new Purchase_item();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exitbtn)
		this.dispose();
	    if(e.getSource()==b1)
		{
			try
			{
				if(t5.getText().equals("")||t7.getText().equals("")||c1.getSelectedItem().equals("-select-")||c3.getSelectedItem().equals("-select-"))
			    JOptionPane.showMessageDialog(this,"Enter all details.");
		        else
			    {
                    String s1="insert into purchase values('"+t1.getText()+"','"+t2.getText()+"','"+c1.getSelectedItem()+"','"+t4.getText()+"','"+c2.getSelectedItem()+"','"+c3.getSelectedItem()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"','"+t9.getText()+"')";
				    stmt.executeUpdate(s1);
			        JOptionPane.showMessageDialog(this,"Record saved.");					
			    }				
				ResultSet rs=stmt.executeQuery("select MAX(sr_no) from purchase");
	            if(rs.next()) 
			    {
		            serial=rs.getInt(1)+1;
		            if(serial<401) 
			        serial=401;
	            }
			    else 
			    {
		            serial=401;
	            }
				String balanceText=t9.getText().trim();
                String idText=c1.getSelectedItem().toString().trim();
                if(!balanceText.isEmpty()&& !idText.equals("-select-")) 
				{
                    double balance=Double.parseDouble(balanceText);
                    int d_id=Integer.parseInt(idText);
                    String updt="update party set balance="+balance+" where d_id="+ d_id;
			        stmt.executeUpdate(updt);
				}	
				ResultSet rst=stmt.executeQuery("select MAX(sr_no) from stock");
	            if(rst.next()) 
			    {
		            srl=rst.getInt(1)+1;
		            if(srl<501) 
			        srl=501;
	            }
			    else 
			    {
		            srl=501;
	            }
				ResultSet check=stmt.executeQuery("select qty from stock where company='"+c2.getSelectedItem()+"' and model='"+c3.getSelectedItem()+"'");
	            if(check.next()) 
				{
		            int qty=check.getInt("qty");
		            int new_qt=qty+Integer.parseInt(t7.getText().trim());
		            stmt.executeUpdate("update stock set qty="+new_qt+" where company='"+c2.getSelectedItem()+"' and model='"+c3.getSelectedItem()+"'");
	            }           
	            else      
	            {		
				    String st="insert into stock values('"+srl+"','"+c2.getSelectedItem()+"','"+c3.getSelectedItem()+"','"+t5.getText()+"','"+t7.getText()+"')";
                    stmt.executeUpdate(st);	
	            }				
                t1.setText(String.valueOf(serial));
		 		t2.setText(sdf.format(currentDate));
				c1.setSelectedIndex(0);
				c2.setSelectedIndex(0);
				c3.setSelectedIndex(0);
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");				
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
                Date enteredDate=sdf.parse(dateText);
                if(enteredDate.after(new Date())) 
				{
                    JOptionPane.showMessageDialog(this,"Future dates are not allowed.");
                    t2.requestFocus();
					return;
                }
	        } 
			catch(Exception e)
			{
                JOptionPane.showMessageDialog(this,"Invalid date format! Use dd-MM-yyyy.");
                t2.requestFocus();
            }
        }
		try
		{
			if(f.getSource()==t7)
			{
				double cp=Double.parseDouble(t6.getText().trim()); 
				int qt=Integer.parseInt(t7.getText().trim());
				double amt=cp*qt;
				amt=Math.round(amt*100.0)/100.0;
				t8.setText(String.format("%.2f",amt));
				double bal=Double.parseDouble(t4.getText().trim());
				bal=Math.round(bal*100.0)/100.0;
				t9.setText(String.format("%.2f",bal+amt));
            } 
		}
		catch(NumberFormatException ex)
		{
            JOptionPane.showMessageDialog(this,"Value must be a number.");
        }
	}
	boolean ignoreItemEvents=true;
	public void itemStateChanged(ItemEvent i)
	{
		if(i.getSource()==c1)
		{
			t5.setText("");
			c2.setEnabled(false);
			if(c1.getSelectedIndex()==0)
			c2.setSelectedIndex(0);
			try
		    {
			    String ss="select * from party where d_id='"+c1.getSelectedItem()+"'";
		        ResultSet rss1=stmt.executeQuery(ss);
		        if(rss1.next())
	            { 
		            t3.setText(rss1.getString(2));
		            t4.setText(rss1.getString(6));
		            c2.setSelectedItem(rss1.getString(3));		        
	            }
		    }
		    catch(SQLException s)
	    	{
		    	System.out.println(s);
		    }
		}
		if(i.getSource()==c2)
		{
			ignoreItemEvents=true;
			c3.removeAllItems();
			c3.addItem("-select-");
			int index=c2.getSelectedIndex();
			if(index==0)
			{
				c3.addItem("-select-");
			}
			else if(index==1)
			{
				c3.addItem("Samsung Galaxy S24 Ultra");
				c3.addItem("Samsung Galaxy A55 5G");
				c3.addItem("Samsung Galaxy M14 5G");
				c3.addItem("Samsung Galaxy Z Flip5");
			}
			else if(index==2)
			{
				c3.addItem("Realme GT 5 Pro");
				c3.addItem("Realme 11 Pro+ 5G");
				c3.addItem("Realme Narzo 60 5G");
				c3.addItem("Realme C55");
			}
			else if(index==3)
			{
				c3.addItem("Vivo X100 Pro");
				c3.addItem("Vivo V29 Pro");
				c3.addItem("Vivo T2 5G");
				c3.addItem("Vivo Y100");
			}
			else if(index==4)
			{
				c3.addItem("OnePlus 12");
				c3.addItem("OnePlus Nord 3 5G");
				c3.addItem("OnePlus Nord CE 3 Lite");
				c3.addItem("OnePlus Open");
			}
			ignoreItemEvents=false;
		}
		if(i.getSource()==c3&&!ignoreItemEvents)
		{
			String item=(String)c3.getSelectedItem();
			int val=0;
			if(item.equals("Samsung Galaxy S24 Ultra"))
			val=90299;
		    else if(item.equals("Samsung Galaxy A55 5G"))
			val=27999;
		    else if(item.equals("Samsung Galaxy M14 5G"))
			val=13899;
			else if(item.equals("Samsung Galaxy Z Flip5"))
			val=39999;
		    else if(item.equals("Realme GT 5 Pro"))
			val=19490;
		    else if(item.equals("Realme 11 Pro+ 5G"))
			val=32999;
		    else if(item.equals("Realme Narzo 60 5G"))
			val=14999;
		    else if(item.equals("Realme C55"))
			val=16289;
		    else if(item.equals("Vivo X100 Pro"))
			val=89899;
		    else if(item.equals("Vivo V29 Pro"))
			val=31999;
		    else if(item.equals("Vivo T2 5G"))
			val=17999;
		    else if(item.equals("Vivo Y100"))
			val=15999;
		    else if(item.equals("OnePlus 12"))
			val=56998;
		    else if(item.equals("OnePlus Nord 3 5G"))
			val=22925;
		    else if(item.equals("OnePlus Nord CE 3 Lite"))
			val=17999;
		    else if(item.equals("OnePlus Open"))
			val=71500;
		    t5.setText(String.valueOf(val));
			double mrp=Double.parseDouble(t5.getText().trim());
            mrp=Math.round(mrp*100.0)/100.0;
			double cp=mrp*0.7;
			cp=Math.round(cp*100.0)/100.0;
			t6.setText(String.format("%.2f",cp));
		}
	}
}