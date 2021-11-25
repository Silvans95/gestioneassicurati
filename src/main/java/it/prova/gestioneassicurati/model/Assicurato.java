package it.prova.gestioneassicurati.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Assicurato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nome;
	String cognome;
	Date dataDiNascita;
	String codiceFiscale;
	Integer numeroSinistri;

	public Assicurato() {
	}

	public Assicurato(String nome, String cognome, Date dataDINascita, String codiceFiscale, Integer numeroSinistri) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDINascita;
		this.codiceFiscale = codiceFiscale;
		this.numeroSinistri = numeroSinistri;
	}

	public Assicurato(Long id, String nome, String cognome, Date dataDINascita, String codiceFiscale,
			Integer numeroSinistri) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDINascita;
		this.codiceFiscale = codiceFiscale;
		this.numeroSinistri = numeroSinistri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDINascita() {
		return dataDiNascita;
	}

	public void setDataDINascita(Date dataDINascita) {
		this.dataDiNascita = dataDINascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Integer getNumeroSinistri() {
		return numeroSinistri;
	}

	public void setNumeroSinistri(Integer numeroSinistri) {
		this.numeroSinistri = numeroSinistri;
	}

}
