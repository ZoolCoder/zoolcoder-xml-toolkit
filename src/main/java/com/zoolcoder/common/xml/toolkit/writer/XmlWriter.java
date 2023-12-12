package com.zoolcoder.common.xml.toolkit.writer;

import com.zoolcoder.common.xml.toolkit.exception.XmlWritingException;

/**
 * XmlWriter is an interface for writing (marshaling) Java objects to XML.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public interface XmlWriter {

  /**
   * Writes an object to an XML file.
   *
   * @param filePath The path to the XML file to be written.
   * @param data     The object to be marshaled to XML.
   * @param <T>      The type of the object.
   */
  <T> void write(String filePath, T data) throws XmlWritingException;
}
