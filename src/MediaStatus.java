/**
 * Created by yosuk on 2/16/2017.
 */
public enum MediaStatus {
    ON_SHELF, CHECKED_OUT, OVERDUE, ON_HOLD;        // Enum for status of the Media object
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
