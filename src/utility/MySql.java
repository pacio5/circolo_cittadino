/**
 * 
 */
package utility;

import java.sql.*;

/* Manipolazione file XML */

import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;

/**
 * @author eliapacioni
 *
 */
public class MySql {
	private String driver;
	private String url;
	private String utente;
	private String password;
	private Connection conn = null;

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

	// Effettua la connessione al db
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Chiude la connessione al db
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public String toString() {
		return "Il driver usato per la connessione al database è: " + driver + " l'url del db è: " + url
				+ " e il suo utente è: " + utente + " la sua password è: " + password;
	}

}
