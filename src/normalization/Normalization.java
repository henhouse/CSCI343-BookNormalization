package normalization;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
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
    
    private static final String COMMA_DELIMITER = ", ";
    private static final String NEW_LINE_SEPARATOR = "\n";


    public static void main(String[] args) throws FileNotFoundException, IOException
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

        normal.buildAllCsvFiles();
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
                if (tempPub.equals(publishers.get(j)))
                    b.publisherId = publishers.get(j).getPublisherId();
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
        
        for (int i = 0; i < bookFileData.size(); ++i)
        {
            BookAuthor ba = new BookAuthor();
            ba.isbn = bookFileData.get(i)[1];

            Author tempAuth = new Author();
            tempAuth.authorFirstName = bookFileData.get(i)[3];
            tempAuth.authorLastName = bookFileData.get(i)[2];
            for (int j = 0; j < authors.size(); ++j)
                if (tempAuth.equals(authors.get(j)))
                    ba.authorId = authors.get(j).getAuthorId();

            bookAuthors.add(ba);

            // Uncomment to see each value added in console
            //System.out.println(ba.toString());
        }
    }

    public void buildAllCsvFiles() throws IOException
    {
        buildPublishers();
        buildAuthors();
        buildBooks();
        buildBookAuthors();
    }

    public void buildPublishers()
    {
        FileWriter fileWriter = null;
        File filename = new File("Publishers.txt");
        try {
            fileWriter = new FileWriter(filename);
            for (Publisher pub : publishers)
            {
                fileWriter.append(String.valueOf(pub.publisherId));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pub.publisherName);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pub.publisherAddress);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildAuthors()
    {
        FileWriter fileWriter = null;
        File filename = new File("Authors.txt");
        try {
            fileWriter = new FileWriter(filename);
            for (Author auth : authors)
            {
                fileWriter.append(String.valueOf(auth.authorId));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(auth.authorFirstName);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(auth.authorLastName);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildBooks()
    {
        FileWriter fileWriter = null;
        File filename = new File("Books.txt");
        try {
            fileWriter = new FileWriter(filename);
            for (Book books : book)
            {
                fileWriter.append(books.isbn);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(books.title);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(books.totalCopiesOrdered);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(books.copiesInStock);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(books.publisherId);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(books.publicationDate);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(books.category);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(books.cost);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildBookAuthors()
    {
        FileWriter fileWriter = null;
        File filename = new File("BookAuthors.txt");
        try {
            fileWriter = new FileWriter(filename);
            for (BookAuthor ba : bookAuthors)
            {
                fileWriter.append(ba.isbn);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(ba.authorId);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
