/**
 * 
 */
package us.getit.hitlist;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import us.getit.hitlist.model.Person;
import us.getit.hitlist.page.ListPage;
import us.getit.hitlist.service.PersonService;

/**
 * @author psy
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/spring-config.xml")
public class ListTest {

	@Autowired
	private PersonService personService;

	@Autowired
	private ListPage listPage;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		personService.deleteAll();
	}

	@Test
	public void test() {
		Person homer = new Person();
		homer.setFirstname("Homer");
		homer.setLastname("Simpson");

		Person marge = new Person();
		marge.setFirstname("Marge");
		marge.setLastname("Simpson");

		long homerId = personService.save(homer);
		long margeId = personService.save(marge);

		// start the test
		listPage.open();
		List<String> persons = listPage.getPersons();

		assertEquals(2, persons.size());
		assertEquals(homer.getFirstname() + " " + homer.getLastname(), persons.get(0));
		assertEquals(marge.getFirstname() + " " + marge.getLastname(), persons.get(1));
	}

}
