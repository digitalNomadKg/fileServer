package FileExample.fileExample.message;

public class ResponseFile {

    private String id;
    private String name;
    private String type;
    private long size;
    private String urlLink;

    public ResponseFile(String downloadFileUri){}

    public ResponseFile(String id, String name, String type, long size, String urlLink) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.urlLink = urlLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }
}
