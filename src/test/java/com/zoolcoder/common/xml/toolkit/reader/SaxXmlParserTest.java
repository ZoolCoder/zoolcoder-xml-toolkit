package com.zoolcoder.common.xml.toolkit.reader;

import com.zoolcoder.common.xml.toolkit.exception.XmlReadingError;
import com.zoolcoder.common.xml.toolkit.exception.XmlReadingException;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class SaxXmlParserTest {

    private SaxXmlParser saxXmlParser;
    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        saxXmlParser = new SaxXmlParser();
        tempFile = File.createTempFile("test", ".xml");
        tempFile.deleteOnExit();
        String xmlData = "<root><element>value</element></root>";
        Files.write(tempFile.toPath(), xmlData.getBytes(StandardCharsets.UTF_8));
    }

    @AfterEach
    void tearDown() {
        tempFile.delete();
    }

    @Test
    void read_ValidXmlFile_ParsesDataCorrectly() throws XmlReadingException {
        saxXmlParser.read(tempFile.getPath());
        Map<String, String> parsedData = saxXmlParser.getParsedData();
        assertEquals("value", parsedData.get("/root/element"));
    }

    @Test
    void read_EmptyXmlFile_ReturnsEmptyMap() throws IOException, XmlReadingException {
        Files.write(tempFile.toPath(), "".getBytes(StandardCharsets.UTF_8));
        saxXmlParser.read(tempFile.getPath());
        assertTrue(saxXmlParser.getParsedData().isEmpty());
    }

    @Test
    void read_NonExistentXmlFile_ThrowsXmlReadingException() {
        assertThrows(XmlReadingException.class, () -> saxXmlParser.read("non_existent.xml"));
    }

    @Test
    void read_InvalidXmlFile_ThrowsXmlReadingException() throws IOException {
        Files.write(tempFile.toPath(), "<root><element>value</element>".getBytes(StandardCharsets.UTF_8));
        assertThrows(XmlReadingException.class, () -> saxXmlParser.read(tempFile.getPath()));
    }
    @Test
    void readXPath_ValidXmlFile_ReturnsXPathResults() throws XmlReadingException {
        Map<String, String> results = saxXmlParser.readXPath(tempFile.getPath(), Arrays.asList("/root/element", "/root/attribute"));
        assertEquals(2, results.size());
        assertEquals("value", results.get("/root/element"));
        assertNull(results.get("/root/attribute"));
    }
}