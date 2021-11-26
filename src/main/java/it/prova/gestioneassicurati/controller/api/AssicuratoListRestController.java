package it.prova.gestioneassicurati.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.service.AssicuratoService;

@RestController
@RequestMapping(value = "/list", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AssicuratoListRestController {

	@Autowired
	AssicuratoService assicuratoService;

	@GetMapping
	public List<Assicurato> getAll() {
		return assicuratoService.listAll();
	}
}
