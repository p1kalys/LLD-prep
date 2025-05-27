import java.io.FileWriter;
import java.util.*;

class DocumentEditor {
    private List<String> documentElements;
    private String renderDocument;

    public DocumentEditor() {
        documentElements = new ArrayList<>();
        renderDocument = "";
    }

    public void addText(String text) {
        documentElements.add(text);
    }

    public void addImage(String imagePath) {
        documentElements.add(imagePath);
    }

    public String render() {
        if (renderDocument.isEmpty()) {
            StringBuilder res = new StringBuilder();
            for (String element: documentElements) {
                if (element.length() > 4 && (element.endsWith(".jpg") || element.endsWith(".png"))) {
                    res.append("[Image: ").append(element).append("]\n");
                } else {
                    res.append(element).append("\n");
                }
            }
            renderDocument = res.toString();
        }
        return renderDocument;
    }

    public void saveFile() {
        try {
            // Save the file in the current working directory
            String currentDir = System.getProperty("user.dir");
            FileWriter writer = new FileWriter(currentDir + "\\document.txt");
            writer.write(render());
            writer.close();
            System.out.println("Document saved successfully at: " + currentDir + "\\document.txt");
        } catch (Exception e) {
            System.out.println("Error saving document");
        }
    }
}

public class BadDesign {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello, this is a sample document!!");
        editor.addImage("image1.jpg");
        editor.addText("This is another line of text.");
        editor.addImage("image2.png");
        
        System.out.println(editor.render());
        
        editor.saveFile();
    }
}