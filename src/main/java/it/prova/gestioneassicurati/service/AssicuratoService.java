package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.model.Assicurato;

@Service
public interface AssicuratoService {
	
	public Assicurato inserisciNuovo(Assicurato transientInstance);

	public List<Assicurato> listAll();

	public Assicurato cariscaSingoloElemento(Long id);

	public Assicurato get(Long idInput);

	public Assicurato save(Assicurato input);

	public void delete(Assicurato input);

	public Assicurato findByCodiceFiscale(String codiceFiscale);
	

	
}
