import java.util.*;



class Book {
    int id;
    String title;
    String author;
    boolean isIssued;


    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println(" Book Added Successfully!");
    }


    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println(" No books available!");
            return;
        }

        System.out.println("\n--------------------------------------------------------");
        System.out.printf("%-5s %-20s %-15s %-10s%n",
                "ID", "Title", "Author", "Status");
        System.out.println("--------------------------------------------------------");

        for (Book b : books) {
            System.out.printf("%-5d %-20s %-15s %-10s%n",
                    b.id, b.title, b.author,
                    b.isIssued ? "Issued" : "Available");
        }
        System.out.println("--------------------------------------------------------");
    }


    static void issueBook() {
        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println(" Book Issued Successfully!");
                } else {
                    System.out.println(" Book is already issued!");
                }
                return;
            }
        }
        System.out.println("❌ Book Not Found!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to Return: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println(" Book Returned Successfully!");
                } else {
                    System.out.println(" Book was not issued!");
                }
                return;
            }
        }
        System.out.println(" Book Not Found!");
    }

    // Main Menu
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> displayBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> {
                    System.out.println(" Exiting Library System...");
                    System.exit(0);
                }
                default -> System.out.println(" Invalid Choice!");
            }
        }
    }
}