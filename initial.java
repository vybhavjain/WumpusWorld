package wumpus;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;  
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Own {
	int index = 12;
	int num;
	int score = 1000;
	String Wumpus = "W";
	String Smell = "s";
	
	String Gold = "G";
	String Glitter = "g";
	
	String Pit = "P";
	String Breeze = "b";
	
	int pitloc = 2;
	int wumploc = 8;
	int goldloc = 9;
	
    JButton buttons[] = new JButton[30];

    public Own(){ 
    	
        JFrame frame=new JFrame();
    	JPanel frame2 = new JPanel();
    	
    	frame2.setLayout(new GridLayout(4, 4));
        
    	Border bored = BorderFactory.createLineBorder(Color.RED);
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton();
            //frame2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            buttons[i].setBorder(bored);
            frame2.add(buttons[i]);
            //buttons[i].setEnabled(false);
        }
        
        buttons[pitloc].setText(Pit);
        buttons[wumploc].setText(Wumpus);
        buttons[goldloc].setText(Gold);

        
        setpos(pitloc,Breeze);
        setpos(wumploc,Smell);
        setpos(goldloc,Glitter);
        
        
        buttons[index].setText("^");
        frame2.setVisible(true);
        frame2.setBounds(250,180,280,280);    
        frame.add(frame2);
        //frame2.setVisible(true);

        
        JButton forward = new JButton("Forward");
        forward.setBounds(30,10,90,60);
     
        JButton left = new JButton("Left");
        left.setBounds(30,80,90,60);
        
        JButton right = new JButton("Right");
        right.setBounds(30,150,90,60);
        
        JButton shoot= new JButton("Shoot");
        shoot.setBounds(30,220,90,60);
        
        JTextField tf = new JTextField("Current score will be displayed here");
        tf.setBounds(30,290,180,60);
        
        
        forward.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            		String s1 = buttons[index].getText();
            		String s2 = "-";
            		num = index;
            		score-=1;
            		if(s1 == "^")
            		{
            			if(index<=3)
            			{
            				index+=4;
            				score+=1;
            			}
            			index-=4;
            		}
            		if(s1 == ">")
            		{
            			if(index%4 == 3)
            			{
            				index-=1;
            				score+=1;
            			}
            			index+=1;    
            		}
            		if(s1 == "<")
            		{
            			if(index%4 == 0)
            			{
            				index+=1;
            				score+=1;
            			}
            			index-=1;            	
            		}
            		if(s1 == "v")
            		{
            			if(index >11)
            			{
            				index-=4;
            				score+=1;
            			}
            			index+=4; 
            		}
            		if((buttons[index].getText()).contains("P") ||(buttons[index].getText()).contains("W")  )
            		{
                		tf.setText("game over, you have died!!!");
                        forward.setEnabled(false);
                        left.setEnabled(false);
                        right.setEnabled(false);
                        shoot.setEnabled(false);
            		}
            		else if((buttons[index].getText()).contains("G"))
            		{
                		tf.setText("CONGRATULATIONS , YOU HAVE WON!! Score is :" + String.valueOf(score));
                        forward.setEnabled(false);
                        left.setEnabled(false);
                        right.setEnabled(false);
                        shoot.setEnabled(false);
            		}
            		else
            		{
            		buttons[num].setText(s2);
            		buttons[index].setText(s1); 
            		tf.setText(String.valueOf(score));
            		}
            }  
            }); 

        left.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            		String s1 = buttons[index].getText();
            		String s2 = "-";
            		if(s1 == "^")
            		{
            			s1 = "<";
            		}
            		else if(s1 == ">")
            		{
            			s1 = "^";
            		}
            		else if(s1 == "<")
            		{
            			s1 = "v";
            		}
            		else if(s1 == "v")
            		{
            			s1 = ">";
            		}
                    buttons[index].setText(s1);       
            }  
            }); 
        
        right.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            		String s1 = buttons[index].getText();
            		String s2 = "-";
            		if(s1 == "^")
            		{
            			s1 = ">";
            		}
            		else if(s1 == ">")
            		{
            			s1 = "v";
            		}
            		else if(s1 == "<")
            		{
            			s1 = "^";
            		}
            		else if(s1 == "v")
            		{
            			s1 = "<";
            		}
                    buttons[index].setText(s1);       
            }  
            }); 
        
        shoot.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            		String s1 = buttons[index].getText();
            		int arrow = index;
            		if(arrow < 11 && s1.contains("^"))
            		{
            			
            		}
                   	if(arrow % 4 !=  3)
            		{
                   		
            		}
                   	if(arrow % 4 !=  0)
            		{
                   	
            		}
                   	if(arrow > 3)
            		{
                   	
            		}
            }  
            }); 
        
        frame.add(forward);
        frame.add(left);
        frame.add(right);
        frame.add(shoot);
        frame.add(tf);
        
        JPanel grid = new JPanel();
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(800,800);
        frame.setLayout(null);  
        frame.setVisible(true);
}
    
    void setpos(int i,String s)
    {
    	String s1,s2;
       	
       	if(i < 11)
		{
       		s2 = buttons[i+4].getText();
           	s1 = s2 +  s;
			buttons[i+4].setText(s1);
		}
       	if(i % 4 !=  3)
		{
       		s2 = buttons[i+1].getText();
           	s1 = s2 +  s;
			buttons[i+1].setText(s1);
		}
       	if(i % 4 !=  0)
		{
       		s2 = buttons[i-1].getText();
           	s1 = s2 +  s;
			buttons[i-1].setText(s1);
		}
       	if(i > 3)
		{
       		s2 = buttons[i-4].getText();
           	s1 = s2 +  s;
			buttons[i-4].setText(s1);
		}
		}
    
public static void main(String[] args) {
        Own t1 = new Own();//makes new ButtonGrid with 2 parameters
	}
}
