package crypto.model.socialStatsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    General general; //: {},
    CryptoCompare cryptoCompare; //: {},
    Twitter twitter; //: {},
    Reddit reddit; //: {},
    Facebook facebook; //: {},
    CodeRepository codeRepository; //: {}

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public CryptoCompare getCryptoCompare() {
        return cryptoCompare;
    }

    public void setCryptoCompare(CryptoCompare cryptoCompare) {
        this.cryptoCompare = cryptoCompare;
    }

    public Twitter getTwitter() {
        return twitter;
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public Reddit getReddit() {
        return reddit;
    }

    public void setReddit(Reddit reddit) {
        this.reddit = reddit;
    }

    public Facebook getFacebook() {
        return facebook;
    }

    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

    public CodeRepository getCodeRepository() {
        return codeRepository;
    }

    public void setCodeRepository(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }
}
