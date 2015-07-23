package sut.usermgmt;

@SuppressWarnings("serial")
public class UserPermsException extends Exception
{
	public UserPermsException(String message)
	{ super(message); }
	
	public UserPermsException(String message, Throwable cause)
	{ super(message, cause); }
	
	@Override
	public String toString()
	{ return super.toString(); }
}
