package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public class DatabaseProcessingServiceImpl implements DatabaseProcessingService {

	@Autowired
	AssicuratoService assicuratoService;

	@Autowired
	FileProcessingService fileProcessingService;

	public void databaseProcessing(Assicurati assicurati, String percorso) {

		List<Assicurati.Assicurato> list = assicurati.getAssicurato();

		if (list.stream().anyMatch(ass -> ass.getNumerosinistri() < 0 || ass.getNumerosinistri() > 10)) {
			fileProcessingService.rejected(percorso);
			return;
		}
		inserisciAssicurati(list, percorso);
	}

	public void inserisciAssicurati(List<Assicurati.Assicurato> list, String percorso) {

		list.stream().forEach(ass -> {
			if (!StringUtils.isEmpty(assicuratoService.findByCodiceFiscale(ass.getCodiceFiscale()))) {
				assicuratoService.inserisciNuovo(trasformaSomma(ass));
			} else {
				assicuratoService.inserisciNuovo(trasforma(ass));
			}
		});
		fileProcessingService.processed(percorso);
	}

	public Assicurato trasforma(Assicurati.Assicurato input) {
		Assicurato assicurato = new Assicurato(input.getNome(), input.getCognome(),
				input.getDatadinascita().toGregorianCalendar().getTime(), input.getCodiceFiscale(),
				input.getNumerosinistri());
		return assicurato;
	}

	public Assicurato trasformaSomma(Assicurati.Assicurato input) {
		Assicurato assicurato = assicuratoService.findByCodiceFiscale(input.getCodiceFiscale());
		assicurato.setNumeroSinistri(assicurato.getNumeroSinistri() + input.getNumerosinistri());
		return assicurato;
	}
}
