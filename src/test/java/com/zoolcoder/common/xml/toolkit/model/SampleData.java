package com.zoolcoder.common.xml.toolkit.model;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * This class represents a sample data object for testing.
 * It has two properties: name and age.
 * It includes a no-arg constructor and getter methods, which are required by JAXB.
 */
@XmlRootElement
public class SampleData {
  private String name;
  private int age;

  // JAXB requires a no-arg constructor
  public SampleData() {}

  /**
   * Constructs a new SampleData object with the specified name and age.
   *
   * @param name the name of the person
   * @param age the age of the person
   */
  public SampleData(String name, int age) {
    this.name = name;
    this.age = age;
  }

  /**
   * Returns the name of the person.
   *
   * @return the name of the person
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the age of the person.
   *
   * @return the age of the person
   */
  public int getAge() {
    return age;
  }
}
