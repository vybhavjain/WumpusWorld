package wumpus;

import javax.swing.JButton;

public class move_rightdirection {

	public move_rightdirection()
	{	
	}
	public void move(int index,JButton buttonsnew[])
	{
	String s1 = buttonsnew[index].getText();
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
    buttonsnew[index].setText(replaceString);    
	}
}