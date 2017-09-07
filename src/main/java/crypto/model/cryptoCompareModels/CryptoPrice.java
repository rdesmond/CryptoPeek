package crypto.model.cryptoCompareModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CryptoPrice extends CryptoCompare{

    String response;
    String message;
    int type;
    boolean aggregated;
    Data data;
    Raw raw;
    Display display;
    ConversionType conversionType;
    String Warning;
    boolean hasWarning;
    double usd;
    double btc;
    double eth;
    double bch;
    double xrp;
    double dash;
    double ltc;
    double miota;
    double xem;
    double xmr;
    double neo;
    double etc;
    double qtum;
    double omg;
    double lsk;
    double bcc;
    double strat;
    double zec;
    double waves;
    double eos;
    double pay;
    double steem;
    double bts;
    double rep;
    double usdt;
    double maid;
    double bcn;
    double fct;
    double gnt;
    double icn;
    double xlm;

    public CryptoPrice() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isAggregated() {
        return aggregated;
    }

    public void setAggregated(boolean aggregated) {
        this.aggregated = aggregated;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Raw getRaw() {
        return raw;
    }

    public void setRaw(Raw raw) {
        this.raw = raw;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }

    public String getWarning() {
        return Warning;
    }

    public void setWarning(String warning) {
        Warning = warning;
    }

    public boolean isHasWarning() {
        return hasWarning;
    }

    public void setHasWarning(boolean hasWarning) {
        this.hasWarning = hasWarning;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getBtc() {
        return btc;
    }

    public void setBtc(double btc) {
        this.btc = btc;
    }

    public double getEth() {
        return eth;
    }

    public void setEth(double eth) {
        this.eth = eth;
    }

    public double getBch() {
        return bch;
    }

    public void setBch(double bch) {
        this.bch = bch;
    }

    public double getXrp() {
        return xrp;
    }

    public void setXrp(double xrp) {
        this.xrp = xrp;
    }

    public double getDash() {
        return dash;
    }

    public void setDash(double dash) {
        this.dash = dash;
    }

    public double getLtc() {
        return ltc;
    }

    public void setLtc(double ltc) {
        this.ltc = ltc;
    }

    public double getMiota() {
        return miota;
    }

    public void setMiota(double miota) {
        this.miota = miota;
    }

    public double getXem() {
        return xem;
    }

    public void setXem(double xem) {
        this.xem = xem;
    }

    public double getXmr() {
        return xmr;
    }

    public void setXmr(double xmr) {
        this.xmr = xmr;
    }

    public double getNeo() {
        return neo;
    }

    public void setNeo(double neo) {
        this.neo = neo;
    }

    public double getEtc() {
        return etc;
    }

    public void setEtc(double etc) {
        this.etc = etc;
    }

    public double getQtum() {
        return qtum;
    }

    public void setQtum(double qtum) {
        this.qtum = qtum;
    }

    public double getOmg() {
        return omg;
    }

    public void setOmg(double omg) {
        this.omg = omg;
    }

    public double getLsk() {
        return lsk;
    }

    public void setLsk(double lsk) {
        this.lsk = lsk;
    }

    public double getBcc() {
        return bcc;
    }

    public void setBcc(double bcc) {
        this.bcc = bcc;
    }

    public double getStrat() {
        return strat;
    }

    public void setStrat(double strat) {
        this.strat = strat;
    }

    public double getZec() {
        return zec;
    }

    public void setZec(double zec) {
        this.zec = zec;
    }

    public double getWaves() {
        return waves;
    }

    public void setWaves(double waves) {
        this.waves = waves;
    }

    public double getEos() {
        return eos;
    }

    public void setEos(double eos) {
        this.eos = eos;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getSteem() {
        return steem;
    }

    public void setSteem(double steem) {
        this.steem = steem;
    }

    public double getBts() {
        return bts;
    }

    public void setBts(double bts) {
        this.bts = bts;
    }

    public double getRep() {
        return rep;
    }

    public void setRep(double rep) {
        this.rep = rep;
    }

    public double getUsdt() {
        return usdt;
    }

    public void setUsdt(double usdt) {
        this.usdt = usdt;
    }

    public double getMaid() {
        return maid;
    }

    public void setMaid(double maid) {
        this.maid = maid;
    }

    public double getBcn() {
        return bcn;
    }

    public void setBcn(double bcn) {
        this.bcn = bcn;
    }

    public double getFct() {
        return fct;
    }

    public void setFct(double fct) {
        this.fct = fct;
    }

    public double getGnt() {
        return gnt;
    }

    public void setGnt(double gnt) {
        this.gnt = gnt;
    }

    public double getIcn() {
        return icn;
    }

    public void setIcn(double icn) {
        this.icn = icn;
    }

    public double getXlm() {
        return xlm;
    }

    public void setXlm(double xlm) {
        this.xlm = xlm;
    }
}
