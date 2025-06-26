import java.util.*;
   
    class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}


 class User {
    private String name;
    private int id;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User ID: " + id + ", Name: " + name;
    }
}



 class Library {
    private List<Book> books;
    private Map<Integer, User> users;

    public Library() {
        books = new ArrayList<>();
        users = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(String title, int userId) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.issueBook();
                System.out.println("Book issued to " + user.getName());
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned.");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}



public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Sample data
        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Data Structures", "Mark Allen Weiss"));
        library.addBook(new Book("Python", "Guido Van Rossom"));
        library.addUser(new User(1, "Harika"));
        library.addUser(new User(2, "Ravi"));

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Clear newline

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    int userId = sc.nextInt();
                    library.issueBook(issueTitle, userId);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}

