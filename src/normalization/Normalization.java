/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    }
    
    public void getPublishers(ArrayList<String[]> bookFileData)
    {
        // Uses sets for unique values
        Set<Publisher> publishers = new HashSet<>();

        for (int i = 0; i < bookFileData.size(); ++i)
        {
            Publisher p = new Publisher();
            p.publisherName = bookFileData.get(i)[4];
            p.publisherAddress = bookFileData.get(i)[5];
            publishers.add(p);
        }
        System.out.println(publishers.toString());
    }
}
