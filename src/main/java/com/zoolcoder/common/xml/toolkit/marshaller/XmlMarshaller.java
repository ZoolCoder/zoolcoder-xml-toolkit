package com.zoolcoder.common.xml.toolkit.marshaller;

import com.zoolcoder.common.xml.toolkit.exception.XmlMarshallingException;

/**
 * XmlMarshaller is an interface for marshaling Java objects to XML.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public interface XmlMarshaller {

  /**
   * Marshals an object to an XML file.
   *
   * @param filePath The path to the XML file to be written.
   * @param data     The object to be marshaled to XML.
   * @param <T>      The type of the object.
   */
  <T> void marshal(String filePath, T data) throws XmlMarshallingException;
}