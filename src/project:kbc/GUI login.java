import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Login extends JFrame implements ItemListener, ActionListener{
	static JFrame f;
	static JLabel 1, 11, 13;
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
		
		1 = new JLabel("Select your login");
		11 = new JLabel("Enter username");
		13 = new JLabel("Enter password");
		
		1.setForeground(Color.blue);
		11.setForeground(Color.black);
		13.setForeground(Color.black);
		
		JPanel p = new JPanel();
		p.add(1);
	
		p.add(c1);	
		p.add(11);
		p.add(userName);
		p.add(13);
		p.add(pasword);
		for(int i = 0; i<s1.length(); i++){
			if(s1[i] == 0){
				p.add(login);
			}
			else{
				p.add(login2);
			}
		}
		p.add(cancel);
		
		f.setLayout(new FlowLayout());
		f.add(p);
		f.setSize(700, 200);
		f.show();
		
		blic void actionPreformed(ActionEvent e){
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
		

