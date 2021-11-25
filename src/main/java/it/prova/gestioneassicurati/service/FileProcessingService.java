package it.prova.gestioneassicurati.service;

import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public interface FileProcessingService {

	public Assicurati unmarshalling(String percorsoCartella);
	
	public void rejected(String percorso);
	
	public void processed(String percorso);
}
