package com.zoolcoder.common.xml.toolkit.writer;

import com.zoolcoder.common.xml.toolkit.exception.XmlWritingError;
import com.zoolcoder.common.xml.toolkit.exception.XmlWritingException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;

/**
 * The DefaultXmlWriter class is an implementation of the XmlWriter interface.
 * It provides functionality to write XML data to a file using JAXB marshalling.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public class DefaultXmlWriter implements XmlWriter {

  private static final Logger logger = LogManager.getLogger(DefaultXmlWriter.class);

  @Override
  public <T> void write(String filePath, T data) throws XmlWritingException {
    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(data.getClass());
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      // output pretty printed
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      jaxbMarshaller.marshal(data, new File(filePath));
    } catch (JAXBException e) {
      logger.error("Error writing XML", e);
      throw new XmlWritingException(XmlWritingError.XML_WRITING_ERROR, e);
    }
  }
}