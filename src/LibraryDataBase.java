/**
 * Created by Mike on 2/15/2017.
 */
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LibraryDataBase {

    public LibraryDataBase(String filename) {
        String med = readTextFromFile(filename);


        String[] byLine = med.split("\\n");
        String[] columns;


        for(int i = 1;i<=19;i++)
        {
            columns = byLine[i].split(","); //populates columns array with split of each line with a comma delimiter

            mediaList.add(new Book(columns[1], columns[2],columns[3]));//populates mediaList with Book objects





        }
    }

    private ArrayList<Media> mediaList = new ArrayList<Media>();



    public void printMediaDatabase() {

        for (int i = 0; i < mediaList.size(); i++) {

            System.out.println(mediaList.get(i).getAuthor()); // Prints book objects to console.

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
