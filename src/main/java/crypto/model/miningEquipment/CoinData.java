package crypto.model.miningEquipment;

import crypto.model.miningContracts.CoinDetails;

/**
 * Created by tanerali on 23/08/2017.
 */
public class CoinData {

    CoinDetails ETH;
    CoinDetails BTC;
    CoinDetails ZEC;
    CoinDetails XMR;
    CoinDetails DASH;
    CoinDetails LTC;


    public CoinDetails getETH() {
        return ETH;
    }

    public void setETH(CoinDetails ETH) {
        this.ETH = ETH;
    }

    public CoinDetails getBTC() {
        return BTC;
    }

    public void setBTC(CoinDetails BTC) {
        this.BTC = BTC;
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

    public CoinDetails getDASH() {
        return DASH;
    }

    public void setDASH(CoinDetails DASH) {
        this.DASH = DASH;
    }

    public CoinDetails getLTC() {
        return LTC;
    }

    public void setLTC(CoinDetails LTC) {
        this.LTC = LTC;
    }
}
