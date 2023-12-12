package com.zoolcoder.common.xml.toolkit.exception;

/**
 * Exception class for errors that occur during XML reading.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public class XmlReadingException extends Exception {

  /**
   * Constructs a new XmlReadingException with the specified error.
   * 
   * @param error the XmlReadingError that caused the exception
   */
  public XmlReadingException(XmlReadingError error) {
    super(error.getMessage());
  }

  /**
   * Constructs a new XmlReadingException with the specified error and cause.
   * 
   * @param error the XmlReadingError that caused the exception
   * @param cause the cause of the exception
   */
  public XmlReadingException(XmlReadingError error, Throwable cause) {
    super(error.getMessage(), cause);
  }
}