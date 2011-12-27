/**
 * 
 */
package us.getit.hitlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import us.getit.hitlist.model.Person;
import us.getit.hitlist.service.PersonService;

/**
 * @author psy
 * 
 */
@Controller
public class ShowController {

	@Autowired
	private PersonService personService;

	/**
	 * @param personService
	 *            the personService to set
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("/show/{id}")
	public String show(@PathVariable long id, Model model) {

		Person person = personService.getById(id);

		model.addAttribute("person", person);

		return "show";
	}

}
