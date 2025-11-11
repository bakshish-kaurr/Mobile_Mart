import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class User extends JFrame implements ActionListener
{
	JLabel l1,img;
	JPanel p1,p2;
	JMenuBar mb;
	JMenu m1,m2,m3;
	JMenuItem m1_1,m1_2,m2_1,m2_2,m3_1,m3_2;
	Color clr1,clr2,clr3,clr4;
	String username;
	public User(String username)
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
        p2.setBackground(clr2);
		p2.setLayout(new BorderLayout());
		mb=new JMenuBar();
		m1=new JMenu("User Activity");
		m2=new JMenu("Inventory Oversight");
		m3=new JMenu("Reports");
		m1_1=new JMenuItem("Change Password");
		m1_2=new JMenuItem("Exit");
		m2_1=new JMenuItem("Sale Item");
		m3_1=new JMenuItem("Itemwise Details");
		m3_2=new JMenuItem("Sale Reports");
		m1.add(m1_1);
		m1.add(m1_2);
		m2.add(m2_1);
		m3.add(m3_1);
		m3.add(m3_2);
		mb.add(Box.createHorizontalStrut(50));
		mb.add(m1);
		mb.add(Box.createHorizontalStrut(250));
		mb.add(m2);
		mb.add(Box.createHorizontalStrut(250));
		mb.add(m3);
		mb.setPreferredSize(new Dimension(mb.getWidth(),70));
		ImageIcon icon=new ImageIcon("logo.png");
        img=new JLabel(icon);
        p2.add(img,BorderLayout.CENTER);
		l1=new JLabel("Welcome "+username+"!");
		l1.setFont(new Font("Arial",Font.BOLD,40));
		m1.setFont(new Font("Arial",Font.BOLD,30));
		m2.setFont(new Font("Arial",Font.BOLD,30));
		m3.setFont(new Font("Arial",Font.BOLD,30));
		m1_1.setFont(new Font("Arial",Font.PLAIN,20));
		m1_2.setFont(new Font("Arial",Font.PLAIN,20));
		m2_1.setFont(new Font("Arial",Font.PLAIN,20));
		m3_1.setFont(new Font("Arial",Font.PLAIN,20));
		m3_2.setFont(new Font("Arial",Font.PLAIN,20));
		l1.setForeground(clr4);
		mb.setBackground(clr3);
		m1.setForeground(clr1);
		m2.setForeground(clr1);
		m3.setForeground(clr1);
		m1_1.setForeground(clr1);
		m1_2.setForeground(clr1);
		m2_1.setForeground(clr1);
		m3_1.setForeground(clr1);
		m3_2.setForeground(clr1);
		p1.add(l1);
		p2.add(mb,BorderLayout.NORTH);
		add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        m1_1.addActionListener(this);
		m1_2.addActionListener(this);
		m2_1.addActionListener(this);
		m3_1.addActionListener(this);
        m3_2.addActionListener(this);		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new User("username");
	}
	public void actionPerformed(ActionEvent e)
	{
        if(e.getSource()==m1_1)
		new Change_password(username);
	    if(e.getSource()==m1_2)
		{
			new Login_page();
			this.dispose();
		}
	    if(e.getSource()==m2_1)
		new Sale_item();
	    if(e.getSource()==m3_1)
		new Itemwise_details();
	    if(e.getSource()==m3_2)
		new Sale_reports();
	}
}