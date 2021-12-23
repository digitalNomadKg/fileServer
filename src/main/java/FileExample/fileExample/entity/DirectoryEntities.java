package FileExample.fileExample.entity;

import javax.persistence.*;

@Entity
@Table(name = "DIRECTORY")
public class DirectoryEntities {



    @Id
    @GeneratedValue

    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "directoryName", unique = true)
    private String directoryName;

    @Column(name = "directoryCreationDate", unique = true)
    private String directoryCreationDate;

    public DirectoryEntities(){}

    public DirectoryEntities(String id, String directoryName, String directoryCreationDate) {
        this.id = id;
        this.directoryName = directoryName;
        this.directoryCreationDate = directoryCreationDate;
    }

    public String getId() {
        return id;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getDirectoryCreationDate() {
        return directoryCreationDate;
    }

    public void setDirectoryCreationDate(String directoryCreationDate) {
        this.directoryCreationDate = directoryCreationDate;
    }
}
