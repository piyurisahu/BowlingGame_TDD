import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingTest {

	Game game;
	@Before
	public void setUp()
	{
		
		game=new Game();
	}
	@Test
	public void canCreateGame() throws Exception
	{
	
	}
	private void rollMany(int n, int pin) {
		for(int i=0;i<n;i++)
	 	{
			game.roll(pin);
		}
	}
	
	@Test
	public void gutterGame() throws Exception
	{
		
		rollMany(20,0);
		assertEquals(0, game.score());
		
	}
	
	@Test
	public void allOne() throws Exception
	{ 
		rollMany(20,1);
		assertEquals(20, game.score());
		
	}
	
	
	@Test
	public void oneSpare() throws Exception
	{
		callSpare();
		game.roll(3);
		rollMany(17,0);
		assertEquals(16, game.score());
	}
	private void callSpare() {
		game.roll(5);
		game.roll(5);
	}
	
	
	
	@Test
	public void oneStrike() throws Exception
	{
		
		game.roll(10);//strike
		game.roll(3);
		game.roll(5);
		rollMany(17,0);
		assertEquals(26,game.score());
	}
	
	@Ignore
	@Test
	
	public void perfectGame() throws Exception
	{
		
		rollMany(12, 10);
		assertEquals(300, game.score());
		
	}
	
	
}

