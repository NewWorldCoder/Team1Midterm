/**
 * Created by Mike on 2/15/2017.
 */
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LibraryDataBase {

    private ArrayList<Media> mediaList = new ArrayList<Media>();

    public LibraryDataBase(String filename) {
        String med = readTextFromFile(filename);


        String[] byLine = med.split("\\n");
        String[] columns;


        for(int i = 0;i<=18;i++)
        {
            columns = byLine[i].split(","); //populates columns array with split of each line with a comma delimiter


            mediaList.add(new Book(columns[1], columns[2],columns[3],columns[4]));//populates mediaList with Book objects//

        }
    }

    public ArrayList getAllMedia(){
        return mediaList;
    }





    public void printMediaDatabase() {

        for (int i = 0; i < mediaList.size(); i++) {

            System.out.println(mediaList.get(i).getTitleAuthorCat()); // Prints book objects to console.

        }
    }

    public ArrayList getAllAuthor(String author){//method returns array list of the books with
        // the author passed as the argument to the method.

        ArrayList<Media> mediaListAuthors = new ArrayList<Media>();
        for(int i = 0;i<19;i++)
        {
           if(mediaList.get(i).getAuthor().equalsIgnoreCase(author)){
               mediaListAuthors.add(mediaList.get(i));//creates new ArrayList to store books that have the
               //specified authors.

           }
           else{
               continue;
           }


        }

        return mediaListAuthors;

    }

    public ArrayList getAllTitle(String title)
    {

        ArrayList<Media> mediaListTitles = new ArrayList<Media>();
        for(int i = 0;i<19;i++) {
            if (mediaList.get(i).getTitle().equalsIgnoreCase(title)){
                mediaListTitles.add(mediaList.get(i));
            }
            else{
                continue;
            }
        }

        return mediaListTitles;

    }

    public ArrayList getAllAvailable() {
        // returns an ArrayList of everything that is currently on the shelf.
        ArrayList<Media> onShelf = new ArrayList<Media>();

        for (int i = 0; i < mediaList.size(); i++) {

            if (mediaList.get(i).getStatus() == MediaStatus.ON_SHELF) {
                onShelf.add(mediaList.get(i));
            }



        }
        return onShelf;
    }

    public void writeTextToFile(String fileName)
    {
        Path filePath = Paths.get(fileName);

        File productsFile = filePath.toFile();

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(
                    productsFile, false)); // append = true


            // PrintWriter out2 = new PrintWriter(productsFile);


            for(int i = 0;i<mediaList.size();i++){
                out.println(mediaList.get(i).toString());
            }

            out.flush();
            out.close();

        }

        catch (FileNotFoundException ex)
        {



        }

    }



    public static String readTextFromFile(String fileName) {
        Path filePath = Paths.get(fileName);

        File productsFile = filePath.toFile();
        StringBuilder result = new StringBuilder();

        try {
            FileReader r = new FileReader(productsFile);
            BufferedReader reader = new BufferedReader(r);

            String line = reader.readLine();
            while (line != null) {
                // System.out.println(line);
                result.append(line + "\n");
                line = reader.readLine();
            }

            reader.close();
            return result.toString();
        } catch (FileNotFoundException ex) {

            return null;

        } catch (IOException ex) {
            return null;
        }


    }
}
