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

		for (Assicurati.Assicurato ans : list) {
			if (ans.getNumerosinistri() < 0 || ans.getNumerosinistri() > 10) {
				fileProcessingService.rejected(percorso);
				return;
			}
		}
		inserisciAssicurati(list, percorso);
	}

	public void inserisciAssicurati(List<Assicurati.Assicurato> list, String percorso) {
		for (Assicurati.Assicurato ans : list) {
			if (!StringUtils.isEmpty(assicuratoService.findByCodiceFiscale(ans.getCodiceFiscale()))) {
				Assicurato assicurato = assicuratoService.findByCodiceFiscale(ans.getCodiceFiscale());
				assicurato.setNumeroSinistri(assicurato.getNumeroSinistri() + ans.getNumerosinistri());
				assicuratoService.inserisciNuovo(assicurato);
			} else {
				Assicurato assicurato = new Assicurato(ans.getNome(), ans.getCognome(),
						ans.getDatadinascita().toGregorianCalendar().getTime(), ans.getCodiceFiscale(),
						ans.getNumerosinistri());
				assicuratoService.inserisciNuovo(assicurato);
			}
		}
		fileProcessingService.processed(percorso);

	}

}
