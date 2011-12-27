/**
 * 
 */
package us.getit.hitlist.model;

/**
 * @author psy
 * 
 */
public class Person {

	/**
	 * id
	 */
	private Long id;

	/**
	 * firstname of this Person
	 */
	private String firstname;

	/**
	 * lastname of this Person
	 */
	private String lastname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
