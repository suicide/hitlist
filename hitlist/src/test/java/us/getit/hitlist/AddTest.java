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

import us.getit.hitlist.page.AddPage;
import us.getit.hitlist.page.ListPage;

/**
 * @author psy
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/spring-config.xml")
public class AddTest {

	@Autowired
	private ListPage listPage;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		listPage.open();

		AddPage addPage = listPage.clickAddPage();

		addPage.setFirstname("Peter");
		addPage.setLastname("Pan");
		addPage.submitForm();

	}

}
