import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Party_master extends JFrame implements ActionListener,FocusListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox c1;
	JButton b1,b2,b3,b4,b5,exitbtn;
	JPanel p1,p2;
	Connection conn;
	Statement stmt;
	int serial;
	Color clr1,clr2,clr3,clr4;
	Party_master()
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
		l1=new JLabel("Party Master");
		l1.setFont(new Font("Arial",Font.BOLD,40));
		l2=new JLabel("Distributor ID:");
		l2.setFont(new Font("Arial",Font.BOLD,30));
		t1=new JTextField();
		t1.setFont(new Font("Arial",Font.BOLD,25));
		l3=new JLabel("D Name:");
		l3.setFont(new Font("Arial",Font.BOLD,30));
		t2=new JTextField();
		t2.setFont(new Font("Arial",Font.BOLD,25));
		l4=new JLabel("Company:");
		l4.setFont(new Font("Arial",Font.BOLD,30));
		c1=new JComboBox();
		c1.setFont(new Font("Arial",Font.BOLD,25));
        c1.addItem("-select-");
		c1.addItem("Samsung");
		c1.addItem("Realme");
		c1.addItem("Vivo");
		c1.addItem("OnePlus");
		l5=new JLabel("Mobile:");
		l5.setFont(new Font("Arial",Font.BOLD,30));
		t3=new JTextField();
		t3.setFont(new Font("Arial",Font.BOLD,25));
		l6=new JLabel("City:");
		l6.setFont(new Font("Arial",Font.BOLD,30));
		t4=new JTextField();
		t4.setFont(new Font("Arial",Font.BOLD,25));
		l7=new JLabel("Balance:");
		l7.setFont(new Font("Arial",Font.BOLD,30));
		t5=new JTextField();
		t5.setFont(new Font("Arial",Font.BOLD,25));
		b1=new JButton("New");
		b1.setFont(new Font("Arial",Font.BOLD,30));
		b2=new JButton("Save");
		b2.setFont(new Font("Arial",Font.BOLD,30));
		b3=new JButton("Modify");
		b3.setFont(new Font("Arial",Font.BOLD,30));
		b4=new JButton("Delete");
		b4.setFont(new Font("Arial",Font.BOLD,30));
		exitbtn=new JButton("Exit");
		exitbtn.setFont(new Font("Arial",Font.BOLD,20));
		t6=new JTextField("");
		t6.setFont(new Font("Arial",Font.PLAIN,20));
		b5=new JButton("Find");
		b5.setFont(new Font("Arial",Font.PLAIN,20));
		l1.setForeground(clr4);
		l2.setForeground(clr1);
		l3.setForeground(clr1);
		l4.setForeground(clr1);
		l5.setForeground(clr1);
		l6.setForeground(clr1);
		l7.setForeground(clr1);		
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
		b2.setForeground(clr4);
		b3.setForeground(clr4);
		b4.setForeground(clr4);
		b5.setForeground(clr4);
		exitbtn.setBackground(clr4);
		b1.setBackground(clr1);
		b2.setBackground(clr1);
		b3.setBackground(clr1);
		b4.setBackground(clr1);
		b5.setBackground(clr1);
		l2.setBounds(350,30,250,50);
		t1.setBounds(650,35,250,40);
		l3.setBounds(350,90,250,50);
		t2.setBounds(650,95,250,40);
		l4.setBounds(350,150,250,50);
		c1.setBounds(650,155,250,40);
		l5.setBounds(350,210,280,50);
		t3.setBounds(650,215,250,40);
		l6.setBounds(350,270,250,50);
		t4.setBounds(650,275,250,40);
		l7.setBounds(350,330,250,50);
		t5.setBounds(650,335,250,40);
		t6.setBounds(250,420,100,40);
		b5.setBounds(370,420,80,40);
		b1.setBounds(250,470,150,50);
		b2.setBounds(450,470,150,50);
		b3.setBounds(650,470,150,50);
		b4.setBounds(850,470,150,50);
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
		p2.add(t5);
		p2.add(t6);
		p2.add(b5);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);	
        p2.add(exitbtn);		
		add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory_master","root","");
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select MAX(d_id) from party");
            if(rs.next()) 
			{
		       serial=rs.getInt(1)+1;
		       if(serial<201) 
			   serial=201;
	        }
			else 
			{
		       serial=201;
	        }			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		t1.setText(String.valueOf(serial));
		exitbtn.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		t3.addFocusListener(this);
		t5.addFocusListener(this);
		b3.setEnabled(false);
		b4.setEnabled(false);
		t1.setEditable(false);
		c1.setSelectedIndex(0);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new Party_master();
	}
	public void focusGained(FocusEvent f)
	{}
	public void focusLost(FocusEvent f)
	{
		if(f.getSource()==t3)
		{
            String mobileText=t3.getText().trim();
			if(!mobileText.matches("\\d{10}")) 
			{
                JOptionPane.showMessageDialog(this,"Mobile number must be exactly 10 digits.");
                t3.requestFocus();
            }
		}
		if(f.getSource()==t5)
		{
		    try
		    {
                double bal= Double.parseDouble(t5.getText().trim());
                bal=Math.round(bal*100.0)/100.0;
                t5.setText(String.format("%.2f",bal)); 
            } 
		    catch(NumberFormatException ex)
		    {
                JOptionPane.showMessageDialog(null,"Balance must be a number.");
                t5.requestFocus();
            }
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exitbtn)
		this.dispose();
        try
        {
			if(e.getSource()==b1)
			{
				//t1.setText("");
				t1.setText(String.valueOf(serial));
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				c1.setSelectedItem("-select-");
				b2.setEnabled(true);
			}
	        if(e.getSource()==b2)
		    {
			    if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals("")||c1.getSelectedItem().equals("-select-"))
				JOptionPane.showMessageDialog(this,"Enter all details.");
		        else
			    {
    			    String s1="insert into party values('"+t1.getText()+"','"+t2.getText()+"','"+c1.getSelectedItem()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"')";
				    stmt.executeUpdate(s1);
			        JOptionPane.showMessageDialog(this,"Record saved.");
					//t1.setText("");
					serial++;
					t1.setText(String.valueOf(serial));
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					c1.setSelectedItem("Samsung");
				}
			}
			if(e.getSource()==b3)
			{
				String s2="update party set d_id='"+t1.getText()+"',d_name='"+t2.getText()+"',company='"+c1.getSelectedItem()+"',mobile='"+t3.getText()+"',city='"+t4.getText()+"',balance='"+t5.getText()+"' where d_id='"+t1.getText()+"'";
		        stmt.executeUpdate(s2);
			    JOptionPane.showMessageDialog(this,"Record updated.");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				c1.setSelectedItem("Samsung");
				b2.setEnabled(true);
				b3.setEnabled(false);
				b4.setEnabled(false);
			}
			if(e.getSource()==b4)
			{
		    	String s3="delete from party where d_id='"+t1.getText()+"'";
			    stmt.executeUpdate(s3);
		        JOptionPane.showMessageDialog(this,"Record deleted successfully.");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				c1.setSelectedItem("Samsung");
				b2.setEnabled(true);
				b3.setEnabled(false);
				b4.setEnabled(false);
			}
			if(e.getSource()==b5)
			{
				String ss="select * from party where d_id='"+t6.getText()+"'";
		        ResultSet rss=stmt.executeQuery(ss);
				String cp="";
				if(rss.next())
		        {
					t1.setText(rss.getString(1));			       
			        t2.setText(rss.getString(2));
					cp=rss.getString(3);
					c1.setSelectedItem(cp);
			        t3.setText(rss.getString(4));
					t4.setText(rss.getString(5));
                    t5.setText(rss.getString(6));
					b2.setEnabled(false);
					b3.setEnabled(true);
					b4.setEnabled(true);
					t1.setEditable(false);
				}
				else if(t6.getText().equals(""))
				JOptionPane.showMessageDialog(this,"Enter D_ID.");
				else
				JOptionPane.showMessageDialog(this,"Record not found.");
			}
		}
		catch(Exception exc)
		{
			System.out.println(exc);
		}
	}
}