package crypto.model.socialStatsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Twitter {

    String favourites; //: "76",
    int statuses; //: 19006,
    String following; //: "105",
    String account_creation; //: "1313643968",
    String name; //: "Bitcoin",
    String link; //: "https://twitter.com/bitcoin",
    int lists; //: 3413,
    int followers; //: 280970,
    int points; //: 298054

    public String getFavourites() {
        return favourites;
    }

    public void setFavourites(String favourites) {
        this.favourites = favourites;
    }

    public int getStatuses() {
        return statuses;
    }

    public void setStatuses(int statuses) {
        this.statuses = statuses;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getAccount_creation() {
        return account_creation;
    }

    public void setAccount_creation(String account_creation) {
        this.account_creation = account_creation;
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

    public int getLists() {
        return lists;
    }

    public void setLists(int lists) {
        this.lists = lists;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
