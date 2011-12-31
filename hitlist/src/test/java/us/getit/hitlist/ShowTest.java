/**
 * 
 */
package us.getit.hitlist;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import us.getit.hitlist.model.Person;
import us.getit.hitlist.page.ShowPage;
import us.getit.hitlist.service.PersonService;

/**
 * @author psy
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/spring-config.xml")
public class ShowTest {

	@Autowired
	private PersonService personService;

	@Autowired
	private ShowPage showPage;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// we need to delete all data before we can do our tests

		personService.deleteAll();
	}

	@Test
	public void testDirect() {
		String firstname = "Homer";
		String lastname = "Simpson";

		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(lastname);

		// the method had to be changed as changes on the person object are not
		// transmitted back
		long id = personService.save(person);

		// do the test!
		showPage.open(id);

		assertEquals(firstname, showPage.getFirstname());
		assertEquals(lastname, showPage.getLastname());
	}

}
