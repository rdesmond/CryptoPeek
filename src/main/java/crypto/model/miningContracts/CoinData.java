package crypto.model.miningContracts;


/**
 * Created by tanerali on 23/08/2017.
 */
public class CoinData {

    CoinDetails BTC;
    CoinDetails BCH;
    CoinDetails LTC;
    CoinDetails ETH;
    CoinDetails DASH;
    CoinDetails ZEC;
    CoinDetails XMR;
    CoinDetails ETC;

    public CoinDetails getBTC() {
        return BTC;
    }

    public void setBTC(CoinDetails BTC) {
        this.BTC = BTC;
    }

    public CoinDetails getBCH() {
        return BCH;
    }

    public void setBCH(CoinDetails BCH) {
        this.BCH = BCH;
    }

    public CoinDetails getLTC() {
        return LTC;
    }

    public void setLTC(CoinDetails LTC) {
        this.LTC = LTC;
    }

    public CoinDetails getETH() {
        return ETH;
    }

    public void setETH(CoinDetails ETH) {
        this.ETH = ETH;
    }

    public CoinDetails getDASH() {
        return DASH;
    }

    public void setDASH(CoinDetails DASH) {
        this.DASH = DASH;
    }

    public CoinDetails getZEC() {
        return ZEC;
    }

    public void setZEC(CoinDetails ZEC) {
        this.ZEC = ZEC;
    }

    public CoinDetails getXMR() {
        return XMR;
    }

    public void setXMR(CoinDetails XMR) {
        this.XMR = XMR;
    }

    public CoinDetails getETC() {
        return ETC;
    }

    public void setETC(CoinDetails ETC) {
        this.ETC = ETC;
    }
}
