package com.agenda.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenda.model.Pessoa;
import com.agenda.repository.PessoaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoa")
public class PessoaResource { 
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> list() {
		return pessoaRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Pessoa> findById(@PathVariable Long id) {
		return pessoaRepository.findById(id);

	}

	@PostMapping
	public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa,
			HttpServletResponse response) {

		Pessoa save = pessoaRepository.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(save.getPessoa_id()).toUri();

		return ResponseEntity.created(uri).body(save);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus
	public void delete(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		Optional<Pessoa> PessoaBanco = pessoaRepository.findById(id);
		BeanUtils.copyProperties(pessoa, PessoaBanco.get(), "id");
		pessoaRepository.save(PessoaBanco.get());
		return ResponseEntity.ok(pessoa);

	}

//	@PatchMapping("/{id}/status")
//	public ResponseEntity<Pessoa> updateStatus(@PathVariable Long id, @Valid @RequestBody String status) {
//		Optional<Pessoa> pessoaBanco = pessoaRepository.findById(id);
//		pessoaBanco.get().setEquip_status(status);
//		pessoaRepository.save(pessoaBanco.get());
//		return ResponseEntity.ok(pessoaBanco.get());
//
//	}
}


