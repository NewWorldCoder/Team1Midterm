/**
 * Created by Mike on 2/15/2017.
 */
public class Book extends Media {

    /**
     * Constructor for Book objects
     * @param title Title for Book object
     * @param category Category for Book object
     * @param author Author for Book object
     */
    public Book (String title, String category, String author) {
        super.setTitle(title);
        super.setCategory(category);
        super.setAuthor(author);
        super.setType(MediaType.BOOK);
    }
    
}
