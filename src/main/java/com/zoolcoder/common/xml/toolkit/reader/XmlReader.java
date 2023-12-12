package com.zoolcoder.common.xml.toolkit.reader;

import com.zoolcoder.common.xml.toolkit.exception.XmlReadingException;
import java.util.List;
import java.util.Map;

/**
 * XmlReader is an interface for reading XML files.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public interface XmlReader {

  /**
   * Reads an XML file.
   *
   * @param filePath The path to the XML file to be read.
   */
  void read(String filePath) throws XmlReadingException;

  /**
   * Reads the XML file at the specified file path and retrieves the values of the XML elements
   * specified by the given XPath expressions.
   *
   * @param filePath         the path of the XML file to be read
   * @param xpathExpressions a list of XPath expressions to retrieve the values of XML elements
   * @return a map containing the XPath expressions as keys and the corresponding element values as values
   * @throws XmlReadingException if an error occurs while reading the XML file or evaluating the XPath expressions
   */
  Map<String, String> readXPath(String filePath, List<String> xpathExpressions) throws XmlReadingException;
}
