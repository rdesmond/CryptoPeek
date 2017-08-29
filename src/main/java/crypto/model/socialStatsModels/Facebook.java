package crypto.model.socialStatsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Facebook {

    int likes; //: 33672,
    String name; //: "Bitcoin P2P Cryptocurrency",
    String link; //: "https://www.facebook.com/bitcoins/",
    int talking_about; //: 219,
    String is_closed; //: "false",
    int points; //: 35862

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getTalking_about() {
        return talking_about;
    }

    public void setTalking_about(int talking_about) {
        this.talking_about = talking_about;
    }

    public String getIs_closed() {
        return is_closed;
    }

    public void setIs_closed(String is_closed) {
        this.is_closed = is_closed;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
