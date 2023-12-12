package com.zoolcoder.common.xml.toolkit.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a test data object used for XML serialization and deserialization.
 */
@XmlRootElement
public class TestData {

  private String field1;
  private String field2;

  // JAXB requires a no-arg constructor
  public TestData() {}

  /**
   * Constructs a TestData object with the specified field values.
   *
   * @param field1 the value of field1
   * @param field2 the value of field2
   */
  public TestData(String field1, String field2) {
    this.field1 = field1;
    this.field2 = field2;
  }

  /**
   * Gets the value of field1.
   *
   * @return the value of field1
   */
  @XmlElement
  public String getField1() {
    return field1;
  }

  /**
   * Sets the value of field1.
   *
   * @param field1 the new value of field1
   */
  public void setField1(String field1) {
    this.field1 = field1;
  }

  /**
   * Gets the value of field2.
   *
   * @return the value of field2
   */
  @XmlElement
  public String getField2() {
    return field2;
  }

  /**
   * Sets the value of field2.
   *
   * @param field2 the new value of field2
   */
  public void setField2(String field2) {
    this.field2 = field2;
  }
}