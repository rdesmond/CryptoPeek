package crypto.model.socialStatsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reddit {

    String comments_per_hour; //: "244.07",
    double comments_per_day; //: 5857.63,
    String link; //: "https://www.reddit.com/r/bitcoin/",
    String posts_per_day; //: "373.91",
    int active_users; //: 5589,
    int subscribers; //: 296962,
    String posts_per_hour; //: "15.58",
    String community_creation; //: "1284042626",
    String name; //: "Bitcoin",
    int points; //: 325444

    public String getComments_per_hour() {
        return comments_per_hour;
    }

    public void setComments_per_hour(String comments_per_hour) {
        this.comments_per_hour = comments_per_hour;
    }

    public double getComments_per_day() {
        return comments_per_day;
    }

    public void setComments_per_day(double comments_per_day) {
        this.comments_per_day = comments_per_day;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPosts_per_day() {
        return posts_per_day;
    }

    public void setPosts_per_day(String posts_per_day) {
        this.posts_per_day = posts_per_day;
    }

    public int getActive_users() {
        return active_users;
    }

    public void setActive_users(int active_users) {
        this.active_users = active_users;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public String getPosts_per_hour() {
        return posts_per_hour;
    }

    public void setPosts_per_hour(String posts_per_hour) {
        this.posts_per_hour = posts_per_hour;
    }

    public String getCommunity_creation() {
        return community_creation;
    }

    public void setCommunity_creation(String community_creation) {
        this.community_creation = community_creation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
