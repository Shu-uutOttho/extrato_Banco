package br.com.banco.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.service.exceptions.ResourceNotFoundException;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository repo;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public List<Transferencia> findAll() {
		return repo.findAll();
	}

	public List<Transferencia> findByNome(String nome) {
		return repo.findByNome(nome);
	}

	public List<Transferencia> findByValor(Double valor) {
		return repo.findByValor(valor);
	}

	public Transferencia findById(Long id) {
		Optional<Transferencia> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException());
	}

	public List<Transferencia> findByDataBetween(String startData, String endData) throws ParseException {

		Date start = sdf.parse(startData);
		Date end = sdf.parse(endData);

		return repo.findByDataBetween(start, end);
	}

	

	public Optional<Transferencia> findTransfer(String nome, String tipo, Long id, Double valor,String startData, String endData) throws ParseException {
		Date start = sdf.parse(startData);
		Date end = sdf.parse(endData);

		return repo.findByNomeAndTipoAndIdAndValorAndDataBetween(nome, tipo,  id, valor, start, end);
		
	}

}
