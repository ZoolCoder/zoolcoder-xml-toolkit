package com.zoolcoder.common.xml.toolkit.writer;

import com.zoolcoder.common.xml.toolkit.exception.XmlWritingException;
import com.zoolcoder.common.xml.toolkit.model.TestData;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultXmlWriterTest {

    private DefaultXmlWriter defaultXmlWriter;
    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        defaultXmlWriter = new DefaultXmlWriter();
        tempFile = File.createTempFile("test", ".xml");
        tempFile.deleteOnExit();
    }

    @Test
    void write_ValidData_WritesXmlCorrectly() throws XmlWritingException, IOException {
        // Create a Java object with some data
        TestData testData = new TestData("value1","value2");

        // Use the write method to write the Java object to an XML file
        defaultXmlWriter.write(tempFile.getPath(), testData);

        // Read the XML file
        String xmlContent = new String(Files.readAllBytes(Paths.get(tempFile.getPath())));

        // Assert that the content matches the expected XML
        String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<testData>\n" +
            "    <field1>value1</field1>\n" +
            "    <field2>value2</field2>\n" +
            "</testData>\n";
        assertEquals(expectedXml, xmlContent);
    }
}