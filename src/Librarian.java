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

//    public Librarian(Media m, LibraryDataBase ldb) {
//        this.m = m;
//        this.ldb = ldb;
//    }


//1
    public void checkOutMedia(Media m) {
       // LibraryDataBase.readTextFromFile("docs/Team1LibraryDbase.csv");
        m.checkOutMedia()

    }
//1
    public void checkInMedia(Media m, LibraryDataBase ldb) {
        m.checkInMedia()


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
