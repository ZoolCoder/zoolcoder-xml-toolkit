package com.zoolcoder.common.xml.toolkit.exception;

/**
 * Exception thrown when an error occurs during XML marshalling.
 *
 * @since 12-12-2023
 * @version 1.0
 * @author Abdallah Emad
 */
public class XmlMarshallingException extends Exception {

  /**
   * Constructs a new XmlMarshallingException with the specified error.
   *
   * @param error the XmlMarshallingError that caused the exception
   */
  public XmlMarshallingException(XmlMarshallingError error) {
    super(error.getMessage());
  }

  /**
   * Constructs a new XmlMarshallingException with the specified error and cause.
   *
   * @param error the XmlMarshallingError that caused the exception
   * @param cause the cause of the exception
   */
  public XmlMarshallingException(XmlMarshallingError error, Throwable cause) {
    super(error.getMessage(), cause);
  }
}