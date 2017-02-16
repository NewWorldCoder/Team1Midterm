/**
 * Created by Mike on 2/15/2017.
 */
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LibraryDataBase {




    public static void printMediaDatabase(){
    String med = readTextFromFile("docs/Team1LibraryDbase.csv");


    String[] byLine = med.split("\\n");
    String[] columns;
        ArrayList<Media> mediaList = new ArrayList<Media>();






    for(int i = 1;i<=19;i++)
    {
        columns = byLine[i].split(",");

            mediaList.add(new Book(columns[1], columns[2],columns[3]));
            




    }




//
//    String[][] columns = new String[byLine.length][];
//
//
//
//    for( int i = 1; i< byLine.length; i++) //skipping first line because it's just book,
//
//    {
//        for(int j = 0; j<byLine[i].length;j++)
//        {
//            columns[i][j]=byLine[i].split(",");
//
//        }
//
//    }

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
