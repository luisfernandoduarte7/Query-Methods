package com.avaliacaoMapeamentoDados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaoMapeamentoDados.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByNome(String nome);
	List<Aluno> findByRenda(String renda);
	List<Aluno> findByRa(String ra);
    List<Aluno> findByCidadeRenda(String cidade, String renda);


}
