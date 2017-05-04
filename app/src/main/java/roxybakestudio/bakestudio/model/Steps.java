package roxybakestudio.bakestudio.model;

public class Steps {

    private int stepsId;
    private String shortDescription;
    private String description;
    private String url;
    private String thumbnail;

    public Steps(int id, String shortDescription, String description,
                 String url, String thumbnail) {
        this.stepsId = id;
        this.shortDescription = shortDescription;
        this.description = description;
        this.url = url;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return stepsId;
    }

    public String getShortDiscription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
