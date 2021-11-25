//
// Questo file � stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andr� persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.11.25 alle 12:31:21 PM CET 
//


package it.prova.gestioneassicurati.xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.prova.gestioneassicurati.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.prova.gestioneassicurati.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Assicurati }
     * 
     */
    public Assicurati createAssicurati() {
        return new Assicurati();
    }

    /**
     * Create an instance of {@link Assicurati.Assicurato }
     * 
     */
    public Assicurati.Assicurato createAssicuratiAssicurato() {
        return new Assicurati.Assicurato();
    }

}
