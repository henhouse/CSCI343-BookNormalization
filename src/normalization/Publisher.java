package normalization;

import java.util.Objects;

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
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.publisherName);
        hash = 19 * hash + Objects.hashCode(this.publisherAddress);
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
        final Publisher other = (Publisher) obj;
        if (!Objects.equals(this.publisherName, other.publisherName)) {
            return false;
        }
        if (!Objects.equals(this.publisherAddress, other.publisherAddress)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Publisher{" + "publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherAddress=" + publisherAddress + '}';
    }
}
