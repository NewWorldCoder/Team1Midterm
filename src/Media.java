import java.util.Calendar;
import java.util.Date;

/**
 * Created by Yosuke on 2/15/2017.
 */
abstract class Media {

    // Data members
    private String title;                                                    // Holds the title of the Media object
    private String category;                                                 // Holds the category of the Media object
    private String author;                                                   // Holds the author of the Media object
    static enum MediaStatus {ON_SHELF, CHECKED_OUT, OVERDUE, ON_HOLD};       // Enum for status of the Media object
    private MediaStatus status;                                              // Status for Media Object
    private Calendar checkOutDate;                                               // Holds the checkout date
    private Calendar dueDate;                                                    // Holds the due date
    static enum MediaType {BOOK, CD, DVD, AUDIO_BOOK, PERIODICAL, REFERENCE} // Enum for the type of the Media object
    private MediaType type;


    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private MediaStatus getStatus() {
        return status;
    }

    private void setStatus(MediaStatus status) {
        this.status = status;
    }

    private Calendar getCheckOutDate() {
        return checkOutDate;
    }

    private void setCheckOutDate(Calendar checkoutDate) {
        this.checkOutDate = checkoutDate;
    }

    public MediaType getType() {
        return type;
    }

    protected void setType(MediaType type) {
        this.type = type;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }


    /**
     * This method allows to checked out this Media object.
     * @return Returns true if successfully checked out.  False if otherwise.
     */
    public boolean checkOutMedia() {
        // Make sure it is not already checked out
        if (status == MediaStatus.CHECKED_OUT) {
            System.out.println("Already checked out!");   // Maybe make it throw an error?
            return false;
        }

        // Set the status to CHECKED_OUT
        setStatus(MediaStatus.CHECKED_OUT);

        // Set the check-out date
        setCheckOutDate(Calendar.getInstance());

        // Set the due date
        //setDueDate(Calendar.getInstance().get);

        // Successfully checked out media
        return true;
    }

    public String getTitleAuthorCat() {
        return getTitle() + ", " + getAuthor() + ", " + getCategory();
    }


}
