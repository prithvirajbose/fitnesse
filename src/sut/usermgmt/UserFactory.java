package sut.usermgmt;

/**
 * Creates users based on permissions.
 * @author pbose
 *
 */
public class UserFactory
{
	private UserFactory() {}
	
	public static User createUser(String name, boolean bCanRead, 
			boolean bCanWrite, boolean bCanDelete)
	{ return new User(name, new UserPerms(bCanRead, bCanWrite, bCanDelete)); }
}
