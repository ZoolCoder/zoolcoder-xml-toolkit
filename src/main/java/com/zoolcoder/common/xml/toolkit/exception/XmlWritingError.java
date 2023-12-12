package com.zoolcoder.common.xml.toolkit.exception;

/**
 * Enum representing errors that can occur during XML writing.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public enum XmlWritingError {
  XML_WRITING_ERROR("Error writing XML file");
  private final String message;

  /**
   * Constructs a new XmlWritingError with the specified error message.
   * @param message the error message
   */
  XmlWritingError(String message) {
    this.message = message;
  }

  /**
   * Returns the error message associated with this XmlWritingError.
   * @return the error message
   */
  public String getMessage() {
    return message;
  }
}
