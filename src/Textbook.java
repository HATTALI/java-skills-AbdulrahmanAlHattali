public class Textbook extends Book{
    private String subject;
    private int edition;

    // Constructor that calls parent constructor using super()
    public Textbook(String title, String author, int pages, String subject, int edition) {
        super(title, author, pages); // Call Book constructor
        this.subject = subject;
        this.edition = edition;
    }

    // Override the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent version
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }

    // Getters for new fields
    public String getSubject() {
        return subject;
    }

    public int getEdition() {
        return edition;
    }
}
