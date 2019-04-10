package wumpus;

//import javax.swing.JFrame;
//import javax.swing.JButton;
//import javax.swing.JPanel;
import javax.swing.*;
//import java.awt.GridLayout;

public class Own {
    public Own(){ 
        JFrame frame=new JFrame();
        
        JButton forward = new JButton("Forward");
        forward.setBounds(30,10,90,60);
     
        JButton left = new JButton("Left");
        left.setBounds(30,80,90,60);
        
        JButton right = new JButton("Right");
        right.setBounds(30,150,90,60);
        
        JButton shoot= new JButton("Shoot");
        shoot.setBounds(30,220,90,60);
        
        frame.add(forward);
        frame.add(left);
        frame.add(right);
        frame.add(shoot);
        
        JPanel grid = new JPanel();
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(1000,1000);
        frame.setLayout(null);  
        frame.setVisible(true);
}
public static void main(String[] args) {
        Own t1 = new Own();//makes new ButtonGrid with 2 parameters
	}
}
