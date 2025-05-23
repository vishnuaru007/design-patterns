interface Prototype {
    Prototype clone();  // Method to clone an object
}

class Document implements Prototype {
    private String content;
    private int version;

    public Document(String content, int version) {
        this.content = content;
        this.version = version;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public int getVersion() {
        return version;
    }

    // Implementing the clone method
    @Override
    public Prototype clone() {
        return new Document(this.content, this.version);
    }

    @Override
    public String toString() {
        return "Document [Content: " + content + ", Version: " + version + "]";
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        // Create a document (prototype)
        Document originalDocument = new Document("Hello, World!", 1);

        // Clone the document
        Document clonedDocument = (Document) originalDocument.clone();

        // Modify the cloned document
        clonedDocument.setVersion(2);
        clonedDocument.setContent("Hello, Clone!");

        // Print both the original and cloned documents
        System.out.println("Original Document: " + originalDocument);
        System.out.println("Cloned Document: " + clonedDocument);
    }
}
