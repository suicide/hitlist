/**
 * 
 */
package us.getit.hitlist.service;

import java.util.Collection;

import us.getit.hitlist.model.Person;

/**
 * @author psy
 * 
 */
public interface PersonService {

	/**
	 * Originally this method did only set the id of the Person within the
	 * object and returned void. However the change on the object is not
	 * returned through jmx. Meaning that the id not available for the test
	 * client. Thus the id must be returned.
	 * 
	 * @param person
	 * @return id of Person
	 */
	long save(Person person);

	void delete(Person person);

	Person getById(Long id);

	Collection<Person> list();

	/**
	 * This method is needed for testing with jmx as we do not want to restart
	 * the app after each test and there is no other way to clean the "database"
	 */
	void deleteAll();

}
