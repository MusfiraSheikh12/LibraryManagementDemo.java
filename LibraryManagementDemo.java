import java.util.ArrayList;
import java.util.List;

public class LibraryManagementDemo {

    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    // Add new book
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    // Borrow a book
    public void borrowBook(String title, String memberName) {
        Book b = findBook(title);
        Member m = findMember(memberName);
        if (b == null) {
            System.out.println("Book not found");
        }
        if (m == null) {
            System.out.println("Member not found");
        }
        books.remove(b); // BUG: removes even if book or member not found
    }

    // Unused method
    private void printInventory() {
        System.out.println("Total books: " + books.size()); // UNUSED method
    }

    // Empty method
    public void futureFeature() {
        // EMPTY block
    }

    // Add member
    public void addMember(String name) {
        members.add(new Member(name));
    }

    // Duplicate logic
    public void bonusBooks() {
        books.add(new Book("Bonus1", "Author1"));
    }

    public void extraBonusBooks() {
        books.add(new Book("Bonus1", "Author1")); // DUPLICATE
    }

    // Hardcoded credentials
    public void adminLogin() {
        String username = "admin";
        String password = "admin123"; // SECURITY ISSUE
        System.out.println("Login: " + username + "/" + password);
    }

    // Helper methods
    private Book findBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }

    private Member findMember(String name) {
        for (Member m : members) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    // Inner classes to make it a single file
    class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        private void unusedMethod() {
            System.out.println("Unused method"); // UNUSED
        }

        public String getTitle() {
            return title;
        }
    }

    class Member {
        private String name;
        private String password = "1234"; // SECURITY ISSUE

        public Member(String name) {
            this.name = name;
        }

        private void emptyMethod() {
            // EMPTY block
        }

        public String getName() {
            return name;
        }
    }

    // Main method to run
    public static void main(String[] args) {
        LibraryManagementDemo lib = new LibraryManagementDemo();
        lib.addBook("Java Programming", "Author A");
        lib.addBook("Python Programming", "Author B");
        lib.addMember("Alice");
        lib.addMember("Bob");

        lib.borrowBook("Java Programming", "Alice"); // triggers bug
        lib.bonusBooks();
        lib.extraBonusBooks(); // duplicate
        lib.adminLogin(); // hardcoded password
    }
}

