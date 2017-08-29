package crypto.model.socialStatsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class General {

    String name; //: "BTC",
    String coinName; //: "Bitcoin",
    String type; //: "Webpagecoinp",
    int points; //: 1387100

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
