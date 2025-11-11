import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Itemwise_details extends JFrame implements ActionListener 
{
    JLabel l1,l2;
    JComboBox<String> c1;
    JTable table;
    JScrollPane scroll;
    JPanel p1,p2;
    DefaultTableModel model;
    JButton exitbtn;
    Color clr1,clr2,clr3,clr4;
    Connection conn;
    Statement stmt;
    public Itemwise_details() 
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
        l1=new JLabel("Itemwise Details");
        l1.setFont(new Font("Arial",Font.BOLD,40));
        l1.setForeground(clr4);
        p1.add(l1);
        p2=new JPanel();
        p2.setBackground(clr3);
        p2.setLayout(null);
        l2=new JLabel("Company:");
        l2.setFont(new Font("Arial",Font.BOLD,30));
        l2.setForeground(clr1);
        l2.setBounds(300,20,200,40);
        p2.add(l2);
        c1=new JComboBox<>();
        c1.setFont(new Font("Arial",Font.BOLD,25));
        c1.setBackground(clr1);
        c1.setForeground(clr4);
        c1.setBounds(500,20,250,40);
        c1.addItem("All");
        c1.addItem("Samsung");
        c1.addItem("Realme");
        c1.addItem("Vivo");
        c1.addItem("OnePlus");
        c1.addActionListener(this);
        p2.add(c1);
        model=new DefaultTableModel();
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
        table.setFont(new Font("Arial",Font.BOLD,24));
        table.setForeground(clr1);
        table.setBackground(clr4);
        table.setRowHeight(50);
        JTableHeader header=table.getTableHeader();
        header.setPreferredSize(new Dimension(100,60));
        header.setBackground(clr1);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial",Font.BOLD,30));
        TableColumnModel columnModel=table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(280);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(150);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<table.getColumnCount();i++) 
		{
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        scroll=new JScrollPane(table);
        scroll.setBounds(140,90,920,340);
        p2.add(scroll);
        exitbtn=new JButton("Exit");
        exitbtn.setFont(new Font("Arial",Font.BOLD,20));
        exitbtn.setBounds(1150,480,80,30);
        exitbtn.setForeground(clr1);
        exitbtn.setBackground(clr4);
        exitbtn.addActionListener(this);
        p2.add(exitbtn);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        try 
		{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/inventory_master", "root", "");
            stmt=conn.createStatement();
            loadData("All");
        }  
		catch(Exception e)
		{
            System.out.println(e);
        }
        setVisible(true);
    }
    public void loadData(String company) 
	{
        try 
		{
            model.setRowCount(0);
            String query=company.equals("All")?"select model,mrp,qty from stock":"select model,mrp,qty from stock where company='"+company+"'";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()) 
			{
                model.addRow(new Object[]{rs.getString("model"),rs.getString("mrp"),rs.getString("qty")});
            }
        } 
		catch(SQLException ex)
		{
            System.out.println(ex);
        }
    }
    public void actionPerformed(ActionEvent e) 
	{
        if(e.getSource()==c1) 
		{
            loadData((String)c1.getSelectedItem());
        } 
		else if(e.getSource()==exitbtn) 
		{
            this.dispose();
        }
    }
    public static void main(String arr[]) 
	{
        new Itemwise_details();
    }
}
