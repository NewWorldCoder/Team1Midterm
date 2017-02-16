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

        // Make sure it is not overdue
        if (status == MediaStatus.CHECKED_OUT &&
                Calendar.getInstance().get(Calendar.DAY_OF_YEAR) > getDueDate().get(Calendar.DAY_OF_YEAR)) {
            status = MediaStatus.OVERDUE;
        }

        return status;
    }

    protected void setStatus(MediaStatus status) {
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
        if (status == MediaStatus.CHECKED_OUT || status == MediaStatus.OVERDUE) {
            System.out.println("Already checked out!");   // Maybe make it throw an error?
            return false;
        }

        // Set the status to CHECKED_OUT
        setStatus(MediaStatus.CHECKED_OUT);

        // Set the check-out date
        setCheckOutDate(Calendar.getInstance());

        // Set the due date, two weeks from checkout
        Calendar twoWeeksFromCO = Calendar.getInstance();
        twoWeeksFromCO.add(Calendar.DAY_OF_YEAR, 14);
        setDueDate(twoWeeksFromCO);

        // Successfully checked out media
        return true;
    }

    /**
     * This method checks in the Media object
     * @return
     */
    public boolean checkInMedia() {
        // Make sure it is not already checked in
        if (status == MediaStatus.ON_SHELF || status == MediaStatus.ON_HOLD) {
            System.out.println("Already available on shelf!");
            return false;
        }

        // Set the status to AVAILABLE
        setStatus(MediaStatus.ON_SHELF);

        // Set the dates
        setCheckOutDate(null);
        setDueDate(null);

        // Successfully checked out media
        return true;
    }


    /**
     * This method return a string of the title, author, and category, separated by string
     * @return string of the title, author, and category, separated by string
     */
    public String getTitleAuthorCat() {
        return getTitle() + ", " + getAuthor() + ", " + getCategory();
    }


}
