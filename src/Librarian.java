import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Victoria Owen on 2/15/2017.
 */
public class Librarian {

    /**
     * YK: Constructor, does nothing
     */
    public Librarian() {
        // Do nothing
    }


    /**
     * YK - Prints a numbered list according to the ArrayList returned by LibraryDataBase
     * @param list ArrayList created by the LibraryDataBase
     */
    public void printArray(ArrayList<Media> list) {
        // Variables to set width of each column
        int indexColWidth = 5;
        int typeColWidth = 12;
        int titleColWidth = 35;
        int categoryColWidth = 30;
        int statusColWidth = 12;
        int checkOutColWidth = 18;
        int dueDateColWidth = 15;

        // Heading
        System.out.printf("%-" + indexColWidth + "s" + "%-" + typeColWidth + "s" +
                "%-" + titleColWidth + "s%-" + categoryColWidth + "s%-" +statusColWidth + "s" +
                        "%-" + checkOutColWidth + "s%-" + dueDateColWidth + "s\n",
                " ", "Type", "Title", "Category", "Status", "Check Out Date", "Due Date");
        for (int i = 0; i < (indexColWidth+typeColWidth+titleColWidth+
                categoryColWidth+statusColWidth+checkOutColWidth+dueDateColWidth); i++) {
            System.out.print("=");
        }
        System.out.println();

        // Print a numbered list according to the list
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-" + indexColWidth + "s" + "%-" + typeColWidth + "s" +
                    "%-" + titleColWidth + "s%-" + categoryColWidth + "s%-" +statusColWidth + "s\n",
                    (i+1) + ". ", list.get(i).getType().toString(), list.get(i).getTitle(),
                    list.get(i).getCategory(), list.get(i).getStatus().toString());
        }

        return;
    }


    /**
     * YK - This method will allow the librarian to check out a media according to the user input index
     * @param list Currently displayed list
     * @param index Choice of user, objects using this class should be careful
     * @return True if executed successfully, false otherwise
     */
    public boolean checkOutMedia(ArrayList<Media> list, int index) {
        list.get(index).checkOutMedia();
        return true;
    }


    /**
     * YK - This method will allow the librarian to check in a media according to the user input index
     * @param list Currently displayed list
     * @param index Choice of user, objects using this class should be careful
     */
    public boolean checkInMedia(ArrayList<Media> list, int index) {
        list.get(index).checkInMedia();
        return true;
    }


    /**
     * This method will put an item on hold
     * @param list Currently displayed list
     * @param index Choice of user, objects using this class should be careful
     * @return True if successfully executed, false otherwise.
     */
    public boolean putOnHold(ArrayList<Media> list, int index) {
        // Check if status is available for hold
        if (list.get(index).getStatus() != MediaStatus.ON_SHELF) {
            System.out.println("This media cannot be put on hold!!");
            return false;
        }

        // Put on hold
        list.get(index).setStatus(MediaStatus.ON_HOLD);

        // Executed successfully
        return true;
    }


    /**
     * This method returns a string with the date in the format of MM-DD-YYYY
     * @param calendar Calendar object
     * @return Date in format of MM-DD-YYYY
     */
    public static String printDate(Calendar calendar) {
        return calendar.get(Calendar.MONTH) + "-" +
                calendar.get(Calendar.DAY_OF_MONTH) + "-" +
                calendar.get(Calendar.YEAR);
    }


    /**
     * YK - This method will print the due date of an object
     * @param list Currently displayed list
     * @param index Choice of user, objects using this class should be careful
     * @return True if executed successfully, false otherwise
     */
    public boolean printDueDate(ArrayList<Media> list, int index) {
        // Make sure that the item is actually checked out.
        if (list.get(index).getStatus() == MediaStatus.ON_HOLD || list.get(index).getStatus() == MediaStatus.ON_SHELF) {
            System.out.println("The media is not checked out!!");
            return false;
        }

        // Print the due date
        System.out.print("The due date for this item is: ");
        System.out.println(printDate(list.get(index).getDueDate()));

        // Print whether overdue or not
        if (list.get(index).getStatus() == MediaStatus.OVERDUE) {
            System.out.println("The media is overdue!!  Please bring back ASAP!!");
        }

        return true;
    }


    /**
     *  YK - This method prints detailed information about a media
     * @param list Currently displayed list
     * @param index Choice of user, objects using this class should be careful
     * @return True if executed successfully, false otherwise
     */
    public boolean lookUpMediaInfo(ArrayList<Media> list, int index) {

        // Print details
        System.out.printf("%12s%-s\n", "TITLE:  ", list.get(index).getTitle());
        System.out.printf("%12s%-s\n", "AUTHOR:  ", list.get(index).getAuthor());
        System.out.printf("%12s%-s\n", "CATEGORY:  ", list.get(index).getCategory());
        System.out.printf("%12s%-s\n", "TYPE:  ", list.get(index).getTitle());
        System.out.printf("%12s%-s\n", "STATUS:  ", list.get(index).getStatus().toString());

        // If checked out, then print check out date and due date
        if (list.get(index).getStatus() == MediaStatus.CHECKED_OUT
                || list.get(index).getStatus() == MediaStatus.OVERDUE) {
            System.out.printf("%12s%-s\n", "CHECKOUT DATE:  ", printDate(list.get(index).getCheckOutDate()));
            System.out.printf("%12s%-s\n", "DUE DATE:  ", printDate(list.get(index).getDueDate()));
        }

        // Return true if executed correctly
        return true;
    }

}
