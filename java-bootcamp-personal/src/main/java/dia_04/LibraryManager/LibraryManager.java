package dia_04.LibraryManager;

import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManager {

    public static int safeIntInput(Scanner in, String prompt, int min,  int max) {
        boolean valid = false;
        int value = 0;

        while (!valid) {
            try {
                System.out.print(prompt);
                value = in.nextInt();
                in.nextLine();

                if (value < min || value > max) {
                    System.out.println("Please enter a number between " + min + " and " + max);
                }else  {
                    valid = true;
                }

            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                in.nextLine();
            }
        }
        return value;
    }

    public static int safeIntInput(Scanner in, String prompt) {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(prompt);
                value = in.nextInt();
                in.nextLine();
                valid = true;

            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return value;
    }

    public static void addBook(ArrayList<String> titles,
                               ArrayList<String> authors,
                               ArrayList<Integer> publicationYears,
                               ArrayList<Boolean> availableBooks,
                               String title,
                               String author,
                               int publicationYear){
        int currentYear = Year.now().getValue();
        if (publicationYear < 1000 || publicationYear > currentYear) {
            throw new IllegalArgumentException("Invalid publication year " + publicationYear);
        }

        titles.add(title);
        authors.add(author);
        publicationYears.add(publicationYear);
        availableBooks.add(true);
        System.out.println("\n------  ¡Book added successfully!  ------\n");
    }

    public static void showBooks(ArrayList<String> titles,
                                 ArrayList<String> authors,
                                 ArrayList<Integer> publicationYears,
                                 ArrayList<Boolean> availableBooks){

        if (titles.isEmpty()){
            throw new IllegalArgumentException("There aren't any book");
        }

        for (int i = 0; i < titles.size(); i++) {
            String available = availableBooks.get(i) ? "Available" : "Unavailable";

            System.out.println("\n---- Book #" + (i + 1));
            System.out.println("Index: " + i);
            System.out.println("Title: " + titles.get(i));
            System.out.println("Author: " + authors.get(i));
            System.out.println("Publication Year: " + publicationYears.get(i));
            System.out.println("Available Books: " + available);
        }
    }

    public static void searchBook(ArrayList<String> titles,
                                  ArrayList<String> authors,
                                  ArrayList<Integer> publicationYears,
                                  ArrayList<Boolean> availableBooks,
                                  String title){
        if (titles.isEmpty()){
            throw new IllegalArgumentException("There aren't any book");
        }

        boolean found = false;

        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).equalsIgnoreCase(title)){
                String  available = availableBooks.get(i) ? "Available" : "Unavailable";

                System.out.println("Book: " + titles.get(i));
                System.out.println("Index: " + i);
                System.out.println("Available Books: " + available);
                System.out.println("Publication Year: " + publicationYears.get(i));
                System.out.println("Author: " + authors.get(i));
                found = true;
                break;
            }
        }

        if (!found){
            System.out.println("Book not found");
        }

    }

    public static void borrowBook(ArrayList<String> titles,
                                  ArrayList<Boolean> availableBooks,
                                  int index){
        if (titles.isEmpty()){
            throw new IllegalArgumentException("There aren't any book");
        }

        try {
            if (availableBooks.get(index)){
                availableBooks.set(index,false);
                System.out.println("You have successfully borrowed the book: " + titles.get(index));
            }else {
                System.out.println("The book " + titles.get(index) + " is not available");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid book index");

        }

    }

    public static void returnBook(ArrayList<String> titles,
                                  ArrayList<Boolean> available,
                                  int index){
        if (titles.isEmpty()){
            throw new IllegalArgumentException("There aren't any book");
        }

        try{
            if (!available.get(index)){
                available.set(index,true);
                System.out.println("You have successfully returned the book: " + titles.get(index));
            }else {
                System.out.println("The book " + titles.get(index) + " already has been returned");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Invalid book index");
        }
    }

    public static void showAvailableBooks(ArrayList<String> titles,
                                          ArrayList<Boolean> available){

        if (titles.isEmpty()){
            throw new IllegalArgumentException("There aren't any book");
        }

        for (int i = 0; i < available.size(); i++) {
            if (available.get(i)){
                String availableBook = available.get(i) ? "Available" : "Unavailable";
                System.out.println( i + ". Book: " + titles.get(i) + " - " + availableBook);
            }
        }
    }

    public static void showBorrowed(ArrayList<String> titles,
                                    ArrayList<Boolean> available){
        if (titles.isEmpty()){
            throw new IllegalArgumentException("There aren't any book");
        }

        for (int i = 0; i < available.size(); i++) {
            if (!available.get(i)){
                String availableBook = available.get(i) ? "Available" : "Unavailable";
                System.out.println( i + ". Book: " + titles.get(i) + " - " + availableBook);
            }
        }
    }

    public static void menu(Scanner in){

        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<Integer> publicationYears = new ArrayList<>();
        ArrayList<Boolean> available = new ArrayList<>();

        int option;

        do {
            System.out.println("----- Library Management -----");
            System.out.println("1. Add book");
            System.out.println("2. Show all book");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Search book by title");
            System.out.println("6. Show available books");
            System.out.println("7. Show borrowed books");
            System.out.println("0. Exit");

            option = safeIntInput(in, "Select an option: ", 0,7);

            try{
                switch (option) {
                    case 1->{
                        System.out.println("------ Add Book ------");

                        System.out.print("Title book: " );
                        String title = in.nextLine();
                        System.out.print("Author book: " );
                        String author = in.nextLine();
                        int year = safeIntInput(in, "Publication year book: ", 1000, 2026);
                        addBook(titles, authors, publicationYears, available, title, author, year);

                    }case 2->{
                        System.out.println("------ Show books ------");

                        showBooks(titles, authors, publicationYears, available);

                    }case 3->{
                        System.out.println("------ Borrow book ------");

                        int index = safeIntInput(in, "Enter the index of the book you want to borrow: ", 0, titles.size() - 1);
                        borrowBook(titles, available, index);
                    }case 4->{
                        System.out.println("------ Return book ------");

                        int index = safeIntInput(in, "Enter the index of the book you want to return: ", 0, titles.size() - 1);
                        returnBook(titles, available, index);
                    }case 5-> {
                        System.out.println("------ Search book by title ------");

                        System.out.print("Title book: " );
                        String title = in.nextLine();
                        searchBook(titles, authors, publicationYears, available, title);
                    }case 6 -> {
                        System.out.println("------ Show available books ------");

                        showAvailableBooks(titles, available);
                    }case 7 -> {
                        System.out.println("------ Show borrowed books ------");

                        showBorrowed(titles, available);
                    }
                }
            } catch (Exception e) {
                System.out.println("\n An error occurred " + e.getMessage());
                System.out.println("Please try again. \n");
            }
        } while (option != 0);

    }

    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        try {
            menu(in);
        }catch (Exception e){
            System.out.println("Critical error: " + e.getMessage());
        }finally {
            in.close();
        }
    }
}