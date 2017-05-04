package roxybakestudio.bakestudio.model;

import com.google.gson.annotations.Expose;

public class Steps {

    @Expose
    private int stepsId;
    @Expose
    private String shortDescription;
    @Expose
    private String description;
    @Expose
    private String url;
    @Expose
    private String thumbnail;

    public Steps(int id, String shortDescription, String description,
                 String url, String thumbnail) {
        this.stepsId = id;
        this.shortDescription = shortDescription;
        this.description = description;
        this.url = url;
        this.thumbnail = thumbnail;
    }

    public int getStepsId() {
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
