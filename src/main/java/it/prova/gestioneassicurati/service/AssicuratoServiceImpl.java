package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneassicurati.exception.AssicuratoNotFoundException;
import it.prova.gestioneassicurati.model.Assicurati.Assicurato;
import it.prova.gestioneassicurati.repository.AssicuratoRepository;

@Service
public class AssicuratoServiceImpl implements AssicuratoService {

	@Autowired
	private AssicuratoRepository associatoRepository;

	@Override
	public List<Assicurato> listAll() {
		return (List<Assicurato>) associatoRepository.findAll();
	}

	@Override
	public Assicurato cariscaSingoloElemento(Long id) {
		return associatoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Assicurato inserisciNuovo(Assicurato transientInstance) {
		return associatoRepository.save(transientInstance);
	}

	@Override
	public Assicurato get(Long idInput) {
		return associatoRepository.findById(idInput)
				.orElseThrow(() -> new AssicuratoNotFoundException("Element with id " + idInput + " not found."));
	}

	@Override
	public Assicurato save(Assicurato input) {
		return associatoRepository.save(input);
	}

	@Override
	public void delete(Assicurato input) {
		associatoRepository.delete(input);
	}

//	@Override
//	public Page<Assicurato> searchAndPaginate(Assicurato associatoExample, Integer pageNo, Integer pageSize, String sortBy) {
//
//		Specification<Assicurato> specificationCriteria = (root, query, cb) -> {
//
//			List<Predicate> predicates = new ArrayList<Predicate>();
//
//			if (!StringUtils.isEmpty(associatoExample.getNome()))
//				predicates.add(cb.like(cb.upper(root.get("nome")), "%" + associatoExample.getNome().toUpperCase() + "%"));
//
//			if (!StringUtils.isEmpty(associatoExample.getCognome()))
//				predicates.add(
//						cb.like(cb.upper(root.get("cognome")), "%" + associatoExample.getCognome().toUpperCase() + "%"));
//
//			if (!StringUtils.isEmpty(associatoExample.getCodiceDipendente()))
//				predicates.add(cb.like(cb.upper(root.get("codiceDipendente")),
//						"%" + associatoExample.getCodiceDipendente().toUpperCase() + "%"));
//			if (associatoExample.isInServizio())
//				predicates.add(cb.isTrue(root.get("inServizio")));
//			else
//				predicates.add(cb.isFalse(root.get("inServizio")));
//
//			if (associatoExample.isInVisita())
//				predicates.add(cb.isTrue(root.get("inVisita")));
//			else
//				predicates.add(cb.isFalse(root.get("inVisita")));
//
//			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
//		};
//
//		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
//
//		return associatoRepository.findAll(specificationCriteria, paging);
//	}

}
