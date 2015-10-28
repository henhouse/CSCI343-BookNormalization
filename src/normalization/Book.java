package normalization;

import java.util.Objects;

/**
 *
 * @author Henry Henderson
 */
public class Book
{
    public String isbn;
    public String title;
    public String totalCopiesOrdered;
    public String copiesInStock;
    public String publisherId;
    public String publicationDate;
    public String category;
    public String cost;

    public Book()
    {

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", title=" + title + ", totalCopiesOrdered=" + totalCopiesOrdered + ", copiesInStock=" + copiesInStock + ", publisherId=" + publisherId + ", publicationDate=" + publicationDate + ", category=" + category + ", cost=" + cost + '}';
    }
}
