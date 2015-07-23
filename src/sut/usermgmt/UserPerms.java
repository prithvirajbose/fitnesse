package sut.usermgmt;

/**
 * Basic permissions class with read, write & delete permissions.
 * @author pbose
 *
 */
public class UserPerms
{
	protected boolean bCanRead = false;
	protected boolean bCanWrite = false;
	protected boolean bCanDelete = false;
	
	/**
	 * Protected access so that creation can happen only through UserFactory.
	 * @param bCanRead
	 * @param bCanWrite
	 * @param bCanDelete
	 */
	protected UserPerms(boolean bCanRead, boolean bCanWrite, boolean bCanDelete)
	{
		this.bCanRead = bCanRead;
		this.bCanWrite = bCanWrite;
		this.bCanDelete = bCanDelete;
	}
	
	public boolean readAllowed()
	{ return bCanRead; }
	
	public boolean writeAllowed()
	{ return bCanWrite; }

	public boolean deleteAllowed()
	{ return bCanDelete; }
}
