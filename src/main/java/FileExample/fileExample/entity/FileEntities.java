package FileExample.fileExample.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "DIRECTORY")
public class FileEntities {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "fileName", unique = true)
    private String fileName;

    @Lob
    @Column(name = "fileSize", unique = true)
    private byte[] size;

    @Column(name = "fileType", unique = true)
    private String type;



    public FileEntities() {
    }

    public FileEntities(String id, String fileName, byte[] size, String type ) {
        this.id = id;
        this.fileName = fileName;
        this.size = size;
        this.type = type;
    }

    public String getId() {
        return id;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getSize() {
        return size;
    }

    public void setSize(byte[] size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

