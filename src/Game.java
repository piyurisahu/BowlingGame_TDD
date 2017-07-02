
public class Game {

	
	private int[] rolls=new int[21];
	int currentRoll=0;
	public void roll(int pin) {
		// TODO Auto-generated method stub
		rolls[currentRoll++]=pin; 
	}

	public int score() {
		// TODO Auto-generated method stub
		int score=0;
		int firstInFrame=0;
		for(int frame=0;frame<10;frame++)
		{
			
			if(isStrike(firstInFrame))
			{
				
				score+=10+nextTwoAfterStrike(firstInFrame);
  				firstInFrame++;
			}
			
			if(spare(firstInFrame))
			{
				score+=10+rolls[firstInFrame+2];
				firstInFrame+=2;
			}
			else
			{
			score+=rolls[firstInFrame]+rolls[firstInFrame+1];
			firstInFrame+=2;
			}
		
		}
		return score; 
		
	}

	private boolean isStrike(int firstInFrame) {
		return rolls[firstInFrame]==10;
	}

	private boolean spare(int firstInFrame) {
		return rolls[firstInFrame]+rolls[firstInFrame+1]==10;
	}

	public int nextTwoAfterStrike(int firstInFrame)
	{
		return rolls[firstInFrame+1] + rolls[firstInFrame+2];
	}
}
