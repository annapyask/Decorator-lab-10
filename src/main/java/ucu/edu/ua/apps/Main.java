package ucu.edu.ua.apps;

import ucu.edu.ua.apps.decorator.MockedDocument;
// import ucu.edu.ua.apps.decorator.SmartDocument;
import ucu.edu.ua.apps.decorator.TimedDocument;

public class Main {
    public static void main(String[] args) {

        MockedDocument mockedDocument = new MockedDocument("gs://cv-examples/wiki.png");
        System.out.println(mockedDocument.parse());

        TimedDocument timedDocument = new TimedDocument(mockedDocument);
        System.out.println(timedDocument.parse());
    }
}