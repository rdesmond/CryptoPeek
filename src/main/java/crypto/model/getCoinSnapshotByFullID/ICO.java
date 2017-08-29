package crypto.model.getCoinSnapshotByFullID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/23/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ICO {

    String status; //: "Finished",
    String description; //: "<p>Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third party interference.</p><p>These apps run on a custom built blockchain, a shared and global infrastructure that can move value around and represent the ownership of property. This enables developers to create markets, store registries of debts or promises, move funds in accordance with instructions given long in the past, and many other things that have not been invented yet, all without a middle man or counterparty risk.</p><p><strong>Team</strong>:</p><ul><li><strong><span>Vitalik Buterin</span></strong>: Creato<span>r of Ethereum.</span> (<a href="https://twitter.com/vitalikbuterin" target="_blank">Twitter</a>);</li><li><strong><span>Mihai Alisie</span></strong>: <span>Co-Founder</span><span> of Ethereum. </span>(<a href="https://twitter.com/mihaialisie" target="_blank">Twitter</a>);</li><li><strong><span>Anthony Di Iorio</span></strong>: <span>Co-Founder</span><span> of Ethereum. </span>(<a href="https://twitter.com/diiorioanthony" target="_blank">Twitter</a>)</li></ul><p><span>The Ethereum sale was uncapped and ran for 42 days. The sale price was 2000 ETH for 1 BTC for the first 14 days and then started to increase linearly, finishing at 1337 ETH for 1 BTC. 31,529 BTC were raised which was worth around $18,500,000 at the time of the sale close. However, in order to pay expenses part of the BTC raised had to be sold at around 50% loss.</span></p><p>Ether th</p><p><strong>Interesting files:</strong></p><ul><li><a data-id="178224" href="/media/1383733/pdfs-ethereum-roadmap.pdf" target="_blank" title="pdfs-Ethereum-Roadmap.pdf"><span>Roadmap</span></a></li><li><a data-id="178225" href="/media/1383734/pdfs-intendeduseofrevenue.pdf" target="_blank" title="pdfs-IntendedUseOfRevenue.pdf"><span>Intended Use of Revenue</span></a></li><li><span><a data-id="178230" href="/media/1383735/pdfs-termsandconditionsoftheethereumgenesissale.pdf" target="_blank" title="pdfs-TermsAndConditionsOfTheEthereumGenesisSale.pdf">Terms and Conditions of the Ethereum Genesis Sale</a></span></li></ul><p> </p>",
    String tokenType; //: "New Blockchain",
    String website; //: "<a href='https://www.ethereum.org/' target='_blank'>https://www.ethereum.org/</a>",
    String websiteLink; //: "https://www.ethereum.org/",
    String publicPortfolioUrl; //: "-",
    String publicPortfolioId; //: "N/A",
    String features; //: "Bonus",
    String fundingTarget; //: "No Target",
    String fundingCap; //: "Unlimited",
    String iCOTokenSupply; //: "72009990.5",
    String tokenSupplyPostICO; //: "Increases",
    String tokenPercentageForInvestors; //: "83.4",
    String tokenReserveSplit; //: "8.3% T, 8.3% C",
    int date; //: 1406070000,
    int endDate; //: 1409698800,
    String fundsRaisedList; //: "31,529 BTC",
    String fundsRaisedUSD; //: "18500000",
    String startPrice; // "0.0005",
    String startPriceCurrency; //: "BTC",
    String paymentMethod; //: "BTC",
    String jurisdiction; //: "Switzerland",
    String legalAdvisers; //: "MME",
    String legalForm; //: "Foundation",
    String securityAuditCompany; //: "DejaVu Security",
    String blog; //: "<a href='https://blog.ethereum.org/' target='_blank'>https://blog.ethereum.org/</a>",
    String blogLink; //: "https://blog.ethereum.org/",
    String whitePaper; //: "<a href='https://github.com/ethereum/wiki/wiki/%5BEnglish%5D-White-Paper' target='_blank'>https://github.com/ethereum/wiki/wiki/%5BEnglish%5D-White-Paper</a>",
    String whitePaperLink; //: "https://github.com/ethereum/wiki/wiki/%5BEnglish%5D-White-Paper"

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getPublicPortfolioUrl() {
        return publicPortfolioUrl;
    }

    public void setPublicPortfolioUrl(String publicPortfolioUrl) {
        this.publicPortfolioUrl = publicPortfolioUrl;
    }

    public String getPublicPortfolioId() {
        return publicPortfolioId;
    }

    public void setPublicPortfolioId(String publicPortfolioId) {
        this.publicPortfolioId = publicPortfolioId;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getFundingTarget() {
        return fundingTarget;
    }

    public void setFundingTarget(String fundingTarget) {
        this.fundingTarget = fundingTarget;
    }

    public String getFundingCap() {
        return fundingCap;
    }

    public void setFundingCap(String fundingCap) {
        this.fundingCap = fundingCap;
    }

    public String getiCOTokenSupply() {
        return iCOTokenSupply;
    }

    public void setiCOTokenSupply(String iCOTokenSupply) {
        this.iCOTokenSupply = iCOTokenSupply;
    }

    public String getTokenSupplyPostICO() {
        return tokenSupplyPostICO;
    }

    public void setTokenSupplyPostICO(String tokenSupplyPostICO) {
        this.tokenSupplyPostICO = tokenSupplyPostICO;
    }

    public String getTokenPercentageForInvestors() {
        return tokenPercentageForInvestors;
    }

    public void setTokenPercentageForInvestors(String tokenPercentageForInvestors) {
        this.tokenPercentageForInvestors = tokenPercentageForInvestors;
    }

    public String getTokenReserveSplit() {
        return tokenReserveSplit;
    }

    public void setTokenReserveSplit(String tokenReserveSplit) {
        this.tokenReserveSplit = tokenReserveSplit;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getFundsRaisedList() {
        return fundsRaisedList;
    }

    public void setFundsRaisedList(String fundsRaisedList) {
        this.fundsRaisedList = fundsRaisedList;
    }

    public String getFundsRaisedUSD() {
        return fundsRaisedUSD;
    }

    public void setFundsRaisedUSD(String fundsRaisedUSD) {
        this.fundsRaisedUSD = fundsRaisedUSD;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getStartPriceCurrency() {
        return startPriceCurrency;
    }

    public void setStartPriceCurrency(String startPriceCurrency) {
        this.startPriceCurrency = startPriceCurrency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getLegalAdvisers() {
        return legalAdvisers;
    }

    public void setLegalAdvisers(String legalAdvisers) {
        this.legalAdvisers = legalAdvisers;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public String getSecurityAuditCompany() {
        return securityAuditCompany;
    }

    public void setSecurityAuditCompany(String securityAuditCompany) {
        this.securityAuditCompany = securityAuditCompany;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getBlogLink() {
        return blogLink;
    }

    public void setBlogLink(String blogLink) {
        this.blogLink = blogLink;
    }

    public String getWhitePaper() {
        return whitePaper;
    }

    public void setWhitePaper(String whitePaper) {
        this.whitePaper = whitePaper;
    }

    public String getWhitePaperLink() {
        return whitePaperLink;
    }

    public void setWhitePaperLink(String whitePaperLink) {
        this.whitePaperLink = whitePaperLink;
    }
}
