package com.zoolcoder.common.xml.toolkit.marshaller;

import com.zoolcoder.common.xml.toolkit.exception.XmlMarshallingException;
import com.zoolcoder.common.xml.toolkit.model.SampleData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class contains tests for the DefaultXmlMarshaller class.
 */
class DefaultXmlMarshallerTest {

  /**
   * This test checks the marshal method of the DefaultXmlMarshaller class.
   * It creates a temporary file, a sample data object, and an instance of DefaultXmlMarshaller.
   * It then calls the marshal method and verifies that the file is created.
   * Finally, it cleans up the temporary file.
   *
   * @throws IOException if an I/O error occurs
   * @throws XmlMarshallingException if an error occurs during XML marshalling
   */
  @Test
  void testMarshal() throws IOException, XmlMarshallingException {
    // Create a temporary file for testing
    Path tempFilePath = Files.createTempFile("test", ".xml");
    String filePath = tempFilePath.toString();

    // Create a sample data object
    SampleData data = new SampleData("John Doe", 25);

    // Create an instance of DefaultXmlMarshaller
    DefaultXmlMarshaller marshaller = new DefaultXmlMarshaller(SampleData.class);

    // Call the marshal method
    marshaller.marshal(filePath, data);

    // Verify that the file is created
    File file = new File(filePath);
    assertTrue(file.exists());

    // Clean up the temporary file
    Files.deleteIfExists(tempFilePath);
  }
}