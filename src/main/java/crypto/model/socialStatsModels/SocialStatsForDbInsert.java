package crypto.model.socialStatsModels;

import crypto.util.DateConverter;

/**
 * Created by aaron on 8/26/17.
 */
public class SocialStatsForDbInsert {

    //int id;
    String name;
    String coin_name;
    String coin_id;
    int general_points;
    int twitter_statuses;
    int twitter_points;
    double reddit_comments_per_day;
    int reddit_points;
    int facebook_likes;
    int facebook_points;
    String time;



    public SocialStatsForDbInsert(SocialStats socialStats) {
        DateConverter dateConverter = new DateConverter();
        this.name = socialStats.getData().general.getName();
        this.coin_name = socialStats.getData().general.getCoinName();
        //this.coin_id = socialStats.getData().general.get
        this.general_points = socialStats.getData().general.getPoints();
        this.twitter_statuses = socialStats.getData().twitter.getStatuses();
        this.twitter_points = socialStats.getData().twitter.getPoints();
        this.reddit_comments_per_day = socialStats.getData().reddit.getComments_per_day();
        this.reddit_points = socialStats.getData().reddit.getPoints();
        this.facebook_likes = socialStats.getData().facebook.getLikes();
        this.facebook_points = socialStats.getData().facebook.getPoints();
        this.time = dateConverter.currentTimeToString();
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public String getCoin_id() {
        return coin_id;
    }

    public void setCoin_id(String coin_id) {
        this.coin_id = coin_id;
    }

    public int getGeneral_points() {
        return general_points;
    }

    public void setGeneral_points(int general_points) {
        this.general_points = general_points;
    }

    public int getTwitter_statuses() {
        return twitter_statuses;
    }

    public void setTwitter_statuses(int twitter_statuses) {
        this.twitter_statuses = twitter_statuses;
    }

    public int getTwitter_points() {
        return twitter_points;
    }

    public void setTwitter_points(int twitter_points) {
        this.twitter_points = twitter_points;
    }

    public double getReddit_comments_per_day() {
        return reddit_comments_per_day;
    }

    public void setReddit_comments_per_day(double reddit_comments_per_day) {
        this.reddit_comments_per_day = reddit_comments_per_day;
    }

    public int getReddit_points() {
        return reddit_points;
    }

    public void setReddit_points(int reddit_points) {
        this.reddit_points = reddit_points;
    }

    public int getFacebook_likes() {
        return facebook_likes;
    }

    public void setFacebook_likes(int facebook_likes) {
        this.facebook_likes = facebook_likes;
    }

    public int getFacebook_points() {
        return facebook_points;
    }

    public void setFacebook_points(int facebook_points) {
        this.facebook_points = facebook_points;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
