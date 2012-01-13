/**
 * 
 */
package us.getit.hitlist.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author psy
 * 
 */
@Entity
public class Person implements Serializable {

	/**
	 * needs to implement serializable for JMX
	 */
	private static final long serialVersionUID = -1028711244621412960L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
