package com.zoolcoder.common.xml.toolkit;

import com.zoolcoder.common.xml.toolkit.exception.XmlReadingException;
import com.zoolcoder.common.xml.toolkit.exception.XmlWritingException;
import com.zoolcoder.common.xml.toolkit.reader.XmlReader;
import com.zoolcoder.common.xml.toolkit.writer.XmlWriter;

/**
 * XmlToolkit is a Java library providing a comprehensive toolkit for XML processing,
 * including parsing, marshaling, and reading XML.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public class XmlToolkit {

  private final XmlReader xmlReader;
  private final XmlWriter xmlWriter;

  private XmlToolkit(Builder builder) {
    this.xmlReader = builder.xmlReader;
    this.xmlWriter = builder.xmlWriter;
  }

  /**
   * Reads an XML file using the configured XmlReader.
   *
   * @param filePath The path to the XML file to be read.
   */
  public void readXml(String filePath) throws XmlReadingException {
    xmlReader.read(filePath);
  }

  /**
   * Writes an object to an XML file using the configured XmlWriter.
   *
   * @param filePath The path to the XML file to be written.
   * @param data     The object to be marshaled to XML.
   */
  public void writeXml(String filePath, Object data) throws XmlWritingException {
    xmlWriter.write(filePath, data);
  }

  /**
   * Builder class for creating instances of XmlToolkit.
   */
  public static class Builder {
    private XmlReader xmlReader;
    private XmlWriter xmlWriter;

    /**
     * Sets the XmlReader for the XmlToolkit.
     *
     * @param xmlReader The XmlReader implementation.
     * @return The builder instance for method chaining.
     */
    public Builder withXmlReader(XmlReader xmlReader) {
      this.xmlReader = xmlReader;
      return this;
    }

    /**
     * Sets the XmlWriter for the XmlToolkit.
     *
     * @param xmlWriter The XmlWriter implementation.
     * @return The builder instance for method chaining.
     */
    public Builder withXmlWriter(XmlWriter xmlWriter) {
      this.xmlWriter = xmlWriter;
      return this;
    }

    /**
     * Builds an instance of XmlToolkit with the provided configurations.
     *
     * @return An instance of XmlToolkit.
     */
    public XmlToolkit build() {
      return new XmlToolkit(this);
    }
  }
}