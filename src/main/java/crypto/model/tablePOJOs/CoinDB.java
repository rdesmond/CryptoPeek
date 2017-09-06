package crypto.model.tablePOJOs;

import javax.persistence.*;

/**
 * Created by tanerali on 06/09/2017.
 */
@Entity
@Table(name = "coins")
public class CoinDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String symbol;
    String coin_name;
    int coin_id;
    String image_url;
    int following;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public int getCoin_id() {
        return coin_id;
    }

    public void setCoin_id(int coin_id) {
        this.coin_id = coin_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }
}
