package crypto.model.socialStatsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageViewsSplit {

    int overview; //: 2443668,
    int markets; //: 162175,
    int analysis; //: 115010,
    int charts; //: 744288,
    int trades; //: 76974,
    int orderbook; //: 20684,
    int forum; //: 235427,
    int influence; //: 10141

    public int getOverview() {
        return overview;
    }

    public void setOverview(int overview) {
        this.overview = overview;
    }

    public int getMarkets() {
        return markets;
    }

    public void setMarkets(int markets) {
        this.markets = markets;
    }

    public int getAnalysis() {
        return analysis;
    }

    public void setAnalysis(int analysis) {
        this.analysis = analysis;
    }

    public int getCharts() {
        return charts;
    }

    public void setCharts(int charts) {
        this.charts = charts;
    }

    public int getTrades() {
        return trades;
    }

    public void setTrades(int trades) {
        this.trades = trades;
    }

    public int getOrderbook() {
        return orderbook;
    }

    public void setOrderbook(int orderbook) {
        this.orderbook = orderbook;
    }

    public int getForum() {
        return forum;
    }

    public void setForum(int forum) {
        this.forum = forum;
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }
}
