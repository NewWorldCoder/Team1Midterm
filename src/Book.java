/**
 * Created by Mike on 2/15/2017.
 */
public class Book extends Media {

    /**
     * Constructor for Book objects
     * @param title Title for Book object
     * @param category Category for Book object
     * @param author Author for Book object
     * @param status Status of the Media
     */
    public Book (String title, String category, String author, String status) {
        super.setTitle(title);
        super.setCategory(category);
        super.setAuthor(author);
        super.setType(MediaType.BOOK);

        // Set of strings to hold month, day, year
//        String[] cOutDateSet = checkOut.split("-");
//        String[] dDateSet = dueDate.split("-");

        //


        // Set correct status according to constructor.
        status = status.toLowerCase();
        switch (status) {
            case "on shelf":
                super.setStatus(MediaStatus.ON_SHELF);
                break;
            case "checked out":
                super.setStatus(MediaStatus.CHECKED_OUT);
                break;
            case "overdue":
                super.setStatus(MediaStatus.OVERDUE);
                break;
            case "on hold":
                super.setStatus(MediaStatus.ON_HOLD);
                break;
            default:
                    break;
        }
    }
    
}
