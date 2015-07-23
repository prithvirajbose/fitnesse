package slim.fixtures;

public class AddNumbersInArrayTest
{
	private int [] values;
	
	public void setValues(int [] values)
	{ this.values = values; }
	
	public int [] getValues()
	{ return values; }
	
	public int result()
	{
		int sum = 0;
		for (int i = 0; i < values.length; i++)
			sum += values[i];
		
		return sum;
	}

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
