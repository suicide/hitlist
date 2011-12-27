/**
 * 
 */
package us.getit.hitlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import us.getit.hitlist.model.Person;
import us.getit.hitlist.service.PersonService;
import us.getit.hitlist.web.form.PersonForm;

/**
 * @author psy
 * 
 */
@Controller
@RequestMapping("/add")
public class AddController {

	@Autowired
	private PersonService personService;

	/**
	 * @param personService
	 *            the personService to set
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {

		PersonForm form = new PersonForm();
		form.setPerson(new Person());

		model.addAttribute("form", form);

		return "addForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addPerson(@ModelAttribute PersonForm form) {

		Person person = form.getPerson();

		personService.save(person);

		return "redirect:/list";
	}

}
