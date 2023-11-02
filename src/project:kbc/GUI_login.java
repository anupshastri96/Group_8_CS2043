
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Login extends JFrame implements ItemListener, ActionListener{
	static JFrame f;
	static JLabel a, b, c;
	static JComboBox c1, c2;
	
	public static void main(String[] args){
		f = new JFrame("login");
		solve11 s = new solve11();
		f.setLayout(new FlowLayout());
		
		String s1[] = {"User Login", "Librarian Login"};
		
		//makes checkbox
		c1 = new JComboBox(s1);
		
		userName = new JTextField(16);
		password = new JTextField(16);
		
		JButton login = new JButton("Login");
		JButton login2 = new JButton("Login");
		JButton  createUser = new JButton("Create new user");
		
		login.addActionListener(s);
		c1.addItemListener(s);
		
		a = new JLabel("Select your login");
		b = new JLabel("Enter username");
		c = new JLabel("Enter password");
		
		a.setForeground(Color.blue);
		b.setForeground(Color.black);
		c.setForeground(Color.black);
		
		JPanel p = new JPanel();
		p.add(a);
	
		p.add(c1);	
		p.add(b);
		p.add(userName);
		p.add(c);
		p.add(pasword);
		
		for(int i = 0; i<s1.length(); i++){
			if(s1[i] == 0){
				p.add(login);
			}
			else{
				p.add(login2);
			}
		}
		
		p.add("Create new user");
		
		p.add(cancel);
		
		f.setLayout(new FlowLayout());
		f.add(p);
		f.setSize(700, 200);
		f.show();
		
		public void actionPreformed(ActionEvent e){
			String s = e.getActionCommand();
			
			if(s.equals("Login")){
				// here we would connect the user/librarian login stuff
			}
			else if(s.equals("Create new user")){
				//here we would have the stuff to make the new user
			}
			else{
				//cancel action
			}
		}
	} 
	
}
		

