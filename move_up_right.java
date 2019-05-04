package wumpus;

public class move_up_right extends ComboMovement {
	public int move(int index,int num,int score)
	{
	num = index;
	if(index<=3)
	{
		index+=4;
	}
	index-=4;
	if(index%4 == 3)
	{
		index-=1;
	}
	index+=1;
	score-=1;
	return index;
	}
}
