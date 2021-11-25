package it.prova.gestioneassicurati.controller.api;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.service.AssicuratoService;
import it.prova.gestioneassicurati.service.DatabaseProcessingService;
import it.prova.gestioneassicurati.service.FileProcessingService;
import it.prova.gestioneassicurati.xml.Assicurati;

@RestController
@RequestMapping(value = "/assicurato", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AssicuratoRestController {

	@Autowired
	AssicuratoService assicuratoService;

	@Autowired
	FileProcessingService fileProcessingService;

	@Autowired
	DatabaseProcessingService databaseProcessingService;

	@GetMapping("/list")
	public List<Assicurato> getAll() {
		return assicuratoService.listAll();
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public void letturaFileXmlPerMetodiDiBusiness() {

		final File folder = new File("C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\startingFolder\\");

		for (final File fileEntry : folder.listFiles()) {
			String percorso = "C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\startingFolder\\" + fileEntry.getName();
			Assicurati assicurati = fileProcessingService
					.unmarshalling(percorso);

			databaseProcessingService.databaseProcessing(assicurati, percorso);
		}

	}
}
