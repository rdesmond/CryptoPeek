package crypto.model.historicalModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversionType {

    String type; //: "direct",
    String conversionSymbol; //: ""

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConversionSymbol() {
        return conversionSymbol;
    }

    public void setConversionSymbol(String conversionSymbol) {
        this.conversionSymbol = conversionSymbol;
    }
}
