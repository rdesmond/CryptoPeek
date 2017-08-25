package crypto.model.getcoinsnapshotbyfullID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/23/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sponsor {

    String textTop; //: "Sponsored by",
    String link; //: "https://goo.gl/WZ6GMH",
    String imageUrl; //: "/media/1383676/test.png"

    public String getTextTop() {
        return textTop;
    }

    public void setTextTop(String textTop) {
        this.textTop = textTop;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
