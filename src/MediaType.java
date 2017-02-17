/**
 * Created by yosuk on 2/16/2017.
 */
public enum MediaType {
    BOOK, CD, DVD, AUDIO_BOOK, PERIODICAL, REFERENCE;

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
                return "Periodical";
            case REFERENCE:
                return "Reference";
            default:
                return "";
        }
    }
}
