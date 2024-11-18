import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ucu.edu.ua.apps.decorator.Document;
import ucu.edu.ua.apps.decorator.MockedDocument;


public class DocumentTest {
    private Document document;

    @Test
    public void testParse() {
        document = new MockedDocument("Mocked GCS Path");
        Assertions.assertEquals("Mocked Parse Result", document.parse());
    }
}