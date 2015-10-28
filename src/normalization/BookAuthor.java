package normalization;

/**
 *
 * @author Henry Henderson
 */
public class BookAuthor
{
    public String isbn;
    public String authorId;

    public BookAuthor()
    {
        
    }

    @Override
    public String toString() {
        return "BookAuthor{" + "isbn=" + isbn + ", authorId=" + authorId + '}';
    }
}
