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

	void save(Person person);

	void delete(Person person);

	Person getById(Long id);

	Collection<Person> list();

}
