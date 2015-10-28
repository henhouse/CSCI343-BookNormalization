package normalization;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author henryhenderson
 */
public class Normalization
{
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


        for (int i = 0; i < bookFileData.size(); ++i)
        {
            
            //System.out.print(Arrays.toString(bla.get(i)));
        }

        infile.close();
        normal.getPublishers(bookFileData);
        normal.getAuthors(bookFileData);
    }
    
    public void getPublishers(ArrayList<String[]> bookFileData)
    {
        // Uses sets for unique values
        Set<Publisher> publishers = new HashSet<>();
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
            System.out.println(p.toString());
        }
    }

    public void getAuthors(ArrayList<String[]> bookFileData)
    {
        Set<Author> authors = new HashSet<>();
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
}
