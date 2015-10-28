package normalization;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author henryhenderson
 */
public class Normalization
{
    ArrayList<Publisher> publishers = new ArrayList<>();
    ArrayList<Author> authors = new ArrayList<>();
    ArrayList<Book> book = new ArrayList<>();
    ArrayList<BookAuthor> bookAuthors = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException
    {
        Normalization normal = new Normalization();
        Scanner infile = new Scanner(new File("BookFile"));
        ArrayList<String[]> bookFileData = new ArrayList<>();

        // Store all lines into bookFileData arraylist delimited by ,
        while(infile.hasNextLine())
        {
            String line = infile.nextLine();
            bookFileData.add(line.split(", "));
        }
        infile.close();

        normal.getPublishers(bookFileData);
        normal.getAuthors(bookFileData);
        normal.getBooks(bookFileData);
        normal.getBookAuthors(bookFileData);
    }
    
    public void getPublishers(ArrayList<String[]> bookFileData)
    {
        int idCt = 1;

        for (int i = 0; i < bookFileData.size(); ++i)
        {
            Publisher p = new Publisher();
            p.publisherName = bookFileData.get(i)[4];
            p.publisherAddress = bookFileData.get(i)[5];

            if (publishers.contains(p)) // check if publisher is already stored
                continue;

            p.publisherId = idCt++;
            publishers.add(p);

            // Uncomment to see each value added in console
            //System.out.println(p.toString());
        }
    }

    public void getAuthors(ArrayList<String[]> bookFileData)
    {
        int idCt = 1;

        for (int i = 0; i < bookFileData.size(); ++i)
        {
            Author a = new Author();
            a.authorFirstName = bookFileData.get(i)[3];
            a.authorLastName = bookFileData.get(i)[2];

            if (authors.contains(a)) // if author already stored, skip it
                continue;

            a.authorId = idCt++;
            authors.add(a);

            // Uncomment to see each value added in console
            //System.out.println(a.toString());
        }
    }

    public void getBooks(ArrayList<String[]> bookFileData)
    {
        for (int i = 0; i < bookFileData.size(); ++i)
        {
            Book b = new Book();
            b.isbn = bookFileData.get(i)[1];
            if (book.contains(b))
                continue;
            b.title = bookFileData.get(i)[0];
            b.totalCopiesOrdered = bookFileData.get(i)[6];
            b.copiesInStock = bookFileData.get(i)[7];

            Publisher tempPub = new Publisher();
            tempPub.publisherName = bookFileData.get(i)[4];
            tempPub.publisherAddress = bookFileData.get(i)[5];
            for (int j = 0; j < publishers.size(); ++j)
            {
                if (tempPub.equals(publishers.get(j)))
                {
                    b.publisherId = publishers.get(j).getPublisherId();
                }
            }
            b.publicationDate = bookFileData.get(i)[8];
            b.category = bookFileData.get(i)[9];
            b.cost = bookFileData.get(i)[11];

            book.add(b);

            // Uncomment to see each value added in console
            //System.out.println(b.toString());
        }
    }

    public void getBookAuthors(ArrayList<String[]> bookFileData)
    {
        BookAuthor ba = new BookAuthor();
        for (int i = 0; i < bookFileData.size(); ++i)
        {
            ba.isbn = bookFileData.get(i)[1];

            Author tempAuth = new Author();
            tempAuth.authorFirstName = bookFileData.get(i)[3];
            tempAuth.authorLastName = bookFileData.get(i)[2];
            for (int j = 0; j < authors.size(); ++j)
            {
                if (tempAuth.equals(authors.get(j)))
                {
                    ba.authorId = authors.get(j).getAuthorId();
                }
            }

            bookAuthors.add(ba);

            // Uncomment to see each value added in console
            //System.out.println(ba.toString());
        }
    }
}
