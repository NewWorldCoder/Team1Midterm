import java.util.ArrayList;

public class LibraryApp {

    public static void main(String[] args) {

        ArrayList<Media> allAuthors = new ArrayList<Media>();

        LibraryDataBase library = new LibraryDataBase("docs/Team1LibraryDbase.csv");

        library.printMediaDatabase();

        allAuthors = library.getAllAuthor("William Shakespeare");


        for(int i = 0;i<allAuthors.size();i++)

        System.out.println(allAuthors.get(i).getTitleAuthorCat());




    LibraryDataBase library = new LibraryDataBase();

    }
}
