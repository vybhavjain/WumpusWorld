package wumpus;
import java.util.Random;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;  
import java.awt.*;
import javax.swing.Icon.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Own {
	int index =12;
	int num;
	int score = 1000;
	String Wumpus = "W";
	String Smell = "s";
	
	String Gold = "G";
	String Glitter = "g";
	
	String Pit = "P";
	String Breeze = "b";
	Random rand = new Random();

   JButton buttons[] = new JButton[30];

    public Own(){ 
    	
        JFrame frame=new JFrame();
    	JPanel frame2 = new JPanel();
    	
    	frame2.setLayout(new GridLayout(4, 4));
        Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 0, 0);

    	Border bored = BorderFactory.createLineBorder(Color.RED);
        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(" ");
            buttons[i].setBorder(emptyBorder);
            buttons[i].setBorder(bored);
            frame2.add(buttons[i]);
            //buttons[i].setEnabled(false);
        }
    	//index = rand.nextInt(16);
    	int pitloc = rand.nextInt(16);
    	int wumploc = rand.nextInt(16);
    	int goldloc = rand.nextInt(16);
    	
    	while(goldloc == wumploc || goldloc == pitloc)
    	{
    		goldloc = rand.nextInt(16);
    	}
    	while(goldloc == index || index == pitloc || wumploc == index)
    	{
    		index = rand.nextInt(16);
    	}
    	    	
        buttons[pitloc].setText(Pit);
        buttons[wumploc].setText(Wumpus);
        buttons[goldloc].setText(Gold);

        Icon pit = new ImageIcon("pit.jpg");
        Icon breeze = new ImageIcon("breeze.jpg");
      
        Icon wumpus = new ImageIcon("wumpus.png");
        Icon smell = new ImageIcon("smell.jpg");
        
        Icon gold = new ImageIcon("gold.png");
        Icon glitter = new ImageIcon("glitter.jpg");
        
        setpos(pitloc,Breeze,pit,breeze);
        setpos(wumploc,Smell,wumpus,smell);
        setpos(goldloc,Glitter,gold,glitter);
        
        
        buttons[index].setText("^");
        frame2.setVisible(true);
        frame2.setBounds(450,20,720,720);    
        frame.add(frame2);

        
        JButton forward = new JButton("Forward");
        forward.setBounds(30,10,90,60);
     
        
        JButton left = new JButton("Left");
        left.setBounds(30,80,90,60);
        
        JButton right = new JButton("Right");
        right.setBounds(30,150,90,60);
        
        JButton shoot= new JButton("Shoot");
        shoot.setBounds(30,220,90,60);
        
        JTextField tf = new JTextField("Current score will be displayed here");
        tf.setBounds(30,290,400,60);
        
        JTextField tf1 = new JTextField("On click shoot will be displayed here");
        tf1.setBounds(30,360,400,60);
        
        JTextArea tf2 = new JTextArea("WELCOME TO WUMPUS WORLD: \n INSTRUCTIONS: \n 0) Start position is denoted by : '^' \n 1)Objective of the game is to retrive the gold. \n 2)Each step forward costs 1 point, and every arrow shot costs 10points. \n 3)Wumpus can be killed by clicking on shoot while facing towards it. \n 4) you start off with 1000 points \n 5)Avoid pitfalls and wumpus(They will kill you). \n 6)b represents breeze(Pit nearby). \n 7)s represents smell(Wumpus nearby) .\n 8)g represents glitter(Gold nearby). \n 9)Good Luck adventurer!!");
        tf2.setBounds(30,430,400,200);
        frame.add(tf2);
        
        JButton actions= new JButton("Actions");
        actions.setBounds(180,20,250,250);
        frame.add(actions);
        actions.setEnabled(false);
        
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
                		tf.setText("Game over, you have lost!!!");
                        forward.setEnabled(false);
                        left.setEnabled(false);
                        right.setEnabled(false);
                        shoot.setEnabled(false);
                		String s8 = buttons[index].getText();
                		buttons[num].setText(s1.replaceAll("[v,>,^,<]",""));
                        if(s8.contains(s3))
                			buttons[index].setText(s8);
                		else
                			buttons[index].setText(s3+s8);
            		}
            		else if((buttons[index].getText()).contains("G"))
            		{
                		tf.setText("CONGRATULATIONS , YOU HAVE WON!! Score is :" + String.valueOf(score));
                        forward.setEnabled(false);
                        left.setEnabled(false);
                        right.setEnabled(false);
                        shoot.setEnabled(false);
                		String s8 = buttons[index].getText();
                		buttons[num].setText(s1.replaceAll("[v,>,^,<]",""));
                        if(s8.contains(s3))
                			buttons[index].setText(s8);
                		else
                			buttons[index].setText(s3+s8);
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
            		score-=10;
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

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(1300,900);
        frame.setLayout(null);  
        frame.setVisible(true);
}
    
    void setpos(int i,String s,Icon x,Icon y) //x is main , y is effect
    {
    	String s1,s2;
       	
       	if(i < 12)
		{
       		s2 = buttons[i+4].getText();
           	s1 = s2 +  s;
			buttons[i+4].setText(s1);
			buttons[i+4].setIcon(y);
		}
       	if(i % 4 !=  3)
		{
       		s2 = buttons[i+1].getText();
           	s1 = s2 +  s;
			buttons[i+1].setText(s1);
			buttons[i+1].setIcon(y);
		}
       	if(i % 4 !=  0)
		{
       		s2 = buttons[i-1].getText();
           	s1 = s2 +  s;
			buttons[i-1].setText(s1);
			buttons[i-1].setIcon(y);
		}
       	if(i > 3)
		{
       		s2 = buttons[i-4].getText();
           	s1 = s2 +  s;
			buttons[i-4].setIcon(y);
			buttons[i-4].setText(s1);
		}
		buttons[i].setIcon(x);
		}
    
public static void main(String[] args) {
        Own t1 = new Own();//makes new ButtonGrid with 2 parameters
	}
}
