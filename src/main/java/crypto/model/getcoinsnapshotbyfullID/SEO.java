package crypto.model.getcoinsnapshotbyfullID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/23/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SEO {

    String pageTitle; //: "Ethereum (ETH) - Live Ether price and market cap",
    String pageDescription; //: "Live Ether price from all markets and ETH coin market Capitalization. Stay up to date with the latest Ether price movements and forum discussion. Check out our snapshot charts and see when there is an opportunity to buy or sell.",
    String baseUrl; //: "https://www.cryptocompare.com",
    String baseImageUrl; //: "https://www.cryptocompare.com",
    String ogImageUrl; //: "/media/20646/eth.png",
    String ogImageWidth; //: "400",
    String ogImageHeight; //: "400"

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseImageUrl() {
        return baseImageUrl;
    }

    public void setBaseImageUrl(String baseImageUrl) {
        this.baseImageUrl = baseImageUrl;
    }

    public String getOgImageUrl() {
        return ogImageUrl;
    }

    public void setOgImageUrl(String ogImageUrl) {
        this.ogImageUrl = ogImageUrl;
    }

    public String getOgImageWidth() {
        return ogImageWidth;
    }

    public void setOgImageWidth(String ogImageWidth) {
        this.ogImageWidth = ogImageWidth;
    }

    public String getOgImageHeight() {
        return ogImageHeight;
    }

    public void setOgImageHeight(String ogImageHeight) {
        this.ogImageHeight = ogImageHeight;
    }
}
