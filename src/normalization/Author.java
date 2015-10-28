package normalization;

import java.util.Objects;

/**
 *
 * @author Henry Henderson
 */
public class Author 
{
    public int authorId;
    public String authorFirstName;
    public String authorLastName;

    public Author()
    {
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.authorFirstName);
        hash = 71 * hash + Objects.hashCode(this.authorLastName);
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
        final Author other = (Author) obj;
        if (!Objects.equals(this.authorFirstName, other.authorFirstName)) {
            return false;
        }
        if (!Objects.equals(this.authorLastName, other.authorLastName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" + "authorId=" + authorId + ", authorFirstName=" + authorFirstName + ", authorLastName=" + authorLastName + '}';
    }
}
