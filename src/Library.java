public class Library {
    public static void main(String[] args) {
        // Create 2 regular books
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 300);
        Book book2 = new Book("1984", "George Orwell", 328);

        // Create 1 textbook
        Textbook textbook1 = new Textbook("Java Programming", "Herbert Schildt", 500, "Computer Science", 9);

        // Test borrowing and returning
        book1.borrowBook();       // should borrow
        book1.borrowBook();       // should say not available
        book1.returnBook();       // should return

        System.out.println();

        textbook1.borrowBook();   // borrow the textbook
        textbook1.returnBook();   // return it

        System.out.println();

        // Display information for all books
        System.out.println("---- Book 1 Info ----");
        book1.displayInfo();

        System.out.println("\n---- Book 2 Info ----");
        book2.displayInfo();

        System.out.println("\n---- Textbook Info ----");
        textbook1.displayInfo();
    }
}
