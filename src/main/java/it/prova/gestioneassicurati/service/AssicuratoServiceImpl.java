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

//	@Override
//	public Page<Assicurato> searchAndPaginate(Assicurato assicuratoExample, Integer pageNo, Integer pageSize, String sortBy) {
//
//		Specification<Assicurato> specificationCriteria = (root, query, cb) -> {
//
//			List<Predicate> predicates = new ArrayList<Predicate>();
//
//			if (!StringUtils.isEmpty(assicuratoExample.getNome()))
//				predicates.add(cb.like(cb.upper(root.get("nome")), "%" + assicuratoExample.getNome().toUpperCase() + "%"));
//
//			if (!StringUtils.isEmpty(assicuratoExample.getCognome()))
//				predicates.add(
//						cb.like(cb.upper(root.get("cognome")), "%" + assicuratoExample.getCognome().toUpperCase() + "%"));
//
//			if (!StringUtils.isEmpty(assicuratoExample.getCodiceDipendente()))
//				predicates.add(cb.like(cb.upper(root.get("codiceDipendente")),
//						"%" + assicuratoExample.getCodiceDipendente().toUpperCase() + "%"));
//			if (assicuratoExample.isInServizio())
//				predicates.add(cb.isTrue(root.get("inServizio")));
//			else
//				predicates.add(cb.isFalse(root.get("inServizio")));
//
//			if (assicuratoExample.isInVisita())
//				predicates.add(cb.isTrue(root.get("inVisita")));
//			else
//				predicates.add(cb.isFalse(root.get("inVisita")));
//
//			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
//		};
//
//		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//		return assicuratoRepository.findAll(specificationCriteria, paging);
//	}

}
