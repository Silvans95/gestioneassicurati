package it.prova.gestioneassicurati.service;

import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public interface DatabaseProcessingService {

	public void databaseProcessing(Assicurati assicurati);
	
}
