package it.prova.gestioneassicurati.service;

import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public interface FileProcessingService {

	public Assicurati unmarshalling();
	
	public void rejected();
	
	public void processed();
}
