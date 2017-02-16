import java.util.ArrayList;

/**
 * Created by Victoria Owen on 2/15/2017.
 */
public class Librarian {

    private Media m;
    private LibraryDataBase ldb;

    public Media getM() {
        return m;
    }

    public void setM(Media m) {
        this.m = m;
    }

    public LibraryDataBase getLdb() {
        return ldb;
    }

    public void setLdb(LibraryDataBase ldb) {
        this.ldb = ldb;
    }

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

    
    // duplicated from LibraryDatabase.java to return a string type to use to create check out/check in
    public String printMediaDatabase2(){
        String med = LibraryDataBase.readTextFromFile("docs/Team1LibraryDbase.csv");


        String[] byLine = med.split("\\n");
        String[] columns;
        ArrayList<Media> mediaList = new ArrayList<Media>();

        for(int i = 1;i<=19;i++)
        {
            columns = byLine[i].split(","); //populates columns array with split of each line with a comma delimiter

            mediaList.add(new Book(columns[1], columns[2],columns[3]));//populates mediaList with Book objects


            System.out.println(mediaList.get(i-1).getAuthor()); // Prints book objects to console.


        }
        return mediaList.toString();
    }

}
