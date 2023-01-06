package br.com.banco.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.entities.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping(value = "/transferencias")
public class TransferenciaResource {

	@Autowired
	private TransferenciaService service;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@GetMapping
	public ResponseEntity<List<Transferencia>> findAll() {
		List<Transferencia> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/id")
	public ResponseEntity<Transferencia> findTransferencia(Long id) {
		Transferencia idT = service.findById(id);
		return ResponseEntity.ok().body(idT);
	}

	@GetMapping(value = "/nome")
	public ResponseEntity<List<Transferencia>> findByNome(@RequestParam(defaultValue = "") String nome) {
		List<Transferencia> list = service.findByNome(nome);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/period")
	public ResponseEntity<List<Transferencia>> findByDataBetween(
			@RequestParam(value = "startData", defaultValue = "") String startData,
			@RequestParam(value = "endData"  , defaultValue = "") String endData   ) throws ParseException {
		List<Transferencia> list = service.findByDataBetween(startData, endData);
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/fullsearch")
	public ResponseEntity<List<Transferencia>> findTransfer(
			@RequestParam(value = "nome" ,defaultValue = "") String nome,
			@RequestParam(value = "tipo" ,defaultValue = "") String tipo,
			@RequestParam(value = "id" ,  defaultValue = "" )Long id,
			@RequestParam(value = "valor" ,defaultValue = "") Double valor,
			@RequestParam(value = "startData", defaultValue = "") String startData,
			@RequestParam(value = "endData"  , defaultValue = "") String endData) throws ParseException {
		List<Transferencia> list = service.findTransfer(nome, tipo, id, valor, startData, endData);
		return ResponseEntity.ok().body(list);
	}
}
