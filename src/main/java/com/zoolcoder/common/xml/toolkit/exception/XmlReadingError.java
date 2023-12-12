package com.zoolcoder.common.xml.toolkit.exception;

/**
 * Enum representing an error that occurs while reading an XML file.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public enum XmlReadingError {
  XML_READING_ERROR("Error reading XML file");
  private final String message;

  /**
   * Constructs a new XmlReadingError with the specified error message.
   * 
   * @param message the error message
   */
  XmlReadingError(String message) {
    this.message = message;
  }

  /**
   * Returns the error message associated with this XmlReadingError.
   * 
   * @return the error message
   */
  public String getMessage() {
    return message;
  }
}
