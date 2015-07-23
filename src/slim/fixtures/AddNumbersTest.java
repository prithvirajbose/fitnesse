package slim.fixtures;

public class AddNumbersTest
{
	private float x;
	private float y;
	
	public void setX(float x)
	{ this.x = x; }

	public void setY(float y)
	{ this.y = y; }
	
	public float getX()
	{ return x; }

	public float getY()
	{ return y; }
	
	public float result()
	{ return x + y; }
	
	// the following are life cycle methods
	public void table()
	{}
	
	public void endTable()
	{}

	public void execute()
	{}

	public void reset()
	{}
}
