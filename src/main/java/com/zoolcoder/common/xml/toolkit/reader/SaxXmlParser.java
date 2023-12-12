package com.zoolcoder.common.xml.toolkit.reader;

import com.zoolcoder.common.xml.toolkit.exception.XmlReadingError;
import com.zoolcoder.common.xml.toolkit.exception.XmlReadingException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a SAX XML parser that implements the XmlReader interface.
 * It is used to read XML files and extract data using SAX parsing.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public class SaxXmlParser implements XmlReader {

  private static final Logger logger = LogManager.getLogger(SaxXmlParser.class);

  private final CustomHandler handler;

  /**
   * Constructs a new SaxXmlParser object.
   * Initializes the CustomHandler used for parsing.
   */
  public SaxXmlParser() {
    this.handler = new CustomHandler();
  }

  /**
   * Reads the XML file at the specified file path and extracts the data using SAX parsing.
   *
   * @param filePath the path of the XML file to be read
   * @throws XmlReadingException if an error occurs while reading the XML file
   */
  @Override
  public void read(String filePath) throws XmlReadingException {
    try {
      File file = new File(filePath);
      if (!file.exists()) {
        logger.error("File does not exist");
        throw new XmlReadingException(XmlReadingError.XML_READING_ERROR);
      }
      if (file.length() == 0) {
        logger.error("File is empty");
        return;
      }

      SAXParserFactory factory = SAXParserFactory.newInstance();
      factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
      factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
      SAXParser saxParser = factory.newSAXParser();
      saxParser.parse(file, handler);
    } catch (SAXException e) {
      logger.error("Invalid XML", e);
      throw new XmlReadingException(XmlReadingError.XML_READING_ERROR, e);
    } catch (Exception e) {
      logger.error("Error reading XML", e);
      throw new XmlReadingException(XmlReadingError.XML_READING_ERROR, e);
    }
  }

  /**
   * Reads the XML file at the specified file path and evaluates the given XPath expressions
   * to retrieve the corresponding values.
   *
   * @param filePath         the path of the XML file to be read
   * @param xpathExpressions a list of XPath expressions to be evaluated
   * @return a map containing the XPath expressions as keys and the corresponding values as values
   * @throws XmlReadingException if an error occurs while reading the XML file or evaluating the XPath expressions
   */
  @Override
  public Map<String, String> readXPath(String filePath, List<String> xpathExpressions) throws XmlReadingException {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
      factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(filePath);

      XPathFactory xPathfactory = XPathFactory.newInstance();
      XPath xpath = xPathfactory.newXPath();

      Map<String, String> results = new HashMap<>();
      for (String xpathExpression : xpathExpressions) {
        Node result = (Node) xpath.evaluate(xpathExpression, doc, XPathConstants.NODE);
        results.put(xpathExpression, result != null ? result.getTextContent() : null);
      }
      return results;
    } catch (Exception e) {
      throw new XmlReadingException(XmlReadingError.XML_READING_ERROR, e);
    }
  }

  /**
   * Returns the parsed data extracted from the XML file.
   *
   * @return a map containing the extracted data, where the keys are element names and the values are the corresponding data
   */
  public Map<String, String> getParsedData() {
    return handler.getDataMap();
  }

  /**
   * This class represents a custom handler used for parsing XML elements and extracting data.
   * It extends the DefaultHandler class provided by the SAX API.
   */
  protected static class CustomHandler extends DefaultHandler {

    private final Map<String, String> dataMap = new HashMap<>();
    private String currentElement = "";
    private StringBuilder data = new StringBuilder();

    /**
     * Called when the start of an XML element is encountered during parsing.
     * Sets the currentElement variable to the qualified name of the element.
     *
     * @param uri        the Namespace URI, or the empty string if the element has no Namespace URI or if Namespace processing is not being performed
     * @param localName  the local name (without prefix), or the empty string if Namespace processing is not being performed
     * @param qName      the qualified name (with prefix), or the empty string if qualified names are not available
     * @param attributes the attributes attached to the element. If there are no attributes, it shall be an empty Attributes object
     * @throws SAXException any SAX exception, possibly wrapping another exception
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      currentElement += "/" + qName;
      data.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      String dataString = data.toString().trim();
      dataMap.computeIfAbsent(currentElement, key -> dataString);
      currentElement = currentElement.substring(0, currentElement.lastIndexOf("/"));
    }
    /**
     * Called when character data inside an element is encountered during parsing.
     * Extracts the data and adds it to the dataMap if it is not empty.
     *
     * @param ch     the characters from the XML document
     * @param start  the start position in the character array
     * @param length the number of characters to read from the character array
     * @throws SAXException any SAX exception, possibly wrapping another exception
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      data.append(ch, start, length);
    }

    /**
     * Returns the data map containing the extracted data.
     *
     * @return a map containing the extracted data, where the keys are element names and the values are the corresponding data
     */
    public Map<String, String> getDataMap() {
      return dataMap;
    }
  }
}