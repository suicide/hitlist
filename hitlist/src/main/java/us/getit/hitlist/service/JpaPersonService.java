/**
 * 
 */
package us.getit.hitlist.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import us.getit.hitlist.model.Person;

/**
 * @author psy
 *
 */
public class JpaPersonService implements PersonService {
	
	@PersistenceContext
	private EntityManager em;

	/* (non-Javadoc)
	 * @see us.getit.hitlist.service.PersonService#save(us.getit.hitlist.model.Person)
	 */
	@Override
	@Transactional
	public long save(Person person) {
		em.persist(person);
		return person.getId();
	}

	/* (non-Javadoc)
	 * @see us.getit.hitlist.service.PersonService#delete(us.getit.hitlist.model.Person)
	 */
	@Override
	@Transactional
	public void delete(Person person) {
		em.remove(person);

	}

	/* (non-Javadoc)
	 * @see us.getit.hitlist.service.PersonService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = true)
	public Person getById(Long id) {
		return em.find(Person.class, id);
	}

	/* (non-Javadoc)
	 * @see us.getit.hitlist.service.PersonService#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Person> list() {
		return em.createQuery("from Person").getResultList();
	}

	/* (non-Javadoc)
	 * @see us.getit.hitlist.service.PersonService#deleteAll()
	 */
	@Override
	@Transactional
	public void deleteAll() {
		Collection<Person> list = list();
		for (Person person : list) {
			delete(person);
		}

	}

}
