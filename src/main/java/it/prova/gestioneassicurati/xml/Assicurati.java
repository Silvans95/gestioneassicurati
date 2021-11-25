//
// Questo file � stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andr� persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.11.25 alle 12:31:21 PM CET 
//


package it.prova.gestioneassicurati.xml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assicurato" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="datadinascita" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="numerosinistri" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "assicurato"
})
@XmlRootElement(name = "assicurati")
public class Assicurati {

    @XmlElement(required = true)
    protected List<Assicurati.Assicurato> assicurato;

    /**
     * Gets the value of the assicurato property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assicurato property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssicurato().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Assicurati.Assicurato }
     * 
     * 
     */
    public List<Assicurati.Assicurato> getAssicurato() {
        if (assicurato == null) {
            assicurato = new ArrayList<Assicurati.Assicurato>();
        }
        return this.assicurato;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="datadinascita" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="numerosinistri" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nome",
        "cognome",
        "datadinascita",
        "codiceFiscale",
        "numerosinistri"
    })
    public static class Assicurato {

        @XmlElement(required = true)
        protected String nome;
        @XmlElement(required = true)
        protected String cognome;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datadinascita;
        @XmlElement(required = true)
        protected String codiceFiscale;
        @XmlElement(required = true)
        protected Integer numerosinistri;

        /**
         * Recupera il valore della propriet� nome.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNome() {
            return nome;
        }

        /**
         * Imposta il valore della propriet� nome.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNome(String value) {
            this.nome = value;
        }

        /**
         * Recupera il valore della propriet� cognome.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCognome() {
            return cognome;
        }

        /**
         * Imposta il valore della propriet� cognome.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCognome(String value) {
            this.cognome = value;
        }

        /**
         * Recupera il valore della propriet� datadinascita.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatadinascita() {
            return datadinascita;
        }

        /**
         * Imposta il valore della propriet� datadinascita.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatadinascita(XMLGregorianCalendar value) {
            this.datadinascita = value;
        }

        /**
         * Recupera il valore della propriet� codiceFiscale.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodiceFiscale() {
            return codiceFiscale;
        }

        /**
         * Imposta il valore della propriet� codiceFiscale.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodiceFiscale(String value) {
            this.codiceFiscale = value;
        }

        /**
         * Recupera il valore della propriet� numerosinistri.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public Integer getNumerosinistri() {
            return numerosinistri;
        }

        /**
         * Imposta il valore della propriet� numerosinistri.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNumerosinistri(Integer value) {
            this.numerosinistri = value;
        }

    }

}
