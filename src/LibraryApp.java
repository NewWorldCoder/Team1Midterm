import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {


        LibraryDataBase ldb = new LibraryDataBase("docs/Team1LibraryDbase.csv");
        Librarian librarian = new Librarian();
        //medialist



        int userInput;


        System.out.println("Welcome to the Grand Circus Library.");
        System.out.println("Please select an option:");
        System.out.println("1. Search for media.");
        System.out.println("2. Check Out");
        System.out.println("3. Check In");
        System.out.println("4. Place a Hold");
        System.out.println("5. Donate");

        userInput = InputValidator.getValidInteger(1, 6);


        System.out.println(userInput);


        switch (userInput) {
            case 1:
                ldb.printMediaDatabase();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;


        }
    }
}
