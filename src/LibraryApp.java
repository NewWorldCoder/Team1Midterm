import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner scan1 = new Scanner(System.in);
        LibraryDataBase ldb = new LibraryDataBase("docs/Team1LibraryDbase.csv");
        Librarian librarian = new Librarian();
        ArrayList<Media> list = new ArrayList<>();


        int userInput;
        String authorInput;
        String titleInput;
        String mediaInput;



        System.out.println("Welcome to the Grand Circus Library.");
        System.out.println("Please select an option:");
        System.out.println("1. Display All.");
        System.out.println("2. Display All Available");
        System.out.println("3. Display All Author Search");
        System.out.println("4. Display All Title Search");
      //  System.out.println("5. Display All Media Search");
      //  System.out.println("6. Donate (Add)");

        userInput = InputValidator.getValidInteger(1, 6);


        switch (userInput) {
            case 1:
                ldb.printMediaDatabase();
                break;
            case 2:
                list = ldb.getAllAvailable();
                librarian.printArray(list);
                break;
            case 3:
                System.out.println("Enter an author you'd like us to search for.");
                authorInput= scan1.nextLine();
                list = ldb.getAllAuthor(authorInput);
                librarian.printArray(list);
                break;
            case 4:
                System.out.println("Enter a title you'd like us to search for.");
                titleInput = scan1.nextLine();
                list = ldb.getAllTitle(titleInput);
                librarian.printArray(list);
                break;
         /*   case 5:
                list = ldb.getAllMedia("");
                ldb.getAllMedia();
                break;
            case 6:
            dd*/



        }
        
    }
}
