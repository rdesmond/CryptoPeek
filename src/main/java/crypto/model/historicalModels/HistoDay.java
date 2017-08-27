package crypto.model.historicalModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by aaron on 8/11/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoDay {

    String response; //: "Success",
    int type; //: 100,
    boolean aggregated; //: true,
    Data[] data; //: [],
    int timeTo; //: 1502409600,
    int timeFrom; //: 1486771200,
    boolean firstValueInArray; //: true,
    ConversionType conversionType; //: {}

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(int timeTo) {
        this.timeTo = timeTo;
    }

    public int getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(int timeFrom) {
        this.timeFrom = timeFrom;
    }

    public boolean isFirstValueInArray() {
        return firstValueInArray;
    }

    public void setFirstValueInArray(boolean firstValueInArray) {
        this.firstValueInArray = firstValueInArray;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }
}
