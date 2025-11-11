import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Welcome_page extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JButton b1;
	JPanel p1,p2,p3;
	Color clr1,clr2,clr3,clr4;
	Welcome_page()
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
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p3=new JPanel();
        p3.setBackground(clr2);
        p3.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		l1=new JLabel("Welcome!!!");
		l1.setFont(new Font("Arial",Font.BOLD,60));
		l2=new JLabel("MOBILE MART:",SwingConstants.CENTER);
		l2.setAlignmentX(Component.CENTER_ALIGNMENT);
		l2.setFont(new Font("Arial",Font.BOLD,80));
		l3=new JLabel("Inventory Control Hub",SwingConstants.CENTER);
		l3.setAlignmentX(Component.CENTER_ALIGNMENT);
		l3.setFont(new Font("Arial",Font.ITALIC,70));
		b1=new JButton("Login");
		b1.setFont(new Font("Arial",Font.BOLD,40));
		b1.setFocusPainted(false); 
		l1.setForeground(clr4);
		l2.setForeground(clr1);
		l3.setForeground(clr1);
		b1.setForeground(clr1);
		b1.setBackground(clr4);		
		p1.add(l1);
		p2.add(Box.createVerticalGlue());
        p2.add(l2);
        p2.add(Box.createVerticalStrut(20));
        p2.add(l3);
        p2.add(Box.createVerticalGlue()); 
		p3.add(b1);
		add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
		b1.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String arr[])
	{
		new Welcome_page();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			new Login_page();
			this.dispose();
		}
	}
}