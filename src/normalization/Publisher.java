/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package normalization;

/**
 *
 * @author henryhenderson
 */
public class Publisher
{
    public int publisherId;
    public String publisherName;
    public String publisherAddress;
    public Publisher()
    {
        
    }

    @Override
    public String toString()
    {
        return "Publisher{" + "publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherAddress=" + publisherAddress + '}';
    }
}
