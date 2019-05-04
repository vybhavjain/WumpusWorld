package wumpus;

import java.util.Random;

public abstract class ComboMovement {
	Random rand = new Random();
public abstract int move(int index,int num,int score);
}
