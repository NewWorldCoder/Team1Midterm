import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

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
        String donationInput;
        String option = " ";
        String yesOption;

        System.out.println("Welcome to the Grand Circus Library.");
        System.out.println("Please select an option:");
        System.out.println("1. Display All.");
        System.out.println("2. Display All Available");
        System.out.println("3. Display All Author Search");
        System.out.println("4. Display All Title Search");
        //  System.out.println("5. Search by Media Type");
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

           /* case 5:
                System.out.println("Please select Book, DVD or CD to narrow your search by media type");
                mediaInput = scan1.nextLine(mediaInput);
                list = ldb.getByMedia(mediaInput); \\this is made up
                librarian.printArray(list);
                break;

            case 6:
                System.out.println("To donate (add) to our library, please select an option:")
                donationInput = scan1.nextLine(donationInput);
                break;*/

        }


        System.out.println("Do you wish to do anything with you selections? Y or N");
        Scanner input = new Scanner(System.in);
        option = input.nextLine();

        if(option.equalsIgnoreCase("Y")) {

            System.out.println("Please select the number associated with your selection.");
            // System.out.println(list.get(i).toString());    Problem here
            // System.out.println("Enjoy the " + titleInput + ".");  Problem here

        }

        else {

            System.out.println("Please return to the Grand Circus Library soon.");

        }
        
        ldb.writeTextToFile("test.csv",list);
                System.out.println("Do you wish to do anything with you selections?");


    public void addDonateMedia() {

        String mediaInput;
        String authorInput;
        String titleInput;
        String categoryInput;

        Scanner scan1 = new Scanner(System.in);

        System.out.println("Enter media type for all donations.");
        mediaInput = scan1.nextLine();

        System.out.println("Enter author if you are donating a book.");
        authorInput = scan1.nextLine();


        System.out.println("Enter title for all donations.");
        titleInput = scan1.nextLine();


        System.out.println("Enter category for all donations.");
        categoryInput = scan1.nextLine();

        System.out.println("Grand Circus Library thanks you for your donations.");

    }

}







