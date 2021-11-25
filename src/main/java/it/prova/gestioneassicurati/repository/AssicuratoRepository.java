package it.prova.gestioneassicurati.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.prova.gestioneassicurati.model.Assicurati.Assicurato;



public interface AssicuratoRepository extends PagingAndSortingRepository<Assicurato, Long>, JpaSpecificationExecutor<Assicurato> {

	Assicurato findByCodiceFiscale(String codiceFiscale);


	
}
