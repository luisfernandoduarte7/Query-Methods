package com.avaliacaoMapeamentoDados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacaoMapeamentoDados.entities.Aluno;
import com.avaliacaoMapeamentoDados.service.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")

public class AlunoController {

	private final AlunoService alunoService;

	@Autowired
	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscaAlunoControlId(@PathVariable Long id) {
		Aluno aluno = alunoService.buscaAlunoId(id);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);
		} else 
			return ResponseEntity.notFound().build();
	}
	
	// Query Method
	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorCidade(@PathVariable String cidade){
		List<Aluno> alunos = alunoService.buscaAlunosPorCidade(cidade);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Aluno>> buscarAlunosPorNome(@PathVariable String nome){
			List<Aluno> alunos = alunoService.buscaAlunosPorNome(nome);
			return ResponseEntity.ok(alunos);
	}
	@GetMapping("/renda/{renda}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorRenda(@PathVariable String renda){
		List<Aluno> alunos = alunoService.buscaAlunosPorRenda(renda);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/ra/{ra}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorRa(@PathVariable String ra){
		List<Aluno> alunos = alunoService.buscaAlunosPorRa(ra);
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/cidadeRenda/{cidadeRenda}")
	public ResponseEntity<List<Aluno>> buscarAlunosPorCidadeRenda(@PathVariable String cidade,String renda){
		List<Aluno> alunos = alunoService.buscaAlunosPorCidadeRenda(cidade,renda);
		return ResponseEntity.ok(alunos);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Aluno>> buscaTodosAlunoControl() {
		List<Aluno> Aluno = alunoService.buscaTodosAluno();
		return ResponseEntity.ok(Aluno);
	}

	@PostMapping
	public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody @Valid Aluno aluno) {
		Aluno salvaAluno = alunoService.salvaAluno(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aluno> alterarAlunoControl(@PathVariable Long id, @RequestBody @Valid Aluno aluno) {
		Aluno alterarAluno = alunoService.alterarAluno(id, aluno);
		if (alterarAluno != null) {
			return ResponseEntity.ok(aluno);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> apagaAlunoControl(@PathVariable Long id) {
		boolean apagar = alunoService.apagarAluno(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
