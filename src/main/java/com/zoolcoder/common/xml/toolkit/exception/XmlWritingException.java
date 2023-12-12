package com.zoolcoder.common.xml.toolkit.exception;

/**
 * Exception class for errors that occur during XML writing operations.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public class XmlWritingException extends Exception {

  /**
   * Constructs a new XmlWritingException with the specified error.
   *
   * @param error the XmlWritingError that caused the exception
   */
  public XmlWritingException(XmlWritingError error) {
    super(error.getMessage());
  }

  /**
   * Constructs a new XmlWritingException with the specified error and cause.
   *
   * @param error the XmlWritingError that caused the exception
   * @param cause the cause of the exception
   */
  public XmlWritingException(XmlWritingError error, Throwable cause) {
    super(error.getMessage(), cause);
  }
}