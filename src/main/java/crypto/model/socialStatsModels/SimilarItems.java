package crypto.model.socialStatsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimilarItems {

    int id; //: 7605,
    String name; //: "Ethereum ",
    String fullName; //: "Ethereum (ETH)",
    String imageUrl; //: "/media/20646/eth.png",
    String url; //: "/coins/eth/",
    int followingType; //: 1

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFollowingType() {
        return followingType;
    }

    public void setFollowingType(int followingType) {
        this.followingType = followingType;
    }
}
