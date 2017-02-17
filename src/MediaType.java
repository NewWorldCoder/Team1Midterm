/**
 * This is the enumeration for the media types.
 * Created by yosuk on 2/16/2017.
 */
public enum MediaType {
    BOOK, CD, DVD, AUDIO_BOOK, PERIODICAL, REFERENCE;

    /**
     * This method will return a string that represents the enum
     * @return String that represents the enum
     */
    @Override
    public String toString() {
        switch (this) {
            case BOOK:
                return "Book";
            case CD:
                return "CD";
            case DVD:
                return "DVD";
            case AUDIO_BOOK:
                return "Audio Book";
            case PERIODICAL:
                return "Periodical";
            case REFERENCE:
                return "Reference";
            default:
                return "";
        }
    }
}
