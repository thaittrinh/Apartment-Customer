package poly.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/can-ho")
public class ApartmentController {

	@GetMapping()
	public String apartment() {
		return "contents/user/apartment";
	}
	
	
}
