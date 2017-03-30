package utility;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;


/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe MySql che si occupa di gestire la connessione con il database
 */
public class MySql {
	private String driver;
	private String url;
	private String utente;
	private String password;
	private Connection conn = null;

	/**
	 * Costruttore della classe Mysql, si occupa di leggere i parametri di connessione al database dal file config.xml
	 */
	public MySql() {
		try {
			File inputFile = new File("resources/config.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(inputFile);
			doc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/database";

			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

			Node nNode = nodeList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				driver = eElement.getElementsByTagName("driver").item(0).getTextContent();
				url = eElement.getElementsByTagName("url").item(0).getTextContent();
				utente = eElement.getElementsByTagName("user").item(0).getTextContent();
				password = eElement.getElementsByTagName("password").item(0).getTextContent();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo che si occupa di aprire una connessione con il database
	 */
	public void open() {
		try {
			// Carico il driver
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			// Il driver non può essere caricato
			e1.printStackTrace();
			System.exit(1);
		}
		try {
			// Apro la connessione
			conn = DriverManager.getConnection(url, utente, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo che si occupa di chiudere la connessione con il database
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return ritorna la connessione al database (Connection)
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Override del metodo toString()
	 */
	@Override
	public String toString() {
		return "Il driver usato per la connessione al database è: " + driver + " l'url del db è: " + url
				+ " e il suo utente è: " + utente;
	}

}
