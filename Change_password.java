import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Change_password extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JPasswordField f1,f2,f3;
	JButton b1,exitbtn;
	JPanel p1,p2;
	Color clr1,clr2,clr3,clr4;
	Connection conn;
	Statement stmt;
	String username;
	public Change_password(String username)
	{
		this.username=username;
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
		l1=new JLabel("Change Password");
		l1.setFont(new Font("Arial",Font.BOLD,40));
		l2=new JLabel("Old Password:");
		l2.setFont(new Font("Arial",Font.BOLD,30));
		f1=new JPasswordField();
		f1.setFont(new Font("Arial",Font.BOLD,25));
		l3=new JLabel("New Password:");
		l3.setFont(new Font("Arial",Font.BOLD,30));
		f2=new JPasswordField();
		f2.setFont(new Font("Arial",Font.BOLD,25));
		l4=new JLabel("Confirm:");
		l4.setFont(new Font("Arial",Font.BOLD,30));
		f3=new JPasswordField();
		f3.setFont(new Font("Arial",Font.BOLD,25));
		b1=new JButton("Change");
		b1.setFont(new Font("Arial",Font.BOLD,30));
		exitbtn=new JButton("Exit");
		exitbtn.setFont(new Font("Arial",Font.BOLD,20));
		l1.setForeground(clr4);
		l2.setForeground(clr1);
		l3.setForeground(clr1);
		l4.setForeground(clr1);
		f1.setForeground(clr4);
		f2.setForeground(clr4);
		f3.setForeground(clr4);
		f1.setBackground(clr1);
		f2.setBackground(clr1);
		f3.setBackground(clr1);
		exitbtn.setForeground(clr1);	
		b1.setForeground(clr4);
		exitbtn.setBackground(clr4);
		b1.setBackground(clr1);
		l2.setBounds(350,50,250,50);
		f1.setBounds(650,55,250,40);
		l3.setBounds(350,120,250,50);
		f2.setBounds(650,125,250,40);
		l4.setBounds(350,190,250,50);
		f3.setBounds(650,195,250,40);
		b1.setBounds(570,400,150,50);
		exitbtn.setBounds(1150,480,80,30);
		p1.add(l1);
        p2.add(l2);
		p2.add(f1);
		p2.add(l3);
		p2.add(f2);
		p2.add(l4);
		p2.add(f3);
		p2.add(b1);
		p2.add(exitbtn);
		add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory_master","root","");
			stmt=conn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		exitbtn.addActionListener(this);
		b1.addActionListener(this);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new Change_password("username");
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exitbtn)
		this.dispose();
	    if(e.getSource()==b1)
		{
			String old_p=new String(f1.getPassword());
            String new_p=new String(f2.getPassword());
            String cn_p=new String(f3.getPassword());
			if(old_p.isEmpty()||new_p.isEmpty()||cn_p.isEmpty()) 
			{
                JOptionPane.showMessageDialog(this,"All fields are required.");
                return;
            }			
            try 
			{
                ResultSet rs=stmt.executeQuery("select password from users where username='"+username+"'");
                if(rs.next()) 
				{
                    String cr_p=rs.getString("password");
                    if(!cr_p.equals(old_p))
			        {
				        JOptionPane.showMessageDialog(this,"Old password is incorrect.");
				        return;
			        }                    
                    else if(!new_p.equals(cn_p))
                    JOptionPane.showMessageDialog(this,"Passwords do not match.");
                    else
					{
                        stmt.executeUpdate("update users set password='"+new_p+ "' where username='"+username+"'");
                        JOptionPane.showMessageDialog(this,"Password changed successfully.");						
                        f1.setText(""); 
						f2.setText(""); 
						f3.setText("");
                    }
                } 
				else 
				{
                    JOptionPane.showMessageDialog(this,"User not found.");
                }
            } 
			catch (Exception ex) 
			{
                JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
            }
        }
    }
}