package crypto.model.getCoinSnapshotByFullID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/23/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    SEO seo; //: {},
    General general; //: {},
    ICO ico; //: {},
    String[] subs; //: [],
    String[] streamerDataRaw; //:

    public SEO getSeo() {
        return seo;
    }

    public void setSeo(SEO seo) {
        this.seo = seo;
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public ICO getIco() {
        return ico;
    }

    public void setIco(ICO ico) {
        this.ico = ico;
    }

    public String[] getSubs() {
        return subs;
    }

    public void setSubs(String[] subs) {
        this.subs = subs;
    }

    public String[] getStreamerDataRaw() {
        return streamerDataRaw;
    }

    public void setStreamerDataRaw(String[] streamerDataRaw) {
        this.streamerDataRaw = streamerDataRaw;
    }
}
