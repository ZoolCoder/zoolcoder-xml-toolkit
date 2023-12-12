package com.zoolcoder.common.xml.toolkit.marshaller;

import com.zoolcoder.common.xml.toolkit.exception.XmlMarshallingError;
import com.zoolcoder.common.xml.toolkit.exception.XmlMarshallingException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class is an implementation of the XmlMarshaller interface.
 * It provides functionality to marshal Java objects to XML using JAXB.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public class DefaultXmlMarshaller implements XmlMarshaller {

  private static final Logger logger = LogManager.getLogger(DefaultXmlMarshaller.class);

  private final Class<?> targetClass;

  /**
   * Constructs a DefaultXmlMarshaller object with the specified target class.
   * 
   * @param targetClass the class of the object to be marshalled
   */
  public DefaultXmlMarshaller(Class<?> targetClass) {
    this.targetClass = targetClass;
  }

  /**
   * Marshals the specified data object to XML and writes it to the specified file path.
   * 
   * @param filePath the file path to write the XML to
   * @param data the data object to be marshalled
   * @throws XmlMarshallingException if an error occurs during marshalling
   */
  @Override
  public <T> void marshal(String filePath, T data) throws XmlMarshallingException {
    try (FileWriter writer = new FileWriter(filePath)) {
      JAXBContext jaxbContext = JAXBContext.newInstance(targetClass);
      jaxbContext.createMarshaller().marshal(data, writer);
    } catch (JAXBException | IOException e) {
      logger.error("Error marshalling XML", e);
      throw new XmlMarshallingException(XmlMarshallingError.MARSHALLING_ERROR, e);
    }
  }
}