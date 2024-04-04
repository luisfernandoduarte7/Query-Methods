package com.avaliacaoMapeamentoDados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaliacaoMapeamentoDados.entities.Aluno;
import com.avaliacaoMapeamentoDados.repository.AlunoRepository;

@Service
public class AlunoService {

	private final AlunoRepository alunoRepository;
	
	@Autowired

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	public  List<Aluno> buscaTodosAluno(){
		return alunoRepository.findAll();
	}
	//Query Method
    public List<Aluno> buscaAlunosPorCidade(String cidade){
    	return alunoRepository.findByCidade(cidade);
    }
    public List<Aluno> buscaAlunosPorNome(String nome){
        	return alunoRepository.findByCidade(nome);
    }
    public List<Aluno> buscaAlunosPorRenda(String renda){
    	return alunoRepository.findByRenda(renda);
    }
    public List<Aluno> buscaAlunosPorRa(String ra){
    	return alunoRepository.findByRa(ra);
    }
    public List<Aluno> buscaAlunosPorCidadeRenda(String cidade, String renda){
    	return alunoRepository.findByCidadeRenda(cidade,renda);
    }
    public Aluno buscaAlunoId(Long id) {
		Optional <Aluno> Aluno = alunoRepository.findById(id);
		return Aluno.orElse(null);
	}
	public Aluno salvaAluno(Aluno Aluno){
		return alunoRepository.save(Aluno);
	}
	public Aluno alterarAluno(Long id, Aluno alterarAluno) {
		Optional <Aluno> existeAluno = alunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alterarAluno.setId(id);
			return alunoRepository.save(alterarAluno);
		}
		return null;
	}
	public boolean apagarAluno (Long id) {
		Optional <Aluno> existeAluno = alunoRepository.findById(id);
		if (existeAluno.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}

