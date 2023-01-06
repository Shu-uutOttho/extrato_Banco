package br.com.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entities.Conta;
import br.com.banco.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;

	public List<Conta> findAll() {
		return repo.findAll();
	}

}
