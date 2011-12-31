/**
 * 
 */
package us.getit.hitlist.service;

import java.util.Collection;
import java.util.Map;

import us.getit.hitlist.model.Person;

/**
 * Implementation using a Map
 * 
 * @author psy
 * 
 */
public class MapPersonService implements PersonService {

	private long currentId;

	/**
	 * Storage
	 */
	private Map<Long, Person> storage;

	/**
	 * @param storage
	 *            the storage to set
	 */
	public void setStorage(Map<Long, Person> storage) {
		this.storage = storage;
	}

	/**
	 * construtor
	 */
	public MapPersonService() {
		currentId = 1L;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * us.getit.hitlist.service.PersonService#save(us.getit.hitlist.model.Person
	 * )
	 */
	@Override
	public long save(Person person) {
		if (person.getId() == null) {
			person.setId(currentId++);

			storage.put(person.getId(), person);
		}
		// id returned for the tests! As the change in the object is not
		// transmitted back to the test client
		return person.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * us.getit.hitlist.service.PersonService#delete(us.getit.hitlist.model.
	 * Person)
	 */
	@Override
	public void delete(Person person) {
		storage.remove(person.getId());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see us.getit.hitlist.service.PersonService#getById(java.lang.Long)
	 */
	@Override
	public Person getById(Long id) {

		return storage.get(id);
	}

	@Override
	public Collection<Person> list() {

		return storage.values();
	}

	@Override
	public void deleteAll() {
		storage.clear();

	}

}
