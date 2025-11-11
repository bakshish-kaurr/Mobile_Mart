import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Login_page extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,img1,img2,logoLabel;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	JPanel p1,p2;
	Color clr1,clr2,clr3,clr4;
	Connection conn;
	Statement stmt;
	Login_page()
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Mobile Mart: Inventory Control Hub");
		setLayout(null);
		clr1=Color.decode("#89A8B2");
	    clr2=Color.decode("#B3C8CF");
	    clr3=Color.decode("#E5E1DA");
	    clr4=Color.decode("#F1F0E8");
		int screenWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
		int p1Width=(int)(screenWidth*0.49);
        int p2Width=screenWidth-p1Width; 
		Container con=getContentPane();
		p1=new JPanel();
        p1.setBackground(clr2);
		p1.setBounds(0,0,p1Width,screenHeight);
		p2=new JPanel();
        p2.setBackground(clr4);
		p2.setBounds(p1Width,0,p2Width,screenHeight);
		add(p1);
		add(p2);
		logoLabel=new JLabel();
		ImageIcon logo=new ImageIcon("logo.png");
        Image scaledLogo=logo.getImage().getScaledInstance(500,500,Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(scaledLogo));
        p1.setLayout(new GridBagLayout());
        p1.add(logoLabel);
		p2.setLayout(null);
		l1=new JLabel("Login");
		l1.setFont(new Font("Arial",Font.BOLD,42));
		img1=new JLabel();
		ImageIcon icon1=new ImageIcon("img1.png");
        img1.setIcon(icon1);
		l2=new JLabel("Username");
		l2.setFont(new Font("Arial",Font.PLAIN,33));
		t1=new JTextField();
		t1.setFont(new Font("Arial",Font.PLAIN,25));
		img2=new JLabel();
		ImageIcon icon2=new ImageIcon("img2.png");
		l3=new JLabel("Password");
		l3.setFont(new Font("Arial",Font.PLAIN,33));
		t2=new JPasswordField();
		t2.setFont(new Font("Arial",Font.PLAIN,25));
        img2.setIcon(icon2);
		b1=new JButton("Login");
		b1.setFont(new Font("Arial",Font.BOLD,25));
		b2=new JButton("Cancel");
		b2.setFont(new Font("Arial",Font.BOLD,25));
		l1.setForeground(clr1);
		l2.setForeground(clr1);
		l3.setForeground(clr1);
		t1.setForeground(clr1);
		t2.setForeground(clr1);
		img1.setForeground(clr1);
		img2.setForeground(clr1);
		b1.setForeground(clr3);
		b2.setForeground(clr3);
		b1.setBackground(clr1);
		b2.setBackground(clr1);
		l1.setBounds(230,30,200,150);
		img1.setBounds(100,180,50,50);
		l2.setBounds(140,180,200,50);
		t1.setBounds(100,230,400,40);
		img2.setBounds(100,300,50,50);
		l3.setBounds(140,300,200,50);
		t2.setBounds(100,350,400,40);
		b1.setBounds(130,480,150,50);
		b2.setBounds(320,480,150,50);
		p2.add(l1);
		p2.add(img1);
		p2.add(l2);
		p2.add(t1);
		p2.add(img2);
		p2.add(l3);
		p2.add(t2);
		p2.add(b1);
		p2.add(b2);
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
		b1.addActionListener(this);
		b2.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new Login_page();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String user=t1.getText();
			String pass=String.valueOf(t2.getPassword());
			try
			{
			    String q1="select * from users where username='"+user+"' and password='"+pass+"'";
                ResultSet rs=stmt.executeQuery(q1);
                if(rs.next())
			    {
					if(user.equals("Admin"))
					new Admin(user);
					else
					new User(user);
				    this.dispose();
                }
				else
                JOptionPane.showMessageDialog(this,"Invalid Username or Password.");
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,"Database Error."+ex+"");
			}
			t1.setText("");
		    t2.setText("");
			t1.requestFocus();
		}
		if(e.getSource()==b2)
		System.exit(1);
	}
}
