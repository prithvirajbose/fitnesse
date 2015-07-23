package sut.usermgmt;

public class User
{
	// user name
	protected String name = null;
	// user permissions
	protected UserPerms perms = null;
	
	/**
	 * Protected access so that creation can happen only through UserFactory.
	 * @param name
	 * @param perms
	 */
	protected User(String name, UserPerms perms) 
	{ 
		this.name = name;
		this.perms = perms; 
	}

	public UserPerms getPerms()
	{ return perms; }

	public String getName()
	{ return name; }
	
	public boolean canRead()
	{ return perms.readAllowed(); }

	public boolean canWrite()
	{ return perms.writeAllowed(); }

	public boolean canDelete()
	{ return perms.deleteAllowed(); }
}
