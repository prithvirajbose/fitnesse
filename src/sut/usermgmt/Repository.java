package sut.usermgmt;

/**
 * Repository allowing read and write operations.
 * @author pbose
 *
 */
public class Repository
{
	public static boolean read(User u) throws UserPermsException
	{
		if (!u.getPerms().readAllowed())
			throw new UserPermsException("User: [" + u.getName() + "] Read restricted.");
		
		return true;
	}

	public static boolean write(User u) throws UserPermsException
	{
		if (!u.getPerms().writeAllowed())
			throw new UserPermsException("User: [" + u.getName() + "] Write restricted.");
		
		return true;
	}
	
	public static boolean delete(User u) throws UserPermsException
	{
		if (!u.getPerms().deleteAllowed())
			throw new UserPermsException("User: [" + u.getName() + "] Deletion restricted.");
		
		return true;
	}
}
