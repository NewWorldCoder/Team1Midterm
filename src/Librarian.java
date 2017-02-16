import java.util.ArrayList;

/**
 * Created by Victoria Owen on 2/15/2017.
 */
public class Librarian {

    

    /**
     * YK - Prints a numbered list according to the ArrayList returned by LibraryDataBase
     * @param list ArrayList created by the LibraryDataBase
     */
    public void printArray(ArrayList list) {

        // YK - Print a numbered list according to
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i).toString());
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
     * @param list
     * @param index
     */
    public void checkInMedia(ArrayList<Media> list, int index) {
        list.get(index).checkInMedia();
        return;
    }


}
