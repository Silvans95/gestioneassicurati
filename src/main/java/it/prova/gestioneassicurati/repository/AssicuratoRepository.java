package it.prova.gestioneassicurati.repository;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestioneassicurati.model.Assicurato;



public interface AssicuratoRepository extends CrudRepository<Assicurato, Long> {

	Assicurato findByCodiceFiscale(String codiceFiscale);


	
}
