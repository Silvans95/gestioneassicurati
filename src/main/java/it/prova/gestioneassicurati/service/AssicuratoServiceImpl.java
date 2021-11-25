package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneassicurati.exception.AssicuratoNotFoundException;
import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.repository.AssicuratoRepository;

@Service
public class AssicuratoServiceImpl implements AssicuratoService {

	@Autowired
	private AssicuratoRepository assicuratoRepository;

	@Override
	public List<Assicurato> listAll() {
		return (List<Assicurato>) assicuratoRepository.findAll();
	}

	@Override
	public Assicurato cariscaSingoloElemento(Long id) {
		return assicuratoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Assicurato inserisciNuovo(Assicurato transientInstance) {
		return assicuratoRepository.save(transientInstance);
	}

	@Override
	public Assicurato get(Long idInput) {
		return assicuratoRepository.findById(idInput)
				.orElseThrow(() -> new AssicuratoNotFoundException("Element with id " + idInput + " not found."));
	}

	@Override
	public Assicurato save(Assicurato input) {
		return assicuratoRepository.save(input);
	}

	@Override
	public void delete(Assicurato input) {
		assicuratoRepository.delete(input);
	}

	@Override
	public Assicurato findByCodiceFiscale(String codiceFiscale) {

		return assicuratoRepository.findByCodiceFiscale(codiceFiscale);
	}

}
