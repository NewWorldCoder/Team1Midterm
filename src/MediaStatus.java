/**
 * This is the enumeration for the media statuses
 * Created by yosuk on 2/16/2017.
 */
public enum MediaStatus {
    ON_SHELF, CHECKED_OUT, OVERDUE, ON_HOLD;        // Enum for status of the Media object

    /**
     * This method will return a string that represents the enum
     * @return String that represents the enum
     */
    @Override
    public String toString() {
        switch (this) {
            case ON_SHELF:
                return "On Shelf";
            case CHECKED_OUT:
                return "Checked Out";
            case OVERDUE:
                return "Overdue";
            case ON_HOLD:
                return "On Hold";
            default:
                return "";
        }
    }
}
