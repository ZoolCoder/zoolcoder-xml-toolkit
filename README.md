# XmlToolkit

XmlToolkit is a Java library providing a comprehensive toolkit for XML processing, including parsing, marshaling, and reading XML. It is designed to simplify the process of working with XML in Java, providing a high-level API that abstracts away many of the complexities of XML processing.

## Components

- **XmlReader:** SAX-based XML reader for parsing XML files. It provides a simple interface for reading XML files and converting them into Java objects.
- **XmlWriter:** Interface for writing (marshaling) Java objects to XML. It allows you to easily convert your Java objects into XML format.
- **XmlParser:** Basic SAX parser for extracting data from XML. It provides a low-level interface for parsing XML, giving you direct control over the parsing process.
- **XmlMarshaller:** Interface for marshaling Java objects to XML. It provides a high-level interface for converting Java objects into XML.


## Usage

### Setup

To use XmlToolkit in your Maven project, add the following dependency:

```xml
<dependency>
    <groupId>com.zoolcoder.common</groupId>
    <artifactId>xmlToolkit</artifactId>
    <version>1.0.0</version>
</dependency>
```
## Example

### Reading XML:

```java
import com.zoolcoder.common.xml.toolkit.XmlToolkit;

public class ReadExample {

  public static void main(String[] args) {
    XmlToolkit xmlToolkit = new XmlToolkit.Builder()
        .withXmlReader(new SaxXmlParser())
        .build();

    // Reading XML
    try {
      xmlToolkit.readXml("path/to/your/input.xml");
    } catch (XmlReadingException e) {
      System.err.println(e.getMessage());
    }
  }
}
```
### Writing XML:

```java
import com.zoolcoder.common.xml.toolkit.XmlToolkit;

public class WriteExample {

  public static void main(String[] args) {
    XmlToolkit xmlToolkit = new XmlToolkit.Builder()
        .withXmlWriter(new SimpleXmlWriter())
        .build();

    // Writing XML
    YourDataClass data = new YourDataClass(); // Replace with your actual data class
    try {
      xmlToolkit.writeXml("path/to/your/output.xml", data);
    } catch (XmlWritingException e) {
      System.err.println(e.getMessage());
    }
  }
}
```
### Marshalling XML:

```java
import com.zoolcoder.common.xml.toolkit.XmlToolkit;
import com.zoolcoder.common.xml.toolkit.marshaller.DefaultXmlMarshaller;
import com.zoolcoder.common.xmlToolkit.marshaller.*;

public class MarshallingExample {

  public static void main(String[] args) {
    XmlToolkit xmlToolkit = new XmlToolkit.Builder()
        .withXmlMarshaller(new DefaultXmlMarshaller(YourDataClass.class))
        .build();

    // Marshalling XML
    YourDataClass data = new YourDataClass(); // Replace with your actual data class
    try {
      xmlToolkit.marshal("path/to/your/output.xml", data);
    } catch (XmlMarshallingException e) {
      System.err.println(e.getMessage());
    }
  }
}
```

## Error Handling
XmlToolkit uses Java enum to manage error messages in a centralized and type-safe manner. Each type of error is represented by an enum constant, and each constant is associated with a specific error message. When an error occurs, an exception is thrown with the appropriate enum constant. You can catch these exceptions and handle them as needed in your code.  

## Customization
You can extend XmlToolkit by implementing the XmlReader and XmlWriter interfaces to suit your specific requirements.

## Dependencies
XStream (for XML marshaling)

## Contribution
Feel free to contribute by opening issues or creating pull requests. Bug reports, feature requests, and feedback are welcome!

## License
This project is licensed under the MIT License - see the LICENSE file for details.