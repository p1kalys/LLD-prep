import java.io.FileWriter;
import java.util.*;

interface DocumentElement {
    String render();
}

class TextElement implements DocumentElement {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class ImageElement implements DocumentElement {
    private String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return "[Image: " + imagePath + "]";
    }
}

class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}

class Document {
    private List<DocumentElement> elements;

    public Document() {
        elements = new ArrayList<>();
    }

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public String render() {
        StringBuilder renderedDocument = new StringBuilder();
        for (DocumentElement element : elements) {
            renderedDocument.append(element.render());
        }
        return renderedDocument.toString();
    }
}

interface Persistence {
    void save(String content);
}

class FilePersistence implements Persistence {
    @Override
    public void save(String content) {
        try {
            String currentDir = System.getProperty("user.dir");
            FileWriter writer = new FileWriter(currentDir + "\\document.txt");
            writer.write(content);
            writer.close();
            System.out.println("Document saved successfully at: " + currentDir + "\\document.txt");
        } catch (Exception e) {
            System.out.println("Error saving document");
        }
    }
}

class DBPersistence implements Persistence {
    @Override
    public void save(String content) {
        // Simulate saving to a database
        System.out.println("Document saved to database: " + content);
    }
}

class DocumentEditors {
    private Document document;
    private Persistence persistence;

    public DocumentEditors(Persistence persistence) {
        this.document = new Document();
        this.persistence = persistence;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    public String render() {
        return document.render();
    }

    public void saveFile() {
        persistence.save(render());
    }
}

public class BetterDesign {
    public static void main(String[] args) {
        Persistence persistence = new FilePersistence(); // or new DBPersistence();
        DocumentEditors editor = new DocumentEditors(persistence);
        
        editor.addText("Hello, this is a sample document!!");
        editor.addImage("image1.jpg");
        editor.addTabSpace();
        editor.addText("This is another line of text.");
        editor.addTabSpace();
        editor.addImage("image2.png");
        
        System.out.println(editor.render());
        
        editor.saveFile();
    }
}
