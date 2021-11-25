package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.data.domain.Page;

import it.prova.gestioneassicurati.model.Assicurati.Assicurato;


public interface AssicuratoService {
	
	public Assicurato inserisciNuovo(Assicurato transientInstance);

	public List<Assicurato> listAll();

	public Assicurato cariscaSingoloElemento(Long id);

//	public Page<Assicurato> searchAndPaginate(Assicurato automobileExample, Integer pageNo, Integer pageSize, String sortBy);

	public Assicurato get(Long idInput);

	public Assicurato save(Assicurato input);

	public void delete(Assicurato input);

	public Assicurato findByCodiceFiscale(String codiceFiscale);
	

	
}
