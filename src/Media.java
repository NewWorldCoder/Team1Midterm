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
    private Date checkoutDate;                                               // Holds the checkout date
    private Date dueDate;                                                    // Holds the due date
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

    private Date getCheckoutDate() {
        return checkoutDate;
    }

    private void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public MediaType getType() {
        return type;
    }

    protected void setType(MediaType type) {
        this.type = type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }





}
