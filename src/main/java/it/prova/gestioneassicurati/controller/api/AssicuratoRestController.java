package it.prova.gestioneassicurati.controller.api;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.service.AssicuratoService;
import it.prova.gestioneassicurati.xml.Assicurati;

@RestController
@RequestMapping(value = "/assicurato", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AssicuratoRestController {

	@Autowired
	AssicuratoService assicuratoService;

	@GetMapping("/list")
	public List<Assicurato> getAll() {
		return assicuratoService.listAll();
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public void letturaFileXmlPerMetodiDiBusiness() {

		try {
			File xmlFile = new File(
					"C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\startingFolder\\assicurato.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Assicurati que = (Assicurati) jaxbUnmarshaller.unmarshal(xmlFile);

			System.out.println("Lista Assicurati:");

			List<Assicurati.Assicurato> list = que.getAssicurato();

			for (Assicurati.Assicurato ans : list) {

				if (ans.getNumerosinistri() < 0 || ans.getNumerosinistri() > 10) {
					xmlFile.renameTo(
							new File("C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\rejected\\assicurato.xml"));
				} else {

					if (!StringUtils.isEmpty(assicuratoService.findByCodiceFiscale(ans.getCodiceFiscale()))) {

						Assicurato assicurato = assicuratoService.findByCodiceFiscale(ans.getCodiceFiscale());
						System.out.println("sono entrato qui ed ho trovato" + assicurato.getNome());
						assicurato.setNumeroSinistri(assicurato.getNumeroSinistri() + ans.getNumerosinistri());
						assicuratoService.inserisciNuovo(assicurato);

					} else {
						Assicurato assicurato = new Assicurato(ans.getNome(), ans.getCognome(), ans.getDatadinascita().toGregorianCalendar().getTime(),
								ans.getCodiceFiscale(), ans.getNumerosinistri());
						assicuratoService.inserisciNuovo(assicurato);
					}

					xmlFile.renameTo(new File(
							"C:\\Users\\Solving Team\\Desktop\\esercizio marshall\\processed\\assicurato.xml"));
				}
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
