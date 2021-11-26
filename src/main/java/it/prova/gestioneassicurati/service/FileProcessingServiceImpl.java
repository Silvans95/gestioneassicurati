package it.prova.gestioneassicurati.service;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {

	@Autowired
	DatabaseProcessingService databaseProcessingService;

	public void unmarshalling(String percorsoCartella) {
		try {
			File xmlFile = new File(percorsoCartella);
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(Assicurati.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Assicurati que = (Assicurati) jaxbUnmarshaller.unmarshal(xmlFile);

			databaseProcessingService.databaseProcessing(que, percorsoCartella);

		} catch (JAXBException e) {
			throw new RuntimeException();
		}
	}

	public void rejected(String percorso) {
		File xmlFile = new File(percorso);
		xmlFile.renameTo(
				new File("C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\rejected\\" + xmlFile.getName()));
	}

	public void processed(String percorso) {
		File xmlFile = new File(percorso);
		xmlFile.renameTo(
				new File("C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\processed\\" + xmlFile.getName()));

	}
}
