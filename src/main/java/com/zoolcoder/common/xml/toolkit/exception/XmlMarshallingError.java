package com.zoolcoder.common.xml.toolkit.exception;

/**
 * Enum representing errors that can occur during XML marshalling.
 *
 * @since 12-12-2023
 * @author Abdallah Emad
 */
public enum XmlMarshallingError {
  JAXB_CONTEXT_CREATION_ERROR("Error creating JAXBContext"),
  MARSHALLING_ERROR("Error marshalling XML");

  private final String message;

  /**
   * Constructs a new XmlMarshallingError with the specified error message.
   * @param message the error message
   */
  XmlMarshallingError(String message) {
    this.message = message;
  }

  /**
   * Returns the error message associated with this XmlMarshallingError.
   * @return the error message
   */
  public String getMessage() {
    return message;
  }
}