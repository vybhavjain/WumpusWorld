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
	int wumploc = 3;
	int goldloc = 9;
	
    JButton buttons[] = new JButton[30];

    public Own(){ 
    	
        JFrame frame=new JFrame();
    	JPanel frame2 = new JPanel();
    	
    	frame2.setLayout(new GridLayout(4, 4));
        
    	Border bored = BorderFactory.createLineBorder(Color.RED);
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(" ");
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
        
        JTextField tf1 = new JTextField("On click shoot will be displayed here");
        tf.setBounds(30,360,180,60);
        
        
        forward.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            		String s1 = buttons[index].getText();
            		String s3 = "";
             		num = index;
            		score-=1;
            		if(s1.contains("^"))
            		{
            			if(index<=3)
            			{
            				index+=4;
            				score+=1;
            			}
            			index-=4;
            			s3 = "^";
            		}
            		if(s1.contains(">"))
            		{
            			if(index%4 == 3)
            			{
            				index-=1;
            				score+=1;
            			}
            			index+=1; 
                			s3 = ">";
            		}
            		if(s1.contains("<"))
            		{
            			if(index%4 == 0)
            			{
            				index+=1;
            				score+=1;
            			}
            			index-=1;       
            			s3 = "<";
            		}
            		if(s1.contains("v"))
            		{
            			if(index >11)
            			{
            				index-=4;
            				score+=1;
            			}
            			index+=4; 
            			s3 = "v";
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
            		buttons[num].setText(s1.replaceAll("[v,>,^,<]",""));
            		String s8 = buttons[index].getText();
            		if(s8.contains(s3))
            			buttons[index].setText(s8);
            		else
            			buttons[index].setText(s3+s8);
            		tf.setText(String.valueOf(score));
            		}
            }  
            }); 

        left.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            		String s1 = buttons[index].getText();
            		String replaceString = "";
            		//String s2 = "-";
            		if(s1.contains("^"))
            		{
            			 replaceString=s1.replace("^","<");
            		}
            		else if(s1.contains(">"))
            		{
            			 replaceString=s1.replace(">","^");
            		}
            		else if(s1.contains("<"))
            		{
            			 replaceString=s1.replace("<","v");
            		}
            		else if(s1.contains("v"))
            		{
            			 replaceString=s1.replace("v",">");
            		}
                    buttons[index].setText(replaceString);       
            }  
            }); 
        
        right.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            	String s1 = buttons[index].getText();
        		String replaceString = "";
        		//String s2 = "-";
        		if(s1.contains("^"))
        		{
        			 replaceString=s1.replace("^",">");
        		}
        		else if(s1.contains(">"))
        		{
        			 replaceString=s1.replace(">","v");
        		}
        		else if(s1.contains("<"))
        		{
        			 replaceString=s1.replace("<","^");
        		}
        		else if(s1.contains("v"))
        		{
        			 replaceString=s1.replace("v","<");
        		}
                buttons[index].setText(replaceString);        
            }  
            }); 
        shoot.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            		String s1 = buttons[index].getText();
            		String s2 = "";
            		String s3 = "";
            		int num;
            		if(index > 3 && s1.contains("^"))
            		{
            			num = index-4; 
            			s2 = buttons[num].getText();
            			if(s2.contains("W"))
            			{
            				s3 = s2.replaceAll("W","");
            				tf1.setText("Congrats,Wumpus shot!!!");
            				buttons[num].setText(s3);
            			}
            			else
            				tf1.setText("No Wumpus present");
            		}
            		if(index % 4 != 0 && s1.contains("<"))
            		{
            			num = index-1; 
            			s2 = buttons[num].getText();
            			if(s2.contains("W"))
            			{
            				s3 = s2.replaceAll("W","");
            				tf1.setText("Congrats,Wumpus shot!!!");
            				buttons[num].setText(s3);
            			}
            			else
            				tf1.setText("No Wumpus present");
            		}
            		if(index % 4 !=3  && s1.contains(">"))
            		{
            			num = index+1; 
            			s2 = buttons[num].getText();
            			if(s2.contains("W"))
            			{
            				s3 = s2.replaceAll("W","");
            				tf1.setText("Congrats,Wumpus shot!!!");
            				buttons[num].setText(s3);
            			}
            			else
            				tf1.setText("No Wumpus present");
            		}
            		if(index <12  && s1.contains("v"))
            		{
            			num = index+4; 
            			s2 = buttons[num].getText();
            			if(s2.contains("W"))
            			{
            				s3 = s2.replaceAll("W","");
            				tf1.setText("Congrats,Wumpus shot!!!");
            				buttons[num].setText(s3);
            			}
            			else
            				tf1.setText("No Wumpus present");
            		}}  
            }); 
        
        frame.add(forward);
        frame.add(left);
        frame.add(right);
        frame.add(shoot);
        frame.add(tf);
        frame.add(tf1);

        
        //JPanel grid = new JPanel();
        
        
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
