import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
public class Purchase_reports extends JFrame implements ActionListener,FocusListener
{
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JTable table;
    JScrollPane scroll;
    JPanel p1,p2;
    DefaultTableModel model;
    JButton b1,exitbtn;
    Color clr1,clr2,clr3,clr4;
    Connection conn;
    Statement stmt;
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    Date currentDate=new Date();
    public Purchase_reports() 
	{
        setTitle("Mobile Mart: Inventory Control Hub");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        clr1=Color.decode("#89A8B2");
        clr2=Color.decode("#B3C8CF");
        clr3=Color.decode("#E5E1DA");
        clr4=Color.decode("#F1F0E8");
        p1=new JPanel();
        p1.setBackground(clr1);
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
        l1=new JLabel("Purchase Reports");
        l1.setFont(new Font("Arial",Font.BOLD,40));
        l1.setForeground(clr4);
        p1.add(l1);
        p2=new JPanel();
        p2.setBackground(clr3);
        p2.setLayout(null);
        l2=new JLabel("Start Date:");
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(clr1);
        l2.setBounds(150,20,160,40);
        p2.add(l2);
		l3=new JLabel("End Date:");
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l3.setForeground(clr1);
        l3.setBounds(550,20,160,40);
        p2.add(l3);
        t1=new JTextField();
        t1.setFont(new Font("Arial",Font.BOLD,25));
        t1.setBackground(clr1);
        t1.setForeground(clr4);
        t1.setBounds(310,20,160,40);
        t1.addFocusListener(this);
        p2.add(t1);
		t2=new JTextField();
        t2.setFont(new Font("Arial",Font.BOLD,25));
        t2.setBackground(clr1);
        t2.setForeground(clr4);
        t2.setBounds(700,20,160,40);
        t2.addFocusListener(this);
        p2.add(t2);
        model=new DefaultTableModel();
        model.addColumn("S_No");
        model.addColumn("Date");
        model.addColumn("D_ID");
		model.addColumn("Model");
        model.addColumn("MRP");
        model.addColumn("Qty");
        table=new JTable(model) 
		{
            public boolean isCellEditable(int row,int column) 
			{
                return false;
            }
        };
        table.setFont(new Font("Arial",Font.BOLD,20));
        table.setForeground(clr1);
        table.setBackground(clr4);
        table.setRowHeight(50);
        JTableHeader header=table.getTableHeader();
        header.setPreferredSize(new Dimension(100,60));
        header.setBackground(clr1);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial",Font.BOLD,25));
        TableColumnModel columnModel=table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(110);
        columnModel.getColumn(2).setPreferredWidth(50);
		columnModel.getColumn(3).setPreferredWidth(220);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(30);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<table.getColumnCount();i++) 
		{
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        scroll=new JScrollPane(table);
        scroll.setBounds(140,90,920,340);
        p2.add(scroll);
		b1=new JButton("Display");
        b1.setFont(new Font("Arial",Font.BOLD,20));
        b1.setBounds(940,25,110,30);
        b1.setForeground(clr1);
        b1.setBackground(clr4);
        b1.addActionListener(this);
        p2.add(b1);
        exitbtn=new JButton("Exit");
        exitbtn.setFont(new Font("Arial",Font.BOLD,20));
        exitbtn.setBounds(1150,480,80,30);
        exitbtn.setForeground(clr1);
        exitbtn.setBackground(clr4);
        exitbtn.addActionListener(this);
        p2.add(exitbtn);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
		t1.setText(sdf.format(currentDate));		
		t2.setText(sdf.format(currentDate));		
        try 
		{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory_master", "root", "");
            stmt=conn.createStatement();
        }  
		catch(Exception e)
		{
            System.out.println(e);
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) 
	{
        if(e.getSource()==b1) 
        {
            String start=t1.getText().trim();
            String end=t2.getText().trim();
            try 
			{
                sdf.setLenient(false);
                Date d1=sdf.parse(start);
                Date d2=sdf.parse(end);
                model.setRowCount(0);
                String query="select sr_no,date,d_id,model,mrp,qty from purchase where str_to_date(date,'%d-%m-%Y') between str_to_date('"+start+"','%d-%m-%Y') and str_to_date('"+end+"','%d-%m-%Y')";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) 
				{
                    model.addRow(new Object[]{rs.getString("sr_no"),rs.getString("date"),rs.getString("d_id"),rs.getString("model"),rs.getString("mrp"),rs.getString("qty")});
                }
            }
			catch(Exception ex) 
			{
				JOptionPane.showMessageDialog(this,"Error: "+ex.getMessage());
            }
        }
		if(e.getSource()==exitbtn) 
		{
            this.dispose();
        }
    }
	public void focusGained(FocusEvent f)
	{}
	public void focusLost(FocusEvent f)
	{
	    if(f.getSource()==t1)
		{
            String dateText=t1.getText().trim();
            try
			{
                sdf.setLenient(false);
                Date enteredDate = sdf.parse(dateText);
                if(enteredDate.after(new Date())) 
				{
                    JOptionPane.showMessageDialog(this,"Future dates are not allowed.");
                    t1.requestFocus();
                }
	        } 
			catch(Exception e)
			{
                JOptionPane.showMessageDialog(this,"Invalid date format! Use dd-MM-yyyy.");
                t1.requestFocus();
            }
        }
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
	}
    public static void main(String arr[]) 
	{
        new Purchase_reports();
    }
}
