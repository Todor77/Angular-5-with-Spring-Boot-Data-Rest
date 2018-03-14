package de.isys.demo;

import de.isys.demo.validator.CustomerValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

	private final GreeterService greeterService;
	private final CustomerValidator customerValidator;

	@InitBinder("customer")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(customerValidator);
	}

	public IndexController(GreeterService greeterService, CustomerValidator customerValidator) {
		this.greeterService = greeterService;
		this.customerValidator = customerValidator;
	}

	@RequestMapping("/")
	public ModelAndView index() {

		final Map<String, Object> model = new HashMap<>();
		model.put("something_completely_different", "index request mapping");
		return new ModelAndView("hello_world", model);
	}

	@RequestMapping("/greet")
	public ModelAndView greet(@RequestParam String greet) {

		final HashMap<String, Object> model = new HashMap<>();

		greet = greeterService.transformation(greet);

		model.put("name_to_greet", greet);
		model.put("something_completely_different", Math.random());
		return new ModelAndView("hello_world", model);
	}

	@RequestMapping("/cust")
	public ModelAndView fillcustomer() {

		final Map<String, Object> model = new HashMap<>();

		model.put("something_completely_different", "index request mapping");
		model.put("customer", new Customer());

		return new ModelAndView("custom_field", model);
	}

	@RequestMapping("/customer")
	public ModelAndView customer(@Valid Customer customer, BindingResult result,  Errors errors){

		if (errors.hasErrors()) {
			System.out.println("errors");
		}
		return new ModelAndView("custom_field", "errors", errors);
	}

}
