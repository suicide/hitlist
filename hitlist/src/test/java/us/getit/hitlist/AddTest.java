/**
 * 
 */
package us.getit.hitlist;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import us.getit.hitlist.model.Person;
import us.getit.hitlist.page.AddPage;
import us.getit.hitlist.page.ListPage;
import us.getit.hitlist.service.PersonService;

/**
 * @author psy
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/spring-config.xml")
public class AddTest {

	@Autowired
	private ListPage listPage;

	@Autowired
	private AddPage addPage;

	/**
	 * this is a jmx proxy!
	 */
	@Autowired
	private PersonService personService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		Person person = new Person();
		person.setFirstname("John");
		person.setLastname("Doe");

		personService.save(person);

	}

	@Test
	public void test() {
		listPage.open();

		listPage.clickAddPage();

		addPage.setFirstname("Peter");
		addPage.setLastname("Pan");
		addPage.submitForm();

	}

}
