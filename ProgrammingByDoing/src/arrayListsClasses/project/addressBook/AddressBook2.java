package arrayListsClasses.project.addressBook;

import java.util.Scanner;

public class AddressBook2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Book[] library  = getBooks(s);

        for (int i=0;i<library.length;i++){
            library[i] = createNewBook(s);
        }
        boolean done = false;
        int selectedBook = 0;
        int selection;
        while (!done){
            System.out.println("Book "+selectedBook+" is currently selected.");

            showAllEntries(library[selectedBook]);
            selection = getSelection(s);

            switch(selection){
                case 1:
                    buildNewEntry(s, library[selectedBook]);
                    break;
                case 2:
                    removeEntry(s, library[selectedBook]);
                    break;
                case 3:
                    editEntry(s, library[selectedBook]);
                    break;
                case 4:
                    sortEntries(s, library[selectedBook]);
                    break;
                case 5:
                    selectedBook = getSelectedBook(s);
                    break;
                case 6:
                    moveEntryToDifferentBook(s, library, library[selectedBook]);
                    break;
                case 7:
                    done = true;
                    break;
                default:
                    System.out.print("Please choose a valid menu number");
                    break;
            }
        }
    }

    private static Book[] getBooks(Scanner s) {
        System.out.print("How many books do you want to create? ");
        int howManyBooks;
        Book[] library;
        while(true){
            howManyBooks = s.nextInt();
            if (howManyBooks>0){
                library = new Book[howManyBooks];                   //This code decides how many books are in the array of books/the library
                break;
            }
            else System.out.print("You must create at least 1 book.");
        }
        return library;
    }

    private static Book createNewBook(Scanner s) {
        Book book = new Book();
        int howManyEntries = 0;
        while(howManyEntries < 1){
            System.out.print("How many entries in book (1 minimum)?");
            howManyEntries = s.nextInt();
        }
        book.initEntries(howManyEntries);
        return book;
    }

    private static void moveEntryToDifferentBook(Scanner s, Book[] library, Book book) {
        System.out.print("Move which entry? ");
        int entryNo = s.nextInt();
        Book.Entry entryToMove = book.contents[entryNo];
        book.remove(entryNo);
        System.out.print("To which book? ");
        int whichBook = s.nextInt();
        library[whichBook].addFromCopy(entryToMove);
    }

    private static int getSelectedBook(Scanner s) {
        int selectedBook;
        System.out.print("Select which book?");
        selectedBook = s.nextInt();
        return selectedBook;
    }

    private static void sortEntries(Scanner s, Book book) {
        System.out.println("Sort alphabetically by which field?");
        System.out.println("1. Sort by first name");
        System.out.println("2. Sort by last name");
        System.out.println("3. Sort by address");
        System.out.println("4. Sort by email");
        book.sort(s.nextInt());
    }

    private static void editEntry(Scanner s, Book book) {
        String first;
        String last;
        String address;
        String email;
        System.out.print("Edit which entry?");
        int whichEntry = s.nextInt();
        System.out.print("First name? ");
        first = s.next();
        System.out.print("Last name? ");
        last = s.next();
        System.out.print("Address? ");
        address = s.next();
        System.out.print("Email? ");
        email = s.next();
        book.edit(first, last, address, email, whichEntry);
    }

    private static void removeEntry(Scanner s, Book book) {
        System.out.print("Remove which entry? ");
        int entry = s.nextInt();
        book.remove(entry);
    }

    private static void buildNewEntry(Scanner s, Book book) {
        String first;
        String last;
        String address;
        String email;
        System.out.print("First name? ");
        first = s.next();
        System.out.print("Last name? ");
        last = s.next();
        System.out.print("Address? ");
        address = s.next();
        System.out.print("Email? ");
        email = s.next();
        book.add(first, last, address, email);
    }

    private static int getSelection(Scanner s) {
        int selection;
        System.out.println("Select an option!");
        System.out.println("1. Add an entry");
        System.out.println("2. Remove an entry");
        System.out.println("3. Edit an entry");
        System.out.println("4. Sort all entries in this book");
        System.out.println("5. Select another book");
        System.out.println("6. Move entry across books");
        System.out.println("7. Exit the menu");
        System.out.print("> ");
        selection = s.nextInt();
        return selection;
    }

    private static void showAllEntries(Book book) {
        for (int i = 0; i< book.getEntries(); i++){
            System.out.println("===========Entry "+i+" ===========");
            book.contents[i].readEntry(); //Accessing the array of entries INSIDE the array of books/the library
            System.out.println("================================");
        }
    }
}
