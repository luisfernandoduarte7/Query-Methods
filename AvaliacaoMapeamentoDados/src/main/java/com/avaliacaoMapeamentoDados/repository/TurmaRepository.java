package com.avaliacaoMapeamentoDados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacaoMapeamentoDados.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	List<Turma> findByNome(String nome);
	List<Turma> findByDescricao(String descricao);
	List<Turma> findByNomeDescricao(String nome,String descricao);

}
