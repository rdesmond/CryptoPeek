package crypto.model.miningContracts;

/**
 * Created by tanerali on 23/08/2017.
 */
public class MiningContractDetails {

    String id;
    String parentId;
    String company;
    String url;
    String logoUrl;
    String name;
    boolean recommended;
    boolean sponsored;
    String affiliateURL;
    String algorithm;
    String hashesPerSecond;
    String cost;
    String currency;
    String feePercentage;
    String feeValue;
    String feeValueCurrency;
    String contractLength;
    String currenciesAvailable;
    String currenciesAvailableLogo;
    String currenciesAvailableName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }

    public String getAffiliateURL() {
        return affiliateURL;
    }

    public void setAffiliateURL(String affiliateURL) {
        this.affiliateURL = affiliateURL;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getHashesPerSecond() {
        return hashesPerSecond;
    }

    public void setHashesPerSecond(String hashesPerSecond) {
        this.hashesPerSecond = hashesPerSecond;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFeePercentage() {
        return feePercentage;
    }

    public void setFeePercentage(String feePercentage) {
        this.feePercentage = feePercentage;
    }

    public String getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(String feeValue) {
        this.feeValue = feeValue;
    }

    public String getFeeValueCurrency() {
        return feeValueCurrency;
    }

    public void setFeeValueCurrency(String feeValueCurrency) {
        this.feeValueCurrency = feeValueCurrency;
    }

    public String getContractLength() {
        return contractLength;
    }

    public void setContractLength(String contractLength) {
        this.contractLength = contractLength;
    }

    public String getCurrenciesAvailable() {
        return currenciesAvailable;
    }

    public void setCurrenciesAvailable(String currenciesAvailable) {
        this.currenciesAvailable = currenciesAvailable;
    }

    public String getCurrenciesAvailableLogo() {
        return currenciesAvailableLogo;
    }

    public void setCurrenciesAvailableLogo(String currenciesAvailableLogo) {
        this.currenciesAvailableLogo = currenciesAvailableLogo;
    }

    public String getCurrenciesAvailableName() {
        return currenciesAvailableName;
    }

    public void setCurrenciesAvailableName(String currenciesAvailableName) {
        this.currenciesAvailableName = currenciesAvailableName;
    }
}
