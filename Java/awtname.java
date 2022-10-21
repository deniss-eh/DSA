import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class awtname extends JFrame implements ActionListener
{
	JTextField t1, t2, t3;
	awtname()
	{
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		
		t1.setBounds(150,90,90,30);
		t2.setBounds(150,150,90,30);
		t3.setBounds(150,250,90,30);
		
		JLabel l1=new JLabel("First Name");
		JLabel l2=new JLabel("Last Name");
		JLabel l3=new JLabel("Your Name");
		l1.setBounds(50,90,90,30);
		l2.setBounds(50,150,90,30);
		l3.setBounds(50,250,90,30);

		JButton b=new JButton("Confirm");
		b.setBounds(150,200,90,30);
		b.addActionListener(this);
		
		add(t1);
		add(t2);
		add(t3);
		add(b);
		add(l1);
		add(l2);
		add(l3);

		setSize(800,600);
		setLayout(null);
		setVisible(true);
		setTitle("Personal Info");
	}

	public void actionPerformed(ActionEvent e)
	{
		t3.setText(t1.getText()+" "+t2.getText());
	}
	
	public static void main(String args[])
	{
		new awtname();
	}
	
}
