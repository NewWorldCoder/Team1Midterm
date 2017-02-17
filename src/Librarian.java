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
        int titleColWidth = 30;
        int categoryColWidth = 30;
        int statusColWidth = 10;

        // Heading
        System.out.printf("%-" + indexColWidth + "s" + "%-" + typeColWidth + "s" +
                "%-" + titleColWidth + "s%-" + categoryColWidth + "s%-" +statusColWidth + "s\n",
                " ", "Type", "Title", "Category", "Status");
        for (int i = 0; i < (typeColWidth+titleColWidth+categoryColWidth+statusColWidth); i++) {
            System.out.print("=");
        }
        System.out.println();

        // Print a numbered list according to the list
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i).toString());
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
     */
    public void checkOutMedia(ArrayList<Media> list, int index) {
        list.get(index).checkOutMedia();
        return;
    }


    /**
     * YK - This method will allow the librarian to check in a media according to the user input index
     * @param list Currently displayed list
     * @param index Choice of user, objects using this class should be careful
     */
    public void checkInMedia(ArrayList<Media> list, int index) {
        list.get(index).checkInMedia();
        return;
    }


    /**
     * YK - This method will print the due date of an object
     * @param list Currently displayed list
     * @param index Choice of user, objects using this class should be careful
     */
    public boolean printDueDate(ArrayList<Media> list, int index) {
        // Make sure that the item is actually checked out.
        if (list.get(index).getStatus() == MediaStatus.ON_HOLD || list.get(index).getStatus() == MediaStatus.ON_SHELF) {
            System.out.println("The media is not checked out!!");
            return false;
        }

        // Print the due date
        System.out.print("The due date for this item is: ");
        System.out.print(list.get(index).getDueDate().get(Calendar.MONTH) + "-");
        System.out.print(list.get(index).getDueDate().get(Calendar.DAY_OF_MONTH) + "-");
        System.out.println(list.get(index).getDueDate().get(Calendar.YEAR));

        // Print whether overdue or not
        if (list.get(index).getStatus() == MediaStatus.OVERDUE) {
            System.out.println("The media is overdue!!  Please bring back ASAP!!");
        }

        return true;
    }

    
    /**
     * YK - This method prints detailed information about an object
     * @param list
     * @param index
     */
    public void lookUpMediaInfo(ArrayList<Media> list, int index) {
        // TODO: Maybe this can provide more information about an object
        list.get(index).toString();
        return;
    }


}
