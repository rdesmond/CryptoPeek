package crypto.model.socialStatsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoCompare {

    SimilarItems[] similarItems; //: [],
    CryptopianFollowers[] cryptopianFollowers; //: [],
    int followers; //: 16955,
    String posts; //: "5331",
    String comments; //: "12152",
    int points; //: 678670,
    PageViewsSplit pageViewsSplit; //: {},
    int pageViews; //: 3808367

    public SimilarItems[] getSimilarItems() {
        return similarItems;
    }

    public void setSimilarItems(SimilarItems[] similarItems) {
        this.similarItems = similarItems;
    }

    public CryptopianFollowers[] getCryptopianFollowers() {
        return cryptopianFollowers;
    }

    public void setCryptopianFollowers(CryptopianFollowers[] cryptopianFollowers) {
        this.cryptopianFollowers = cryptopianFollowers;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public PageViewsSplit getPageViewsSplit() {
        return pageViewsSplit;
    }

    public void setPageViewsSplit(PageViewsSplit pageViewsSplit) {
        this.pageViewsSplit = pageViewsSplit;
    }

    public int getPageViews() {
        return pageViews;
    }

    public void setPageViews(int pageViews) {
        this.pageViews = pageViews;
    }
}
