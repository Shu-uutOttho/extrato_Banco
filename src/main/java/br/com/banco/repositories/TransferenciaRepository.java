package br.com.banco.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.entities.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	List<Transferencia> findByNome(String nome);
	List<Transferencia> findByValor(Double valor);
	List<Transferencia> findByDataBetween(Date startData, Date endData);
	List<Transferencia> findByNomeAndTipoAndIdAndValorAndDataBetween(String nome,String tipo,Long id,Double valor,Date startData, Date endData);
}
