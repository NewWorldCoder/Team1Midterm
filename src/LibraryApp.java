import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.CheckedInputStream;

public class LibraryApp {

    public static void main(String[] args) {

        String fileName = "docs/Team1LibraryDbase.csv";

        Scanner scan1 = new Scanner(System.in);
        LibraryDataBase ldb = new LibraryDataBase(fileName);
        Librarian librarian = new Librarian();
        ArrayList<Media> list = new ArrayList<>();

        int userInput;
        String authorInput = "";
        String titleInput = "";
        String mediaInput;
        String donationInput;
        String option = " ";
        String yesOption;

        System.out.println("Welcome to the Grand Circus Library.");

        while (true) {
            System.out.println("====== MENU =======");
            System.out.println("1. Display All");
            System.out.println("2. Display All Available");
            System.out.println("3. Display All Author Search");
            System.out.println("4. Display All Title Search");
            System.out.println("5. Check in Media");
            //  System.out.println("5. Search by Media Type");
            //  System.out.println("6. Donate (Add)");
            System.out.print("Please select an option: ");

            userInput = InputValidator.getValidInteger(1, 5);

            switch (userInput) {
                case 1:
                    list = ldb.getAllMedia();
                    librarian.printArray(list);
                    break;

                case 2:
                    list = ldb.getAllAvailable();
                    librarian.printArray(list);
                    break;

                case 3:
                    System.out.println("Enter an author you'd like us to search for.");
                    authorInput = scan1.nextLine();
                    list = ldb.getAllAuthor(authorInput);
                    librarian.printArray(list);
                    break;

                case 4:
                    System.out.println("Enter a title you'd like us to search for.");
                    titleInput = scan1.nextLine();
                    list = ldb.getAllTitle(titleInput);
                    librarian.printArray(list);
                    break;
                case 5:
                    list = ldb.getAllMedia(); //pull it from here
                    librarian.printArray(list); //display it from here
                    System.out.println("Enter number to be checked in.");
                    userInput = scan1.nextInt();
                    scan1.nextLine();

                    //titleInput = scan1.nextLine();
                    //  librarian.checkInMedia(list);
                    //if(titleInput == list.get())

                    boolean checkInSuccess;
                    checkInSuccess = librarian.checkInMedia(list, userInput - 1);

                    if (checkInSuccess == true) {

                        System.out.println("You have checked in: " + list.get(userInput - 1).getTitle());
                    }


                    librarian.printArray(list);

//            System.out.print("The due date for this item is: ");
//            System.out.println(librarian.printDate(list.get(bookNum - 1).getDueDate()));
//
                    //librarian.printDueDate(list, userInput - 1);
                    //scan1.nextLine();


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
                    //break;
            }

            System.out.println("Do you wish to check out one of these titles? Y or N");
            // Scanner input = new Scanner(System.in);
            option = scan1.nextLine();

            if (option.equalsIgnoreCase("Y")) {

                System.out.println("Please select the item number you would like to checkout.");

                int bookNum = scan1.nextInt();
                scan1.nextLine();
                boolean checkOutSuccess;
                checkOutSuccess = librarian.checkOutMedia(list, bookNum - 1);

                if (checkOutSuccess == true) {

                    System.out.println("You have checked out: " + list.get(bookNum - 1).getTitle());
                }


                librarian.printArray(list);

//            System.out.print("The due date for this item is: ");
//            System.out.println(librarian.printDate(list.get(bookNum - 1).getDueDate()));
//
                librarian.printDueDate(list, bookNum - 1);
            }

            System.out.print("Would you like to continue? (y/n) ");
            if (!InputValidator.askUserYesNo()) {
                break;
            }
        }







        // Vicky and I will use this reference to rewrite to csv file
        ldb.writeTextToFile(fileName);
        System.out.println("Grand Circus Library thanks you for visiting the library.");

    }

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







