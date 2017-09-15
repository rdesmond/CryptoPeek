package crypto.mappers;

import crypto.model.socialStatsModels.SocialStatsCoins;
import crypto.model.socialStatsModels.SocialStatsForDbInsert;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.ArrayList;

/**
 * Created by aaron on 8/26/17.
 */
@Mapper
public interface SocialStatsMapper {

    String GET_COINS = "SELECT coin_id FROM cryptopeek.top_30;";
    String INSERT_SOCIAL_STATS = "INSERT INTO `cryptopeek`.social_stats (name, coin_name, " +
            "general_points, twitter_statuses, twitter_points, reddit_comments_per_day, reddit_points, facebook_likes, " +
            "facebook_points, time) values (#{name}, #{coin_name}, #{general_points}, " +
            "#{twitter_statuses}, #{twitter_points}, #{reddit_comments_per_day}, #{reddit_points}, #{facebook_likes}, " +
            "#{facebook_points}, #{time});";

    @Select(GET_COINS)
    ArrayList<SocialStatsCoins> getSocialStatsCoins();

    @Insert(INSERT_SOCIAL_STATS)
    public void addSocialStatsToDb(SocialStatsForDbInsert socialStatsForDbInsert);


}
