import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


class Myframe extends JFrame implements ActionListener
{
	Hashtable tm = new Hashtable();	
	JLabel l1,l2;
	JTextField t1,t2,t3,t4;
	JTextArea a;
	JButton b1,b2,b3;
	TreeSet ts = new TreeSet();
	Myframe()
	{
		super("City name and code");
		l1 = new JLabel("City");
		l2 = new JLabel("Code");
		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		b1 = new JButton("Add");
		b2 = new JButton("Remove");
		b3 = new JButton("Search");
		a = new JTextArea();
		
		setLayout(null);
		add(a);
		add(l1);add(l2);
		add(t1);add(t2);add(t3);add(t4);
		add(b1);add(b2);add(b3);
		t1.addActionListener(this);
		t2.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		a.setBounds(50,50,250,400);
		l1.setBounds(310,50,100,30);
		t1.setBounds(310,90,100,30);
		l2.setBounds(440,50,100,30);		
		t2.setBounds(440,90,100,30);
		b1.setBounds(400,130,100,30);
		t3.setBounds(310,180,100,30);
		b2.setBounds(310,230,100,30);
		t4.setBounds(440,180,100,30);
		b3.setBounds(440,230,100,30);
		
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a1)
	{
		if(a1.getSource()==b1)
		{
			tm.put(t1.getText(),t2.getText());
			a.setText("");
			Enumeration k = tm.keys();
			Enumeration vl = tm.elements();
			while(k.hasMoreElements())
			{
				String an = (String)k.nextElement();
				String v = (String)vl.nextElement();
				a.append("\n"+an+"  "+v);
				
			}
			t1.setText("");
			t2.setText("");
			t1.requestFocus();
		}	
		if(a1.getSource()==b2)
		{
			tm.remove(t3.getText());
			a.setText("");
			Enumeration k = tm.keys();
			Enumeration vl = tm.elements();
			while(k.hasMoreElements())
			{
				String an = (String)k.nextElement();
				String v = (String)vl.nextElement();
				a.append("\n"+an+"  "+v);
				
			}
			t3.setText("");
		}	
		if(a1.getSource()==b3)
		{
			Enumeration k = tm.keys();
			Enumeration vl = tm.elements();
			while(k.hasMoreElements())
			{
				if(tm.containsKey(t4.getText()))
				{
					JOptionPane.showMessageDialog(this,"Code: "+tm.get(t4.getText()),"Code",JOptionPane.OK_OPTION); 
				break;
				}
			}
			t1.setText("");
			t2.setText("");
			t4.setText("");
			t1.requestFocus();
		}	
	}

}


class Slip16_2
{
	public static void main(String args[])
	{
		new Myframe();
	}
}
