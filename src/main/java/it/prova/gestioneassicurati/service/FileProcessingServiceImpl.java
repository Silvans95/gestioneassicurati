package it.prova.gestioneassicurati.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {

	public Assicurati unmarshalling() {
		try {

			File xmlFile = new File(
					"C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\startingFolder\\assicurato.xml");
			JAXBContext jaxbContext;
			jaxbContext = JAXBContext.newInstance(Assicurati.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Assicurati que = (Assicurati) jaxbUnmarshaller.unmarshal(xmlFile);
			return que;

		} catch (JAXBException e) {
			throw new RuntimeException();
		}
	}

	public void rejected() {
		File xmlFile = new File("C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\startingFolder\\assicurato.xml");
		xmlFile.renameTo(new File("C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\rejected\\assicurato.xml"));
	}

	public void processed() {
		File xmlFile = new File("C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\startingFolder\\assicurato.xml");
		xmlFile.renameTo(new File("C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\processed\\assicurato.xml"));

	}
}
