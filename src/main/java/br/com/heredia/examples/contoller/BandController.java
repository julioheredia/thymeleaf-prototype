package br.com.heredia.examples.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.heredia.examples.dto.rockandroll.Band;
import br.com.heredia.examples.repository.RockAndRollRepository;

@Controller
public class BandController {

	private RockAndRollRepository rockAndRollRepository;

	@Autowired
	public BandController(RockAndRollRepository rockAndRollRepository) {
		this.rockAndRollRepository = rockAndRollRepository;
	}

	@GetMapping("bands")
	public String  getBands(Model model) {
		model.addAttribute("bands",rockAndRollRepository.getBands());
	    return "list-band";
		
	}

	@GetMapping("findBand/{name}")
	public Band findBandByName(@PathVariable("name") String name) {
		return rockAndRollRepository.findBandByName(name);
	}

}
