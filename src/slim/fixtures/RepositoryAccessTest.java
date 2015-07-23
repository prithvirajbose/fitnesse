package slim.fixtures;

import sut.usermgmt.User;
import sut.usermgmt.Repository;
import sut.usermgmt.UserFactory;
import sut.usermgmt.UserPermsException;

enum RepositoryOperation { READ, WRITE, DELETE }

public class RepositoryAccessTest
{
	private User user = null;
	private String errMsg = null;
	
	public RepositoryAccessTest() {}
	
	public void createUserCanReadCanWriteCanDelete(String name, boolean bCanRead, 
			boolean bCanWrite, boolean bCanDelete)
	{
		user = UserFactory.createUser(name, bCanRead, bCanWrite, bCanDelete);
	}
	
	public boolean readFromRepository()
	{ return accessRepository(RepositoryOperation.READ); }

	public boolean writeToRepository()
	{ return accessRepository(RepositoryOperation.WRITE); }

	public boolean deleteFromRepository()
	{ return accessRepository(RepositoryOperation.DELETE); }
	
	public String errorMessage()
	{ return errMsg; }

	protected boolean accessRepository(RepositoryOperation op)
	{
		boolean retVal = false;
		
		try 
		{ 
			switch(op)
			{
				case READ:
					retVal = Repository.read(user);
					break;
				case WRITE:
					retVal = Repository.write(user);
					break;
				case DELETE:
					retVal = Repository.delete(user);
					break;					
			}
		}
		catch (UserPermsException e) 
		{ errMsg = e.getMessage(); }
		
		return retVal;
	}
}
