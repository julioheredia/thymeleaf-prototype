package br.com.heredia.examples.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.heredia.examples.dto.rockandroll.Musician;
import br.com.heredia.examples.repository.RockAndRollRepository;

@Controller
public class MusicianController {

	private RockAndRollRepository rockAndRollRepository;

	@Autowired
	public MusicianController(RockAndRollRepository rockAndRollRepository) {
		this.rockAndRollRepository = rockAndRollRepository;
	}

	@GetMapping("musicians")
	public List<Musician> getMusicians() {
		return rockAndRollRepository.getMusicians();
	}

	@GetMapping("findMusician/{name}")
	public Musician findMusicianByName(@PathVariable("name") String name) {
		return rockAndRollRepository.findMusicianByName(name);
	}

}
