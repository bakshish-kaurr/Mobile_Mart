import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Create_user extends JFrame implements ActionListener,FocusListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3;
	JPasswordField f1,f2;
	JButton b1,b2,exitbtn;
	JPanel p1,p2;
	Color clr1,clr2,clr3,clr4;
	int serial;
	Connection conn;
	Statement stmt;
	Create_user()
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
		l1=new JLabel("Create User",SwingConstants.CENTER);
		l1.setFont(new Font("Arial",Font.BOLD,40));
		l2=new JLabel("User Name:");
		l2.setFont(new Font("Arial",Font.BOLD,30));
		t1=new JTextField();
		t1.setFont(new Font("Arial",Font.BOLD,25));
		l3=new JLabel("Password:");
		l3.setFont(new Font("Arial",Font.BOLD,30));
		f1=new JPasswordField();
		f1.setFont(new Font("Arial",Font.BOLD,25));
		l4=new JLabel("Confirm Password:");
		l4.setFont(new Font("Arial",Font.BOLD,30));
		f2=new JPasswordField();
		f2.setFont(new Font("Arial",Font.BOLD,25));
		l5=new JLabel("Mobile:");
		l5.setFont(new Font("Arial",Font.BOLD,30));
		t2=new JTextField();
		t2.setFont(new Font("Arial",Font.BOLD,25));
		l6=new JLabel("City:");
		l6.setFont(new Font("Arial",Font.BOLD,30));
		t3=new JTextField();
		t3.setFont(new Font("Arial",Font.BOLD,25));
		b1=new JButton("New");
		b1.setFont(new Font("Arial",Font.BOLD,30));
		b2=new JButton("Create");
		b2.setFont(new Font("Arial",Font.BOLD,30));
		exitbtn=new JButton("Exit");
		exitbtn.setFont(new Font("Arial",Font.BOLD,20));
		l1.setForeground(clr4);
		l2.setForeground(clr1);
		l3.setForeground(clr1);
		l4.setForeground(clr1);
		l5.setForeground(clr1);
		l6.setForeground(clr1);
		t1.setForeground(clr4);
		t2.setForeground(clr4);
		t3.setForeground(clr4);
		f1.setForeground(clr4);
		f2.setForeground(clr4);			
		t1.setBackground(clr1);
		t2.setBackground(clr1);
		t3.setBackground(clr1);	
        f1.setBackground(clr1);
        f2.setBackground(clr1);	
        exitbtn.setForeground(clr1);		
		b1.setForeground(clr4);
		b2.setForeground(clr4);
		exitbtn.setBackground(clr4);
		b1.setBackground(clr1);
		b2.setBackground(clr1);
		l2.setBounds(350,30,250,50);
		t1.setBounds(650,35,250,40);
		l3.setBounds(350,90,250,50);
		f1.setBounds(650,95,250,40);
		l4.setBounds(350,150,280,50);
		f2.setBounds(650,155,250,40);
		l5.setBounds(350,210,250,50);
		t2.setBounds(650,215,250,40);
		l6.setBounds(350,270,250,50);
		t3.setBounds(650,275,250,40);
		b1.setBounds(450,470,150,50);
		b2.setBounds(650,470,150,50);
		exitbtn.setBounds(1150,480,80,30);
		p1.add(l1);
        p2.add(l2);
		p2.add(t1);
		p2.add(l3);
		p2.add(t2);
		p2.add(l4);
		p2.add(f1);
		p2.add(l5);
		p2.add(f2);
		p2.add(l6);
		p2.add(t3);
		p2.add(b1);
		p2.add(b2);
		p2.add(exitbtn);
		add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory_master","root","");
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select MAX(user_id) from users");
            if(rs.next()) 
			{
		       serial=rs.getInt(1)+1;
		       if(serial<101) 
			   serial=101;
	        }
			else 
			{
		       serial=101;
	        }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		exitbtn.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		t2.addFocusListener(this);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new Create_user();
	}
	public void focusGained(FocusEvent f)
	{}
	public void focusLost(FocusEvent f)
	{
		if(f.getSource()==t2)
		{
            String mobileText=t2.getText().trim();
			if(!mobileText.matches("\\d{10}")) 
			{
                JOptionPane.showMessageDialog(this,"Mobile number must be exactly 10 digits.");
                t2.requestFocus();
            }
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exitbtn)
		this.dispose();
	    if(e.getSource()==b1)
		{
			t1.setText("");
			f1.setText("");
			f2.setText("");
			t2.setText("");
			t3.setText("");
			t1.requestFocus();
		}
	    if(e.getSource()==b2)
		{
			try
			{
				String stt="select count(*)from users where username='"+t1.getText()+"'";
			    int c=0;
			    ResultSet rs1=stmt.executeQuery(stt);
			    if(rs1.next())
			    c=rs1.getInt(1);
		        if(c>0)
			    JOptionPane.showMessageDialog(this,"Can't enter duplicate records.");
			    else if(t1.getText().equals("")||f1.getText().equals("")||t2.getText().equals("")||t3.getText().equals(""))
				JOptionPane.showMessageDialog(this,"Enter all details.");
			    else if(!f1.getText().equals(f2.getText()))
				JOptionPane.showMessageDialog(this,"Enter password again.");
		        else
			    {
			        String s1="insert into users values("+serial+",'"+t1.getText()+"','"+f1.getText()+"','"+t2.getText()+"','"+t3.getText()+"')";
			        stmt.executeUpdate(s1);
			        JOptionPane.showMessageDialog(this,"Record saved.");
					serial++;
					t1.setText("");
					f1.setText("");
					f2.setText("");
					t2.setText("");
					t3.setText("");
					t1.requestFocus();
			    }
			}
			catch(Exception exc)
			{
				System.out.println(exc);
			}
		}
	}
}