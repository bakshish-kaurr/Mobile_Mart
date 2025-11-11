import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Drop_user extends JFrame implements ActionListener,ItemListener
{
	JLabel l1,l2,l3,l4,l5;
	JComboBox c1;
	JTextField t1,t2,t3;
	JButton b1,exitbtn;
	JPanel p1,p2;
	Color clr1,clr2,clr3,clr4;
	Connection conn;
	Statement stmt;
	Drop_user()
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
		l1=new JLabel("Drop User");
		l1.setFont(new Font("Arial",Font.BOLD,40));
		l2=new JLabel("User List:");
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
		b1=new JButton("Drop");
		b1.setFont(new Font("Arial",Font.BOLD,30));
		exitbtn=new JButton("Exit");
		exitbtn.setFont(new Font("Arial",Font.BOLD,20));
		l1.setForeground(clr4);
		l2.setForeground(clr1);
		l3.setForeground(clr1);
		l4.setForeground(clr1);
		l5.setForeground(clr1);
		c1.setForeground(clr4);
		t1.setForeground(clr4);
		t2.setForeground(clr4);
		t3.setForeground(clr4);
        c1.setBackground(clr1);		
		t1.setBackground(clr1);
		t2.setBackground(clr1);
		t3.setBackground(clr1);	
		exitbtn.setForeground(clr1);	
		b1.setForeground(clr4);
		exitbtn.setBackground(clr4);
		b1.setBackground(clr1);
		l2.setBounds(350,30,250,50);
		c1.setBounds(650,35,250,40);
		l3.setBounds(350,120,250,50);
		t1.setBounds(650,125,250,40);
		l4.setBounds(350,190,250,50);
		t2.setBounds(650,195,250,40);
		l5.setBounds(350,260,250,50);
		t3.setBounds(650,265,250,40);
		b1.setBounds(570,400,150,50);
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
		p2.add(b1);
		p2.add(exitbtn);
		add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory_master","root","");
			stmt=conn.createStatement();
		    ResultSet rs=stmt.executeQuery("select username from users");
		    while(rs.next())
		    {
			    if(!rs.getString(1).equals("Admin"))
				c1.addItem(rs.getString(1));
		    }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		c1.addItemListener(this);
		b1.addActionListener(this);
		exitbtn.addActionListener(this);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new Drop_user();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exitbtn)
		this.dispose();
	    if(e.getSource()==b1)
		{
			try
			{
				if(c1.getSelectedItem().equals("-select-"))
			    JOptionPane.showMessageDialog(this,"Enter all details.");
			    else
				{
				    String del="delete from users where username='"+t1.getText()+"'";
			        stmt.executeUpdate(del);
			        JOptionPane.showMessageDialog(this,"Record deleted successfully.");
					c1.removeItem(t1.getText());
					c1.setSelectedIndex(0);			        
				    t1.setText("");
				    t2.setText("");
				    t3.setText("");
					
				}
			}
		    catch(Exception ex)
		    {
		        System.out.println(ex);
		    }
		}
	}
	public void itemStateChanged(ItemEvent i)
	{
		try
		{
			String rec="select * from users where username='"+c1.getSelectedItem()+"'";
		    ResultSet rss=stmt.executeQuery(rec);
		    if(rss.next())
		    {
			    t1.setText(rss.getString(2));
			    t2.setText(rss.getString(4));
			    t3.setText(rss.getString(5));
		    }
		}
		catch(SQLException s)
		{
			System.out.println(s);
		}
	}
}